package view.zhengxiaolong.bw.com.gittext.persenter;

import java.util.List;

import view.zhengxiaolong.bw.com.gittext.bean.GetMVInfo;

/**
 * Created by lenovo on 2018/4/25.
 */

public interface IMvPersenter {
    void onSuccess(List<GetMVInfo.DataBean> dataBeans );
    void onFailed(String s);
    void getMv(String source,String uid,String appVersion);
    void onDestory();
}
