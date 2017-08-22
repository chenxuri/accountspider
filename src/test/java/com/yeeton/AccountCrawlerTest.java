package com.yeeton;

import com.yeeton.modules.spider.webChat.processor.WebchatPageProcessor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by user on 2017/7/13.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountCrawlerTest {


    @Autowired
    WebchatPageProcessor webchatPageProcessor;

    @Test
    public void search(){
        webchatPageProcessor.search("银行");

    }

}
