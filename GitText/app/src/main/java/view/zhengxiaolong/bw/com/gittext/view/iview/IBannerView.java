package view.zhengxiaolong.bw.com.gittext.view.iview;


import java.util.List;

import view.zhengxiaolong.bw.com.gittext.bean.BannerSuperClass;

/**
 * 轮播图v层实现类
 */

public interface IBannerView {
    void onFailed(String msg);

    void onSuccess(List<BannerSuperClass.DataBean> data);
}
