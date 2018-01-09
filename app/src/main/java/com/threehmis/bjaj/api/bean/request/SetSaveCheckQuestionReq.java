package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.GetLoginListRsp;

public class SetSaveCheckQuestionReq extends BaseBeanReq<GetLoginListRsp> {

//	27.接口地址：http://192.168.2.50:8080/app/question/saveQuestion
//    接口：保存问题
//    参数：params={"inspectionPK":"监督pk","checkType":"抽查类型","questions":"问题内容","dealNote":"整改信息","questionType":"问题分类"}
//    例：params={"inspectionPK":"402882b2590b748101590b79cbb60000","checkType":"行为管理","questions":"占道施工未办理手续",
// "dealNote":"整改","questionType":"道及交通要道施工"}

    public Object inspectionPK, checkType, questions, dealNote, questionType,userId,pk;

//    @Override
//    public TypeReference<BaseBeanRsp<GetLoginListRsp>> myTypeReference() {
//        // TODO Auto-generated method stub
//        return new TypeReference<BaseBeanRsp<GetLoginListRsp>>() {
//        };
//    }

}
