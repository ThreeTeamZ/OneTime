package view.zhengxiaolong.bw.com.gittext.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import view.zhengxiaolong.bw.com.gittext.R;
import view.zhengxiaolong.bw.com.gittext.VideoActivity;
import view.zhengxiaolong.bw.com.gittext.adapter.MyMVOneAdapter;
import view.zhengxiaolong.bw.com.gittext.base.BaseFragment;
import view.zhengxiaolong.bw.com.gittext.bean.GetMVInfo;
import view.zhengxiaolong.bw.com.gittext.bean.ProgressStyle;
import view.zhengxiaolong.bw.com.gittext.ifragment.IMvFragment;
import view.zhengxiaolong.bw.com.gittext.persenter.MvPersenter;
import view.zhengxiaolong.bw.com.gittext.utils.RecyclerViewItemDecoration;

/**
 * Created by lenovo on 2018/4/25.
 */

public class MvOneFragment extends BaseFragment implements IMvFragment {
    private View view;
    private MvPersenter persenter;
    private String uid;
    private List<GetMVInfo.DataBean> dataAll;
    private MyMVOneAdapter adapter;
    private XRecyclerView mMOneRlv;
    private int appVerson = 1;
    @Override
    protected int getLayoutID() {
        return R.layout.mvonefragment;
    }

    @Override
    protected void initView(View view) {
        mMOneRlv = (XRecyclerView) view.findViewById(R.id.mOneRlv);
        mMOneRlv.setRefreshProgressStyle(ProgressStyle.BallZigZag); //设定下拉刷新样式
        mMOneRlv.setLoadingMoreProgressStyle(ProgressStyle.BallZigZag);//设定上拉加载样式

        RecyclerViewItemDecoration decoration = new RecyclerViewItemDecoration(5);
        mMOneRlv.addItemDecoration(decoration);
        mMOneRlv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        persenter = new MvPersenter(this);

    }

    @Override
    protected void initData() {
        uid = "1";
        if (uid.equals("") || uid == null) {
            Toast.makeText(getActivity(), "未登录", Toast.LENGTH_SHORT).show();
        } else {
            persenter.getMv("android", uid, "1");
        }



    }

    @Override
    public void onSuccess(final List<GetMVInfo.DataBean> dataBeans) {
        this.dataAll = dataBeans;
        adapter = new MyMVOneAdapter(getActivity());
        adapter.setList(dataAll);
        mMOneRlv.setAdapter(adapter);

        mMOneRlv.setLoadingListener(new XRecyclerView.LoadingListener() {
                @Override
                public void onRefresh() {
                    dataAll.clear();
                    appVerson=1;
                    persenter.getMv("android", uid, appVerson+"");
                    mMOneRlv.refreshComplete();
                }

                @Override
                public void onLoadMore() {
                    Toast.makeText(getActivity(), "加载...", Toast.LENGTH_SHORT).show();
                    appVerson++;
                    dataAll.addAll(dataBeans);
                    mMOneRlv.setAdapter(adapter);
                    mMOneRlv.refreshComplete();
                }
        });

        adapter.setOnItemClick(new MyMVOneAdapter.setOnClick() {
            @Override
            public void onClick(int position) {
                //Toast.makeText(getContext(), "点击了"+position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),VideoActivity.class);
                intent.putExtra("url",dataAll.get(position).getVideoUrl()+"");
                intent.putExtra("title",dataAll.get(position).getWorkDesc()+"");
                intent.putExtra("img",dataAll.get(position).getCover()+"");
                startActivity(intent);
            }
        });

    }

    @Override
    public void onFailed(String s) {
        Toast.makeText(getActivity(), "网络错误", Toast.LENGTH_SHORT).show();
    }


}
