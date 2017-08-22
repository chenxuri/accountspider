package com.yeeton.modules.spider.webChat.processor;

import com.yeeton.modules.spider.domain.AccountInfo;
import com.yeeton.modules.spider.webChat.pipeline.WebchatPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017/6/16.
 */

@Component
public class WebchatPageProcessor implements PageProcessor {


    @Autowired
    private WebchatPipeline webchatPipeline;


    private static String keywords;

    private  Spider webChatSpider;

    public void setWebChatSpider(Spider webChatSpider) {
        this.webChatSpider = webChatSpider;
    }

    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(5)
                            .setSleepTime(1000*60)
                            .setDomain("weixin.sogou.com")
                            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36")
                            .addCookie("CXID","B4F0DB6C4A3C2D638072D752AB986497")
                            .addCookie("SUV","002401EA72F15C77592E919AA2426497")
                            .addCookie("sw_uuid","6215024991")
                            .addCookie("sg_uuid","4838326546")
                            .addCookie("dt_ssuid","5920763228")
                            .addCookie("ABTEST","7|1497229116|v1")
                            .addCookie("weixinIndexVisited","1")
                            .addCookie("ld","Nlllllllll2B5WN$lllllV6diLolllllWTvKMkllll9lllllRllll5@@@@@@@@@@")
                            .addCookie("LSTMV","263%2C25")
                            .addCookie("LCLKINT","940")
                            .addCookie("ad","z7paSlllll2B9SyXlllllV6M$hwlllllLsOJpZllll9lllllRllll5@@@@@@@@@@")
                            .addCookie("SUID","1B49F9DA5B68860A591114270009FEC7")
                            .addCookie("SNUID","173DDDD2A9AFF85FA6017CB7AAFA04A9")
                            .addCookie("IPLOC","CN1101")
                            .addCookie("weixinIndexVisited","1")
                            .addCookie("JSESSIONID","aaafJXmAdv_yV92IvSIXv")
                            .addCookie("sct","4");

    public void process(Page page) {
        if(page.isDownloadSuccess()){

                //根据列表拆分
                List<String> contents = page.getHtml().xpath("//div[@class='news-box']/ul[@class='news-list2']/li/html()").all();

                List<AccountInfo> accountInfoList = new ArrayList<>();
                for (String content : contents) {
                    //将列表每一个转化为一个HTML对象，再在HTML对象中获取元素
                    Html html = new Html(content);
                    AccountInfo accountInfo = new AccountInfo();
                    accountInfo.setKeywords(keywords);
                    accountInfo.setUrl(html.xpath("//div[@class='gzh-box2']/div[@class='img-box']/a/@href").get());
                    accountInfo.setAccountName(getText(html.xpath("//div[@class='gzh-box2']/div[@class='txt-box']/p[@class='tit']/a/html()").get()));
                    accountInfo.setIcon(html.xpath("//div[@class='gzh-box2']/div[@class='img-box']/a/img/@src").get());
                    accountInfo.setAccountId(html.xpath("//div[@class='gzh-box2']/div[@class='txt-box']/p[@class='info']/label[@name='em_weixinhao']/text()").get());
                    accountInfo.setImage(html.xpath("//div[@class='gzh-box2']/div[@class='ew-pop']/span[@class='pop']/img/@src").get());
                    accountInfo.setRemarks(getText(html.xpath("//dl[1]/dd/html()").get()));
                    accountInfo.setRenzhen(html.xpath("//dl[2]/dd/text()").get());
                    accountInfoList.add(accountInfo);
                }

                 page.putField("accountInfoList",accountInfoList);


                //分页URL全部获取并加入到，加入目标url队列中
                List<String> pages =  page.getHtml().xpath("//div[@id='pagebar_container']").links().all();
                page.addTargetRequests(pages);


        }

    }

    public Site getSite() {
        return site;
    }


    public void search(String keywords){
        String[] aa = keywords.split(" ");
        this.keywords = keywords;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < aa.length; i++) {
            sb.append(aa[i]);
            if(i != aa.length -1){
                sb.append("+");
            }
        }
       // setSite(CookieStr);
        try{
            Spider webChatSpider = Spider.create(new WebchatPageProcessor())
                    .addUrl("http://weixin.sogou.com/weixin?query="+sb.toString()+"&page=1&ie=utf8")
                    .addPipeline(webchatPipeline)
                    //开启1个线程抓取
                    .thread(1);
            //启动爬虫
            webChatSpider.run();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static String getText(String text){
        if(text != null && !"".equals(text.trim())){
            text=   text.replaceAll("<em>","")
                    .replaceAll("</em>","")
                    .replaceAll("<!--red_beg-->","")
                    .replaceAll("<!--red_end-->","")
                    .replaceAll("\n","")
                    .replaceAll(" ", "");;
            return text;
        }else {
            return null;
        }
    }
}
