package view.zhengxiaolong.bw.com.gittext.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
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
import view.zhengxiaolong.bw.com.gittext.base.BasePresenter;

/**
 * Created by lenovo on 2018/4/25.
 */

public class MvFragment extends BaseFragment implements View.OnClickListener {

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
    protected int getLayoutId() {
        return R.layout.mvfragment;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected void initView(View view) {

        mMTouXiang = (ImageView) view.findViewById(R.id.mTouXiang);
        mMTitle = (TextView) view.findViewById(R.id.mTitle);
        mMBianJi = (ImageView) view.findViewById(R.id.mBianJi);
        mDrawid = (LinearLayout) view.findViewById(R.id.drawid);
        mMMvTab = (TabLayout) view.findViewById(R.id.mMvTab);
        mMMvVp = (ViewPager) view.findViewById(R.id.mMvVp);
        mMMvTab.setOnClickListener(this);
        mMMvVp.setOnClickListener(this);
    }

    @Override
    protected void getData() {
        //        mMTitle.setText("视频");
//        Glide.with(this)
//                .load(R.drawable.touxiang)
//                .bitmapTransform(new RoundedCornersTransformation(getContext(), 100, 5))
//                .into(mMTouXiang);

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

    @Override
    protected void getDestory() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.mMvTab:
                break;
            case R.id.mMvVp:
                break;
        }
    }
}