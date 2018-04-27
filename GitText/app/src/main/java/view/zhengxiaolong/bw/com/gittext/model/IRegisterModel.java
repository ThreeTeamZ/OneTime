package view.zhengxiaolong.bw.com.gittext.model;

import view.zhengxiaolong.bw.com.gittext.persenter.IRegisterPersenter;

/**
 * Created by lenovo on 2018/4/26.
 */

public interface IRegisterModel {
    void getRegister(String mobile, String password, IRegisterPersenter iRegisterPersenter);
}
