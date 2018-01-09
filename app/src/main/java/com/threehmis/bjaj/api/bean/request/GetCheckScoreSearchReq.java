package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.GetLoginListRsp;

public class GetCheckScoreSearchReq extends BaseBeanReq<GetLoginListRsp> {

//接口地址：http://192.168.2.50:8080/app/score/getScoreByType
//	3hzp(张焙) 01-17 14:10:32
//	{"type":"AQST01","inspectionId":"402882b2590b748101590b79cbb60000","pageno":"1","pagesize":"20"}

	public String type,inspectionId,pageno,pagesize;

//	@Override
//	public TypeReference<BaseBeanRsp<GetLoginListRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<GetLoginListRsp>>() {
//		};
//	}

}
