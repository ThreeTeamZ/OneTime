package view.zhengxiaolong.bw.com.gittext.persenter;


import java.util.List;

import view.zhengxiaolong.bw.com.gittext.base.BasePresenter;
import view.zhengxiaolong.bw.com.gittext.bean.BannerSuperClass;
import view.zhengxiaolong.bw.com.gittext.model.ITotalModle;
import view.zhengxiaolong.bw.com.gittext.model.TotalModle;
import view.zhengxiaolong.bw.com.gittext.view.iview.IBannerView;

/**
 * 轮播图p层类
 */

public class BannerPresenter extends BasePresenter<IBannerView> implements IBannerPresenter {
    private ITotalModle iTotalModle;
    public BannerPresenter(IBannerView iBannerView) {
        super.attachView(iBannerView);
        iTotalModle = new TotalModle();
    }

    @Override
    public void banner(String path) {
        iTotalModle.banner(path,this);
    }

    @Override
    public void onFailed(String msg) {
        if (view != null){
            view.onFailed(msg);
        }
    }

    @Override
    public void onSuccess(List<BannerSuperClass.DataBean> data) {
        if (view != null){
            view.onSuccess(data);
        }
    }

    @Override
    public void onDestrry() {
        if (view != null){
            view = null;
        }
    }
}
