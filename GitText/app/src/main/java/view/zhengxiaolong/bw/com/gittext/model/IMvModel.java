package view.zhengxiaolong.bw.com.gittext.model;

import view.zhengxiaolong.bw.com.gittext.persenter.IMvPersenter;

/**
 * Created by lenovo on 2018/4/25.
 */

public interface IMvModel {
    void getMv(String source, String uid, String appVersion, IMvPersenter iMvPersenter);
}
