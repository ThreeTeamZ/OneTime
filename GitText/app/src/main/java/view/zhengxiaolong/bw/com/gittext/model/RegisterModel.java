package view.zhengxiaolong.bw.com.gittext.model;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;
import view.zhengxiaolong.bw.com.gittext.api.Api;
import view.zhengxiaolong.bw.com.gittext.api.ApiService;
import view.zhengxiaolong.bw.com.gittext.bean.RegisterInfo;
import view.zhengxiaolong.bw.com.gittext.persenter.IRegisterPersenter;
import view.zhengxiaolong.bw.com.gittext.utils.RetorfitUtils;

/**
 * Created by lenovo on 2018/4/26.
 */

public class RegisterModel implements IRegisterModel {
    @Override
    public void getRegister(String mobile, String password, final IRegisterPersenter iRegisterPersenter) {
        RetorfitUtils inData = RetorfitUtils.getInData();
        ApiService retorfit = inData.getRetorfit(Api.HOME, ApiService.class);
        Flowable<RegisterInfo> register = retorfit.getRegister(mobile, password);
        register.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<RegisterInfo>() {
                    @Override
                    public void onNext(RegisterInfo registerInfo) {
                        if (iRegisterPersenter!=null){
                            iRegisterPersenter.onSuccess(registerInfo);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        if (iRegisterPersenter!=null){
                            iRegisterPersenter.onFailed(t.toString());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
