package view.zhengxiaolong.bw.com.gittext.persenter;

import view.zhengxiaolong.bw.com.gittext.bean.RegisterInfo;
import view.zhengxiaolong.bw.com.gittext.model.RegisterModel;
import view.zhengxiaolong.bw.com.gittext.view.iview.IRegisterActivity;

/**
 * Created by lenovo on 2018/4/26.
 */

public class RegisterPersenter implements IRegisterPersenter {
    private IRegisterActivity iRegisterActivity;
    private RegisterModel model;
    public RegisterPersenter(IRegisterActivity iRegisterActivity) {
        this.iRegisterActivity = iRegisterActivity;
        model = new RegisterModel();
    }

    @Override
    public void onSuccess(RegisterInfo registerInfo) {
        if (iRegisterActivity!=null){
            iRegisterActivity.onSuccess(registerInfo);
        }
    }

    @Override
    public void onFailed(String s) {
        if (iRegisterActivity!=null){
            iRegisterActivity.onFailed(s);
        }
    }

    @Override
    public void getRegister(String mobile, String password) {
        model.getRegister(mobile,password,this);
    }

    @Override
    public void onDestory() {
        if (iRegisterActivity!=null){
            iRegisterActivity=null;
        }
    }
}
