package com.threehmis.bjaj.api.bean.respon;

import java.io.Serializable;
import java.util.List;

public class GetStopWorkRsp implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * pk : null
     * areaCode : null
     * checkDate : null
     * customerId : null
     * projectCode : null
     * projectID : null
     * projectName : null
     * projectNum : null
     * projectPart : null
     * projectXXJD : 形象进度
     * receiveDate : null
     * reformDate : null
     * reformNote : null
     * remark : null
     * restartDate : null
     * restartNO : null
     * restartSendDate : null
     * restartSendMan : null
     * stopNO : null
     * stopReason : null
     * stopSendDate : null
     * stopSendMan : null
     * stopType : null
     * unitName : 广东省重工建筑设计院有限公司,广东省建筑设计研究院,广州市广州工程建设监理有限公司,中建三局第一建设有限责任公司,广州市邦杰置业有限公司,
     * updateDate : null
     * userId : null
     */

    public String pk;
    public String projectCode;
    public String projectID;
    public String projectNum;
    public String projectXXJD, projectPart, stopSendDate, reformDate, stopNO, checkDate, stopReason;
    public String receiveDate;
    public String reformNote;
    public String restartDate;
    public String restartSendDate;
    public String restartNO;
    public String stopType;
    public String unitName;
    public String stopPk;
    public List<FileListBean> fileList;

    public static class FileListBean implements Serializable {

        public String id;
        public String type;
        public String url;
    }

}
