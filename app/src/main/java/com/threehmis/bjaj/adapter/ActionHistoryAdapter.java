package com.threehmis.bjaj.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.threehmis.bjaj.R;
import com.threehmis.bjaj.api.GetData;
import com.threehmis.bjaj.api.bean.respon.GetActionHistoryRsp;
import com.threehmis.bjaj.dialog.DeleteDialog;
import com.threehmis.bjaj.utils.ScreenUtil;


import java.util.ArrayList;
import java.util.List;


public class ActionHistoryAdapter extends RecyclerView.Adapter<ActionHistoryAdapter.ViewHolder> {

    private List<GetActionHistoryRsp> listRsps = new ArrayList<>();

    Context context;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_actionhistory_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
//        viewHolder.setIsRecyclable(false);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        FrameLayout.LayoutParams pars = (FrameLayout.LayoutParams) holder.pics[0].getLayoutParams();

        pars.width = (int) (ScreenUtil.getScreenWidth(context) * 0.2);
        pars.height = (int) (ScreenUtil.getScreenWidth(context) * 0.13);

        FrameLayout.LayoutParams pars2 = (FrameLayout.LayoutParams) holder.pics[1].getLayoutParams();
        pars2.width = (int) (ScreenUtil.getScreenWidth(context) * 0.2);
        pars2.height = (int) (ScreenUtil.getScreenWidth(context) * 0.13);

        FrameLayout.LayoutParams pars3 = (FrameLayout.LayoutParams) holder.pics[2].getLayoutParams();
        pars3.width = (int) (ScreenUtil.getScreenWidth(context) * 0.2);
        pars3.height = (int) (ScreenUtil.getScreenWidth(context) * 0.13);


        FrameLayout.LayoutParams pars4 = (FrameLayout.LayoutParams) holder.pics[3].getLayoutParams();
        pars4.width = (int) (ScreenUtil.getScreenWidth(context) * 0.2);
        pars4.height = (int) (ScreenUtil.getScreenWidth(context) * 0.13);

        holder.title.setVisibility(View.VISIBLE);
        holder.title.setText(listRsps.get(position).type);

        if (position != 0) {
            holder.title.setVisibility(listRsps.get(position).type.equals(listRsps.get(position - 1).type) ? View.GONE : View.VISIBLE);
        }

        holder.content.setText(listRsps.get(position).itemName);
        switch (listRsps.get(position).checkResult) {

            case "符合":
                holder.type.setText("符合");
                holder.type.setBackgroundResource(R.drawable.shape_centergreen_btn);
                break;
            case "不符合":
                holder.type.setText("不符合");
                holder.type.setBackgroundResource(R.drawable.shape_centerred_btn);
                break;
//            case "":
//                holder.nook.setChecked(false);
//                holder.ok.setChecked(false);
//                break;
            default:
                break;
        }

        //点击监听
        holder.content_layout.setOnClickListener(new clickListener(position));
        holder.flayouts[0].setOnClickListener(new clickListener(position));
        holder.flayouts[1].setOnClickListener(new clickListener(position));
        holder.flayouts[2].setOnClickListener(new clickListener(position));
        holder.flayouts[3].setOnClickListener(new clickListener(position));


        if (listRsps.get(position).checkFile != null && listRsps.get(position).checkFile.size() > 0) {
            //图片处理

            holder.layout_pics.setVisibility(View.VISIBLE);
            holder.pics[0].setVisibility(View.INVISIBLE);
            holder.pics[1].setVisibility(View.INVISIBLE);
            holder.pics[2].setVisibility(View.INVISIBLE);
            holder.pics[3].setVisibility(View.INVISIBLE);
            holder.types[0].setVisibility(View.INVISIBLE);
            holder.types[1].setVisibility(View.INVISIBLE);
            holder.types[2].setVisibility(View.INVISIBLE);
            holder.types[3].setVisibility(View.INVISIBLE);

            for (int i = 0; i < (listRsps.get(position).checkFile.size() > 4 ? 4 : listRsps.get(position).checkFile.size()); i++) {


                //视频
                if (listRsps.get(position).checkFile.get(i).url != null && listRsps.get(position).checkFile.get(i).url.length() > 0) {
                    Glide.with(context).load(GetData.url + "supervise/lookPhoto/" + listRsps.get(position).checkFile.get(i).id).diskCacheStrategy(DiskCacheStrategy.ALL)
                            .override(900, 600).centerCrop().into(holder.pics[i]);
                    holder.types[i].setImageResource(R.drawable.play_btn);
                    holder.pics[i].setVisibility(View.VISIBLE);
                    holder.types[i].setVisibility(View.VISIBLE);

                } else
                    switch (listRsps.get(position).checkFile.get(i).type) {
                        //视频
//                    case "video":
//                        //获取视频url第一帧图片
//                        Bitmap bitmap = getBitmapFormUrl(GetData.url + "supervise/lookPhoto/" + listRsps.get(position).checkFile.get(i).id);
//                        //bitmap转uri
//                        Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, null, null));
//                        Glide.with(context).load(uri).diskCacheStrategy(DiskCacheStrategy.ALL)
//                                .override(900, 600).centerCrop().into(holder.pics[i]);
//
//                        holder.types[i].setImageResource(R.drawable.play_btn);
//                        holder.pics[i].setVisibility(View.VISIBLE);
//                        holder.types[i].setVisibility(View.VISIBLE);
//
//                        break;
                        //声音
                        case "audio":

                            holder.types[i].setImageResource(R.drawable.vol);
                            Glide.with(context).load(R.drawable.t_pic).diskCacheStrategy(DiskCacheStrategy.ALL)
                                    .override(900, 600).centerCrop().into(holder.pics[i]);
                            holder.pics[i].setVisibility(View.VISIBLE);
                            holder.types[i].setVisibility(View.VISIBLE);

                            break;

                        default:
                            Glide.with(context).load(GetData.url + "supervise/lookPhoto/" + listRsps.get(position).checkFile.get(i).id).diskCacheStrategy(DiskCacheStrategy.ALL)
                                    .override(900, 600).centerCrop().into(holder.pics[i]);
                            holder.pics[i].setVisibility(View.VISIBLE);

                            break;
                    }
            }
        } else
            holder.layout_pics.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {
        return listRsps!=null?listRsps.size():0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView content, title, type;
        ImageView[] pics = new ImageView[4];
        ImageView[] types = new ImageView[4];
        FrameLayout[] flayouts = new FrameLayout[4];
        LinearLayout layout_pics, content_layout;

        public ViewHolder(View itemView) {
            super(itemView);

            content_layout = (LinearLayout) itemView.findViewById(R.id.content_layout);
            layout_pics = (LinearLayout) itemView.findViewById(R.id.layout_pics);
            type = (TextView) itemView.findViewById(R.id.type);
            title = (TextView) itemView.findViewById(R.id.title);
            content = (TextView) itemView.findViewById(R.id.content);
            pics[0] = (ImageView) itemView.findViewById(R.id.pic1);
            pics[1] = (ImageView) itemView.findViewById(R.id.pic2);
            pics[2] = (ImageView) itemView.findViewById(R.id.pic3);
            pics[3] = (ImageView) itemView.findViewById(R.id.pic4);
            types[0] = (ImageView) itemView.findViewById(R.id.type1);
            types[1] = (ImageView) itemView.findViewById(R.id.type2);
            types[2] = (ImageView) itemView.findViewById(R.id.type3);
            types[3] = (ImageView) itemView.findViewById(R.id.type4);
            flayouts[0] = (FrameLayout) itemView.findViewById(R.id.f_layout1);
            flayouts[1] = (FrameLayout) itemView.findViewById(R.id.f_layout2);
            flayouts[2] = (FrameLayout) itemView.findViewById(R.id.f_layout3);
            flayouts[3] = (FrameLayout) itemView.findViewById(R.id.f_layout4);

        }

    }

