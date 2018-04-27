package view.zhengxiaolong.bw.com.gittext.persenter;

import java.util.List;

import view.zhengxiaolong.bw.com.gittext.bean.GetCrossDZ;
import view.zhengxiaolong.bw.com.gittext.bean.GetMVInfo;

/**
 * Created by Administrator on 2018/4/27.
 */

public interface IDzPersenter {
    void onSuccess(List<GetCrossDZ.DataBean> dataBeans );
    void onFailed(String s);
    void getMv(String source,String page,String appVersion);
    void onDestory();
}
