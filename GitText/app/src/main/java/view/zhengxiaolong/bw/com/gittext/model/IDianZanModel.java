package view.zhengxiaolong.bw.com.gittext.model;

import view.zhengxiaolong.bw.com.gittext.persenter.IDianZanPersenter;

/**
 * Created by lenovo on 2018/4/27.
 */

public interface IDianZanModel {
    void getDianZ(String uid, String wid, String token, String appVersion, String source, IDianZanPersenter iDianZanPersenter);
}
