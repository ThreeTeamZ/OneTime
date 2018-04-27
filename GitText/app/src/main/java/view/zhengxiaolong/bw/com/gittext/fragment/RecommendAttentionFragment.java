package view.zhengxiaolong.bw.com.gittext.fragment;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import view.zhengxiaolong.bw.com.gittext.R;
import view.zhengxiaolong.bw.com.gittext.adapter.RecommendListAdapter;
import view.zhengxiaolong.bw.com.gittext.api.Api;
import view.zhengxiaolong.bw.com.gittext.base.BaseFragment;
import view.zhengxiaolong.bw.com.gittext.bean.RecommendListSuperClass;
import view.zhengxiaolong.bw.com.gittext.persenter.RecommendListPresenter;
import view.zhengxiaolong.bw.com.gittext.view.iview.IRecommendListView;

/**
 * 推荐-->关注
 */

public class RecommendAttentionFragment extends BaseFragment<RecommendListPresenter> implements IRecommendListView {

    private ImageView attention_imageView;
    private XRecyclerView attention_recycle_view;
    private RecommendListAdapter adapter;
    private List<RecommendListSuperClass.DataBean> listAll;
    private int count = 1;

    @Override
    protected int getLayoutId() {
        return R.layout.recommend_attention_fragment;
    }

    @Override
    protected RecommendListPresenter getPresenter() {
        presenter = new RecommendListPresenter(this);
        return presenter;
    }

    @Override
    protected void initView(View view) {
        attention_imageView = view.findViewById(R.id.attention_imageView);
        attention_recycle_view = (XRecyclerView) view.findViewById(R.id.attention_recycle_view);
        adapter = new RecommendListAdapter(getContext());
    }

    @Override
    protected void getData() {
        presenter.recommendList(Api.HOME,"2","1",count + "","android","101");
        //设置xrecycleview的布局
        attention_recycle_view.setLayoutManager(new LinearLayoutManager(getContext()));
        //添加分割线
        attention_recycle_view.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        //XRecyclerView的上下拉监听方法
        attention_recycle_view.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            //下拉刷新
            public void onRefresh() {
                count = 1;
                listAll.clear();
                presenter.recommendList(Api.HOME,"2","1",count + "","android","101");
                attention_recycle_view.refreshComplete();
            }

            @Override
            //上拉加载
            public void onLoadMore() {
                count++;
                presenter.recommendList(Api.HOME,"2","1",count + "","android","101");
                attention_recycle_view.refreshComplete();
            }
        });

        //设置适配器
        attention_recycle_view.setAdapter(adapter);
    }

    @Override
    protected void getDestory() {
        presenter.onDestrry();
    }

    @Override
    public void onFailed(String msg) {
        Toast.makeText(getContext(),msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSuccessData(List<RecommendListSuperClass.DataBean> data) {
        if (data != null){
            if (count == 1){
                listAll = new ArrayList<>();
            }
            listAll.addAll(data);
            adapter.setList(listAll);
        }
    }
}
