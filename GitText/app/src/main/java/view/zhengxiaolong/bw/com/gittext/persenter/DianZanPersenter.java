package view.zhengxiaolong.bw.com.gittext.persenter;

import view.zhengxiaolong.bw.com.gittext.bean.DianZanInfo;
import view.zhengxiaolong.bw.com.gittext.model.DianZanModel;
import view.zhengxiaolong.bw.com.gittext.view.iview.IDianZanActivity;

/**
 * Created by lenovo on 2018/4/27.
 */

public class DianZanPersenter implements IDianZanPersenter {
    private IDianZanActivity iDianZanActivity;
    private DianZanModel model;
    public DianZanPersenter(IDianZanActivity iDianZanActivity) {
        this.iDianZanActivity = iDianZanActivity;
        model = new DianZanModel();
    }

    @Override
    public void onSuccess(DianZanInfo dianZanInfo) {
        if (iDianZanActivity != null) {
            iDianZanActivity.onSuccess(dianZanInfo);
        }
    }

    @Override
    public void onFailed(String s) {
        if (iDianZanActivity != null) {
            iDianZanActivity.onFailed(s.toString());
        }
    }

    @Override
    public void getDianZ(String uid, String wid, String token, String appVersion, String source) {
        model.getDianZ(uid,wid,token,appVersion,source,this);
    }

    @Override
    public void onDestory() {
        if (iDianZanActivity != null) {
            iDianZanActivity=null;
        }
    }
}
