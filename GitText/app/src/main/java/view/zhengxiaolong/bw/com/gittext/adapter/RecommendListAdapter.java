package view.zhengxiaolong.bw.com.gittext.adapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import view.zhengxiaolong.bw.com.gittext.R;
import view.zhengxiaolong.bw.com.gittext.bean.RecommendListSuperClass;

/**
 * 推荐里列表适配器
 */

public class RecommendListAdapter extends RecyclerView.Adapter<RecommendListAdapter.ViewHolder> {
    private Context context;
    private List<RecommendListSuperClass.DataBean> list;
    private ObjectAnimator animator;
    private ObjectAnimator fanimator;
    private ObjectAnimator animator1;
    private ObjectAnimator fanimator1;
    private ObjectAnimator animator2;
    private ObjectAnimator fanimator2;
    private ObjectAnimator animator3;
    private ObjectAnimator fanimator3;

    public RecommendListAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<RecommendListSuperClass.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public RecommendListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recommend_list_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecommendListAdapter.ViewHolder holder, final int position) {
        //得到图片并判断是否为空
        String icon = list.get(position).getUser().getIcon();
        if (icon != null && !"".equals(icon)){
            Glide.with(context)
                    .load(R.drawable.dz6)
                    .bitmapTransform(new RoundedCornersTransformation(context, 100, 5))
                    .into(holder.recommend_list_image);
        }
        //得到名称并判断名称是否为空
        String nickname = list.get(position).getUser().getNickname();
        if (nickname != null && !"".equals(nickname)){
            holder.recommend_list_name.setText(nickname);
        }
        //赋值 设置创建时间
        holder.recommend_list_time.setText(list.get(position).getCreateTime());
        //得到集合判断是否为空
        List<RecommendListSuperClass.DataBean.CommentsBean> comments = list.get(position).getComments();
        if (comments.size() != 0){
            //赋值 设置内容
            holder.recommend_list_content.setText(comments.get(0).getContent());
        }
        //点击展开监听
        holder.recommend_list_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示与隐藏
                holder.recommend_list_add.setVisibility(View.GONE);
                holder.recommend_list_subtract.setVisibility(View.VISIBLE);
                holder.recommend_list_report.setVisibility(View.VISIBLE);
                holder.recommend_list_link.setVisibility(View.VISIBLE);
                holder.recommend_list_shield.setVisibility(View.VISIBLE);

                //-----伸出时的动画
                animator = ObjectAnimator.ofFloat(holder.recommend_list_subtract, "rotation", 0f, 180f);
                animator1 = ObjectAnimator.ofFloat(holder.recommend_list_report, "translationX", 0f,-80f);
                animator2 = ObjectAnimator.ofFloat(holder.recommend_list_link, "translationX", 0f,-160f);
                animator3 = ObjectAnimator.ofFloat(holder.recommend_list_shield, "translationX", 0f,-240f);

                //实现伸出效果
                AnimatorSet animSet = new AnimatorSet();//动画集合
                animSet.play(animator).with(animator1).with(animator2).with(animator3);
                animSet.setDuration(1000);
                animSet.start();
            }
        });
        //点击缩回监听
        holder.recommend_list_subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //----缩回时的动画
                fanimator = ObjectAnimator.ofFloat(holder.recommend_list_subtract, "rotation", 0f, -180f);
                fanimator1 = ObjectAnimator.ofFloat(holder.recommend_list_report, "translationX", -80f,0f);
                fanimator2 = ObjectAnimator.ofFloat(holder.recommend_list_link, "translationX", -160f,0f);
                fanimator3 = ObjectAnimator.ofFloat(holder.recommend_list_shield, "translationX", -240f,0f);

                //实现缩回效果
                AnimatorSet animSet1 = new AnimatorSet();//动画集合
                animSet1.play(fanimator).with(fanimator1).with(fanimator2).with(fanimator3);
                animSet1.setDuration(1000);
                animSet1.start();

                //给缩回动画设置监听
                fanimator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        //显示与隐藏
                        holder.recommend_list_add.setVisibility(View.VISIBLE);
                        holder.recommend_list_subtract.setVisibility(View.GONE);
                        holder.recommend_list_report.setVisibility(View.GONE);
                        holder.recommend_list_link.setVisibility(View.GONE);
                        holder.recommend_list_shield.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });
            }
        });
        //举报监听
        holder.recommend_list_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,position + "举报",Toast.LENGTH_LONG).show();
            }
        });
        //链接监听
        holder.recommend_list_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,position + "链接",Toast.LENGTH_LONG).show();
            }
        });
        //屏蔽监听
        holder.recommend_list_shield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,position + "屏蔽",Toast.LENGTH_LONG).show();
            }
        });

        //设置视频
        holder.recommend_list_videoplayer.setUp(list.get(position).getVideoUrl(),
                list.get(position).getWorkDesc());
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView recommend_list_image,recommend_list_add,recommend_list_subtract,recommend_list_report,recommend_list_link,recommend_list_shield;
        private TextView recommend_list_name,recommend_list_time,recommend_list_content;
        private JCVideoPlayer recommend_list_videoplayer;

        public ViewHolder(View itemView) {
            super(itemView);
            recommend_list_image = itemView.findViewById(R.id.recommend_list_image);
            recommend_list_name = itemView.findViewById(R.id.recommend_list_name);
            recommend_list_time = itemView.findViewById(R.id.recommend_list_time);
            recommend_list_content = itemView.findViewById(R.id.recommend_list_content);
            recommend_list_add = itemView.findViewById(R.id.recommend_list_add);
            recommend_list_subtract = itemView.findViewById(R.id.recommend_list_subtract);
            recommend_list_report = itemView.findViewById(R.id.recommend_list_report);
            recommend_list_link = itemView.findViewById(R.id.recommend_list_link);
            recommend_list_shield = itemView.findViewById(R.id.recommend_list_shield);
            recommend_list_videoplayer = itemView.findViewById(R.id.recommend_list_videoplayer);
        }
    }
}
