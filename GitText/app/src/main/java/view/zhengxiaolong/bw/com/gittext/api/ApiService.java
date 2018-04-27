package view.zhengxiaolong.bw.com.gittext.api;

import android.database.Observable;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
<<<<<<< HEAD

import view.zhengxiaolong.bw.com.gittext.bean.GetCrossDZ;

import view.zhengxiaolong.bw.com.gittext.bean.DianZanInfo;

=======
import view.zhengxiaolong.bw.com.gittext.bean.BannerSuperClass;
import view.zhengxiaolong.bw.com.gittext.bean.GetCrossDZ;
import view.zhengxiaolong.bw.com.gittext.bean.DianZanInfo;
>>>>>>> f53fa8fd6e28e860831a8f178f5e482d485ff5cc
import view.zhengxiaolong.bw.com.gittext.bean.GetMVInfo;
import view.zhengxiaolong.bw.com.gittext.bean.LoginInfo;
import view.zhengxiaolong.bw.com.gittext.bean.RecommendListSuperClass;
import view.zhengxiaolong.bw.com.gittext.bean.RegisterInfo;

/**
 * Created by lenovo on 2018/4/25.
 */

public interface ApiService {
    //获取视频
    @GET("/quarter/getVideos")
    Flowable<GetMVInfo> getMv(@Query("source") String source, @Query("uid") String uid, @Query("appVersion") String appVersion);

    @GET("/quarter/getJokes ")
    Flowable<GetCrossDZ> getDz(@Query("source") String source,@Query("page") String page,@Query("appVersion") String appVersion );

<<<<<<< HEAD



=======
>>>>>>> f53fa8fd6e28e860831a8f178f5e482d485ff5cc
    //登录
    @FormUrlEncoded
    @POST("/user/login?")
    Flowable<LoginInfo> getLogin(@Field("mobile") String mobile, @Field("password") String password);

    //注册
    @FormUrlEncoded
    @POST("/quarter/register")
    Flowable<RegisterInfo> getRegister(@Field("mobile") String mobile,@Field("password") String password);

    //点赞
    @FormUrlEncoded
    @POST("/quarter/praise")
    Flowable<DianZanInfo> getDianZan(@Field("wid") String wid,@Field("uid") String uid,@Field("token") String token,@Field("source") String source,@Field("appVersion")String appVersion);

<<<<<<< HEAD
=======
    //广告轮播图
    @POST("/quarter/getAd")
    Flowable<BannerSuperClass> getBannerData();
    //推荐里的列表
    @FormUrlEncoded
    @POST("/quarter/getVideos")
    Flowable<RecommendListSuperClass> getRecommendListData(@Field("uid")String uid, @Field("type")String type, @Field("page")String page, @Field("source")String android, @Field("appVersion")String appVersion);

>>>>>>> f53fa8fd6e28e860831a8f178f5e482d485ff5cc
}
