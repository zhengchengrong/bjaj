package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.GetLoginListRsp;

public class GetInfoRegistReq extends BaseBeanReq<GetLoginListRsp> {

//	行为抽查-信息登记请求数据  "pageno":"1","pagesize":"20"
// params={"superviseType":"安全","projectType":"房建","itemType":"行为管理","inspectionId":"402882b2590b748101590b79cbb60000"}
	public Object superviseType,projectType,itemType,inspectionId,pageno,pagesize;

//	@Override
//	public TypeReference<BaseBeanRsp<GetLoginListRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<GetLoginListRsp>>() {
//		};
//	}

}
