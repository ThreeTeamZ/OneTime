package view.zhengxiaolong.bw.com.gittext.model;

import view.zhengxiaolong.bw.com.gittext.persenter.ILoginPersenter;

/**
 * Created by lenovo on 2018/4/26.
 */

public interface ILoginModel {
    void getLogin(String mobile, String password, ILoginPersenter iLoginPersenter);
}
