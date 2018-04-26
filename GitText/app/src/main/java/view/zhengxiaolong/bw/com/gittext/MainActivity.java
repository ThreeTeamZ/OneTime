package view.zhengxiaolong.bw.com.gittext;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.hjm.bottomtabbar.BottomTabBar;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import view.zhengxiaolong.bw.com.gittext.base.BaseActivity;
import view.zhengxiaolong.bw.com.gittext.fragment.MvFragment;
import view.zhengxiaolong.bw.com.gittext.fragment.ParagraphFragment;
import view.zhengxiaolong.bw.com.gittext.fragment.RecommendFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    private BottomTabBar mBottomTabBar;
    private ImageView mMTouXiang;
    /**
     * 推荐
     */
    private TextView mMTitle;
    private ImageView mMBianJi;
    private LinearLayout mDrawid;
    private LinearLayout mDrawLinearlayout;
    private DrawerLayout mDrawDrawerlayout;

    @Override
    protected int getViewID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mBottomTabBar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);
        mMTouXiang = (ImageView) findViewById(R.id.mTouXiang);
        mMTitle = (TextView) findViewById(R.id.mTitle);
        mMBianJi = (ImageView) findViewById(R.id.mBianJi);
        mDrawid = (LinearLayout) findViewById(R.id.drawid);
        mDrawLinearlayout = (LinearLayout) findViewById(R.id.draw_linearlayout);
        mDrawDrawerlayout = (DrawerLayout) findViewById(R.id.draw_drawerlayout);
        mDrawDrawerlayout.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        Glide.with(this)
                .load(R.drawable.touxiang)
                .bitmapTransform(new RoundedCornersTransformation(this, 100, 5))
                .into(mMTouXiang);

        mBottomTabBar.init(getSupportFragmentManager())
                .setImgSize(60, 60)
                .setFontSize(8)
                .setTabPadding(4, 6, 10)
                .addTabItem("推荐", R.drawable.tj2, R.drawable.tj1, RecommendFragment.class)
                .addTabItem("段子", R.drawable.dz2, R.drawable.dz1, ParagraphFragment.class)
                .addTabItem("视频", R.drawable.sp2, R.drawable.sp1, MvFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                        mMTitle.setText(name);
                    }
                });
        mMBianJi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "编辑", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected Object getPersenter() {
        return null;
    }


    @Override
    public void onClick(View v) {
        mDrawDrawerlayout.openDrawer(mDrawLinearlayout);
    }
}
