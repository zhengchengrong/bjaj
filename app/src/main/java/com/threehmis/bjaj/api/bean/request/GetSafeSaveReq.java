package com.threehmis.bjaj.api.bean.request;

import com.ydzf.hhh.hhh_ydzf.responbean.GetLoginListRsp;

public class GetSafeSaveReq extends BaseBeanReq<GetLoginListRsp> {

//	6.接口地址：http://192.168.2.50:8080/app/inspection/saveInspection
//	接口：保存执法信息（安全监督/质量监督）
//	参数：params={"pk":"主键(为空代表新增)","projectID":"查询出来的工程id","checkPart":"检查部位"，"weekday":"星期"，"weather":"天气","inspectionType":"执法类型（0.质量 1.安全 传0,1）"
//			,"dealOpinion":"处理意见","checkDate":"检查日期 (2016-11-11)","isReform":"是否整改(是，否)"，"checkDocument":"资料核查(符合，不符合)"}
//	例：params={"pk":"","projectID":"40298a85513ccb660151563c395f0533","checkPart":"检查部位","weekday":"星期无","weather":"晴","inspectionType":"0"
//			,"dealOpinion":"处理意见","checkDate":"2016-11-11","isReform":"是","checkDocument":"符合"}

//	抽查内容:checkContent 监督员 monitors　　
	public String userId,pk,projectID,checkPart,weekday,weather,inspectionType,dealOpinion,checkDate,isReform,checkDocument,isSubmit,
	checkContent,monitors,optType;
//	@Override
//	public TypeReference<BaseBeanRsp<GetLoginListRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<GetLoginListRsp>>() {
//		};
//	}

}
