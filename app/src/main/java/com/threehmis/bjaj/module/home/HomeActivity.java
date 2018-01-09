package com.threehmis.bjaj.module.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.threehmis.bjaj.R;
import com.threehmis.bjaj.adapter.HomeFragmentPagerAdapter;
import com.threehmis.bjaj.dialog.MainMoreDialog;
import com.threehmis.bjaj.injector.components.DaggerHomeComponent;
import com.threehmis.bjaj.injector.modules.HomeModule;
import com.threehmis.bjaj.module.base.BaseActivity;
import com.threehmis.bjaj.module.map.MainMapFragment;
import com.threehmis.bjaj.utils.ScreenUtil;
import com.threehmis.bjaj.widget.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhengchengrong on 2017/9/4.
 */

public class HomeActivity extends BaseActivity<HomePresenter> implements IHomeView {

    @BindView(R.id.viewPager)
    NoScrollViewPager mViewPager;
    @BindView(R.id.maps)
    RadioButton mMaps;
    @BindView(R.id.notice)
    RadioButton mNotice;
    @BindView(R.id.count)
    RadioButton mCount;
    @BindView(R.id.more)
    TextView mMore;
    @BindView(R.id.radioGroup)
    RadioGroup mRadioGroup;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_home;
    }

    @Override
    protected void initInjector() {
        // Activity与presenter仅仅耦合在了一起，当需要改变presenter的构造方式时，需要修改这里的代码,所以用依赖注入
        DaggerHomeComponent.builder()
                .homeModule(new HomeModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void initViews() {

        LinearLayout.LayoutParams pars = (LinearLayout.LayoutParams) mMore.getLayoutParams();
        pars.width = (int) (ScreenUtil.getScreenWidth(this) * 0.25);

        //RadioGroup选中状态改变监听
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.maps:
                        /**
                         * setCurrentItem第二个参数控制页面切换动画
                         * true:打开/false:关闭
                         */
                        mViewPager.setCurrentItem(0, false);
                        break;
                    case R.id.notice:
                        mViewPager.setCurrentItem(1, false);
                        break;
                    case R.id.count:
                        mViewPager.setCurrentItem(2, false);
                        break;
                }
            }
        });
        MainMapFragment weChatFragment = new MainMapFragment();
        MainMapFragment contactsFragment = new MainMapFragment();
        MainMapFragment discoveryFragment = new MainMapFragment();
        List<Fragment> alFragment = new ArrayList<Fragment>();
        alFragment.add(weChatFragment);
        alFragment.add(contactsFragment);
        alFragment.add(discoveryFragment);
        //ViewPager设置适配器
        mViewPager.setAdapter(new HomeFragmentPagerAdapter(getSupportFragmentManager(), alFragment));
        //ViewPager显示第一个Fragment
        mViewPager.setCurrentItem(0);
        //ViewPager页面切换监听
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mRadioGroup.check(R.id.maps);
                        break;
                    case 1:
                        mRadioGroup.check(R.id.notice);
                        break;
                    case 2:
                        mRadioGroup.check(R.id.count);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

}

    @Override
    protected void updateViews(boolean isRefresh) {

    }
    @OnClick(R.id.more)
    void more() {
        new MainMoreDialog(this).show();
    }
}
