package com.threehmis.bjaj.module.base;


import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * Created by long on 2016/8/23.
 * 基础 BaseView 接口
 */
public interface IBaseView {
    /**
     * 显示加载动画
     */
    void showLoading();
    /**
     * 隐藏加载
     */
    void hideLoading();
    /**
     * 显示网络错误，modify 对网络异常在 BaseActivity 和 BaseFragment 统一处理
     */
    void showNetError();

    /**
     * 显示空数据
     */
    void showEmpty();
    /**
     * 绑定生命周期
     * @param <T>
     * @return
     */
    <T> LifecycleTransformer<T> bindToLife();

}
