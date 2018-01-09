package com.threehmis.bjaj.api.bean.request;

import com.ydzf.hhh.hhh_ydzf.responbean.MGetRectificationNotificationRsp;

public class MGetRectificationNotificationReq extends BaseBeanReq<MGetRectificationNotificationRsp> {

//	17.接口地址：http://192.168.2.50:8080/app/reform/addReform
//	接口：点击整改通知按钮
//	参数：params={"projectId":"工程id","userId":"用户主键"}
//	例：params={"projectId":"40298a85513ccb660151563c395f0533","userId":"B671EF90-F272-4A8D-AFF2-70251CBC76F0"}


	public Object projectId,userId,pk;

//	@Override
//	public TypeReference<BaseBeanRsp<MGetRectificationNotificationRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<MGetRectificationNotificationRsp>>() {
//		};
//	}

}
