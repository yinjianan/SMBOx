package com.yin.administrator.smbox.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;

import com.tandong.sa.activity.SmartActivity;
import com.tandong.sa.activity.SmartFragmentActivity;
import com.yin.administrator.smbox.R;
import com.yin.administrator.smbox.adapter.FragmentAdapter;
import com.yin.administrator.smbox.adapter.MenuListViewAdapter;
import com.yin.administrator.smbox.constant.FragmentName;
import com.yin.administrator.smbox.fragment.PropsFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends SmartFragmentActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private MenuListViewAdapter mMenuAdapter;
    private RecyclerView mMenuListView;


    private String[] titles = new String[]{"道具资料", "神明资料"};
    private String[] propsTypes = new String[]{"全部", "消耗", "圣物", "出门装", "鞋子", "物理", "魔法", "通用", "特殊"};
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mTabLayout = (TabLayout) this.findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) this.findViewById(R.id.view_pager);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < propsTypes.length; i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(propsTypes[i]));
            fragments.add(new PropsFragment(i));
        }
        //init Menu
        mMenuListView = (RecyclerView) findViewById(R.id.menu_listview);
        mMenuListView.setLayoutManager(new LinearLayoutManager(this));
        mMenuAdapter = new MenuListViewAdapter(titles);
        mMenuListView.setAdapter(mMenuAdapter);
        //加载数据
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), fragments, propsTypes);
        mViewPager.setAdapter(adapter);
    }


    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        if (mDataManager.getmCurrentMenuPosition() != position) {
//            mMenus.get(mDataManager.getmCurrentMenuPosition()).setSelected(false);
//            mDataManager.setmCurrentMenuPosition(position);
//            ThingMenuItem item = mMenus.get(position);
//            mCurrentFragmentName = item.getFragmentName();
//            item.setSelected(true);
//            mDrawerLayout.closeDrawers();
//            mMenuAdapter.notifyDataSetChanged();
//        }

    }


    private void showContent(Fragment fragment) {
        if (fragment == null) {
            return;
        }

        FragmentTransaction transaction = getFragmentManager().beginTransaction();

//        transaction.replace(R.id.main_content, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
