package view.zhengxiaolong.bw.com.gittext.api;

import android.database.Observable;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import view.zhengxiaolong.bw.com.gittext.bean.GetMVInfo;
import view.zhengxiaolong.bw.com.gittext.bean.LoginInfo;
import view.zhengxiaolong.bw.com.gittext.bean.RegisterInfo;

/**
 * Created by lenovo on 2018/4/25.
 */

public interface ApiService {
    //获取视频
    @GET("/quarter/getVideos")
    Flowable<GetMVInfo> getMv(@Query("source") String source, @Query("uid") String uid, @Query("appVersion") String appVersion);

    //登录
    @FormUrlEncoded
    @POST("/user/login?")
    Flowable<LoginInfo> getLogin(@Field("mobile") String mobile, @Field("password") String password);

    //注册
    @FormUrlEncoded
    @POST("/quarter/register")
    Flowable<RegisterInfo> getRegister(@Field("mobile") String mobile,@Field("password") String password);

}
