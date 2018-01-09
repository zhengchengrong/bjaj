package com.threehmis.bjaj;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.threehmis.bjaj.adapter.ChangeAddressAapter;
import com.threehmis.bjaj.api.BaseObserver;
import com.threehmis.bjaj.api.Const;
import com.threehmis.bjaj.api.RetrofitFactory;
import com.threehmis.bjaj.api.RxSchedulers;
import com.threehmis.bjaj.api.bean.BaseBeanRsp;
import com.threehmis.bjaj.api.bean.BaseEntity;
import com.threehmis.bjaj.api.bean.GlobalConstant;
import com.threehmis.bjaj.api.bean.ItemResult;
import com.threehmis.bjaj.api.bean.request.ChangeAddressRequestBean;
import com.threehmis.bjaj.api.bean.respon.ChangeAddressResponBean;
import com.threehmis.bjaj.api.bean.respon.GetMainAddressRsp;
import com.threehmis.bjaj.module.base.BaseActivity;
import com.threehmis.bjaj.module.home.HomeActivity;
import com.threehmis.bjaj.module.logins.LoginActivity;
import com.threehmis.bjaj.utils.EmojiEditText;
import com.threehmis.bjaj.utils.KeyBoardUtils;
import com.threehmis.bjaj.utils.RegexUtil;
import com.threehmis.bjaj.utils.SPUtils;
import com.vondear.rxtools.view.RxToast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import okhttp3.RequestBody;

