package com.yin.administrator.smbox.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tandong.sa.zUImageLoader.core.ImageLoader;
import com.yin.administrator.smbox.R;
import com.yin.administrator.smbox.bean.Props;
import com.yin.administrator.smbox.util.NetManager;

import java.util.List;

/**
 * Created by Administrator on 2016/4/19 0019.
 */
public class ListViewAdapter extends BaseAdapter {
    private final List<Props> propses;
    private final Context context;

    public ListViewAdapter(List<Props> propses, Context context) {
        this.propses = propses;
        this.context = context;
    }

    @Override
    public int getCount() {
        return propses.size();
    }

    @Override
    public Object getItem(int position) {
        return propses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_item, null);
            holder.imageView = (ImageView) convertView.findViewById(R.id.img);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.content = (TextView) convertView.findViewById(R.id.content);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ImageLoader.getInstance().displayImage(propses.get(position).getImgUrl(), holder.imageView);
        holder.title.setText(propses.get(position).getName());
        holder.content.setText(propses.get(position).getInfo());
        return convertView;
    }

    class ViewHolder {
        private ImageView imageView;
        private TextView title;
        private TextView content;
    }
}
