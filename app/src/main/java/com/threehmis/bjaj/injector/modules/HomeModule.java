package com.threehmis.bjaj.injector.modules;

import com.threehmis.bjaj.module.home.IHomeView;
import com.threehmis.bjaj.module.logins.ILoginView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhengchengrong on 2017/9/4.
 */

@Module
public class HomeModule {

    private final IHomeView mHomeView;

    public HomeModule(IHomeView homeView){
        this.mHomeView = homeView;
    }

    // 给 LoginActivity 实例化LoginPresenter传递这个对象给构造方法loginView
    @Provides
    IHomeView provideLoginView(){
        return mHomeView;
    }


}
