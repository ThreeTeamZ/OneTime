package view.zhengxiaolong.bw.com.gittext;

import android.graphics.Color;
import android.os.Bundle;

import com.hjm.bottomtabbar.BottomTabBar;

import view.zhengxiaolong.bw.com.gittext.base.BaseActivity;
import view.zhengxiaolong.bw.com.gittext.fragment.MvFragment;
import view.zhengxiaolong.bw.com.gittext.fragment.ParagraphFragment;
import view.zhengxiaolong.bw.com.gittext.fragment.RecommendFragment;

public class MainActivity extends BaseActivity {


    private BottomTabBar mBottomTabBar;

    @Override
    protected int getViewID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mBottomTabBar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);
    }

    @Override
    protected void initData() {
        mBottomTabBar.init(getSupportFragmentManager())
                .setImgSize(80,80)
                .setFontSize(8)
                .setTabPadding(4,6,10)
                .addTabItem("推荐",R.drawable.tj2,R.drawable.tj1, RecommendFragment.class)
                .addTabItem("段子",R.drawable.dz2,R.drawable.dz1, ParagraphFragment.class)
                .addTabItem("视频",R.drawable.sp2,R.drawable.sp1, MvFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
    }

    @Override
    protected Object getPersenter() {
        return null;
    }


}
