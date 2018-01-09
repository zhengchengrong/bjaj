package com.threehmis.bjaj.api;

/**
 * Created by zhengchengrong on 2017/9/3.
 */

/**
 * Created by long on 2016/8/31.
 * 新闻常量
 */
public class Const {
    // 北京安监 SP 缓存
    public static final String SP_BJAJ = "SP_BJAJ";

    // 通用
    public static final String NET_ERROR = "网络错误!";



    // 修改地址页面 ChangeAddressActivity.java
    public static final String ADDRESS = "ADDRESS";
    public static final String CHOSE_ME = "请选择";
    public static final String CHOSE_ME_SHOW = "请选择监督站！";

    // 登陆页面 LoginActivity.java
    public static final String INPUT_ACCOUNT = "请输入账号";
    public static final String INPUT_PASSWORD = "请输入密码";
    public static final String PHONENUM = "phoneNum";
    public static final String PASSWORD = "password";
    public static final String ISCHECKED = "isChecked";
    public static final String LOGINDATE = "LoginDate";
    public static final String REEORLOGIN = "登陆失败";
    public static final String PERMISSIONSUCCESS = "授权成功";


    private Const() {
        throw new RuntimeException("NewsConst cannot be initialized!");
    }

}
