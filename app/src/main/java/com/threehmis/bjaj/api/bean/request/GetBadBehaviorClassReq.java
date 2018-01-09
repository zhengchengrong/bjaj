package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.GetBadBehaviorClassRsp;

public class GetBadBehaviorClassReq extends BaseBeanReq<GetBadBehaviorClassRsp> {

//	37.接口地址：http://192.168.2.50:8080/app/misconduct/findBase
//	接口：查询基础库中不良行为
//	参数：params={"punishObject":"(施工单位、监理单位、项目经理、总监)","pageno":"1","pagesize":"20"}
//	例：params={"punishObject":"施工单位","pageno":"1","pagesize":"20"}

	public Object punishObject,pageno,pagesize;

//	@Override
//	public TypeReference<BaseBeanRsp<GetBadBehaviorClassRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<GetBadBehaviorClassRsp>>() {
//		};
//	}

}
