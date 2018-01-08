package com.threehmis.bjaj.module.logins;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.TextView;

import com.threehmis.bjaj.AndroidApplication;
import com.threehmis.bjaj.R;
import com.threehmis.bjaj.api.bean.BaseEntity;
import com.threehmis.bjaj.api.bean.GlobalConstant;
import com.threehmis.bjaj.api.bean.LoginInfoBean;
import com.threehmis.bjaj.injector.components.DaggerLoginComponent;
import com.threehmis.bjaj.injector.modules.LoginModule;
import com.threehmis.bjaj.module.base.BaseActivity;
import com.threehmis.bjaj.module.home.HomeActivity;
import com.threehmis.bjaj.utils.SPUtils;
import com.vondear.rxtools.RxActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhengchengrong on 2017/9/4.
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements ILoginView, View.OnClickListener {

    @BindView(R.id.login)
    TextView mLogin;
    @BindView(R.id.address)
    TextView mAddress;
    @BindView(R.id.phoneNum)
    EditText mPhoneNum;
    @BindView(R.id.password)
    EditText mPassword;
    @BindView(R.id.agree)
    CheckedTextView mAgree;
    @BindView(R.id.change_address)
    TextView mChangeAddress;

    // 加载布局
    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_login;
    }

    // 依赖注入
    @Override
    protected void initInjector() {
        // Activity与presenter仅仅耦合在了一起，当需要改变presenter的构造方式时，需要修改这里的代码,所以用依赖注入
        DaggerLoginComponent.builder()
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);
    }

    // 初始化视图
    @Override
    protected void initViews() {
    }

    // 更新视图
    @Override
    protected void updateViews(boolean isRefresh) {
    }

    @Override
    public void toActivity(String loginInfo) {
        Bundle bundle = new Bundle();
        bundle.putString(GlobalConstant.LOGININFO, loginInfo);
        RxActivityUtils.skipActivity(this, HomeActivity.class, bundle);
    }

    // 保存登陆后的用户信息
    @Override
    public void saveLoginInfo(BaseEntity<LoginInfoBean> loginInfoBean) {
        SPUtils.put(AndroidApplication.getAppContext(), GlobalConstant.TOKEN, loginInfoBean.getData().getToken());
        SPUtils.put(AndroidApplication.getAppContext(), GlobalConstant.LOGINID, loginInfoBean.getData().getLoginId() + "");

    }

    @Override
    public void onClick(View view) {

    }


}
