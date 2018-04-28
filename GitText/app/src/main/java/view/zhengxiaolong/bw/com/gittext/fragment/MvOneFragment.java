package view.zhengxiaolong.bw.com.gittext.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import view.zhengxiaolong.bw.com.gittext.R;
import view.zhengxiaolong.bw.com.gittext.base.BasePresenter;
import view.zhengxiaolong.bw.com.gittext.view.LoginActivity;
import view.zhengxiaolong.bw.com.gittext.view.VideoActivity;
import view.zhengxiaolong.bw.com.gittext.adapter.MyMVOneAdapter;
import view.zhengxiaolong.bw.com.gittext.base.BaseFragment;
import view.zhengxiaolong.bw.com.gittext.bean.GetMVInfo;
import view.zhengxiaolong.bw.com.gittext.bean.ProgressStyle;
import view.zhengxiaolong.bw.com.gittext.ifragment.IMvFragment;
import view.zhengxiaolong.bw.com.gittext.persenter.MvPersenter;
import view.zhengxiaolong.bw.com.gittext.utils.RecyclerViewItemDecoration;

import static android.content.Context.MODE_PRIVATE;

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
    private int count = 1;
    private SharedPreferences userOne;
    private int i;
    private SharedPreferences mSharedPreferences;


    @Override
    protected int getLayoutId() {
        return R.layout.mvonefragment;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected void initView(View view) {
        mMOneRlv = (XRecyclerView) view.findViewById(R.id.mOneRlv);
        /*mMOneRlv.setRefreshProgressStyle(ProgressStyle.BallZigZag); //设定下拉刷新样式
        mMOneRlv.setLoadingMoreProgressStyle(ProgressStyle.BallZigZag);//设定上拉加载样式*/

        mMOneRlv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
       /* RecyclerViewItemDecoration decoration = new RecyclerViewItemDecoration(5);
        mMOneRlv.addItemDecoration(decoration);*/
        persenter = new MvPersenter(this);
        mSharedPreferences = getActivity().getSharedPreferences("UserOne",MODE_PRIVATE);
        uid = mSharedPreferences.getString("uid", "");
        adapter = new MyMVOneAdapter(getContext());
    }

    @Override
    protected void getData() {
        persenter.getMv("android", count + "", count + "");
        mMOneRlv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        mMOneRlv.setAdapter(adapter);

        //XRecyclerView的上下拉监听方法
        mMOneRlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            //下拉刷新
            public void onRefresh() {
                count = 1;
                dataAll.clear();
                persenter.getMv("android", uid, count + "");
                mMOneRlv.refreshComplete();
            }

            @Override
            //上拉加载
            public void onLoadMore() {
                Toast.makeText(getActivity(), "加载...", Toast.LENGTH_SHORT).show();
                count++;
                persenter.getMv("android", uid, count + "");
                mMOneRlv.refreshComplete();
            }
        });
    }

    @Override
    protected void getDestory() {

    }

    @Override
    public void onSuccess(List<GetMVInfo.DataBean> dataBeans) {
        if (dataBeans != null){
            if (count == 1){
                dataAll = new ArrayList<>();
            }
            dataAll.addAll(dataBeans);
            adapter.setList(dataAll);
        }


        adapter.setOnItemClick(new MyMVOneAdapter.setOnClick() {
            @Override
            public void onClick(int position) {
                //Toast.makeText(getContext(), "点击了"+position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),VideoActivity.class);
                intent.putExtra("url",dataAll.get(position).getVideoUrl()+"");
                intent.putExtra("title",dataAll.get(position).getWorkDesc()+"");
                intent.putExtra("img",dataAll.get(position).getCover()+"");
                intent.putExtra("wid",dataAll.get(position).getWid()+"");
                Log.i("AAA",dataAll.get(position).getWid()+"---->>> wid");
                Log.i("AAA",uid+"---->>> uid");
                Log.i("AAA",dataAll.get(position)+"---->>> token");
                startActivity(intent);
            }
        });

    }

    @Override
    public void onFailed(String s) {
        Toast.makeText(getActivity(), "网络错误", Toast.LENGTH_SHORT).show();
    }


}
