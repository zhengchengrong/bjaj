package com.threehmis.bjaj.api.bean.respon;

import java.io.Serializable;
import java.util.List;

/**
 * 不良行为管理 返回bean
 */
public class GetFormTongJiRsp implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * max : 25
     * list : [{"key":"NULL","value":6},{"key":"主体","value":13},{"key":"地下结构","value":1},{"key":"地基","value":2},{"key":"基坑","value":2},{"key":"封顶","value":1},{"key":"开工前准备","value":1},{"key":"形象进度","value":1},{"key":"桩基","value":1},{"key":"装修","value":22}]
     */

    public double max;
    public List<ListBean> list;

    public static class ListBean {
        /**
         * key : NULL
         * value : 6
         */

        public String key;
        public int value;
    }
}
