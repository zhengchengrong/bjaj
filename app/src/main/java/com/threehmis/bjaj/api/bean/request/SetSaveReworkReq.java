package com.threehmis.bjaj.api.bean.request;

import com.ydzf.hhh.hhh_ydzf.responbean.GetLoginListRsp;

public class SetSaveReworkReq extends BaseBeanReq<GetLoginListRsp> {

//33.接口地址：http://192.168.2.50:8080/app/stop/saveStop
//    接口：保存复工通知
//    参数：params=
//
//    {
//        "projectID":"工程id", "pk":"查询出来的主键pk", "restartNO":"复工通知书编号", "restartDate":
//        "复工日期", "restartSendDate":"复工签发日期", "reformNote":"整改内容", "userId":"当前登录人id"
//    }
//
//    例：params=
//
//    {
//        "projectID":"40298a85513ccb660151563c395f0533", "pk":
//        "402882b2592a058901592a075fd50002", "restartNO":"123", "restartDate":
//        "2016-11-11", "restartSendDate":"2016-11-21", "reformNote":"整改内容", "userId":
//        "B671EF90-F272-4A8D-AFF2-70251CBC76F0"
//    }

    public String projectID, pk, restartNO, restartDate, restartSendDate,
            reformNote,userId,isRecordSubmit,stopPk;

//    @Override
//    public TypeReference<BaseBeanRsp<GetLoginListRsp>> myTypeReference() {
//        // TODO Auto-generated method stub
//        return new TypeReference<BaseBeanRsp<GetLoginListRsp>>() {
//        };
//    }

}
