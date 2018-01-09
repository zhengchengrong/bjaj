package com.threehmis.bjaj.module.logins;

import com.google.gson.Gson;
import com.threehmis.bjaj.api.BaseObserver;
import com.threehmis.bjaj.api.BjajService;
import com.threehmis.bjaj.api.Const;
import com.threehmis.bjaj.api.RetrofitFactory;
import com.threehmis.bjaj.api.RxSchedulers;
import com.threehmis.bjaj.api.bean.BaseBeanRsp;
import com.threehmis.bjaj.api.bean.BaseEntity;
import com.threehmis.bjaj.api.bean.LoginInfoBean;
import com.threehmis.bjaj.api.bean.request.GetLoginListReq;
import com.threehmis.bjaj.api.bean.respon.GetLoginListRsp;
import com.threehmis.bjaj.module.base.IBasePresenter;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by zhengchengrong on 2017/9/4.
 */

public class LoginPresenter implements IBasePresenter{

     private ILoginView mLoginView;
    // 当LoginAcitivty注解@Inject LoginPresenter 会调用这个构造方法进行实例化，ILoginView是通过module传递的

    @Inject
    LoginPresenter(ILoginView loginView){
        this.mLoginView = loginView;
    }


    // 登录操作
    // mLoginView.<BaseEntity<UserEntity>>bindToLife()00
    // 回调了BaseActivity中的bindToLife 返回了LifecycleTransformer对象，将生命周期和LoginAcitivity捆绑防止内存泄漏

    public void login(String phoneNum,String password){
        mLoginView.showLoading();
        GetLoginListReq req = new GetLoginListReq();
        req.setPhone(phoneNum);
        req.setPassword(password);
        String str = new Gson().toJson(req);

        Observable<BaseBeanRsp<GetLoginListRsp>> observable = RetrofitFactory.getInstance().toLogin(str);
        observable.compose(RxSchedulers.<BaseBeanRsp<GetLoginListRsp>>compose(mLoginView.<BaseBeanRsp<GetLoginListRsp>>bindToLife()
        )).subscribe(new BaseObserver<GetLoginListRsp>(mLoginView) {
            @Override
            protected void onHandleSuccess(BaseBeanRsp<GetLoginListRsp> userEntity) {
                // 登陆成功 保存用户信息等操作
                mLoginView.successLogin(userEntity);
            }
            @Override
            protected void onHandleEmpty(BaseBeanRsp<GetLoginListRsp> t) {
            // 登陆失败
                mLoginView.errorLogin();
            }
        });
    }

    @Override
    public void getData(boolean isRefresh) {
        //调用model层方法，加载数据
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //回调方法成功时
        //mLoginView.getDate(2);
    }
    @Override
    public void getMoreData() {

    }
}
