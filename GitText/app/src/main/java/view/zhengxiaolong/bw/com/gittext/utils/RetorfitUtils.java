package view.zhengxiaolong.bw.com.gittext.utils;

import android.util.Log;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 2018/4/25.
 */

public class RetorfitUtils {
    private static RetorfitUtils RETORFITUTILS = null;

    public RetorfitUtils() {
    }

    public static RetorfitUtils getInData(){
        if (RETORFITUTILS==null){
            synchronized (RetorfitUtils.class){
                if (RETORFITUTILS==null){
                    RETORFITUTILS = new RetorfitUtils();
                }
            }
        }
        return RETORFITUTILS;
    }
    public <T> T getRetorfit(String path,Class<T> cal){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("TAG",message);
            }
        });

        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        T t = retrofit.create(cal);
        return t;
    }
}
