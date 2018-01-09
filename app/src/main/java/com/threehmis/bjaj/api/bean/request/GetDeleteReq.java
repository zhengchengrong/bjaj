package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.StateSuccessRsp;

public class GetDeleteReq extends BaseBeanReq<StateSuccessRsp> {

//	54.接口地址：http://192.168.2.50:8080/app/progress/deleteProgress
//	接口：删除形象进度
//	参数 params={"id":"402882b2593e18e601593e190b430000"}

	public Object id,pk;

//	@Override
//	public TypeReference<BaseBeanRsp<StateSuccessRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<StateSuccessRsp>>() {
//		};
//	}

}
