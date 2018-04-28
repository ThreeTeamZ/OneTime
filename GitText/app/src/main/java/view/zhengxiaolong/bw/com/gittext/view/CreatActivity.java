package view.zhengxiaolong.bw.com.gittext.view;

<<<<<<< HEAD
=======
import android.content.Intent;
import android.os.Bundle;
>>>>>>> 86f06117eeb2f0f187145698ad3ce616f1b615c0
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import view.zhengxiaolong.bw.com.gittext.R;
import view.zhengxiaolong.bw.com.gittext.base.BaseActivity;

public class CreatActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mCreatVedio;
    private ImageView mCreatDZ;
    /**
     * 取消
     */
    private TextView mCreatQuxiao;

    @Override
    protected int getViewID() {
        return R.layout.activity_creat;
    }

    @Override
    protected void initView() {

        mCreatVedio = (ImageView) findViewById(R.id.Creat_Vedio);
        mCreatDZ = (ImageView) findViewById(R.id.Creat_DZ);
        mCreatQuxiao = (TextView) findViewById(R.id.creat_quxiao);
        mCreatVedio.setOnClickListener(this);
        mCreatDZ.setOnClickListener(this);

    }

    @Override
    protected void initData() {
        Glide.with(this)
                .load(R.drawable.sp6)
                .bitmapTransform(new RoundedCornersTransformation(this, 100, 5))
                .into(mCreatVedio);
        Glide.with(this)
                .load(R.drawable.dz6)
                .bitmapTransform(new RoundedCornersTransformation(this, 100, 5))
                .into(mCreatDZ);

        mCreatQuxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreatActivity.this.finish();
            }
        });
    }

    @Override
    protected Object getPersenter() {
        return null;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.Creat_Vedio:
                Intent intent = new Intent(CreatActivity.this,ShootVideoActivity.class);
                startActivity(intent);
                break;
            case R.id.Creat_DZ:
                Toast.makeText(this, "写段子", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
