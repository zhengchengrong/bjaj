package com.threehmis.bjaj.api.bean.request;

import com.ydzf.hhh.hhh_ydzf.responbean.GetLoginListRsp;

public class GetPersonPostHistoryReq extends BaseBeanReq<GetLoginListRsp> {

//	24.接口地址：http://192.168.2.50:8080/app/attendance/getListByUser
//    接口：历史记录
//    参数：params=
//
//    {
//        "projectId":"工程id", "inspectionPK":"监督信息主键", "personName":"人员姓名", "pageno":"1", "pagesize":
//        "20"
//    }
//
//    例：params=
//
//    {
//        "projectId":"40298a85513ccb660151563c395f0533", "inspectionPK":
//        "402882b2590b748101590b79cbb60000", "pageno":"1", "pagesize":"20", "personName":"王健"
//    }

    public String projectId, inspectionPK, pageno, pagesize,personName;

//    @Override
//    public TypeReference<BaseBeanRsp<GetLoginListRsp>> myTypeReference() {
//        // TODO Auto-generated method stub
//        return new TypeReference<BaseBeanRsp<GetLoginListRsp>>() {
//        };
//    }

}
