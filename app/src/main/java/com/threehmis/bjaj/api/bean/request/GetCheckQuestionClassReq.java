package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.GetLoginListRsp;

public class GetCheckQuestionClassReq extends BaseBeanReq<GetLoginListRsp> {

//	25.接口地址：http://192.168.2.50:8080/app/question/getBaseQuestion
//	接口：取出所有基础库问题
//	参数：params={"superviseType":"监督类型","projectType":"工程类型","pageno":"1","pagesize":"20"}
//	例：params={"superviseType":"安全","projectType":"建筑","pageno":"1","pagesize":"20"}

	public Object superviseType,projectType,pageno,pagesize;

//	@Override
//	public TypeReference<BaseBeanRsp<GetLoginListRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<GetLoginListRsp>>() {
//		};
//	}

}
