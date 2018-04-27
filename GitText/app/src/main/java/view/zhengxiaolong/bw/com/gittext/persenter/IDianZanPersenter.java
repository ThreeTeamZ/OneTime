package view.zhengxiaolong.bw.com.gittext.persenter;

import view.zhengxiaolong.bw.com.gittext.bean.DianZanInfo;

/**
 * Created by lenovo on 2018/4/27.
 */

public interface IDianZanPersenter {
    void onSuccess(DianZanInfo dianZanInfo);
    void onFailed(String s);
    void getDianZ(String uid,String wid,String token,String appVersion,String source);
    void onDestory();
}
