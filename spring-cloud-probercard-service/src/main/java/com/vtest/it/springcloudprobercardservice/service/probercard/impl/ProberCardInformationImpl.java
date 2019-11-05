package com.vtest.it.springcloudprobercardservice.service.probercard.impl;

import com.netflix.discovery.converters.Auto;
import com.vtest.it.springcloudprobercardservice.dao.ProberCardInformationDao;
import com.vtest.it.springcloudprobercardservice.domain.*;
import com.vtest.it.springcloudprobercardservice.service.probercard.ProberCardInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(transactionManager = "transactionManager", propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED, readOnly = true)
public class ProberCardInformationImpl implements ProberCardInformation {

    @Autowired
    private ProberCardInformationDao informationDao;

    @Override
    @Cacheable(value = "ProberCardCache", key = "#root.methodName")
    public List<ProberCardEntityBean> getAllList() {
        return informationDao.getAllList();
    }

    @Override
    @Cacheable(value = "ProberCardCache", key = "#methodName+'&'+#cardId")
    public ProberCardEntityBean getCard(String cardId) {
        return null;
    }

    @Override
    public String getProberCardStatus(String proberCardId) {
        return null;
    }

    @Override
    public ReleaseProberCardBean getReleaseCardInfo(String proberCardId) {
        return null;
    }

    @Override
    public ArrayList<ProberCardStatusBean> getAllProberCardStatus() {
        return null;
    }

    @Override
    public boolean getProberCardReleaseFlag(String proberCardId) {
        return false;
    }

    @Override
    public ArrayList<IqcRecordBean> getAllIQCRecord() {
        return null;
    }

    @Override
    public ArrayList<ProberCardMaintainBean> getAllMaintainRecord() {
        return null;
    }

    @Override
    public Integer getInfoRebuildCount(String proberCardId) {
        return null;
    }

    @Override
    public ArrayList<ProberCardTDBean> getTd() {
        return null;
    }

    @Override
    public ArrayList<OutProberCardBean> getOutProberCard(String[] proberCardIdArrays) {
        return null;
    }

    @Override
    public ArrayList<BackProberCardBean> getBackProberCard(String[] proberCardIdArrays) {
        return null;
    }

    @Override
    public ArrayList<ProberCardEntityBean> getInfoProberCard(String[] proberCardIdArrays) {
        return null;
    }

    @Override
    public ArrayList<IqcRecordBean> getIQCProberCard(String[] proberCardIdArrays) {
        return null;
    }

    @Override
    public ArrayList<ProberCardMaintainBean> getMaintainProberCard(String[] proberCardIdArrays) {
        return null;
    }

    @Override
    public ArrayList<ReleaseProberCardBean> getReleaseProberCard(String[] proberCardIdArrays) {
        return null;
    }

    @Override
    public ArrayList<ProberCardEntityBean> getProberCardId(String[] custNameArrays) {
        return null;
    }

    @Override
    public ArrayList<ProberCardExtensionBean> getEXRecord(String[] proberCardIdArrays) {
        return null;
    }

    @Override
    public ArrayList<String> getProberCardEX() {
        return null;
    }

    @Override
    public ArrayList<ProberCardExtensionBean> getEXInfoSingle(String proberCardId) {
        return null;
    }

    @Override
    public ArrayList<IqcRecordBean> getAllIQCRecordByMinTime() {
        return null;
    }

    @Override
    public ArrayList<IqcRecordBean> getAllIQCRecordByMaxTime() {
        return null;
    }
}
