package view.zhengxiaolong.bw.com.gittext.view.iview;

import view.zhengxiaolong.bw.com.gittext.bean.DianZanInfo;

/**
 * Created by lenovo on 2018/4/27.
 */

public interface IDianZanActivity {
    void onSuccess(DianZanInfo dianZanInfo);
    void onFailed(String s);
}
