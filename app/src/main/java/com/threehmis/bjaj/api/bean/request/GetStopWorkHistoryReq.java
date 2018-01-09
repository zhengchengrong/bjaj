package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.GetLoginListRsp;

public class GetStopWorkHistoryReq extends BaseBeanReq<GetLoginListRsp> {

//	35.接口地址：http://192.168.2.50:8080/app/stop/getList
//	接口：历史记录
//	参数：params={"projectId":"工程主键","pageno":"1","pagesize":"20"}
//	例：params={"projectId":"40298a85513ccb660151563c395f0533","pageno":"1","pagesize":"20"}

	public String projectId,pageno,pagesize;

//	@Override
//	public TypeReference<BaseBeanRsp<GetLoginListRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<GetLoginListRsp>>() {
//		};
//	}

}
