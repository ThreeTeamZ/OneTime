package view.zhengxiaolong.bw.com.gittext.view.iview;

import java.util.List;

import view.zhengxiaolong.bw.com.gittext.bean.LoginInfo;

/**
 * Created by lenovo on 2018/4/26.
 */

public interface ILoginActivity {
    void onSuccess(LoginInfo dataBeans );
    void onFailed(String s);
}
