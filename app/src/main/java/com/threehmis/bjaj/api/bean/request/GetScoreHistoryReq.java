package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.GetLoginListRsp;

public class GetScoreHistoryReq extends BaseBeanReq<GetLoginListRsp> {

//9.接口地址：http://192.168.2.50:8080/app/score/scoreList
//	接口：历史记录
//	参数：params={"inspectionPK":"402882b2590b748101590b79cbb60000","pageno":"1","pagesize":"20"}
//	例：params={"inspectionPK":"402882b2590b748101590b79cbb60000","pageno":"1","pagesize":"20"}


	public String inspectionPK,pageno,pagesize;

//	@Override
//	public TypeReference<BaseBeanRsp<GetLoginListRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<GetLoginListRsp>>() {
//		};
//	}

}
