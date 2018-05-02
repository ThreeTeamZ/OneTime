package view.zhengxiaolong.bw.com.gittext.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.hjm.bottomtabbar.BottomTabBar;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import view.zhengxiaolong.bw.com.gittext.R;
import view.zhengxiaolong.bw.com.gittext.adapter.MyDrawAdapter;
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
    private ImageView mDrawTouxaing;
    private ListView mDrawLv;
    private TextView mDrawName;
    private SharedPreferences userOne;
    private TextView mDrawUsername;
    /**
     * 退出登录
     */
    private Button mTui;
    private SharedPreferences.Editor edit;

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
        mMTouXiang.setOnClickListener(this);
        mMTitle.setOnClickListener(this);
        mMBianJi.setOnClickListener(this);
        mDrawid.setOnClickListener(this);
        mBottomTabBar.setOnClickListener(this);
        mDrawTouxaing = (ImageView) findViewById(R.id.draw_touxaing);
        mDrawLv = (ListView) findViewById(R.id.draw_lv);
        mDrawLinearlayout.setOnClickListener(this);
        mDrawDrawerlayout.setOnClickListener(this);

        mDrawTouxaing.setOnClickListener(this);
        mDrawName = (TextView) findViewById(R.id.draw_username);

        mDrawUsername = (TextView) findViewById(R.id.draw_username);
        mTui = (Button) findViewById(R.id.tui);
    }

    @Override
    protected void onResume() {
        super.onResume();
        userOne = this.getSharedPreferences("UserOne", MODE_PRIVATE);
        edit = userOne.edit();
        String name = userOne.getString("name", "");
        mDrawName.setText(name);
    }

    @Override
    protected void initData() {


        Glide.with(this)
                .load(R.mipmap.touxiang)
                .bitmapTransform(new RoundedCornersTransformation(this, 100, 5))
                .into(mMTouXiang);
        Glide.with(this)
                .load(R.mipmap.touxiang)
                .bitmapTransform(new RoundedCornersTransformation(this, 100, 5))
                .into(mDrawTouxaing);

        mBottomTabBar.init(getSupportFragmentManager())
                .setImgSize(60, 60)
                .setFontSize(8)
                .setTabPadding(4, 6, 10)
                .addTabItem("推荐", R.mipmap.tj2, R.mipmap.tj1, RecommendFragment.class)
                .addTabItem("段子", R.mipmap.dz2, R.mipmap.dz1, ParagraphFragment.class)
                .addTabItem("视频", R.mipmap.sp2, R.mipmap.sp1, MvFragment.class)
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

        mDrawTouxaing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        mMBianJi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CreatActivity.class));
            }
        });

        mTui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.clear();
                edit.commit();
                Toast.makeText(MainActivity.this, "已退出登录", Toast.LENGTH_SHORT).show();
                mDrawDrawerlayout.closeDrawer(mDrawLinearlayout);
            }
        });
        MyDrawAdapter adapter;


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