    public void notifyData(List<GetActionHistoryRsp> listRsps, int pageIndex) {

        if (pageIndex == 1)
            this.listRsps = listRsps;
        else
            this.listRsps.addAll(listRsps);

        notifyDataSetChanged();

    }


    class clickListener implements View.OnClickListener {

        int position;

        public clickListener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {

                case R.id.content_layout:

                    new DeleteDialog(context, listRsps.get(position).pk, "抽查").show();
                    break;

                case R.id.f_layout1:
                    if (listRsps.get(position).checkFile.size() > 0) {
                        if (listRsps.get(position).checkFile.get(0).url != null && listRsps.get(position).checkFile.get(0).url.length() > 0)
                            play("video", listRsps.get(position).checkFile.get(0).url,position);
                        else
                            play(listRsps.get(position).checkFile.get(0).type, listRsps.get(position).checkFile.get(0).id,position);

                    }
                    break;
                case R.id.f_layout2:
                    if (listRsps.get(position).checkFile.size() > 1) {
                        if (listRsps.get(position).checkFile.get(1).url != null && listRsps.get(position).checkFile.get(1).url.length() > 0)
                            play("video", listRsps.get(position).checkFile.get(1).url,position);
                        else
                            play(listRsps.get(position).checkFile.get(1).type, listRsps.get(position).checkFile.get(1).id,position);

                    }
                    break;
                case R.id.f_layout3:

                    if (listRsps.get(position).checkFile.size() > 2) {
                        if (listRsps.get(position).checkFile.get(2).url != null && listRsps.get(position).checkFile.get(2).url.length() > 0)
                            play("video", listRsps.get(position).checkFile.get(2).url,position);
                        else
                            play(listRsps.get(position).checkFile.get(2).type, listRsps.get(position).checkFile.get(2).id,position);

                    }
                    break;
                case R.id.f_layout4:

                    if (listRsps.get(position).checkFile.size() > 3) {
                        if (listRsps.get(position).checkFile.get(3).url != null && listRsps.get(position).checkFile.get(3).url.length() > 0)
                            play("video", listRsps.get(position).checkFile.get(3).url,position);
                        else
                            play(listRsps.get(position).checkFile.get(3).type, listRsps.get(position).checkFile.get(3).id,position);

                    }
                    break;

            }

        }

        private void play(String type, String id, int position) {

            switch (type) {

                case "video":

                    //播放视频
                    Intent intent = new Intent(context, PlayActivity.class);
                    intent.putExtra(PlayActivity.DATA, GetData.url + "supervise/lookPhoto/" + id);
                    context.startActivity(intent);
                    break;
                case "audio":
                    //播放音频


                    new PlayVoiceDialog(context, GetData.url + "supervise/lookPhoto/" + id).show();
//                    new PlayVoiceDialog(context,"http://api1.zhengw.cn/Picture/201607/131822160358.mp3").show();
//                    new PlayVoiceDialog(context,"http://192.168.2.50:8080/app/assets/img/5881b5b5bbea891b10843953.wav").show();

                    break;
                case "photo":
                    //查看图片
                    Intent intent3 = new Intent(context, PictureDetailActivity.class);
                    intent3.putExtra("pictureUrl", GetData.url + "supervise/lookPhoto/" + id);
                    intent3.putExtra("checkId",listRsps.get(position).pk);
                    intent3.putExtra("photoId", id);
                    context.startActivity(intent3);

                    break;


            }

        }

    }


}
