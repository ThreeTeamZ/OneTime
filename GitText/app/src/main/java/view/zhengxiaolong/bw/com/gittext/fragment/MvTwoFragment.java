package view.zhengxiaolong.bw.com.gittext.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;


import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import view.zhengxiaolong.bw.com.gittext.R;
import view.zhengxiaolong.bw.com.gittext.adapter.MyMVOneAdapter;
import view.zhengxiaolong.bw.com.gittext.base.BaseFragment;
import view.zhengxiaolong.bw.com.gittext.bean.GetMVInfo;
import view.zhengxiaolong.bw.com.gittext.ifragment.IMvFragment;
import view.zhengxiaolong.bw.com.gittext.persenter.MvPersenter;
import view.zhengxiaolong.bw.com.gittext.utils.RecyclerViewItemDecoration;
import view.zhengxiaolong.bw.com.gittext.view.LoginActivity;
import view.zhengxiaolong.bw.com.gittext.view.VideoActivity;

/**
 * Created by lenovo on 2018/4/25.
 */

public class MvTwoFragment extends BaseFragment implements IMvFragment {
    private View view;
    private MvPersenter persenter;
    private String uid;
    private List<GetMVInfo.DataBean> dataAll;
    private MyMVOneAdapter adapter;
    private int appVerson = 101;
    private SharedPreferences userOne;
    private int i;
    private XRecyclerView mTwoRlv;

    @Override
    protected int getLayoutID() {
        return R.layout.mvtwofragment;
    }

    @Override
    protected void initView(View view) {
        mTwoRlv = (XRecyclerView) view.findViewById(R.id.mTwoRlv);
        mTwoRlv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        persenter = new MvPersenter(this);
    }


    @Override
    protected void initData() {
        userOne = getActivity().getSharedPreferences("UserOne", Context.MODE_PRIVATE);
        uid = userOne.getString("uid", "");
        if (this.uid.equals("") || this.uid == null) {
            Toast.makeText(getActivity(), "未登录", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getActivity(), LoginActivity.class));
        } else {
            i = Integer.parseInt(uid);
            if (i > 500) {
                i = 1;
            }
            persenter.getMv("android", i + "", "1");
        }



    }

    @Override
    public void onSuccess(final List<GetMVInfo.DataBean> dataBeans) {
        this.dataAll = dataBeans;
        adapter = new MyMVOneAdapter(getActivity());
        adapter.setList(dataAll);
        mTwoRlv.setAdapter(adapter);


        adapter.setOnItemClick(new MyMVOneAdapter.setOnClick() {
            @Override
            public void onClick(int position) {
                //Toast.makeText(getContext(), "点击了"+position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), VideoActivity.class);
                intent.putExtra("url", dataAll.get(position).getVideoUrl() + "");
                intent.putExtra("title", dataAll.get(position).getWorkDesc() + "");
                intent.putExtra("img", dataAll.get(position).getCover() + "");
                startActivity(intent);
            }
        });

        mTwoRlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                dataAll.clear();
                appVerson=101;
                persenter.getMv("android", uid, appVerson+"");
                mTwoRlv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                Toast.makeText(getActivity(), "加载...", Toast.LENGTH_SHORT).show();
                appVerson++;
                dataAll.addAll(dataBeans);
                mTwoRlv.setAdapter(adapter);
                mTwoRlv.refreshComplete();
            }
        });

    }

    @Override
    public void onFailed(String s) {
        Toast.makeText(getActivity(), "网络错误", Toast.LENGTH_SHORT).show();
    }



}
