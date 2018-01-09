package com.threehmis.bjaj.api;

import android.widget.Toast;

import com.threehmis.bjaj.api.bean.BaseBeanRsp;
import com.vondear.rxtools.RxLogUtils;
import com.threehmis.bjaj.api.bean.BaseEntity;
import com.threehmis.bjaj.module.base.IBaseView;
import com.vondear.rxtools.view.RxToast;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by zhengchengrong on 2017/9/3.
 */
// 基本观察者，所有的观察都实现该类，然后重写onHandleSuccess方法处理消息即可。
public abstract class BaseObserver<T> implements Observer<BaseBeanRsp<T>>{
    private static final String TAG = "BaseObserver";

    private  IBaseView mBaseView;
    protected BaseObserver(IBaseView baseView) {
        this.mBaseView = baseView;
    }

    protected BaseObserver() {
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(BaseBeanRsp<T> value) {
        // 隐藏加载
        mBaseView.hideLoading();
        if (value.isSuccess()) {
            onHandleSuccess(value);
        } else if(value.isError()){ // 如果数据为空，显示空视图
            onHandleEmpty(value);
        }else{ // 其他，显示网络错误
            mBaseView.showNetError();
        }

    }

    @Override
    public void onError(Throwable e) {
        RxLogUtils.e(e.getStackTrace()+":"+e.getMessage());
    }

    @Override
    public void onComplete() {
        RxLogUtils.d(TAG, "onComplete");
    }

    protected abstract void onHandleSuccess(BaseBeanRsp<T> t);

    protected abstract void onHandleEmpty(BaseBeanRsp<T> t);

}
