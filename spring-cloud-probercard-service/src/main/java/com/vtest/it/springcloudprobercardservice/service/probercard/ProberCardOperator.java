package com.vtest.it.springcloudprobercardservice.service.probercard;

import com.vtest.it.springcloudprobercardservice.domain.*;
import org.apache.ibatis.annotations.Param;

public interface ProberCardOperator {
    public void addProberCardInfo(ProberCardEntityBean bean);

    public void addNewIqcRecord(IqcRecordBean bean);

    public void addNewBackRecord(BackProberCardBean bean);

    public void outProberCard(OutProberCardBean bean);

    public void addnewReleaseProberCard(ReleaseProberCardBean bean);

    public void addNewMaintainRecord(ProberCardMaintainBean bean);

    public void addProberCardEX(ProberCardExtensionBean bean);

    public void deleteProberCardInfo(@Param("cardId") String cardId);

    public void proberCardCreateState(@Param("proberCardId") String proberCardId, @Param("lastProcess") String lastProcess, @Param("currentProcess") String currentProcess, @Param("op") String operator);

    public void updateProberCardState(@Param("proberCardId") String proberCardId, @Param("NewStatus") String newStatus, @Param("odlStatus") String oldStatus, @Param("operator") String operator);

    public void updateProberCard(ProberCardEntityBean bean);

    public boolean updateProberCardReleaseFlag(@Param("proberCardId") String proberCardId, @Param("releaseFlag") boolean releaseFlag);

    public boolean updateProberCardInfoReleaseFlag(@Param("proberCardId") String proberCardId, @Param("releaseFlag") boolean releaseFlag);

    public boolean updateSingleState(@Param("proberCardId") String proberCardId, @Param("currentProcess") String currentProcess);

    public boolean updateProberCardItem(@Param("proberCardId") String proberCardId, @Param("pinlenSpec") String pinlenSpec, @Param("pindiamSpec") String pindiamSpec, @Param("pinlevelSpec") String pinlevelSpec, @Param("rebuildCount") Integer rebuildCount);

    public boolean updateMaintainItem(@Param("proberCardId") String proberCardId, @Param("afterPinlen") double afterPinlen, @Param("afterPindiam") double afterPindiam, @Param("afterPinlevel") double afterPinlevel);

    public boolean updateIQCItem(@Param("proberCardId") String proberCardId, @Param("pinMinlen") double pinMinlen, @Param("pinMaxdiam") double pinMaxdiam, @Param("pinLevel") double pinLevel);


    public boolean cleanPM(@Param("cardid") String cardid, @Param("ownerid") String ownerid);

    public void addCheckProberCard(ReleaseProberCardBean bean);
}
