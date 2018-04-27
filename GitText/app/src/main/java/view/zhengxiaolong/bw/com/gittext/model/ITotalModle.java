package view.zhengxiaolong.bw.com.gittext.model;


import view.zhengxiaolong.bw.com.gittext.persenter.IBannerPresenter;
import view.zhengxiaolong.bw.com.gittext.persenter.IRecommendListPresenter;

/**
 * 全部的Modle层实现类
 */

public interface ITotalModle {
    //广告轮播图
    void banner(String path, IBannerPresenter iBannerPresenter);
    //推荐里的列表
    void recommendList(String path, String uid, String type, String page, String android, String appVersion, IRecommendListPresenter iRecommendListPresenter);
}
