package view.zhengxiaolong.bw.com.gittext.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import view.zhengxiaolong.bw.com.gittext.R;
import view.zhengxiaolong.bw.com.gittext.bean.GetMVInfo;

/**
 * Created by lenovo on 2018/4/26.
 */

public class MyMVOneAdapter extends RecyclerView.Adapter<MyMVOneAdapter.MyViewHolder>{
    private List<GetMVInfo.DataBean> dataAll;
    private Context context;
    private List<Integer> heightList;
    private setOnClick onItemClick;
    public MyMVOneAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<GetMVInfo.DataBean> dataBeans){
        this.dataAll = dataBeans;
        //记录为每个控件产生的随机高度,避免滑回到顶部出现空白
        heightList = new ArrayList<>();
        for (int i = 0; i < dataBeans.size(); i++) {
            int height = new Random().nextInt(200) + 100;//[100,300)的随机数
            heightList.add(height);
        }
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mv_one_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        ViewGroup.LayoutParams params = holder.imageView.getLayoutParams();
        params.height=heightList.get(position);
        String cover = dataAll.get(position).getCover();
        String icon = dataAll.get(position).getUser().getIcon();
        if (cover.equals("") || cover==null){
            Glide.with(context).load(icon).into(holder.imageView);
        }else{
            Glide.with(context).load(cover).into(holder.imageView);
        }
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onClick(position);
            }
        });
        /*String icon = dataAll.get(position).getUser().getIcon();
        if (icon != null && !"".equals(icon)){
            Glide.with(context).load(icon).into(holder.imageView);
        }else {
            Glide.with(context).load(R.mipmap.ic_launcher).into(holder.imageView);
        }*/
    }

    @Override
    public int getItemCount() {
        return dataAll != null ? dataAll.size() : 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{


        private ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.mvImg);
        }
    }
    public interface setOnClick{
        void onClick(int position);
    }
    public void setOnItemClick(setOnClick onItemClick){
        this.onItemClick=onItemClick;
    }
}
