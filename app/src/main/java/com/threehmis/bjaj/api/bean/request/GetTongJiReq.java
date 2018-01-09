package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.GetTongJiRsp;

public class GetTongJiReq extends BaseBeanReq<GetTongJiRsp> {

//	50.接口地址：http://192.168.2.50:8080/app/projectTj/projectByTj
//	接口：工程 抽查情况统计
//	参数 params={"projectId":"40298a854e968bf3014e9af630a3015d"}

	public Object projectId;

//	@Override
//	public TypeReference<BaseBeanRsp<GetTongJiRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<GetTongJiRsp>>() {
//		};
//	}

}
