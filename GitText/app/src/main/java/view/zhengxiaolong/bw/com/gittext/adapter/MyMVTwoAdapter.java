package view.zhengxiaolong.bw.com.gittext.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import view.zhengxiaolong.bw.com.gittext.R;
import view.zhengxiaolong.bw.com.gittext.bean.GetMVInfo2;

/**
 * Created by lenovo on 2018/4/27.
 */

public class MyMVTwoAdapter extends RecyclerView.Adapter<MyMVTwoAdapter.MyViewHolder>{
    private List<GetMVInfo2.DataBean> dataBeans;
    private Context context;

    public MyMVTwoAdapter(Context context) {
        this.context = context;
    }
    public void setList(List<GetMVInfo2.DataBean> dataBeans){
        this.dataBeans = dataBeans;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mv_two_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Glide.with(context).load(dataBeans.get(position).getUser().getIcon()).into(holder.iv);
        Log.i("AAA",""+dataBeans.get(position).getUser().getIcon());
    }

    @Override
    public int getItemCount() {
        return dataBeans!=null?dataBeans.size():0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.mvImg2);
        }
    }

}
