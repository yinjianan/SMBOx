package com.yin.administrator.smbox.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yin.administrator.smbox.R;

/**
 * Created by zhenghuiyan on 2015/1/28.
 */
public class MenuListViewAdapter extends RecyclerView.Adapter<MenuListViewAdapter.ViewHolder> {

    private final String[] titles;

    public MenuListViewAdapter(String... titles) {
        this.titles = titles;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_menu_item, null);
        itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTvName.setText(titles[position]);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mIvImg;

        private TextView mTvName;

        private ImageView mIvSeleted;

        public ViewHolder(View itemView) {
            super(itemView);
            this.mIvImg = (ImageView) itemView.findViewById(R.id.img);
            this.mTvName = (TextView) itemView.findViewById(R.id.name);
            this.mIvSeleted = (ImageView) itemView.findViewById(R.id.isSeleted);
        }
    }
}
