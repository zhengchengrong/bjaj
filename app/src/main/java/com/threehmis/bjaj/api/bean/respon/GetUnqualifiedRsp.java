package com.threehmis.bjaj.api.bean.respon;

import java.io.Serializable;

/**
 * Created by 3hcd on 2017/2/20.
 * 检测不合格统计情况 返回bean
 */

public class GetUnqualifiedRsp implements Serializable {


    /**
     * oneSucc : 0
     * oneError : 0
     * twoSucc : 0
     * twoError : 0
     * threeSucc : 0
     * threeError : 0
     * fourSucc : 28
     * fourError : 0
     * max : 30
     */

    public int oneSucc;
    public int oneError;
    public int twoSucc;
    public int twoError;
    public int threeSucc;
    public int threeError;
    public int fourSucc;
    public int fourError;
    public double max;
}
