package view.zhengxiaolong.bw.com.gittext.fragment;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import view.zhengxiaolong.bw.com.gittext.R;
import view.zhengxiaolong.bw.com.gittext.adapter.RecommendListAdapter;
import view.zhengxiaolong.bw.com.gittext.api.Api;
import view.zhengxiaolong.bw.com.gittext.banner.AccordionTransformer;
import view.zhengxiaolong.bw.com.gittext.banner.AutoBanner;
import view.zhengxiaolong.bw.com.gittext.base.BaseFragment;
import view.zhengxiaolong.bw.com.gittext.base.BasePresenter;
import view.zhengxiaolong.bw.com.gittext.bean.BannerSuperClass;
import view.zhengxiaolong.bw.com.gittext.bean.RecommendListSuperClass;
import view.zhengxiaolong.bw.com.gittext.persenter.BannerPresenter;
import view.zhengxiaolong.bw.com.gittext.persenter.IBannerPresenter;
import view.zhengxiaolong.bw.com.gittext.persenter.IRecommendListPresenter;
import view.zhengxiaolong.bw.com.gittext.persenter.RecommendListPresenter;
import view.zhengxiaolong.bw.com.gittext.view.iview.IBannerView;
import view.zhengxiaolong.bw.com.gittext.view.iview.IRecommendListView;

/**
 * 推荐-->热门
 */

public class RecommendHotFragment extends BaseFragment implements IBannerView, AutoBanner.AutoBannerListener,IRecommendListView {
    private AutoBanner mAutoBanner;
    private XRecyclerView hot_recycle_view;
    private List<String> mImgUrls;
    private IBannerPresenter iBannerPresenter;
    private IRecommendListPresenter iRecommendListPresenter;
    private RecommendListAdapter adapter;
    private List<RecommendListSuperClass.DataBean> listAll;
    private int count = 1;

    @Override
    protected int getLayoutId() {
        return R.layout.recommend_hot_fragment;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected void initView(View view) {
        mAutoBanner = (AutoBanner) view.findViewById(R.id.hot_auto_banner);
        hot_recycle_view = (XRecyclerView) view.findViewById(R.id.hot_recycle_view);
        iBannerPresenter = new BannerPresenter(this);
        iRecommendListPresenter = new RecommendListPresenter(this);
        mImgUrls = new ArrayList<>();
        adapter = new RecommendListAdapter(getContext());
    }

    @Override
    protected void getData() {
        iBannerPresenter.banner(Api.HOME);
        iRecommendListPresenter.recommendList(Api.HOME,"2","1",count + "","android","101");
        //设置xrecycleview的布局
        hot_recycle_view.setLayoutManager(new LinearLayoutManager(getContext()));
        //添加分割线
        hot_recycle_view.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        //XRecyclerView的上下拉监听方法
        hot_recycle_view.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            //下拉刷新
            public void onRefresh() {
                count = 1;
                listAll.clear();
                iRecommendListPresenter.recommendList(Api.HOME,"2","1",count + "","android","101");
                hot_recycle_view.refreshComplete();
            }

            @Override
            //上拉加载
            public void onLoadMore() {
                count++;
                iRecommendListPresenter.recommendList(Api.HOME,"2","1",count + "","android","101");
                hot_recycle_view.refreshComplete();
            }
        });

        //设置适配器
        hot_recycle_view.setAdapter(adapter);
    }

    @Override
    protected void getDestory() {
        iBannerPresenter.onDestrry();
        iRecommendListPresenter.onDestrry();
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


    @Override
    public void onSuccess(List<BannerSuperClass.DataBean> data) {

        for (int i = 0; i < data.size() ; i++){
            mImgUrls.add(data.get(i).getIcon());
        }

        //不设置setAuto，不会自动轮播，不设置监听，无法点击,动画转换器可以根据需要设置
        mAutoBanner.load(mImgUrls).setOnAutoBannerListener(this).setAuto(3000).setAutoBannerAnimation(AccordionTransformer.class).display();
    }

    @Override
    public void onClickListener(int postion) {
        Toast.makeText(getContext(), "点击了：" + postion + "位置", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        mAutoBanner.startAuto();
    }

    @Override
    public void onStop() {
        super.onStop();
        mAutoBanner.stopAuto();
    }
}
