package view.zhengxiaolong.bw.com.gittext.api;

import android.database.Observable;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import view.zhengxiaolong.bw.com.gittext.bean.GetMVInfo;

/**
 * Created by lenovo on 2018/4/25.
 */

public interface ApiService {
    @GET("/quarter/getVideos")
    Flowable<GetMVInfo> getMv(@Query("source") String source, @Query("uid") String uid, @Query("appVersion") String appVersion);
}
