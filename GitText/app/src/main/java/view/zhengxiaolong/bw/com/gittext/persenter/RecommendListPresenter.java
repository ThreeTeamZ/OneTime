package view.zhengxiaolong.bw.com.gittext.persenter;


import java.util.List;

import view.zhengxiaolong.bw.com.gittext.base.BasePresenter;
import view.zhengxiaolong.bw.com.gittext.bean.RecommendListSuperClass;
import view.zhengxiaolong.bw.com.gittext.model.ITotalModle;
import view.zhengxiaolong.bw.com.gittext.model.TotalModle;
import view.zhengxiaolong.bw.com.gittext.view.iview.IRecommendListView;

/**
 * 列表p层类
 */

public class RecommendListPresenter extends BasePresenter<IRecommendListView> implements IRecommendListPresenter {
    private ITotalModle iTotalModle;

    public RecommendListPresenter(IRecommendListView iRecommendListView) {
        super.attachView(iRecommendListView);
        iTotalModle = new TotalModle();
    }

    @Override
    public void recommendList(String path, String uid, String type, String page, String android, String appVersion) {
        iTotalModle.recommendList(path,uid,type,page,android,appVersion,this);
    }

    @Override
    public void onFailed(String msg) {
        if (view != null){
            view.onFailed(msg);
        }
    }

    @Override
    public void onSuccess(List<RecommendListSuperClass.DataBean> data) {
        if (view != null){
            view.onSuccessData(data);
        }
    }

    @Override
    public void onDestrry() {
        if (view != null){
            view = null;
        }
    }
}
