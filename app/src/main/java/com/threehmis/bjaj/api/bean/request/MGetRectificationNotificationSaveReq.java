package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.StateSuccessRsp;

public class MGetRectificationNotificationSaveReq extends BaseBeanReq<StateSuccessRsp> {

//	18.接口地址：http://192.168.2.50:8080/app/reform/saveReform
//	接口：保存整改信息
//	参数：params={"sendMan":"签发人","sendDate":"签发日期"}
//	例：params={"projectID":"40298a85513ccb660151563c395f0533","userId":"B671EF90-F272-4A8D-AFF2-70251CBC76F0","noticeNO":"123456","unitName":"广东省重工建筑设计院有限公司","questionNote":"问题描述","planReformDate":"2016-11-11","sendMan":"签发人","sendDate":"2016-11-11"}

	public String projectID,userId,noticeNO,unitName,questionNote,planReformDate,sendMan,sendDate,pk,isSubmit,status;

//	@Override
//	public TypeReference<BaseBeanRsp<StateSuccessRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<StateSuccessRsp>>() {
//		};
//	}

}
