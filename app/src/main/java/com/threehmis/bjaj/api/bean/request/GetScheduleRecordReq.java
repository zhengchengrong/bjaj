package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.GetLoginListRsp;

public class GetScheduleRecordReq extends BaseBeanReq<GetLoginListRsp> {

//	params={"projectID":"40298a85513ccb660151563c395f0533","pageno":"1","pagesize":"20"}

	public String projectID,pageno,pagesize;

//	@Override
//	public TypeReference<BaseBeanRsp<GetLoginListRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<GetLoginListRsp>>() {
//		};
//	}

}
