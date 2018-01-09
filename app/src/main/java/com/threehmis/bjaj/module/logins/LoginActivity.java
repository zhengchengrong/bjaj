package com.threehmis.bjaj.module.logins;

import android.Manifest;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.TextView;

import com.threehmis.bjaj.ChangeAddressActivity;
import com.threehmis.bjaj.R;
import com.threehmis.bjaj.api.Const;
import com.threehmis.bjaj.api.bean.BaseBeanRsp;
import com.threehmis.bjaj.api.bean.GlobalConstant;
import com.threehmis.bjaj.api.bean.respon.GetLoginListRsp;
import com.threehmis.bjaj.injector.components.DaggerLoginComponent;
import com.threehmis.bjaj.injector.modules.LoginModule;
import com.threehmis.bjaj.module.base.BaseActivity;
import com.threehmis.bjaj.module.home.HomeActivity;
import com.threehmis.bjaj.utils.CDUtil;
import com.threehmis.bjaj.utils.SPUtils;
import com.vondear.rxtools.RxActivityUtils;
import com.vondear.rxtools.view.RxToast;

import butterknife.BindView;
import kr.co.namee.permissiongen.PermissionGen;

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

    private static int WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 1;
    private static int WRITE_EXTERNAL_STORAGE_REQUEST_CODE2 = 2;


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
        // 监督站
        String address = (String) SPUtils.get(this, Const.ADDRESS,"");
        if(!TextUtils.isEmpty(address)){
            mAddress.setText(address);
        }
        // 修改地址
        mChangeAddress.setOnClickListener(this);

        // 登陆
        mLogin.setOnClickListener(this);




    }

    // 更新视图
    @Override
    protected void updateViews(boolean isRefresh) {
    }


    // 登陸成功，保存登陆后的用户信息
    @Override
    public void successLogin(BaseBeanRsp<GetLoginListRsp> loginInfoBean) {
        if (mAgree.isChecked()) {
            //实例化SharedPreferences.Editor对象（第二步）
            SPUtils.put(this,Const.PHONENUM,mPhoneNum.getText().toString());
            SPUtils.put(this,Const.PASSWORD,mPhoneNum.getText().toString());
            SPUtils.put(this,Const.ISCHECKED,true);
        }
        // 登陆页面本地缓存保存坐标点
        CDUtil.saveObject(loginInfoBean.projectList, Const.LOGINDATE);
        //登陆成功后，跳转到主页面
        startActivity(HomeActivity.class);
    }

    // 登陆失败
    @Override
    public void errorLogin() {
        RxToast.showToast(Const.REEORLOGIN);
    }

    @Override
    public void onClick(View view) {
                switch (view.getId()){
                    case R.id.change_address:
                    startActivity(ChangeAddressActivity.class);
                    finish();
                    break;
                    case R.id.login:
                        String phoneNum = mPhoneNum.getText().toString();
                        String password = mPassword.getText().toString();
                        if(TextUtils.isEmpty(phoneNum)){
                            RxToast.showToast(Const.INPUT_ACCOUNT);
                            return;
                        }
                        if(TextUtils.isEmpty(password)){
                            RxToast.showToast(Const.INPUT_PASSWORD);
                            return;
                        }
                        mPresenter.login(phoneNum,password);
                        break;
                }
    }
    @Override
    protected void onResume() {
        super.onResume();
        // 缺少权限时, 进入权限配置页面
        //存储授权
        PermissionGen.with(LoginActivity.this)
                .addRequestCode(100)
                .permissions(
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA,
                        Manifest.permission.RECORD_AUDIO)
                .request();
    }
    @Override public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                                     int[] grantResults) {
        PermissionGen.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }
}
