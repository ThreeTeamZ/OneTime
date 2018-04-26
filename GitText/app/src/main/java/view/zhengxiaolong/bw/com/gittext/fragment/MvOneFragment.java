package view.zhengxiaolong.bw.com.gittext.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import view.zhengxiaolong.bw.com.gittext.R;
import view.zhengxiaolong.bw.com.gittext.adapter.MyMVOneAdapter;
import view.zhengxiaolong.bw.com.gittext.base.BaseFragment;
import view.zhengxiaolong.bw.com.gittext.bean.GetMVInfo;
import view.zhengxiaolong.bw.com.gittext.ifragment.IMvFragment;
import view.zhengxiaolong.bw.com.gittext.persenter.MvPersenter;

/**
 * Created by lenovo on 2018/4/25.
 */

public class MvOneFragment extends BaseFragment implements IMvFragment{
    private View view;
    private RecyclerView mMOneRlv;
    private MvPersenter persenter;
    private String uid;
    private List<GetMVInfo.DataBean> dataBeans;
    private MyMVOneAdapter adapter;

    @Override
    protected int getLayoutID() {
        return R.layout.mvonefragment;
    }

    @Override
    protected void initView(View view) {
        mMOneRlv = (RecyclerView) view.findViewById(R.id.mOneRlv);
        mMOneRlv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        persenter = new MvPersenter(this);
    }

    @Override
    protected void initData() {
        uid = "1";
        if (uid.equals("")||uid==null){
            Toast.makeText(getActivity(), "未登录", Toast.LENGTH_SHORT).show();
        }else{
            persenter.getMv("android", uid,"1");
        }

    }


    @Override
    public void onSuccess(List<GetMVInfo.DataBean> dataBeans) {
        this.dataBeans = dataBeans;
        adapter = new MyMVOneAdapter(getActivity());
        adapter.setList(dataBeans);
        mMOneRlv.setAdapter(adapter);

    }

    @Override
    public void onFailed(String s) {

    }
}
