package com.yin.administrator.smbox.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.yin.administrator.smbox.R;
import com.yin.administrator.smbox.adapter.ListViewAdapter;
import com.yin.administrator.smbox.adapter.RecyclerViewAdapter;
import com.yin.administrator.smbox.bean.Props;
import com.yin.administrator.smbox.util.NetManager;

import java.util.ArrayList;
import java.util.List;

public class PropsFragment extends BaseFragment {
    private int type;
    private static List<Props> propsData;

    public PropsFragment(int i) {
        type = i;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_props, null);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fp_lv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        propsData = NetManager.getInstance().getPropsData();
        List<Props> props = new ArrayList<>();
        if (type == 0)
            props = propsData;
        else {
            for (Props props1 :
                    propsData) {
                if (props1.getType_code().equals(type))
                    props.add(props1);
            }
        }
        recyclerView.setAdapter(new RecyclerViewAdapter(props, getActivity()));
        return view;
    }
}
