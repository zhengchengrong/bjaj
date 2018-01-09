package com.threehmis.bjaj.api.bean.respon;

import java.io.Serializable;
import java.util.List;

/**
 * 不良行为管理 返回bean
 */
public class GetLawTongJiRsp implements Serializable {

    private static final long serialVersionUID = 1L;


    public AllListBean allList;
    public List<ListBeanX> list;

    public static class AllListBean {
        /**
         * max : 45
         * list : [{"key":"抽检次数","value":45},{"key":"不良行为","value":7},]
         */

        public double max;
        public List<ListBean> list;

        public static class ListBean {
            /**
             * key : 抽检次数
             * value : 45
             */

            public String key;
            public int value;
        }
    }

    public static class ListBeanX {
        /**
         * projectCode : GUANGZJD00034
         * projectName : 金融城起步区A007-1地块施工总承包
         * checkValue : 11
         * refromValue : 4
         * reformStatusValue : 2
         * misconductValue : 4
         */

        public String projectCode;
        public String projectName;
        public String checkValue;
        public String refromValue;
        public String reformStatusValue;
        public String misconductValue;
    }
}
