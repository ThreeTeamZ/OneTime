package view.zhengxiaolong.bw.com.gittext.model;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;
import view.zhengxiaolong.bw.com.gittext.api.Api;
import view.zhengxiaolong.bw.com.gittext.api.ApiService;
import view.zhengxiaolong.bw.com.gittext.bean.GetMVInfo;
import view.zhengxiaolong.bw.com.gittext.persenter.IMvPersenter;
import view.zhengxiaolong.bw.com.gittext.utils.RetorfitUtils;

/**
 * Created by lenovo on 2018/4/25.
 */

public class MvModel implements IMvModel {
    @Override
    public void getMv(String source, String uid, String appVersion, final IMvPersenter iMvPersenter) {
        RetorfitUtils inData = RetorfitUtils.getInData();
        ApiService retorfit = inData.getRetorfit(Api.HOME, ApiService.class);
        Flowable<GetMVInfo> mv = retorfit.getMv(source, uid, appVersion);
        mv.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<GetMVInfo>() {
                    @Override
                    public void onNext(GetMVInfo getMVInfo) {
                        if (iMvPersenter!=null){
                            List<GetMVInfo.DataBean> data = getMVInfo.getData();
                            iMvPersenter.onSuccess(data);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        if (iMvPersenter!=null){
                            iMvPersenter.onFailed(t.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
