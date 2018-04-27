package view.zhengxiaolong.bw.com.gittext.base;

/**
 * 封住Presenter基类
 */

public class BasePresenter<V> {
    public V view;

    public void attachView(V view) {
        this.view = view;
    }
}
