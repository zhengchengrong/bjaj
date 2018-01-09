package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.GetLoginListRsp;

public class GetHistoryReq extends BaseBeanReq<GetLoginListRsp> {

//	{"projectId":"40298a854e968bf3014e9af630a3015d","inspectionType":"1","pageno":"1","pagesize":"20"}
	public String projectId,inspectionType,pageno,pagesize,optType;

//	@Override
//	public TypeReference<BaseBeanRsp<GetLoginListRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<GetLoginListRsp>>() {
//		};
//	}

}
