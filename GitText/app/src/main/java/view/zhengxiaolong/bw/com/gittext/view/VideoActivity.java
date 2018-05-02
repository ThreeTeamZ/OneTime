package view.zhengxiaolong.bw.com.gittext.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import view.zhengxiaolong.bw.com.gittext.R;
import view.zhengxiaolong.bw.com.gittext.base.BaseActivity;
import view.zhengxiaolong.bw.com.gittext.bean.DianZanInfo;
import view.zhengxiaolong.bw.com.gittext.persenter.DianZanPersenter;
import view.zhengxiaolong.bw.com.gittext.view.iview.IDianZanActivity;

public class VideoActivity extends BaseActivity<DianZanPersenter> implements IDianZanActivity{


    private JCVideoPlayer mMvPlayer;
    private String vedio_url;
    private Intent intent;
    private String title;
    private ImageView mBack;
    private ImageView mXin;
    private ImageView mXinsui;
    private ImageView mFenxiang;
    private ImageView mVedioTouXiang;
    private TextView mVedioPinglun;
    private SharedPreferences mSharedPreferences;
    private String uid;
    private String token;
    private String wid;
    private boolean flag = false;
    private String img;

    @Override
    protected int getViewID() {
        return R.layout.activity_video;
    }

    @Override
    protected void initView() {
        mMvPlayer = (JCVideoPlayer) findViewById(R.id.mvPlayer);
        intent = getIntent();
        vedio_url = intent.getStringExtra("url");
        title = intent.getStringExtra("title");
        img = intent.getStringExtra("img");
        mBack = (ImageView) findViewById(R.id.back);
        mXin = (ImageView) findViewById(R.id.xin);
        mXinsui = (ImageView) findViewById(R.id.xinsui);
        mFenxiang = (ImageView) findViewById(R.id.fenxiang);
        mVedioTouXiang = (ImageView) findViewById(R.id.Vedio_TouXiang);
        mVedioPinglun = (TextView) findViewById(R.id.vedio_pinglun);
        mSharedPreferences = this.getSharedPreferences("UserOne",MODE_PRIVATE);
        uid = mSharedPreferences.getString("uid", "");
        token = mSharedPreferences.getString("token", "");
        wid = getIntent().getStringExtra("wid");
    }

    @Override
    protected void initData() {

        Glide.with(this)
                .load(R.mipmap.touxiang)
                .bitmapTransform(new RoundedCornersTransformation(this,100,5))
                .into(mVedioTouXiang);
       // Toast.makeText(this, vedio_url, Toast.LENGTH_SHORT).show();


        if (title == null || title.equals("null")) {
            mMvPlayer.setUp(vedio_url, "");
        } else {
            mMvPlayer.setUp(vedio_url, title);
        }
        mMvPlayer.setThumbImageViewScalType(ImageView.ScaleType.FIT_XY);

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoActivity.this.finish();
            }
        });
        mXin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                persenter.getDianZ(uid,wid,token,"1","android");
            }
        });

        mVedioTouXiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VideoActivity.this,UserXiangActivity.class));
            }
        });
        mXinsui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag){
                    mXinsui.setImageResource(R.mipmap.xin_white);
                    Toast.makeText(VideoActivity.this, "", Toast.LENGTH_SHORT).show();
                    flag = !flag;
                }else if (!flag){
                    mXinsui.setImageResource(R.mipmap.xin_black);
                    Toast.makeText(VideoActivity.this, "不喜欢", Toast.LENGTH_SHORT).show();
                    flag=!flag;
                    int xin_red = R.mipmap.xin;
                    mXin.setImageResource(xin_red);
                }

            }
        });

    }

    @Override
    protected DianZanPersenter getPersenter() {
        persenter = new DianZanPersenter(this);
        return persenter;
    }



    @Override
    public void onSuccess(DianZanInfo dianZanInfo) {
        Toast.makeText(this, dianZanInfo.getMsg(), Toast.LENGTH_SHORT).show();
        int xin_red = R.mipmap.xin_red;
        mXin.setImageResource(xin_red);

    }

    @Override
    public void onFailed(String s) {
        Toast.makeText(this, "错误", Toast.LENGTH_SHORT).show();
    }
}
