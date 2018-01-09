package com.threehmis.bjaj;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.threehmis.bjaj.api.bean.request.BaseBeanReq;
import com.tinkerpatch.sdk.TinkerPatch;
import com.tinkerpatch.sdk.loader.TinkerPatchApplicationLike;
import com.vondear.rxtools.RxUtils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by zhengchengrong on 2017/8/29.
 */

public class AndroidApplication extends Application {
    private static Context mAppContext;
    private static AndroidApplication app;

    private ApplicationLike tinkerApplicationLike;


    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");

    OkHttpClient mOkHttpClient=new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).build();

    public static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化工具框架 https://github.com/vondear/RxTools
        RxUtils.init(this);
        this.mAppContext = this;
        this.app = this;
        // 我们可以从这里获得Tinker加载过程的信息
        tinkerApplicationLike = TinkerPatchApplicationLike.getTinkerPatchApplicationLike();
        // 初始化TinkerPatch SDK, 更多配置可参照API章节中的,初始化SDK
        TinkerPatch.init(tinkerApplicationLike)
                .reflectPatchLibrary()
                .setPatchRollbackOnScreenOff(true)
                .setPatchRestartOnSrceenOff(true)
                .setFetchPatchIntervalByHours(3);

        // 每隔3个小时(通过setFetchPatchIntervalByHours设置)去访问后台时候有更新,通过handler实现轮训的效果
        TinkerPatch.with().fetchPatchUpdateAndPollWithInterval();


        // 我们可以从这里获得Tinker加载过程的信息
        tinkerApplicationLike = TinkerPatchApplicationLike.getTinkerPatchApplicationLike();

        // 初始化TinkerPatch SDK, 更多配置可参照API章节中的,初始化SDK
        TinkerPatch.init(tinkerApplicationLike)
                .reflectPatchLibrary()
                .setPatchRollbackOnScreenOff(true)
                .setPatchRestartOnSrceenOff(true)
                .setFetchPatchIntervalByHours(3);

        // 每隔3个小时(通过setFetchPatchIntervalByHours设置)去访问后台时候有更新,通过handler实现轮训的效果
        TinkerPatch.with().fetchPatchUpdateAndPollWithInterval();

    }

    public static Context getAppContext(){
        return mAppContext;
    }

    public static AndroidApplication getInstance() {
        return app;
    }

    //Okhttp post 方式上传数据
    public <T> void doPostAsyncfile(String url, BaseBeanReq<T> object, Callback callback) {
        RequestBody requestBody = new FormBody.Builder()
                .add("params", JSON.toJSONString(object))
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        mOkHttpClient.newCall(request).enqueue(callback);
    }
    //Okhttp post 方式上传编辑后的图片
    public void doPostAsyncEditimage(String url, File file, String checkId, String photoId, String type, Callback callback) {

        Log.d("CD", "url=="+url+"=="+checkId);

        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(), RequestBody.create(MEDIA_TYPE_PNG, file))
                .addFormDataPart("checkId",checkId)
                .addFormDataPart("photoId",photoId)
                .addFormDataPart("type",type).build();


        Request request = new Request.Builder().url(url)
                .post(requestBody).build();

        mOkHttpClient.newCall(request).enqueue(callback);

    }
}
