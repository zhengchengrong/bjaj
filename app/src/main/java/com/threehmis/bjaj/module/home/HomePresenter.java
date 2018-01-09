package com.threehmis.bjaj.module.home;

import com.google.gson.Gson;
import com.threehmis.bjaj.api.BaseObserver;
import com.threehmis.bjaj.api.RetrofitFactory;
import com.threehmis.bjaj.api.RxSchedulers;
import com.threehmis.bjaj.api.bean.BaseBeanRsp;
import com.threehmis.bjaj.api.bean.request.GetLoginListReq;
import com.threehmis.bjaj.api.bean.respon.GetLoginListRsp;
import com.threehmis.bjaj.module.base.IBasePresenter;
import com.threehmis.bjaj.module.logins.ILoginView;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by zhengchengrong on 2017/9/4.
 */

public class HomePresenter implements IBasePresenter{

     private IHomeView mHomeView;
    // 当LoginAcitivty注解@Inject LoginPresenter 会调用这个构造方法进行实例化，ILoginView是通过module传递的

    @Inject
    HomePresenter(IHomeView homeView){
        this.mHomeView = homeView;
    }


    // 几乎每个页面都有获取数据的逻辑，所以抽象出一个方法
    @Override
    public void getData(boolean isRefresh) {

    }

    @Override
    public void getMoreData() {

    }
}
