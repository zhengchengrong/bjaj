package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.GetLoginListRsp;

public class GetEtlHandcheckReq extends BaseBeanReq<GetLoginListRsp> {

//43.接口地址：http://192.168.2.50:8080/app/etlSamplcheck/findByGrouporder
//	接口：查询现场检测
//	参数：params={"grouporder":"送检编号"}
//	例：params={"grouporder":"JZ2016028584"}
	public String grouporder;

//	@Override
//	public TypeReference<BaseBeanRsp<GetLoginListRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<GetLoginListRsp>>() {
//		};
//	}

}
