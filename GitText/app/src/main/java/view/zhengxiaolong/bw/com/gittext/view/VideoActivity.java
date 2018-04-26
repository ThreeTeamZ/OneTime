package view.zhengxiaolong.bw.com.gittext.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import view.zhengxiaolong.bw.com.gittext.R;
import view.zhengxiaolong.bw.com.gittext.base.BaseActivity;

public class VideoActivity extends BaseActivity {


    private JCVideoPlayer mMvPlayer;
    private String vedio_url;
    private Intent intent;
    private String title;
    private String img;
    private Uri uri;

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
        uri = Uri.parse(img);
    }

    @Override
    protected void initData() {
        Toast.makeText(this, vedio_url, Toast.LENGTH_SHORT).show();
        mMvPlayer.ivThumb.setImageURI(uri);
        mMvPlayer.setUp(vedio_url,title);

        mMvPlayer.setThumbImageViewScalType(ImageView.ScaleType.FIT_XY);


    }

    @Override
    protected Object getPersenter() {
        return null;
    }


}
