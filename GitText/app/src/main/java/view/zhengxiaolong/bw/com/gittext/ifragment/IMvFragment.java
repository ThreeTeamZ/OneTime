package view.zhengxiaolong.bw.com.gittext.ifragment;

import java.util.List;

import view.zhengxiaolong.bw.com.gittext.bean.GetMVInfo;

/**
 * Created by lenovo on 2018/4/25.
 */

public interface IMvFragment {
    void onSuccess(List<GetMVInfo.DataBean> dataBeans );
    void onFailed(String s);
}
