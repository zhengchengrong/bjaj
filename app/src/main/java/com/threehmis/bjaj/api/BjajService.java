package com.threehmis.bjaj.api;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

import com.threehmis.bjaj.api.bean.BaseEntity;
import com.threehmis.bjaj.api.bean.ItemResult;
import com.threehmis.bjaj.api.bean.LoginInfoBean;
import com.threehmis.bjaj.api.bean.PictureResult;

/**
 * Created by zhengchengrong on 2017/9/1.
 */

public interface BjajService {


    @POST("item/{id}")
    Observable<BaseEntity<ItemResult>> getMonitorunit(@Path("id") String id);



}
