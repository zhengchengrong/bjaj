package com.threehmis.bjaj.api.bean.request;

public class GetMenusListReq  {

//	接口地址：http://192.168.2.219:8080/app/menu/getMenus
//	接口：根据登录用户的customerId和appType获取菜单
//	参数：params={"customerId":"登录用户的customerId","appType":"app类型"}
//	返回数据:菜单bean
//
//	测试参数:params={"customerId":"GZJD001","appType":"1"}}

	public String customerId,appType;


}
