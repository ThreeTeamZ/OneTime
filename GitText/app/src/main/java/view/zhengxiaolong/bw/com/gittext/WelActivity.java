package view.zhengxiaolong.bw.com.gittext;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wel);
        getSupportActionBar().hide();
        new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {

                Intent intent = new Intent(WelActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                return false;
            }
        }).sendEmptyMessageDelayed(0,3000);
    }
}
