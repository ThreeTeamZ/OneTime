package view.zhengxiaolong.bw.com.gittext.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import view.zhengxiaolong.bw.com.gittext.R;
import view.zhengxiaolong.bw.com.gittext.bean.GetMVInfo;

/**
 * Created by lenovo on 2018/4/26.
 */

public class MyMVOneAdapter extends RecyclerView.Adapter<MyMVOneAdapter.MyViewHolder>{
    private List<GetMVInfo.DataBean> dataBeans;
    private Context context;

    public MyMVOneAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<GetMVInfo.DataBean> dataBeans){
        this.dataBeans = dataBeans;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mv_one_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.myMyPlayer.setUp(dataBeans.get(position).getVideoUrl(),dataBeans.get(position).getWorkDesc());

    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final JCVideoPlayer myMyPlayer;

        public MyViewHolder(View itemView) {
            super(itemView);
            myMyPlayer = itemView.findViewById(R.id.myMvPlayer);
        }
    }
}
