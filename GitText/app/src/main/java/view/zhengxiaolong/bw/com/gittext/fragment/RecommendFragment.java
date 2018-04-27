package view.zhengxiaolong.bw.com.gittext.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import view.zhengxiaolong.bw.com.gittext.R;
import view.zhengxiaolong.bw.com.gittext.base.BaseFragment;
import view.zhengxiaolong.bw.com.gittext.base.BasePresenter;

/**
 * 推荐页面
 */

public class RecommendFragment extends BaseFragment {

    private TabLayout recommend_tabLayout;
    private ViewPager recommend_viewPager;
    private String[] strings = {"热门","关注"};
    private List<Fragment> list;

    @Override
    protected int getLayoutId() {
        return R.layout.recommendfragment;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }


    @Override
    protected void initView(View view) {
        recommend_tabLayout = view.findViewById(R.id.recommend_tabLayout);
        recommend_viewPager = view.findViewById(R.id.recommend_viewPager);
        list = new ArrayList<>();
    }

    @Override
    protected void getData() {
        //把fragment添加到集合中
        list.add(new RecommendHotFragment());
        list.add(new RecommendAttentionFragment());
        //把标题添加到TabLayout里
        for (int i = 0; i < strings.length; i++) {
            recommend_tabLayout.addTab(recommend_tabLayout.newTab().setText(strings[i]));
        }
        //设置viewpager适配器
        recommend_viewPager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list != null ? list.size() : 0;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return strings[position];
            }
        });
        //设置viewpager和tablayout联动
        recommend_tabLayout.setupWithViewPager(recommend_viewPager);
    }

    @Override
    protected void getDestory() {

    }
}
