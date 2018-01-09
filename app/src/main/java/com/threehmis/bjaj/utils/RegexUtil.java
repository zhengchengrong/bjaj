package com.threehmis.bjaj.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @author 王超
 *  正则表达式工具类
 */
public class RegexUtil {
	/**
     * 判断字符串是否符合手机号码格式
     * @param str
     * @return 待检测的字符串
     */
    public static boolean isCellphone(String str) {
        Pattern pattern = Pattern.compile("1[0-9]{10}");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    /**
     * 验证码 由  6位纯数字组成
     * 判断字符串是否符合验证码格式
     * @param str
     * @return 待检测的字符串
     */
    public static boolean isAuthCode(String str) {
        Pattern pattern = Pattern.compile("[0-9]{6}");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    /**
     * 判断用户昵称是否合法
     *只含有汉字、数字、字母、下划线不能以下划线开头和结尾
     * @param str
     *            待检测的字符串
     * @return
     */
    public static boolean isValidUserName(String str) {
//        String regex = "^[@A-Za-z0-9!#$%^&*.~\u4e00-\u9fa5]{4,16}+$";
//    	String regex = "^(?!_)(?!.*?_$)[[@A-Za-z0-9_]{5,16}[\u4e00-\u9fa5{2,16}]]+$";
//    	String regex = "^(?!_)(?!.*?_$)[\u4e00-\u9fa5]{2,16}$|^[@A-Za-z0-9]{4,16}$";
//    	String regex = "^[\u4e00-\u9fa5]{2,16}$|^[dA-Za-z_0-9]{4,16}$";//可进行下划线开头结尾的
    	String regex = "^(?!_)(?!.*?_$)[\u4e00-\u9fa5]{2,16}$|^[dA-Za-z_0-9]{4,16}$";//支持2-16个汉字或4-16个字母数字不可已下划线开头和结尾
//    	String regex = "^(?!_)(?!.*?_$)[[\u4e00-\u9fa5]{2,16}$[dA-Za-z_0-9]]+$";//三个字符就修改成功了
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }
    
    /**
     * 判断用户昵称是否合法
     * 6-18位  大小写字母和数字组成
     * @param str
     *            待检测的字符串
     * @return
     */
    public static boolean isValidPwd(String str) {
        String regex = "^[A-Za-z0-9]{6,18}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }
    
    /**
     * 判断用户昵称是否合法
     * 6 位数字组成
     * @param str
     *            待检测的字符串
     * @return
     */
    public static boolean isValidCode(String str) {
        String regex = "^[0-9]{6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    //3、通过正则表达式来判断。下面的例子只允许显示字母、数字和汉字。
    public static String stringFilter(String str)throws PatternSyntaxException {
        // 只允许字母、数字和汉字
        String regEx  =  "[^a-zA-Z0-9\u4E00-\u9FA5]";
        Pattern p   =   Pattern.compile(regEx);
        Matcher m   =   p.matcher(str);
        return   m.replaceAll("").trim();
    }


}
