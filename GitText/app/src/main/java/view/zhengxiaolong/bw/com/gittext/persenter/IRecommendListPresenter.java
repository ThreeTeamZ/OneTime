package view.zhengxiaolong.bw.com.gittext.persenter;


import java.util.List;

import view.zhengxiaolong.bw.com.gittext.bean.RecommendListSuperClass;

/**
 * 列表p层实现类
 */

public interface IRecommendListPresenter {
    void recommendList(String path, String uid, String type, String page, String android, String appVersion);

    void onFailed(String msg);

    void onSuccess(List<RecommendListSuperClass.DataBean> data);

    void onDestrry();
}
