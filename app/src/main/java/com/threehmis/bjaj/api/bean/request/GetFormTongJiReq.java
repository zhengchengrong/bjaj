package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.GetFormTongJiRsp;

public class GetFormTongJiReq extends BaseBeanReq<GetFormTongJiRsp> {

//	49.接口地址：http://192.168.2.50:8080/app/tj/xxjdByTj
//	接口：形象进度统计
//	参数 params={"userId":"B671EF90-F272-4A8D-AFF2-70251CBC76F0"}

    //这条是传入的参数
    public String userId;

//    @Override
//    public TypeReference<BaseBeanRsp<GetFormTongJiRsp>> myTypeReference() {
//        // TODO Auto-generated method stub
//        return new TypeReference<BaseBeanRsp<GetFormTongJiRsp>>() {
//        };
//    }
}
