package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.GetBadHaviorRsp;

public class GetBadBehaviorReq extends BaseBeanReq<GetBadHaviorRsp> {

//	5.接口地址：http://192.168.2.50:8080/app/progress/getProgressByProId
//	接口：查询形象进度
//	参数：params={projectID:"40298a85513ccb660151563c395f0533"}

	//这条是传入的参数
	public Object projectId,pk;

	// 这条是返回的json数据解析后的结果
//	@Override
//	public TypeReference<BaseBeanRsp<GetBadHaviorRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<GetBadHaviorRsp>>() {
//		};
//	}

}
