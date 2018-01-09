package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.GetLoginListRsp;

public class GetCheckScoreReq extends BaseBeanReq<GetLoginListRsp> {

//接口地址：http://192.168.2.50:8080/app/score/getItem
//	接口：抽查项目信息表
//	参数：params={superviseType="监督类型 (质量、安全)","projectType":"工程类型(不限、建筑、市政)","inspectionId":"监督信息主键","pageno":"当前页码","pagesize":"每页数量"}
//	例：params={"superviseType":"安全","projectType":"建筑","inspectionId":"402882b2590b748101590b79cbb60000","pageno":"1","pagesize":"20"

	public String superviseType,projectType,inspectionId,pageno,pagesize;

//	@Override
//	public TypeReference<BaseBeanRsp<GetLoginListRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<GetLoginListRsp>>() {
//		};
//	}

}
