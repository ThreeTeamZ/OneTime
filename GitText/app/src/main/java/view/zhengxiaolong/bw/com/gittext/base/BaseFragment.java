package view.zhengxiaolong.bw.com.gittext.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lenovo on 2018/4/25.
 */

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(getViewID(),container,false);
        initView(view);
        initData();
        return view;
    }
    protected abstract int getViewID();
    protected abstract void initView(View view);
    protected abstract void initData();
}
