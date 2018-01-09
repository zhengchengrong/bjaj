package com.threehmis.bjaj.module.more;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.threehmis.bjaj.R;

public class MapLocationActivity extends AppCompatActivity implements OnGetGeoCoderResultListener {

    GeoCoder mSearch = null; // 搜索模块，也可去掉地图模块独立使用
    BaiduMap mBaiduMap = null;
    MapView mMapView;
    private TextView location_name;
    Float lat,lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_location);

        lat=getIntent().getFloatExtra("lat", (float)39.915112);
        lon=getIntent().getFloatExtra("lon",(float)116.403955);

        Log.d("cd","lat="+lat+"=lon="+lon);
        TextView titleback = (TextView) findViewById(R.id.titleback);
        TextView title = (TextView) findViewById(R.id.title);
        title.setText("地理位置");
        titleback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        location_name = (TextView) findViewById(R.id.location_name);

// 地图初始化
        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();

        // 初始化搜索模块，注册事件监听
        mSearch = GeoCoder.newInstance();
        mSearch.setOnGetGeoCodeResultListener(this);

//        String lat="23.151885",lon="113.353893";
        LatLng ptCenter = new LatLng(lat, lon);
        // 反Geo搜索
        mSearch.reverseGeoCode(new ReverseGeoCodeOption()
                .location(ptCenter));

    }


    @Override
    protected void onPause() {
        if (mMapView != null)
            mMapView.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        if (mMapView != null)
            mMapView.onResume();

        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mMapView.onDestroy();
        mSearch.destroy();
        super.onDestroy();
    }


    @Override
    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {

    }

    @Override
    public void onGetReverseGeoCodeResult(ReverseGeoCodeResult result) {

        //通过经纬度获取地址
        if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
            location_name.setText( "抱歉，未能找到结果");

            return;
        }
        mBaiduMap.clear();
        mBaiduMap.addOverlay(new MarkerOptions().position(result.getLocation())
                .icon(BitmapDescriptorFactory
                        .fromResource(R.drawable.icon_marka)));
        mBaiduMap.setMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().zoom(15).build()));//设置缩放级别
        mBaiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(result
                .getLocation()));
        location_name.setText( result.getAddress());

    }


}
