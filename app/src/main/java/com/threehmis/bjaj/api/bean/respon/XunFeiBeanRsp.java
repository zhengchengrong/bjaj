package com.threehmis.bjaj.api.bean.respon;

import java.util.List;

/**
 * Created by 3hcd on 2016/12/13 0013.
 */

public class XunFeiBeanRsp  {


    /**
     * sn : 1
     * ls : false
     * bg : 0
     * ed : 0
     * ws : [{"bg":0,"cw":[{"sc":0,"w":"123456"}]}]
     */

    public String sn;
    public boolean ls;
    public int bg;
    public int ed;
    public List<WsBean> ws;

    public static class WsBean {
        /**
         * bg : 0
         * cw : [{"sc":0,"w":"123456"}]
         */

        public int bg;
        public List<CwBean> cw;

        public static class CwBean {
            /**
             * sc : 0
             * w : 123456
             */

            public int sc;
            public StringBuffer w;
        }
    }
}
