package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.GetLoginListRsp;

public class SetInfoRegistSaveReq extends BaseBeanReq<GetLoginListRsp> {

//	10.接口地址：http://192.168.2.50:8080/app/supervise/saveCheck
//	接口：保存抽查信息
//	例：params={"inspectionPK":"402882b2590b748101590b79cbb60000",
//			"checkType":"行为管理","checkItem":"施工前办理质量监督手续情况",
//			"checkResult":"符合","userId":"B671EF90-F272-4A8D-AFF2-70251CBC76F0","baseItemPK":"1"}


	public Object inspectionPK,checkType,checkItem,checkResult,userId,baseItemPK,checkItemType,pk,remark;
//
//	@Override
//	public TypeReference<BaseBeanRsp<GetLoginListRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<GetLoginListRsp>>() {
//		};
//	}

}
