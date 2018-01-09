package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.StateSuccessRsp;

public class MGetFormScheduleSaveReq extends BaseBeanReq<StateSuccessRsp> {

//	{"verification":true,"projectList":null}  接受到这一层级的数据为空

	//这条是传入的参数 形象进度保存
	public Object projectID,projectXXJD,projectPart,remark,updatedate,isSubmit,id,userId;

	// 这条是返回的json数据解析后的结果
//	@Override
//	public TypeReference<BaseBeanRsp<StateSuccessRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<StateSuccessRsp>>() {
//		};
//	}

}
