package com.threehmis.bjaj;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.threehmis.bjaj.api.BaseObserver;
import com.threehmis.bjaj.api.RetrofitFactory;
import com.threehmis.bjaj.api.RxSchedulers;
import com.threehmis.bjaj.api.bean.BaseEntity;
import com.threehmis.bjaj.api.bean.GlobalConstant;
import com.threehmis.bjaj.api.bean.ItemResult;
import com.threehmis.bjaj.api.bean.respon.GetMainAddressRsp;
import com.threehmis.bjaj.module.base.BaseActivity;
import com.threehmis.bjaj.module.home.HomeActivity;
import com.threehmis.bjaj.module.logins.LoginActivity;
import com.threehmis.bjaj.utils.EmojiEditText;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

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
    @BindView(R.id.list_view)
    RecyclerView mListView;
    List<GetMainAddressRsp> data = new ArrayList<>();
    public LocationClient mLocationClient;
    public MyLocationListener mMyLocationListener;
    LocationClientOption option;
    public String province = "", city = "";
    private ProgressDialog dialog;
    private Handler handler = new Handler();

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

        // 定位
        mLocationClient = new LocationClient(this.getApplicationContext());
        mMyLocationListener = new MyLocationListener();
        mLocationClient.registerLocationListener(mMyLocationListener);
        option = new LocationClientOption();
        option.setOpenGps(true);// 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(0);
        option.setIsNeedAddress(true);
        mLocationClient.setLocOption(option);
        mLocationClient.start();

        mListView.setAdapter(new BaseQuickAdapter<GetMainAddressRsp, BaseViewHolder>(R.layout.layout_address_list_item, data) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, GetMainAddressRsp getMainAddressRsp) {
                baseViewHolder.setText(R.id.name,getMainAddressRsp.unitName);
            }
        });

     /*   mListView.setAdapter(new BaseQuickAdapter<String,BaseViewHolder>(R.layout.item_listview_popup,) {

            @Override
            protected void convert(BaseViewHolder baseViewHolder, String s) {

            }
        });*/

    }

    @Override
    protected void updateViews(boolean isRefresh) {
        if (province!=null&&province.length()>0){
            getData();
        }else {
            dialog = new ProgressDialog(this);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(true);
            dialog.setTitle("正在获取定位信息...");
            dialog.show();
            handler.postDelayed(task,2000);//延迟调用
//            handler.post(task);//立即调用
        }



    }
    private Runnable task = new Runnable() {
        public void run() {
            // TODO Auto-generated method stub
            if (province!=null&&province.length()>0)
                getData();
            else
                handler.postDelayed(this,2*1000);//设置延迟时间，此处是2秒
            //需要执行的代码
        }
    };
    public void getData() {
        if (dialog!=null)
            dialog.cancel();


        Observable<BaseEntity<ItemResult>> observable =  RetrofitFactory.getInstance().getItemObser(536563);
        observable.compose(RxSchedulers.<BaseEntity<ItemResult>>compose(this.<BaseEntity<ItemResult>>bindToLifecycle()
        )).subscribe(new BaseObserver<ItemResult>() {
            @Override
            protected void onHandleSuccess(BaseEntity<ItemResult> t) {
                tvHomeContent.setText(new Gson().toJson(t));

            }

            @Override
            protected void onHandleError(BaseEntity<ItemResult> t) {
                if(t.getCode() == GlobalConstant.TOKEN_REEOR){
                    Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


    /**
     * 实现实时位置回调监听
     */
    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            // Receive Location

            if (location.getLocType() == BDLocation.TypeGpsLocation) {// GPS定位结果
                city = location.getCity();
                province = location.getProvince();
            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {// 网络定位结果
                city = location.getCity();
                province = location.getProvince();
            } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {// 离线定位结果
                city = location.getCity();
                province = location.getProvince();
            } else if (location.getLocType() == BDLocation.TypeServerError) {
                province = "江西省";city = "南昌市";
            } else if (location.getLocType() == BDLocation.TypeNetWorkException) {
                province = "江西省";city = "南昌市";
                Toast.makeText(getApplicationContext(), "网络错误，定位失败", Toast.LENGTH_LONG).show();
            } else if (location.getLocType() == BDLocation.TypeCriteriaException) {
                province = "江西省";city = "南昌市";
                Toast.makeText(getApplicationContext(), "无法获取有效定位，请检查手机是否处于飞行模式", Toast.LENGTH_LONG).show();
            }
        }

    }

}
