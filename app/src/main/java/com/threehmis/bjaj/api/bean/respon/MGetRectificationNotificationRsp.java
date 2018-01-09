package com.threehmis.bjaj.api.bean.respon;

import java.io.Serializable;
import java.util.List;

public class MGetRectificationNotificationRsp implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * "sendMan":"黄少英",
     * "status":null,
     * "unitName":"广东省重工建筑设计院有限公司,广东省建筑设计研究院,广州市广州工程建设监理有限公司,中建三局第一建设有限责任公司,广州市邦杰置业有限公司,",
     */

    public String unitName, sendDate, questionNote, noticeNO, sendMan, planReformDate,companyName;
    public List<GetStopWorkRsp.FileListBean> fileList;

    public static class FileListBean implements Serializable {
        public String id;
        public String type;
        public String url;
    }

}
