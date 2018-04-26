package view.zhengxiaolong.bw.com.gittext.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import view.zhengxiaolong.bw.com.gittext.R;
import view.zhengxiaolong.bw.com.gittext.adapter.ViewPagerAdapter;
import view.zhengxiaolong.bw.com.gittext.base.BaseFragment;

/**
 * Created by lenovo on 2018/4/25.
 */

public class MvFragment extends BaseFragment {

    private View view;
    private ImageView mMTouXiang;
    /**
     * 推荐
     */
    private TextView mMTitle;
    private ImageView mMBianJi;
    private LinearLayout mDrawid;
    private TabLayout mMMvTab;
    private ViewPager mMMvVp;
    private List<Fragment> fragments;
    private List<String> titles;

    @Override
    protected int getLayoutID() {
        return R.layout.mvfragment;
    }

    @Override
    protected void initView(View view) {

        mMTouXiang = (ImageView) view.findViewById(R.id.mTouXiang);
        mMTitle = (TextView) view.findViewById(R.id.mTitle);
        mMBianJi = (ImageView) view.findViewById(R.id.mBianJi);
        mDrawid = (LinearLayout) view.findViewById(R.id.drawid);
        mMMvTab = (TabLayout) view.findViewById(R.id.mMvTab);
        mMMvVp = (ViewPager) view.findViewById(R.id.mMvVp);
    }

    @Override
    protected void initData() {
        mMMvTab.addTab(mMMvTab.newTab().setText("推荐"));
        mMMvTab.addTab(mMMvTab.newTab().setText("附近"));

        fragments = new ArrayList<>();
        fragments.add(new MvOneFragment());
        fragments.add(new MvTwoFragment());

        titles = new ArrayList<>();
        titles.add("推荐");
        titles.add("附近");

        mMMvTab.setupWithViewPager(mMMvVp);
        ViewPagerAdapter mAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(), fragments, titles);
        mMMvVp.setAdapter(mAdapter);
        mMMvTab.setTabMode(TabLayout.MODE_FIXED);

    }


}