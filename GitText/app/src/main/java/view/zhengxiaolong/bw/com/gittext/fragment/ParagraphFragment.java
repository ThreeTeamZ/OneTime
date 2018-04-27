package view.zhengxiaolong.bw.com.gittext.fragment;


import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import view.zhengxiaolong.bw.com.gittext.R;
import view.zhengxiaolong.bw.com.gittext.adapter.DuanAdapter;
import view.zhengxiaolong.bw.com.gittext.base.BaseFragment;
import view.zhengxiaolong.bw.com.gittext.bean.GetCrossDZ;
import view.zhengxiaolong.bw.com.gittext.bean.ProgressStyle;
import view.zhengxiaolong.bw.com.gittext.ifragment.IDZFragment;
import view.zhengxiaolong.bw.com.gittext.persenter.DuanPersenter;
import view.zhengxiaolong.bw.com.gittext.utils.RecyclerViewItemDecoration;

/**
 * Created by lenovo on 2018/4/25.
 */

public class ParagraphFragment extends BaseFragment implements IDZFragment{

    private XRecyclerView paragxRecycler;
    private DuanPersenter persenter;
    private String page;
    private List<GetCrossDZ.DataBean> dataAll;
    private DuanAdapter adapter;

    @Override
    protected int getLayoutID() {
        return R.layout.paragraphfragment;
    }

    @Override
    protected void initView(View view) {
        paragxRecycler = view.findViewById(R.id.paragxRecycler);
        paragxRecycler.setRefreshProgressStyle(ProgressStyle.BallZigZag); //设定下拉刷新样式
        paragxRecycler.setLoadingMoreProgressStyle(ProgressStyle.BallZigZag);//设定上拉加载样式
        //添加Android自带的分割线
        paragxRecycler.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        RecyclerViewItemDecoration decoration = new RecyclerViewItemDecoration(5);
        paragxRecycler.addItemDecoration(decoration);
        paragxRecycler.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        persenter = new DuanPersenter(this);

    }

    @Override
    protected void initData() {
        page = "1";
        if (page.equals("") || page == null) {
            Toast.makeText(getActivity(), "未登录", Toast.LENGTH_SHORT).show();
        } else {
            persenter.getMv("android", page, "1");
        }

    }

    @Override
    public void onSuccess(List<GetCrossDZ.DataBean> dataBeans) {
        this.dataAll = dataBeans;
        adapter = new DuanAdapter(getActivity());
        adapter.setList(dataAll);
         paragxRecycler.setAdapter(adapter);
    }

    @Override
    public void onFailed(String s) {
        Toast.makeText(getActivity(), "网络错误", Toast.LENGTH_SHORT).show();

    }
}
