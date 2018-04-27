package view.zhengxiaolong.bw.com.gittext.model;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;
import view.zhengxiaolong.bw.com.gittext.api.Api;
import view.zhengxiaolong.bw.com.gittext.api.ApiService;
import view.zhengxiaolong.bw.com.gittext.bean.GetCrossDZ;
import view.zhengxiaolong.bw.com.gittext.persenter.IDzPersenter;
import view.zhengxiaolong.bw.com.gittext.utils.RetorfitUtils;

/**
 * Created by Administrator on 2018/4/27.
 */

public class DZModle implements IDZModel {
    @Override
    public void getDz(String source, String page, String appVersion, final IDzPersenter iDzPersenter) {
        RetorfitUtils inData = RetorfitUtils.getInData();
        ApiService retorfit = inData.getRetorfit(Api.DUAN, ApiService.class);
        Flowable<GetCrossDZ> dz = retorfit.getDz(source, page, appVersion);
        dz.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<GetCrossDZ>() {
                    @Override
                    public void onNext(GetCrossDZ getCrossDZ) {

                        if (iDzPersenter!=null){
                            List<GetCrossDZ.DataBean> data = getCrossDZ.getData();
                            iDzPersenter.onSuccess(data);

                        }

                    }

                    @Override
                    public void onError(Throwable t) {

                         if (iDzPersenter!=null){
                             iDzPersenter.onFailed(t.getMessage());
                         }

                    }

                    @Override
                    public void onComplete() {

                    }
                });




    }
}
