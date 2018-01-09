package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.GetLoginListRsp;

public class GetSafeReq extends BaseBeanReq<GetLoginListRsp> {

//	7.接口地址：http://192.168.2.50:8080/app/inspection/getInspectionByProId
//	接口: 查询执法信息
//	参数： params={"projectId":"工程id",inspectionType:"执法类型（0.质量 1.安全 传0,1）}
//		例： params={"projectId":"40298a85513ccb660151563c395f0533","inspectionType":"0"}

	public Object projectId,inspectionType,pk,optType;

//	@Override
//	public TypeReference<BaseBeanRsp<GetLoginListRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<GetLoginListRsp>>() {
//		};
//	}

}
