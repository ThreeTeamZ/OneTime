package view.zhengxiaolong.bw.com.gittext.model;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;
import view.zhengxiaolong.bw.com.gittext.api.Api;
import view.zhengxiaolong.bw.com.gittext.api.ApiService;
import view.zhengxiaolong.bw.com.gittext.bean.LoginInfo;
import view.zhengxiaolong.bw.com.gittext.persenter.ILoginPersenter;
import view.zhengxiaolong.bw.com.gittext.utils.RetorfitUtils;

/**
 * Created by lenovo on 2018/4/26.
 */

public class LoginModel implements ILoginModel {
    @Override
    public void getLogin(String mobile, String password, final ILoginPersenter iLoginPersenter) {
        RetorfitUtils inData = RetorfitUtils.getInData();
        ApiService retorfit = inData.getRetorfit(Api.HOME, ApiService.class);
        Flowable<LoginInfo> login = retorfit.getLogin(mobile, password);
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<LoginInfo>() {
                    @Override
                    public void onNext(LoginInfo loginInfo) {
                        if (iLoginPersenter!=null){
                            iLoginPersenter.onSuccess(loginInfo);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        if (iLoginPersenter!=null){
                            iLoginPersenter.onFailed(t.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
