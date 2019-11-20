package com.vtest.it.springcloudprobercardservice.controller;

import com.alibaba.fastjson.JSON;
import com.vtest.it.springcloudprobercardservice.domain.*;
import com.vtest.it.springcloudprobercardservice.service.probercard.ProberCardInformation;
import com.vtest.it.springcloudprobercardservice.service.probercard.ProberCardOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/operator")
@CrossOrigin
public class OperatorController {

    @Autowired
    private ProberCardOperator proberCardOperator;

    @Autowired
    private ProberCardInformation proberCardInformation;

    @PostMapping("/ProberCardInfo")
    public void addProberCardInfo(@RequestBody ProberCardEntityBean bean){
            proberCardOperator.addProberCardInfo(bean);

    }
    @PostMapping("/NewIqcRecord")
    public void addNewIqcRecord(@RequestBody IqcRecordBean bean) {
            proberCardOperator.updateProberCardState(bean.getProberCardId(), bean.getNextStation(),bean.getLastProcess(),bean.getUpdateOperator());
            proberCardOperator.addNewIqcRecord(bean);
    }
    @PostMapping("/backProberCard")
    public void backProberCard(@RequestBody BackProberCardBean bean) {
            proberCardOperator.addNewBackRecord(bean);
            String oldStatus=proberCardInformation.getProberCardStatus(bean.getProberCardId());
            proberCardOperator.updateProberCardState(bean.getProberCardId(), bean.getNextStation(),oldStatus, bean.getCreateOperator());
    }
    @PostMapping("/outProberCard")
    public void outProberCard(@RequestBody OutProberCardBean bean){
        proberCardOperator.outProberCard(bean);
        String oldStatus=proberCardInformation.getProberCardStatus(bean.getProberCardId());
        proberCardOperator.updateProberCardState(bean.getProberCardId(), bean.getNextStation(), oldStatus, bean.getOutOperator());
    }
    @PostMapping("/ReleaseProberCard")
    public void ReleaseProberCard(@RequestBody ReleaseProberCardBean bean) {
            proberCardOperator.addnewReleaseProberCard(bean);
    }

    @PostMapping("/ProberCardMaintain")
    public void ProberCardMaintain(@RequestBody ProberCardMaintainBean bean) {
            proberCardOperator.addNewMaintainRecord(bean);
            String oldStatus=proberCardInformation.getProberCardStatus(bean.getProberCardId());
            proberCardOperator.updateProberCardState(bean.getProberCardId(),bean.getNextStation(), oldStatus, bean.getUpdateOperator());
    }
    @PostMapping("/ProberCardEX")
    public void addProberCardEX(@RequestBody ProberCardExtensionBean bean) {
            proberCardOperator.addProberCardEX(bean);
            proberCardOperator.updateProberCardState(bean.getProberCardId(), bean.getCurrentProcess(), bean.getLastProcess(), bean.getCreator());
    }
    @PostMapping("/ProbercardCheck")
    public void checkProberCard(@RequestBody ReleaseProberCardBean bean) {
            proberCardOperator.addnewReleaseProberCard(bean);
    }
    @PostMapping("/ProberCardState")
    public void updateProberCardState(String proberCardId, String newStatus, String oldStatus, String operator) {
        proberCardOperator.updateProberCardState(proberCardId,newStatus,oldStatus,operator);
    }

    @PostMapping("/ProberCard")
    public void updateProberCard(@RequestBody ProberCardEntityBean bean) {
            proberCardOperator.updateProberCard(bean);
    }
    @PostMapping("/ProberCardReleaseFlag")
    public void updateProberCardReleaseFlag(String proberCardId, boolean releaseFlag) {
            proberCardOperator.updateProberCardReleaseFlag(proberCardId, releaseFlag);
    }
    @PostMapping("/ProberCardInfoReleaseFlag")
    public void updateProberCardInfoReleaseFlag(String proberCardId, boolean releaseFlag) {
            proberCardOperator.updateProberCardInfoReleaseFlag(proberCardId, releaseFlag);
    }
    @PostMapping("/SingleState")
    public void updateSingleState(String proberCardId, String currentProcess) {
            proberCardOperator.updateSingleState(proberCardId, currentProcess);
    }
    @PostMapping("/ProberCardItem")
    public void updateProberCardItem(String proberCardId, String pinlenSpec, String pindiamSpec, String pinlevelSpec, Integer rebuildCount) {
            pinlenSpec = String.valueOf(0);
            pindiamSpec = String.valueOf(0);
            pinlevelSpec = String.valueOf(0);
            rebuildCount++;
            proberCardOperator.updateProberCardItem(proberCardId, pinlenSpec, pindiamSpec, pinlevelSpec, rebuildCount);
    }
    @PostMapping("/MaintainItem")
    public void updateMaintainItem(String proberCardId, double afterPinlen, double afterPindiam, double afterPinlevel) {
            afterPinlen = 0;
            afterPindiam = 0;
            afterPinlevel = 0;
            proberCardOperator.updateMaintainItem(proberCardId, afterPinlen, afterPindiam, afterPinlevel);
    }
    @PostMapping("/IQCItem")
    public void updateIQCItem(String proberCardId, double pinMinlen, double pinMaxdiam, double pinLevel) {
            pinMinlen = 0;
            pinMaxdiam = 0;
            pinLevel = 0;
            proberCardOperator.updateIQCItem(proberCardId, pinMinlen, pinMaxdiam, pinLevel);
    }
    @PostMapping("/PM")
    public boolean cleanPM(String cardid,String ownerid) {
        return proberCardOperator.cleanPM(cardid,ownerid);
    }
    @DeleteMapping("/ProberCards")
    public void deleteProberCards(@RequestParam("cardId") String cardId) {
        proberCardOperator.deleteProberCardInfo(cardId);

    }
}
