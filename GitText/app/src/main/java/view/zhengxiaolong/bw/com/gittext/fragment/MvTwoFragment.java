package view.zhengxiaolong.bw.com.gittext.fragment;

import android.content.Intent;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import view.zhengxiaolong.bw.com.gittext.R;
import view.zhengxiaolong.bw.com.gittext.adapter.MyMVOneAdapter;
import view.zhengxiaolong.bw.com.gittext.adapter.MyMVTwoAdapter;
import view.zhengxiaolong.bw.com.gittext.base.BaseFragment;
import view.zhengxiaolong.bw.com.gittext.base.BasePresenter;
import view.zhengxiaolong.bw.com.gittext.bean.GetMVInfo;
import view.zhengxiaolong.bw.com.gittext.ifragment.IMvFragment;
import view.zhengxiaolong.bw.com.gittext.persenter.MvPersenter;
import view.zhengxiaolong.bw.com.gittext.view.VideoActivity;

/**
 * Created by lenovo on 2018/4/25.
 */

public class MvTwoFragment extends BaseFragment implements IMvFragment {
    private MvPersenter persenter;
    private List<GetMVInfo.DataBean> dataAll;
    private XRecyclerView mTwoRlv;
    private MyMVOneAdapter adapter;
    private int appVersion;

    @Override
    protected int getLayoutId() {
        return R.layout.mvtwofragment;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected void initView(View view) {
        mTwoRlv = (XRecyclerView) view.findViewById(R.id.mTwoRlv);
        adapter = new MyMVOneAdapter(getContext());
        persenter = new MvPersenter(this);
    }

    @Override
    protected void getData() {
        appVersion = 1;
        persenter.getMv("android", "CC1072092AB66EFAC067940BBBD4E01B", appVersion+"");
        mTwoRlv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        mTwoRlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                appVersion = 1;
                dataAll.clear();
                persenter.getMv("android", "CC1072092AB66EFAC067940BBBD4E01B", appVersion+"");
                mTwoRlv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                Toast.makeText(getActivity(), "加载...", Toast.LENGTH_SHORT).show();
                appVersion++;
                persenter.getMv("android", "CC1072092AB66EFAC067940BBBD4E01B", appVersion+"");
                mTwoRlv.refreshComplete();
            }
        });
        mTwoRlv.setAdapter(adapter);
    }

    @Override
    protected void getDestory() {
    }


    @Override
    public void onSuccess(final List<GetMVInfo.DataBean> dataBeans) {
        if (dataBeans!=null){
            Log.i("AAA",dataBeans.size() + "===");
            if (appVersion==1){
                dataAll = new ArrayList<>();
            }
            dataAll.addAll(dataBeans);
            adapter.setList(dataAll);
        }
        /*Toast.makeText(getActivity(), dataBeans.size()+"--", Toast.LENGTH_SHORT).show();*/

        adapter.setOnItemClick(new MyMVOneAdapter.setOnClick() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), VideoActivity.class);
                intent.putExtra("url", dataAll.get(position).getVideoUrl() + "");
                intent.putExtra("title", dataAll.get(position).getWorkDesc() + "");
                intent.putExtra("img", dataAll.get(position).getCover() + "");
                startActivity(intent);
            }
        });



    }

    @Override
    public void onFailed(String s) {
        Toast.makeText(getActivity(), "网络错误", Toast.LENGTH_SHORT).show();
    }

}
