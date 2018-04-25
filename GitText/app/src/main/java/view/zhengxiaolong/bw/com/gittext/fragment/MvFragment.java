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
    private TabLayout mMMvTab;
    private ViewPager mMMvVp;
    private String uid = "1";

    @Override
    protected int getViewID() {
        return R.layout.mvfragment;
    }

    @Override
    protected void initView(View view) {
        mMTouXiang = (ImageView) view.findViewById(R.id.mTouXiang);
        mMTitle = (TextView) view.findViewById(R.id.mTitle);
        mMBianJi = (ImageView) view.findViewById(R.id.mBianJi);
        mMMvTab = (TabLayout) view.findViewById(R.id.mMvTab);
        mMMvVp = (ViewPager) view.findViewById(R.id.mMvVp);
    }

    @Override
    protected void initData() {
        mMTitle.setText("视频");
        mMMvTab.addTab(mMMvTab.newTab().setText("热门"));
        mMMvTab.addTab(mMMvTab.newTab().setText("附近"));

        mMMvTab.setupWithViewPager(mMMvVp);


        List<Fragment> fragments = new ArrayList<Fragment>();
        Fragment OneFragment = new MvOneFragment();
        Fragment TwoFragment = new MvTwoFragment();
        fragments.add(OneFragment);
        fragments.add(TwoFragment);

        List<String> titles = new ArrayList<String>();
        titles.add("热门");
        titles.add("附近");

        ViewPagerAdapter mAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(), fragments, titles);
        mMMvVp.setAdapter(mAdapter);
        mMMvTab.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = View.inflate(getActivity(), R.layout.mvfragment, null);
    }


}
