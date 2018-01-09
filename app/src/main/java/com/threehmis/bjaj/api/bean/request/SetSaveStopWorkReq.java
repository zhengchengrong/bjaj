package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.GetLoginListRsp;

public class SetSaveStopWorkReq extends BaseBeanReq<GetLoginListRsp> {

//33.接口地址：http://192.168.2.50:8080/app/stop/saveStop
//    接口：保存停工通知
//    参数：params=
//
//    {
//        "projectID":"工程id", "stopType":"停工类型(局部停工,停工)", "stopNO":"停工通知书编号", "projectPart":
//        "具体施工部位", "stopReason":"停工原因", "stopSendDate":"停工签发日期", "reformDate":"整改期限", "checkDate":
//        "停工日期", "userId":"登录人id", "unitName":"通知企业"
//    }
//
//    例：params=
//
//    {
//        "projectID":"40298a85513ccb660151563c395f0533", "stopType":"停工",
//            "stopNO":"123", "projectPart":"具体施工部位", "stopReason":"停工原因", "stopSendDate":
//        "2016-11-11", "reformDate":"2016-11-21", "checkDate":"2016-11-11", "userId":
//        "B671EF90-F272-4A8D-AFF2-70251CBC76F0", "unitName":"通知企业"
//    }

    public String projectID, stopType, stopNO, projectPart, stopReason,
            stopSendDate,reformDate,checkDate,userId,unitName,pk,isStopSubmit;

//    @Override
//    public TypeReference<BaseBeanRsp<GetLoginListRsp>> myTypeReference() {
//        // TODO Auto-generated method stub
//        return new TypeReference<BaseBeanRsp<GetLoginListRsp>>() {
//        };
//    }

}
