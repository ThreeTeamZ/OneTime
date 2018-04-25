package view.zhengxiaolong.bw.com.gittext.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import view.zhengxiaolong.bw.com.gittext.R;

/**
 * Created by lenovo on 2018/4/25.
 */

public class ParagraphFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.paragraphfragment,container,false);
        return view;
    }
}
