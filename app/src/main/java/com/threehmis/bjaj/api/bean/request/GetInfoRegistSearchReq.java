package com.threehmis.bjaj.api.bean.request;

import com.ydzf.hhh.hhh_ydzf.responbean.GetLoginListRsp;

public class GetInfoRegistSearchReq extends BaseBeanReq<GetLoginListRsp> {

//	46.接口地址：http://192.168.2.50:8080/app/supervise/getItemByType
//	接口：根据类型查询
//	参数：params={"type":"主键",inspectionId:"监督信息主键","pageno":"1","pagesize":"20"}
//	例：params={"type":"AQST01","inspectionId":"402882b2590b748101590b79cbb60000","pageno":"1","pagesize":"20"}

	public Object type,inspectionId,pageno,pagesize,itemType,projectType,superviseType;

//	@Override
//	public TypeReference<BaseBeanRsp<GetLoginListRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<GetLoginListRsp>>() {
//		};
//	}

}
