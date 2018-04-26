package view.zhengxiaolong.bw.com.gittext.view;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import view.zhengxiaolong.bw.com.gittext.R;
import view.zhengxiaolong.bw.com.gittext.base.BaseActivity;
import view.zhengxiaolong.bw.com.gittext.bean.RegisterInfo;
import view.zhengxiaolong.bw.com.gittext.persenter.RegisterPersenter;
import view.zhengxiaolong.bw.com.gittext.view.iview.IRegisterActivity;

public class RegisterActivity extends BaseActivity<RegisterPersenter> implements View.OnClickListener ,IRegisterActivity{


    /**
     * 请输入手机号。。。
     */
    private EditText mEtMobile;
    /**
     * 请输入密码
     */
    private EditText mEtPassword;
    /**
     * 注册
     */
    private Button mBtnBtnResign;
    private RegisterInfo registerInfo;
    @Override
    protected int getViewID() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {

        mEtMobile = (EditText) findViewById(R.id.et_mobile);
        mEtPassword = (EditText) findViewById(R.id.et_password);
        mBtnBtnResign = (Button) findViewById(R.id.btn_btn_resign);
        mBtnBtnResign.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected RegisterPersenter getPersenter() {
        persenter = new RegisterPersenter(this);
        return persenter;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_btn_resign:
                String mobile = mEtMobile.getText().toString();
                String password = mEtPassword.getText().toString();
                persenter.getRegister(mobile,password);
                break;
        }
    }

    @Override
    public void onSuccess(RegisterInfo registerInfo) {
        this.registerInfo = registerInfo;
        if (registerInfo.getCode().equals("0")){
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(this, registerInfo.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailed(String s) {
        Toast.makeText(this, "无网络", Toast.LENGTH_SHORT).show();
    }
}
