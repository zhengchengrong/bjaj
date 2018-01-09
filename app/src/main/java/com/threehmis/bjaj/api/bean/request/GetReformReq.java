package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.GetReformRsp;

public class GetReformReq extends BaseBeanReq<GetReformRsp> {

//	21.接口地址：http://192.168.2.50:8080/app/reform/findById
//	接口：点击整改通知查看
//	参数：params={"pk":"整改通知主键"}
//	例：params={"pk":"402882b25920766601592076e9e00000"}

	public Object pk;

//	@Override
//	public TypeReference<BaseBeanRsp<GetReformRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<GetReformRsp>>() {
//		};
//	}

}
