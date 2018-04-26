package view.zhengxiaolong.bw.com.gittext.persenter;

import java.util.List;

import view.zhengxiaolong.bw.com.gittext.bean.GetMVInfo;
import view.zhengxiaolong.bw.com.gittext.ifragment.IMvFragment;
import view.zhengxiaolong.bw.com.gittext.model.MvModel;

/**
 * Created by lenovo on 2018/4/25.
 */

public class MvPersenter implements IMvPersenter {

    private IMvFragment iMvFragment;
    private MvModel mvModel;
    public MvPersenter(IMvFragment iMvFragment) {
        this.iMvFragment = iMvFragment;
        mvModel = new MvModel();
    }

    @Override
    public void onSuccess(List<GetMVInfo.DataBean> dataBeans) {
        if (iMvFragment!=null){
            iMvFragment.onSuccess(dataBeans);
        }
    }

    @Override
    public void onFailed(String s) {
        if (iMvFragment!=null){
            iMvFragment.onFailed(s);
        }
    }

    @Override
    public void getMv(String source, String uid, String appVersion) {
        mvModel.getMv(source,uid,appVersion,this);
    }

    @Override
    public void onDestory() {
        if (iMvFragment!=null){
            iMvFragment=null;
        }
    }
}
