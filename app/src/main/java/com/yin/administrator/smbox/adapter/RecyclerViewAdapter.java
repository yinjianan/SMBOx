package com.yin.administrator.smbox.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tandong.sa.zUImageLoader.core.ImageLoader;
import com.yin.administrator.smbox.R;
import com.yin.administrator.smbox.bean.Props;

import java.util.List;

/**
 * Author       : yanbo
 * Date         : 2015-06-02
 * Time         : 09:47
 * Description  :
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final List<Props> propses;
    private Context mContext;

    public RecyclerViewAdapter(List<Props> propses, Context mContext) {
        this.propses = propses;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.listview_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ImageLoader.getInstance().displayImage(propses.get(position).getImgUrl(), holder.img);
        holder.title.setText(propses.get(position).getName());
        holder.content.setText(propses.get(position).getInfo());
    }

    @Override
    public int getItemCount() {
        return propses.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView img;
        public final TextView title;
        public final TextView content;

        public ViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.img);
            title = (TextView) view.findViewById(R.id.title);
            content = (TextView) view.findViewById(R.id.content);
        }
    }
}
