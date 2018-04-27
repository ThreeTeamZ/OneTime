package view.zhengxiaolong.bw.com.gittext.model;

import view.zhengxiaolong.bw.com.gittext.persenter.IDzPersenter;
import view.zhengxiaolong.bw.com.gittext.persenter.IMvPersenter;

/**
 * Created by Administrator on 2018/4/27.
 */

public interface IDZModel {
    void getDz(String source, String page, String appVersion, IDzPersenter iDzPersenter);

}
