package com.vtest.it.springcloudprobercardservice.service.probercard.impl;

import com.alibaba.fastjson.JSON;
import com.vtest.it.springcloudprobercardservice.domain.*;
import com.vtest.it.springcloudprobercardservice.service.probercard.ProberCardInformation;
import com.vtest.it.springcloudprobercardservice.service.probercard.ProberCardOperator;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProberCardInformationImplTest {
    private static final Logger TESTLOGGER=Logger.getLogger(ProberCardInformationImplTest.class);
    @Autowired
    private ProberCardInformation proberCardInformation;
    @Autowired
    private ProberCardOperator proberCardOperator;

    @Test
   public void getEXInfoSingle() {
//      ArrayList<ProberCardExtensionBean> bean= proberCardInformation.getEXInfoSingle("S-1");
//        for (ProberCardExtensionBean  infor: bean) {
//               System.out.println(infor.getCardType());
//        }
//        ProberCardEntityBean bean=proberCardInformation.getCard("S-1");
//        for (ProberCardEntityBean info: bean.) {
//
//        }
//        boolean flag=proberCardOperator.updateProberCardInfoReleaseFlag("S-1",false);
//        TESTLOGGER.warn(flag);
        ReleaseProberCardBean bean=new ReleaseProberCardBean();
        bean.setProberCardId("Q-1");
        bean.setPteOperator("v011");
        bean.setCardYield(98.00);
        bean.setCardOperator("v011");
        bean.setPinMarks(false);
        bean.setReleaseFlag(false);
        bean.setUpdateOperator("v011");
        bean.setNote("1");
        System.err.println(JSON.toJSONString(bean));
    }
}