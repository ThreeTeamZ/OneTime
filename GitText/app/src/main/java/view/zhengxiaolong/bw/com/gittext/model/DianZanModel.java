package view.zhengxiaolong.bw.com.gittext.model;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;
import view.zhengxiaolong.bw.com.gittext.api.Api;
import view.zhengxiaolong.bw.com.gittext.api.ApiService;
import view.zhengxiaolong.bw.com.gittext.bean.DianZanInfo;
import view.zhengxiaolong.bw.com.gittext.persenter.IDianZanPersenter;
import view.zhengxiaolong.bw.com.gittext.utils.RetorfitUtils;

/**
 * Created by lenovo on 2018/4/27.
 */

public class DianZanModel implements IDianZanModel {
    @Override
    public void getDianZ(String uid, String wid, String token, String appVersion, String source, final IDianZanPersenter iDianZanPersenter) {
        RetorfitUtils inData = RetorfitUtils.getInData();
        ApiService retorfit = inData.getRetorfit(Api.HOME, ApiService.class);
        Flowable<DianZanInfo> dianZan = retorfit.getDianZan(wid, uid, token, source, appVersion);
        dianZan.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<DianZanInfo>() {
                    @Override
                    public void onNext(DianZanInfo dianZanInfo) {
                        if (iDianZanPersenter!=null){
                            iDianZanPersenter.onSuccess(dianZanInfo);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        if (iDianZanPersenter != null) {
                            iDianZanPersenter.onFailed(t.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
