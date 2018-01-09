package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.MGetRectificationNotNotificationRsp;

public class MGetRectificationNotNotificationReq extends BaseBeanReq<MGetRectificationNotNotificationRsp> {

// 未回复
//	19.接口地址：http://192.168.2.50:8080/app/reform/reformList
//	接口：点击未回复(status="整改未回复")或者已回复(status="整改已回复")
//	参数：params={"projectId":"工程id","status":"整改未回复","pageno":"1","pagesize":"20"}
//	例：params={"projectId":"40298a85513ccb660151563c395f0533","status":"整改未回复","pageno":"1","pagesize":"20"}

	public String projectId,status,pageno,pagesize;

//	@Override
//	public TypeReference<BaseBeanRsp<MGetRectificationNotNotificationRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<MGetRectificationNotNotificationRsp>>() {
//		};
//	}

}
