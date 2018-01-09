package com.threehmis.bjaj.api.bean.respon;

import java.io.Serializable;
import java.util.List;

public class GetInfoRigistRsp implements Serializable {

    private static final long serialVersionUID = 1L;


    public List<CheckListBean> checkList;
    public List<TitleListBean> titleList;

    public static class CheckListBean {
        /**
         * type : 地基基础工程（60分）
         * itemName : 复合地基应按要求进行检测，检测报告应齐全(5分)
         * checkResult :
         * checkFile : null
         * baseItemPk : FWST01-01-01
         * pk : null
         */

        public String type;
        public String itemName;
        public String checkResult;
        public List<CheckFileBean> checkFile;
        public String baseItemPk;
        public String pk;

        public static class CheckFileBean{

            public String type;
            public String id;
            public String url;
        }

    }

    public static class TitleListBean {
        /**
         * itemName : 地基基础工程（60分）
         * pk : FWST01
         */

        public String itemName;
        public String pk;
    }
}
