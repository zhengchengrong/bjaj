package com.threehmis.bjaj.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.threehmis.bjaj.R;
import com.threehmis.bjaj.api.bean.respon.NameKeyRsp;
import com.threehmis.bjaj.utils.VHUtil;

import java.util.ArrayList;
import java.util.List;


public class ExamReportListAdapter extends BaseAdapter {

    List<NameKeyRsp> liststr = new ArrayList<>();


    @Override
    public int getCount() {
        return liststr == null ? 0 : liststr.size();
    }

    @Override
    public Object getItem(int i) {
        return liststr.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null)
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_examreport_item, parent, false);

        TextView itemName = VHUtil.ViewHolder.get(convertView, R.id.itemName);
        TextView itemLabel = VHUtil.ViewHolder.get(convertView, R.id.itemLabel);


        itemName.setText(liststr.get(position).name);
        itemLabel.setText(liststr.get(position).key);

        return convertView;
    }

    public void adddate(List<NameKeyRsp> str) {

        this.liststr = str;
        notifyDataSetChanged();
    }

}
