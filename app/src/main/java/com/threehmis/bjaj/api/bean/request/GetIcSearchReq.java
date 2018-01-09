package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.GetLoginListRsp;

public class GetIcSearchReq extends BaseBeanReq<GetLoginListRsp> {

//45.接口地址：http://192.168.2.50:8080/app/etlChipset/findByCode
//	接口：查询芯片检测
//	参数：params={"code":"芯片外码"}
//	例：params={"code":"105214615105214615412345678"}
	public String code;

//	@Override
//	public TypeReference<BaseBeanRsp<GetLoginListRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<GetLoginListRsp>>() {
//		};
//	}

}
