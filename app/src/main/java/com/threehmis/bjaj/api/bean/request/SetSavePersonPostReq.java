package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.GetLoginListRsp;

public class SetSavePersonPostReq extends BaseBeanReq<GetLoginListRsp> {

//	23.接口地址：http://192.168.2.50:8080/app/attendance/saveAttendance
//    接口：保存到岗人员
//    参数：params=
//
//    {
//        "inspectionPk":"执法记录pk", "duty":"职务", "personName":"人员姓名", "personPk":
//        "人员主键", "attendanceMark":"到岗情况", "userId":"当前登录人id", "projectId":"工程主键"
//    }
//
//    例：params=
//
//    {
//        "inspectionPk":"402882b2590b748101590b79cbb60000", "duty":"法定代表人", "personName":
//        "王健", "personPk":"40298a85513ccb6601515773c8cb05cb", "attendanceMark":"到岗情况", "userId":
//        "B671EF90-F272-4A8D-AFF2-70251CBC76F0", "projectId":"40298a85513ccb660151563c395f0533"
//    }

    public Object inspectionPk, duty, personName, personPk, attendanceMark, userId,projectId;

//    @Override
//    public TypeReference<BaseBeanRsp<GetLoginListRsp>> myTypeReference() {
//        // TODO Auto-generated method stub
//        return new TypeReference<BaseBeanRsp<GetLoginListRsp>>() {
//        };
//    }

}
