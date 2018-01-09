package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.GetLoginListRsp;

public class GetStopWorkReq extends BaseBeanReq<GetLoginListRsp> {

//	31.接口地址：http://192.168.2.50:8080/app/stop/addStop
//	接口：新增停工通知
//	参数：params={"projectId":"工程主键"}
//	例：params={"projectId":"40298a85513ccb660151563c395f0533"}

	public Object projectId,pk;

//	@Override
//	public TypeReference<BaseBeanRsp<GetLoginListRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<GetLoginListRsp>>() {
//		};
//	}

}
