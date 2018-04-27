package view.zhengxiaolong.bw.com.gittext.ifragment;

import java.util.List;

import view.zhengxiaolong.bw.com.gittext.bean.GetCrossDZ;
import view.zhengxiaolong.bw.com.gittext.bean.GetMVInfo;

/**
 * Created by Administrator on 2018/4/27.
 */

public interface IDZFragment {
    void onSuccess(List<GetCrossDZ.DataBean> dataBeans );
    void onFailed(String s);
}
