package view.zhengxiaolong.bw.com.gittext.persenter;

import java.util.List;

import view.zhengxiaolong.bw.com.gittext.bean.LoginInfo;

/**
 * Created by lenovo on 2018/4/26.
 */

public interface ILoginPersenter {
    void onSuccess(LoginInfo dataBeans);
    void onFailed(String s);
    void getLogin(String mobile,String password);
    void onDestory();
}
