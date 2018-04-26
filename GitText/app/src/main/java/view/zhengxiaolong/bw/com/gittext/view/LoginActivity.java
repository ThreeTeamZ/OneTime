package view.zhengxiaolong.bw.com.gittext.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import view.zhengxiaolong.bw.com.gittext.R;
import view.zhengxiaolong.bw.com.gittext.base.BaseActivity;
import view.zhengxiaolong.bw.com.gittext.bean.LoginInfo;
import view.zhengxiaolong.bw.com.gittext.persenter.LoginPersenter;
import view.zhengxiaolong.bw.com.gittext.view.iview.ILoginActivity;

public class LoginActivity extends BaseActivity<LoginPersenter> implements ILoginActivity, View.OnClickListener {


    /**
     * 请输入手机号。。。
     */
    private EditText mEtMobile;
    /**
     * 请输入密码
     */
    private EditText mEtPassword;
    /**
     * 登录
     */
    private Button mBtnLogin;
    /**
     * 注册
     */
    private Button mBtnResign;

    private LoginInfo dataBeans;


    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor edit;


    @Override
    protected int getViewID() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

        mEtMobile = (EditText) findViewById(R.id.et_mobile);
        mEtPassword = (EditText) findViewById(R.id.et_password);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(this);
        mBtnResign = (Button) findViewById(R.id.btn_resign);
        mBtnResign.setOnClickListener(this);
        mSharedPreferences = this.getSharedPreferences("UserOne",MODE_PRIVATE);
        edit = mSharedPreferences.edit();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected LoginPersenter getPersenter() {
        persenter = new LoginPersenter(this);
        return persenter;
    }

    @Override
    public void onSuccess(LoginInfo dataBeans) {
        this.dataBeans = dataBeans;
        String code = dataBeans.getCode();
        if (code.equals("0")){
            edit.putString("uid",dataBeans.getData().getUid()+"");
            edit.putString("token",dataBeans.getData().getToken()+"");
            edit.putString("name",dataBeans.getData().getUsername()+"");
            edit.commit();
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(this, dataBeans.getMsg(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onFailed(String s) {
        Toast.makeText(this, "无网络", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_login:
                String mobile = mEtMobile.getText().toString();
                String password = mEtPassword.getText().toString();
                persenter.getLogin(mobile,password);
                break;
            case R.id.btn_resign:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
        }
    }
}
