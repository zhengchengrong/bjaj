package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.GetLoginListRsp;

public class GetQuestionClassSearchReq extends BaseBeanReq<GetLoginListRsp> {

//	48.接口地址：http://192.168.2.50:8080/app/question/getQuestionByType
//	接口：根据类型查询 问题
//	参数：params={"type":"列表的中文字","pageno":"1","pagesize":"20"}
//	例：params={"type":"施工电梯","pageno":"1","pagesize":"20"}

	public Object type,pageno,pagesize;

//	@Override
//	public TypeReference<BaseBeanRsp<GetLoginListRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<GetLoginListRsp>>() {
//		};
//	}

}
