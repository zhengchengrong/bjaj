package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.StateSuccessRsp;

public class SetSaveRectificationReplyReq extends BaseBeanReq<StateSuccessRsp> {

//0.接口地址：http://192.168.2.50:8080/app/reform/saveReform
//    接口：点击整改回复保存
//    参数：params=
//
//    {
//        "pk":"主键", "answerNote":"整改回复内容", "answerMan":"回复人", "answerDate":"2016-11-11", "checkMan":
//        "确认人", "checkDate":"确认日期"
//    }
//
//    例：params=
//
//    {
//        "pk":"402882b25920766601592076e9e00000", "answerNote":"整改回复内容", "answerMan":
//        "回复人", "answerDate":"2016-11-11", "checkMan":"确认人", "checkDate":"2016-11-11"
//    }


    public Object pk, answerNote, answerMan, answerDate, checkMan, checkDate,status,userId;

//    @Override
//    public TypeReference<BaseBeanRsp<StateSuccessRsp>> myTypeReference() {
//        // TODO Auto-generated method stub
//        return new TypeReference<BaseBeanRsp<StateSuccessRsp>>() {
//        };
//    }

}
