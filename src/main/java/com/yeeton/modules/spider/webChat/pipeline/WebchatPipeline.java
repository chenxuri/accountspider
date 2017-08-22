package com.yeeton.modules.spider.webChat.pipeline;

import com.yeeton.modules.spider.domain.AccountInfo;
import com.yeeton.modules.spider.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 * Created by user on 2017/6/23.
 */
@Component
public class WebchatPipeline implements Pipeline {


    @Autowired
    AccountInfoService accountInfoService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        List<AccountInfo> accountInfoList = (List<AccountInfo>) resultItems.getAll().get("accountInfoList");
        if(accountInfoList != null && accountInfoList.size()>0){
            accountInfoService.save(accountInfoList);
        }
    }
}
