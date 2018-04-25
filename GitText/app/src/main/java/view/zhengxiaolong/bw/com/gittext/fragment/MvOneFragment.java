package view.zhengxiaolong.bw.com.gittext.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import view.zhengxiaolong.bw.com.gittext.R;
import view.zhengxiaolong.bw.com.gittext.base.BaseFragment;

/**
 * Created by lenovo on 2018/4/25.
 */

public class MvOneFragment extends BaseFragment {
    private View view;
    private RecyclerView mMOneRlv;

    @Override
    protected int getLayoutID() {
        return R.layout.mvonefragment;
    }

    @Override
    protected void initView(View view) {
        mMOneRlv = (RecyclerView) view.findViewById(R.id.mOneRlv);
        mMOneRlv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
    }

    @Override
    protected void initData() {

    }




}
