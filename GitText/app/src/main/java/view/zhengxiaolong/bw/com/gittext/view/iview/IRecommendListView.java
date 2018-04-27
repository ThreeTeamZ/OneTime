package view.zhengxiaolong.bw.com.gittext.view.iview;


import java.util.List;

import view.zhengxiaolong.bw.com.gittext.bean.RecommendListSuperClass;

/**
 * 推荐里列表v层实现类
 */

public interface IRecommendListView {
    void onFailed(String msg);

    void onSuccessData(List<RecommendListSuperClass.DataBean> data);
}
