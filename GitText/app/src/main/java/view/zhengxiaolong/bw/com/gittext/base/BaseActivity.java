package view.zhengxiaolong.bw.com.gittext.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by lenovo on 2018/4/25.
 */

public abstract class BaseActivity<T> extends AppCompatActivity {
    public T persenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(getViewID());
        persenter = getPersenter();
        initView();
        initData();
    }

    protected abstract int getViewID();
    protected abstract void initView();
    protected abstract void initData();
    protected abstract T getPersenter();
}
