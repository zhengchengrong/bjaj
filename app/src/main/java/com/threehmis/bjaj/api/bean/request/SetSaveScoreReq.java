package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.GetLoginListRsp;

public class SetSaveScoreReq extends BaseBeanReq<GetLoginListRsp> {

//	1.接口地址：http://192.168.2.50:8080/app/score/saveScore
//    接口：保存评分信息表
//    参数：params=
//
//    {
//        "inspectionPK":"执法记录PK", "checkType":"从数据中获得", "checkItemType":"从数据中获得", "checkScore":
//        "当前选择的分数", "checkItem":"从数据中获得", "userId":"用户id", "baseItemPK":"保存的检查项目主键"
//    }
//
//    例：params=
//
//    {
//        "inspectionPK":"402882b2590b748101590b79cbb60000", "checkType":"行为管理", "checkItem":
//        "施工前办理质量监督手续情况", "checkScore":"1", "userId":
//        "B671EF90-F272-4A8D-AFF2-70251CBC76F0", "baseItemPK":"2"
//    }

    public Object inspectionPK, checkType, checkItem, checkScore, userId, baseItemPK;

//    @Override
//    public TypeReference<BaseBeanRsp<GetLoginListRsp>> myTypeReference() {
//        // TODO Auto-generated method stub
//        return new TypeReference<BaseBeanRsp<GetLoginListRsp>>() {
//        };
//    }

}
