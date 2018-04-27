package view.zhengxiaolong.bw.com.gittext.persenter;

import view.zhengxiaolong.bw.com.gittext.bean.RegisterInfo;

/**
 * Created by lenovo on 2018/4/26.
 */

public interface IRegisterPersenter {
    void onSuccess(RegisterInfo registerInfo);
    void onFailed(String s);
    void getRegister(String mobile,String password);
    void onDestory();
}
