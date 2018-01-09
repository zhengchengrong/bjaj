package com.threehmis.bjaj.api;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import com.threehmis.bjaj.api.bean.BaseBeanRsp;
import com.threehmis.bjaj.api.bean.BaseEntity;
import com.threehmis.bjaj.api.bean.ItemResult;
import com.threehmis.bjaj.api.bean.request.ChangeAddressRequestBean;
import com.threehmis.bjaj.api.bean.respon.ChangeAddressResponBean;
import com.threehmis.bjaj.api.bean.respon.GetMainAddressRsp;

/**
 * Created by zhengchengrong on 2017/9/1.
 */

public interface BjajService {

    @POST("monitorunit/getMonitorunit")
    Observable<BaseBeanRsp<ChangeAddressResponBean>> getMonitorunit(@Body ChangeAddressRequestBean params);


    // 获取附近工地列表
    @FormUrlEncoded
    @POST("monitorunit/getMonitorunit")
    Observable<BaseBeanRsp<ChangeAddressResponBean>> getMonitorunitStr(@Field("params") String  str);

    //根据关键字搜索工地
    @FormUrlEncoded
    @POST("monitorunit/findByUnitName")
    Observable<BaseBeanRsp<ChangeAddressResponBean>> byKeyForMonitorunit(@Field("params") String  str);


/*    @POST("monitorunit/getMonitorunit")
    Observable<BaseBeanRsp<ChangeAddressResponBean>> getMonitorunitStr(@Body ChangeAddressRequestBean params);*/

}
