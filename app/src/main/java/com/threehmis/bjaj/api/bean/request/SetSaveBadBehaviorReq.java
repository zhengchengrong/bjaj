package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.GetLoginListRsp;

public class SetSaveBadBehaviorReq extends BaseBeanReq<GetLoginListRsp> {

//	接口地址：http://192.168.2.50:8080/app/misconduct/saveMisconduct
//    接口：保存不良行为
//    参数：params=
//
//    {
//        "projectID":"工程主键", "punishObject":"处罚对象(单位/个人)", "unitName":"单位名称", "duty":
//        "职务", "personName":"责任人", "punishNote":"不良行为内容", "punishType":"处理结果", "registerMan":
//        "监督员", "inspectDate":"2016-11-11"
//    }
//
//    例：params=
//
//    {
//        "projectID":"40298a85513ccb660151563c395f0533", "punishObject":"单位", "unitName":
//        "广东省重工建筑设计院有限公司", "duty":"职务", "personName":"责任人", "punishNote":"不良行为内容", "punishType":
//        "处理结果", "registerMan":"监督员", "inspectDate":"2016-11-11"
//    }


    public Object projectID, punishObject, unitName, duty, personName, punishNote
            ,punishType,registerMan,inspectDate,isSubmit,pk,userId,actionLaw;

//    @Override
//    public TypeReference<BaseBeanRsp<GetLoginListRsp>> myTypeReference() {
//        // TODO Auto-generated method stub
//        return new TypeReference<BaseBeanRsp<GetLoginListRsp>>() {
//        };
//    }

}
