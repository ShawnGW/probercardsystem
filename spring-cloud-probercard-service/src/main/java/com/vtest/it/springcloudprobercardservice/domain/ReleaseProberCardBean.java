package com.vtest.it.springcloudprobercardservice.domain;

import java.io.Serializable;
import java.util.Date;

public class ReleaseProberCardBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String proberCardId;
    private String pteOperator;
    private double cardYield;
    private String cardOperator;
    private boolean pinMarks;
    private boolean releaseFlag;
    private String updateOperator;
    private String note;
    private Date loadTime;

    public Date getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(Date loadTime) {
        this.loadTime = loadTime;
    }

    public String getProberCardId() {
        return proberCardId;
    }

    public void setProberCardId(String proberCardId) {
        this.proberCardId = proberCardId;
    }

    public String getPteOperator() {
        return pteOperator;
    }

    public void setPteOperator(String pteOperator) {
        this.pteOperator = pteOperator;
    }

    public double getCardYield() {
        return cardYield;
    }

    public void setCardYield(double cardYield) {
        this.cardYield = cardYield;
    }

    public String getCardOperator() {
        return cardOperator;
    }

    public void setCardOperator(String cardOperator) {
        this.cardOperator = cardOperator;
    }

    public boolean isPinMarks() {
        return pinMarks;
    }

    public void setPinMarks(boolean pinMarks) {
        this.pinMarks = pinMarks;
    }

    public boolean isReleaseFlag() {
        return releaseFlag;
    }

    public void setReleaseFlag(boolean releaseFlag) {
        this.releaseFlag = releaseFlag;
    }

    public String getUpdateOperator() {
        return updateOperator;
    }

    public void setUpdateOperator(String updateOperator) {
        this.updateOperator = updateOperator;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