public class ChangeAddressActivity extends BaseActivity {


    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.other)
    TextView mOther;
    @BindView(R.id.titleback)
    TextView mTitleback;
    @BindView(R.id.write)
    EmojiEditText mWrite;
    @BindView(R.id.address)
    TextView mAddress;
    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;

    ChangeAddressAapter mAdapter;
    List<ChangeAddressResponBean> data;
    public LocationClient mLocationClient = null;
    private MyLocationListener myListener = new MyLocationListener();
    public String province = "", city = "";

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_change_address;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initViews() {
        mTitleback.setVisibility(View.GONE);
        mOther.setVisibility(View.VISIBLE);
        mTitle.setText(R.string.change_address);
        mOther.setText(R.string.change_address_ok);


        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        data = new ArrayList<ChangeAddressResponBean>();
        mAdapter = new ChangeAddressAapter(R.layout.layout_address_list_item,data);

        recycler_view.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                String unitName = data.get(i).getUnitName();
                if(!TextUtils.isEmpty(unitName)){
                    mAddress.setText(unitName);
                }
            }
        });

        // 通过定位获取工地列表
        mLocationClient = new LocationClient(getApplicationContext());
        //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);
        //注册监听函数
        baiduMapConfig();
        // 便可发起定位请求
        mLocationClient.start();

        // 通过搜索获取工地列表
        mWrite.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String editable = mWrite.getText().toString();
                String str = RegexUtil.stringFilter(editable.toString());
                if(!editable.equals(str)){
                    mWrite.setText(str);
                    //设置新的光标所在位置
                    mWrite.setSelection(str.length());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mWrite.setOnEditorActionListener(new EditorActionListener());   mWrite.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String editable = mWrite.getText().toString();
                String str = RegexUtil.stringFilter(editable.toString());
                if(!editable.equals(str)){
                    mWrite.setText(str);
                    //设置新的光标所在位置
                    mWrite.setSelection(str.length());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mWrite.setOnEditorActionListener(new EditorActionListener());

    }

    @Override
    protected void updateViews(boolean isRefresh) {
        // 网络错误，点击重新获取数据
        getData();
    }

    private class EditorActionListener implements TextView.OnEditorActionListener {
        @Override
        public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {

            if (actionId== EditorInfo.IME_ACTION_SEARCH|| (keyEvent != null && keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER)){

                KeyBoardUtils.closeKeybord(mWrite,ChangeAddressActivity.this);
                getSearch();
            }

            return false;
        }
    }
    public void getData() {
        ChangeAddressRequestBean changeAddressRequestBean = new ChangeAddressRequestBean();
        changeAddressRequestBean.setProvince(province);
        changeAddressRequestBean.setCity(city);
        String str = new Gson().toJson(changeAddressRequestBean);
        Observable<BaseBeanRsp<ChangeAddressResponBean>> observable = RetrofitFactory.getInstance().getMonitorunitStr(RetrofitFactory.BASE_URL_BEIFEN+"monitorunit/getMonitorunit",str);
        observable.compose(RxSchedulers.<BaseBeanRsp<ChangeAddressResponBean>>compose(this.<BaseBeanRsp<ChangeAddressResponBean>>bindToLifecycle()
        )).subscribe(new BaseObserver<ChangeAddressResponBean>(this) {
            @Override
            protected void onHandleSuccess(BaseBeanRsp<ChangeAddressResponBean> t) {
                data.clear();
                data.addAll(t.getProjectList());
                mAdapter.notifyDataSetChanged();
            }

            @Override
            protected void onHandleEmpty(BaseBeanRsp<ChangeAddressResponBean> t) {
                showEmpty();
            }
        });
    }



    @OnClick(R.id.other)
    void other(){
        if (!mAddress.getText().toString().endsWith(Const.CHOSE_ME)) {
            SPUtils.put(this,Const.ADDRESS,mAddress.getText().toString());
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }else {
            Toast.makeText(getApplicationContext(), Const.CHOSE_ME_SHOW, Toast.LENGTH_SHORT).show();
        }
}
    //搜索
    void getSearch(){
        GetMainAddressRsp getMainAddressRsp = new GetMainAddressRsp();
        String unitName= mWrite.getText().toString();
        if(!TextUtils.isEmpty(unitName)){
            getMainAddressRsp.setUnitName(unitName);
            String str = new Gson().toJson(getMainAddressRsp);
            Observable<BaseBeanRsp<ChangeAddressResponBean>> observable = RetrofitFactory.getInstance().byKeyForMonitorunit(RetrofitFactory.BASE_URL_BEIFEN+"monitorunit/findByUnitName",str);
            observable.compose(RxSchedulers.<BaseBeanRsp<ChangeAddressResponBean>>compose(this.<BaseBeanRsp<ChangeAddressResponBean>>bindToLifecycle()
            )).subscribe(new BaseObserver<ChangeAddressResponBean>(this) {
                @Override
                protected void onHandleSuccess(BaseBeanRsp<ChangeAddressResponBean> t) {
                    data.clear();
                    data.addAll(t.getProjectList());
                    mAdapter.notifyDataSetChanged();
                }

                @Override
                protected void onHandleEmpty(BaseBeanRsp<ChangeAddressResponBean> t) {
                    showEmpty();
                }
            });
        }

    }



    /**
     * 实现实时位置回调监听
     */
    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            // Receive Location
            city = location.getCity();
            province = location.getProvince();

            if( !TextUtils.isEmpty(city) || !TextUtils.isEmpty(province)){
                // 停止定位
                mLocationClient.stop();
                getData();
            }
        }
    }



    private void baiduMapConfig() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        //可选，设置定位模式，默认高精度
        //LocationMode.Hight_Accuracy：高精度；
        //LocationMode. Battery_Saving：低功耗；
        //LocationMode. Device_Sensors：仅使用设备；
        option.setCoorType("bd09ll");
        //可选，设置返回经纬度坐标类型，默认gcj02
        //gcj02：国测局坐标；
        //bd09ll：百度经纬度坐标；
        //bd09：百度墨卡托坐标；
        //海外地区定位，无需设置坐标类型，统一返回wgs84类型坐标
        option.setScanSpan(1000);
        //可选，设置发起定位请求的间隔，int类型，单位ms
        //如果设置为0，则代表单次定位，即仅定位一次，默认为0
        //如果设置非0，需设置1000ms以上才有效
        option.setOpenGps(true);
        //可选，设置是否使用gps，默认false
        //使用高精度和仅用设备两种定位模式的，参数必须设置为true
        option.setLocationNotify(true);
        //可选，设置是否当GPS有效时按照1S/1次频率输出GPS结果，默认false
        option.setIgnoreKillProcess(false);
        //可选，定位SDK内部是一个service，并放到了独立进程。
        //设置是否在stop的时候杀死这个进程，默认（建议）不杀死，即setIgnoreKillProcess(true)
        option.SetIgnoreCacheException(false);
        //可选，设置是否收集Crash信息，默认收集，即参数为false
        option.setWifiCacheTimeOut(5*60*1000);
        //可选，7.2版本新增能力
        //如果设置了该接口，首次启动定位时，会先判断当前WiFi是否超出有效期，若超出有效期，会先重新扫描WiFi，然后定位
        option.setEnableSimulateGps(false);
        //可选，设置是否需要过滤GPS仿真结果，默认需要，即参数为false


        option.setIsNeedAddress(true);
//可选，是否需要地址信息，默认为不需要，即参数为false
//如果开发者需要获得当前点的地址信息，此处必须为true


        mLocationClient.setLocOption(option);



        //mLocationClient为第二步初始化过的LocationClient对象
        //需将配置好的LocationClientOption对象，通过setLocOption方法传递给LocationClient对象使用
        //更多LocationClientOption的配置，请参照类参考中LocationClientOption类的详细说明
    }
}
