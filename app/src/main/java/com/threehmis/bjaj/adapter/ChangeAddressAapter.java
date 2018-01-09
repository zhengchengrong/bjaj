package com.threehmis.bjaj.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.threehmis.bjaj.R;
import com.threehmis.bjaj.api.bean.respon.ChangeAddressResponBean;

import java.util.List;

/**
 * Created by llz on 2018/1/9.
 */

public class ChangeAddressAapter  extends BaseQuickAdapter<ChangeAddressResponBean, BaseViewHolder> {
    public ChangeAddressAapter(int layoutResId, @Nullable List<ChangeAddressResponBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, ChangeAddressResponBean changeAddressResponBean) {
        baseViewHolder.setText(R.id.tv_address_name,changeAddressResponBean.getUnitName());
    }
}
