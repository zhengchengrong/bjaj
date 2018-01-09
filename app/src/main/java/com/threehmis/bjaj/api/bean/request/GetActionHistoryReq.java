package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.GetLoginListRsp;

public class GetActionHistoryReq extends BaseBeanReq<GetLoginListRsp> {

//	13.接口地址：http://192.168.2.50:8080/app/supervise/checkList
//	接口：历史记录
//	参数：params={"inspectionPK":"监督信息id",,"pageno":"当前页码","pagesize":"每页数量"checkType":"检查类型(行为管理，实体抽查)"}

	public String inspectionPK,pageno,pagesize,checkType;

//	@Override
//	public TypeReference<BaseBeanRsp<GetLoginListRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<GetLoginListRsp>>() {
//		};
//	}

}
