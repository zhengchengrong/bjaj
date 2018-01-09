package com.threehmis.bjaj.api.bean.request;

import com.ydzf.hhh.hhh_ydzf.responbean.GetLoginListRsp;

public class GetExamReportReq extends BaseBeanReq<GetLoginListRsp> {

//42.接口地址：http://192.168.2.50:8080/app/etlRegister/findByPrtidentity
//	接口：查询检测报告查验
//	参数：params={"prtidentity":"送检编号"}
//	例：params={"prtidentity":"1JC000JZ00032016033618"}
	public String prtidentity,syNum;

//	@Override
//	public TypeReference<BaseBeanRsp<GetLoginListRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<GetLoginListRsp>>() {
//		};
//	}

}
