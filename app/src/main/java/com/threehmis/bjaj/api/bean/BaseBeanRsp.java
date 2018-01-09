package com.threehmis.bjaj.api.bean;

import java.util.ArrayList;

/**
 * Created by 3hcd on 2016/12/13 0013.
 */

public class BaseBeanRsp<DATA>  {

    public boolean verification;  //是否有数据返回 true 有 flase 没有

//    public int total, iscollection;
//
    public String result; //标示后台接口异常信息 如 无此ID数据

    public int showSubmit; //showSubmit("0" 显示　"1" 不显示)

    public ArrayList<DATA> projectList; //返回的数据对象

    // 根据后台给的信息，看什么代码代表成功，我的是 001
    public boolean isSuccess() {
        return verification == true;
    }
    public boolean isError() {
        return verification == false;
    }



    public boolean isVerification() {
        return verification;
    }

    public void setVerification(boolean verification) {
        this.verification = verification;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getShowSubmit() {
        return showSubmit;
    }

    public void setShowSubmit(int showSubmit) {
        this.showSubmit = showSubmit;
    }

    public ArrayList<DATA> getProjectList() {
        return projectList;
    }

    public void setProjectList(ArrayList<DATA> projectList) {
        this.projectList = projectList;
    }
}
