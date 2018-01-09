package com.threehmis.bjaj.api.bean.respon;

import java.io.Serializable;

/**
 * Created by 3hcd on 2017/2/20.
 * 执法统计情况图表 返回bean
 */

public class GetTongJiRsp implements Serializable {


    /**
     * projectCode : null
     * projectName : 金融城起步区A007-1地块施工总承包
     * checkValue : 11
     * refromValue : 4
     * reformStatusValue : 2
     * misconductValue : 4
     * projectStatus : SP020
     * max : 15
     */

    public String projectCode;
    public String projectName;
    public int checkValue;
    public int refromValue;
    public int reformStatusValue;
    public int misconductValue;
    public String projectStatus;
    public double max;
}
