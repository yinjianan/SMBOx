package com.yin.administrator.smbox.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;

import com.yin.administrator.smbox.R;
/**
 * Created by zhenghuiyan on 2015/3/20.
 */
public class BaseFragment extends Fragment {
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        getActivity().overridePendingTransition(R.anim.keep_status, R.anim.one_scale_zero);
    }
}
