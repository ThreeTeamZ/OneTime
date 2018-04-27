package view.zhengxiaolong.bw.com.gittext.persenter;

import java.util.List;

import view.zhengxiaolong.bw.com.gittext.bean.GetCrossDZ;
import view.zhengxiaolong.bw.com.gittext.ifragment.IDZFragment;
import view.zhengxiaolong.bw.com.gittext.model.DZModle;

/**
 * Created by Administrator on 2018/4/27.
 */

public class DuanPersenter implements IDzPersenter {
    private IDZFragment idzFragment;
    private DZModle dzModle;

    public DuanPersenter(IDZFragment idzFragment) {
        this.idzFragment = idzFragment;
        dzModle= new DZModle();
    }

    @Override
    public void onSuccess(List<GetCrossDZ.DataBean> dataBeans) {

        if (idzFragment!=null){
            idzFragment.onSuccess(dataBeans);
        }

    }

    @Override
    public void onFailed(String s) {
        if (idzFragment!=null){
            idzFragment.onFailed(s);
        }
    }

    @Override
    public void getMv(String source, String page, String appVersion) {
         dzModle.getDz(source,page,appVersion,this);
    }

    @Override
    public void onDestory() {
        if (idzFragment!=null){
            idzFragment=null;
        }
    }
}
