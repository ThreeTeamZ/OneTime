package view.zhengxiaolong.bw.com.gittext.model;


import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;
import view.zhengxiaolong.bw.com.gittext.api.ApiService;
import view.zhengxiaolong.bw.com.gittext.bean.BannerSuperClass;
import view.zhengxiaolong.bw.com.gittext.bean.RecommendListSuperClass;
import view.zhengxiaolong.bw.com.gittext.persenter.IBannerPresenter;
import view.zhengxiaolong.bw.com.gittext.persenter.IRecommendListPresenter;
import view.zhengxiaolong.bw.com.gittext.utils.RetrofitUtils;

/**
 * 全部的Modle类
 */

public class TotalModle implements ITotalModle {

    private RetrofitUtils retrofitUtils;

    @Override
    public void banner(String path, final IBannerPresenter iBannerPresenter) {
        retrofitUtils = RetrofitUtils.getInData();
        ApiService apiService = retrofitUtils.getRetrofit(path, ApiService.class);
        Flowable<BannerSuperClass> flowable = apiService.getBannerData();
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<BannerSuperClass>() {
                    @Override
                    public void onNext(BannerSuperClass bannerSuperClass) {
                        iBannerPresenter.onSuccess(bannerSuperClass.getData());
                    }

                    @Override
                    public void onError(Throwable t) {
                        iBannerPresenter.onFailed(t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void recommendList(String path, String uid, String type, String page, String android, String appVersion, final IRecommendListPresenter iRecommendListPresenter) {
        retrofitUtils = RetrofitUtils.getInData();
        ApiService apiService = retrofitUtils.getRetrofit(path, ApiService.class);
        Flowable<RecommendListSuperClass> flowable = apiService.getRecommendListData(uid, type, page, android, appVersion);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<RecommendListSuperClass>() {
                    @Override
                    public void onNext(RecommendListSuperClass recommendListSuperClass) {
                        iRecommendListPresenter.onSuccess(recommendListSuperClass.getData());
                    }

                    @Override
                    public void onError(Throwable t) {
                        iRecommendListPresenter.onFailed(t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
