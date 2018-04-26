package view.zhengxiaolong.bw.com.gittext.persenter;

import java.util.List;

import view.zhengxiaolong.bw.com.gittext.bean.LoginInfo;
import view.zhengxiaolong.bw.com.gittext.model.LoginModel;
import view.zhengxiaolong.bw.com.gittext.view.iview.ILoginActivity;

/**
 * Created by lenovo on 2018/4/26.
 */

public class LoginPersenter implements ILoginPersenter {

    private ILoginActivity iLoginActivity;
    private LoginModel model;
    public LoginPersenter(ILoginActivity iLoginActivity) {
        this.iLoginActivity = iLoginActivity;
        model = new LoginModel();
    }

    @Override
    public void onSuccess(LoginInfo dataBeans) {
        if (iLoginActivity!=null){
            iLoginActivity.onSuccess(dataBeans);
        }
    }

    @Override
    public void onFailed(String s) {
        if (iLoginActivity!=null){
            iLoginActivity.onFailed(s);
        }
    }

    @Override
    public void getLogin(String mobile, String password) {
        model.getLogin(mobile,password,this);
    }

    @Override
    public void onDestory() {
        if (iLoginActivity!=null){
            iLoginActivity=null;
        }
    }
}
