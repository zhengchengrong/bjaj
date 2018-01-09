package com.threehmis.bjaj.api.bean.request;

import com.ydzf.hhh.hhh_ydzf.responbean.GetLoginListRsp;

public class GetPersonPostReq extends BaseBeanReq<GetLoginListRsp> {

//	22.接口地址：http://192.168.2.50:8080/app/attendance/getPersonList
//	接口：点击到岗人员
//	参数：params={"projectId":"工程id","inspectionPK":"监督信息主键"}
//	例：params={"projectId":"40298a85513ccb660151563c395f0533","inspectionPK":"402882b2590b748101590b79cbb60000"}

//	2.接口地址：http://192.168.2.219:8080/app/attendance/getAttendanceList
//	接口：根据检查日期检索到岗记录
//	参数：params={"checkDate":"检查日期(输入格式如"2017-1-1")"}

	public Object projectId,inspectionPK,checkDate;

//	@Override
//	public TypeReference<BaseBeanRsp<GetLoginListRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<GetLoginListRsp>>() {
//		};
//	}

}
