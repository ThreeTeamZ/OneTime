package view.zhengxiaolong.bw.com.gittext.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import view.zhengxiaolong.bw.com.gittext.R;
import view.zhengxiaolong.bw.com.gittext.bean.GetCrossDZ;

/**
 * Created by Administrator on 2018/4/27.
 */

public class DuanAdapter extends RecyclerView.Adapter<DuanAdapter.MyViewHolder>  {
    private List<GetCrossDZ.DataBean> dataAll;
     private Context context;
    private ArrayList<Integer> heightList;

    public DuanAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<GetCrossDZ.DataBean> dataBeans){
                  this.dataAll= dataBeans;
        heightList = new ArrayList<>();
        for (int i = 0; i < dataBeans.size(); i++) {
            int height = new Random().nextInt(200) + 100;//[100,300)的随机数
            heightList.add(height);
        }
          notifyDataSetChanged();

    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.parag_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String imgUrls = dataAll.get(position).getImgUrls();
        if (imgUrls != null && !"".equals(imgUrls)){
            String[] split = imgUrls.split("\\|");
            Log.i("gggggggggg",split[0].toString());
            //Glide.with(context).load(split[0].toString()).into(holder.parag_img_left);
            Glide.with(context)
                    .load(split[0].toString())
                    .bitmapTransform(new RoundedCornersTransformation(context, 100, 5))
                    .into(holder.parag_img_left);
        }
        String createTime = dataAll.get(position).getCreateTime();
        String icon = dataAll.get(position).getUser().getIcon();
        //String content = dataAll.get(position).getContent();


         Glide.with(context)
                .load(icon)
                .bitmapTransform(new RoundedCornersTransformation(context, 100, 5))
                .into(holder.parag_img_right);
        holder.paragTime.setText(createTime);
      //  holder.paragTv.setText(content);

    }

    @Override
    public int getItemCount() {
        return dataAll.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

     private final ImageView parag_img_left;
     private final TextView paragTv_up;
     private final TextView paragTime;
     private final ImageView parag_img_right;
     private final TextView paragTv;

     public MyViewHolder(View itemView) {
         super(itemView);
           parag_img_left = itemView.findViewById(R.id.parag_img_left);
           paragTv_up = itemView.findViewById(R.id.paragTv_up);
           paragTime = itemView.findViewById(R.id.paragTime);
           parag_img_right = itemView.findViewById(R.id.parag_img_right);
           paragTv = itemView.findViewById(R.id.paragTv);

     }
 }


}
