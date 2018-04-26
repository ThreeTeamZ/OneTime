package view.zhengxiaolong.bw.com.gittext.view.iview;

import view.zhengxiaolong.bw.com.gittext.bean.RegisterInfo;
import view.zhengxiaolong.bw.com.gittext.view.RegisterActivity;

/**
 * Created by lenovo on 2018/4/26.
 */

public interface IRegisterActivity {
    void onSuccess(RegisterInfo registerInfo);
    void onFailed(String s);
}
