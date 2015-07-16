package com.printfstudio.current.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.printfstudio.current.R;

import java.util.List;

/**
 * Created by DTLuc on 2015/7/16.
 * Recycler Adapter  --  时间轴
 * v0.1
 */
public class TimelineAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<Timeline_ItemBean> list;
    private LayoutInflater layoutInflater;
    private Context context;

    public TimelineAdapter(Context context, List<Timeline_ItemBean> list) {
        this.layoutInflater = LayoutInflater.from(context);
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.timeline_item,parent,false);
//        MyViewHolder myViewHolder = new MyViewHolder(view);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Timeline_ItemBean bean = list.get(position);
        holder.getTime().setText(bean.getTime());
        holder.getContents().setText(bean.getContents());
        holder.getImageView().setImageResource(bean.getImageResid());
        holder.getStyleView().setImageResource(bean.getStyleResid());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
class MyViewHolder extends RecyclerView.ViewHolder{
    private TextView time;
    private TextView contents;
    private ImageView imageView;
    private ImageView styleView;

    public MyViewHolder(View itemView) {
        super(itemView);
        time = (TextView) itemView.findViewById(R.id.time );
        contents = (TextView) itemView.findViewById(R.id.contents);
        imageView = (ImageView) itemView.findViewById(R.id.image_1);
        styleView = (ImageView) itemView.findViewById(R.id.image);
    }

    public TextView getContents() {
        return contents;
    }

    public TextView getTime() {
        return time;
    }


    public ImageView getImageView() {
        return imageView;
    }


    public ImageView getStyleView() {
        return styleView;
    }

}

