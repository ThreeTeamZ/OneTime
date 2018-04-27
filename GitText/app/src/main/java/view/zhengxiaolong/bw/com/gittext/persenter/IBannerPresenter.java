package view.zhengxiaolong.bw.com.gittext.persenter;


import java.util.List;

import view.zhengxiaolong.bw.com.gittext.bean.BannerSuperClass;

/**
 * 轮播图p层实现类
 */

public interface IBannerPresenter {
    void banner(String path);

    void onFailed(String msg);

    void onSuccess(List<BannerSuperClass.DataBean> data);

    void onDestrry();
}
