package com.threehmis.bjaj.api.bean.respon;

import java.util.List;

public class GetActionHistoryRsp {


    /**
     * ""type": "建设单位",
     * "itemName": "施工前办理质量监督手续情况",
     * "checkResult": "符合",
     * "photoIds": null,
     * "baseItemPk": null
     */

    public String type;
    public String itemName;
    public String checkResult;
    public String pk;
    public List<DataListBean> checkFile;

    public static class DataListBean {
        /**
         * type : 主要参建企业
         * id : 勘察单位
         */
        public String type;
        public String id;
        public String url;;
    }

    public String baseItemPk;

}
