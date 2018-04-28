package view.zhengxiaolong.bw.com.gittext.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import view.zhengxiaolong.bw.com.gittext.R;

/**
 *
 */
public class ShowVideoActivity extends AppCompatActivity {
    private GridView gridView;
    private List<Map<String, Object>> items;
    private List<File> videoList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_video);
        gridView= (GridView) findViewById(R.id.gv_show_video);
        videoList = new ArrayList<File>();
        GetFiles();
        final SimpleAdapter adapter = new SimpleAdapter(this,items,R.layout.item_show_video,
                new String[]{"imageItem", "textItem"},new int[]{R.id.image_item, R.id.text_item});
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/VideoRecorderTest/"+FileToStr(videoList)[position]);//调用系统自带的播放器
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(uri, "video/*");
                Log.i("AAA",uri + "=====");
                startActivity(intent);
            }
        });
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                items.remove(position);
                Toast.makeText(ShowVideoActivity.this,"删除成功",Toast.LENGTH_LONG).show();
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }
    /**
     * 把文件列表转换成字符串
     */
    public String[] FileToStr(List<File> f ){
        ArrayList<String> listStr = new ArrayList<String>();
        int i;
        for (i = 0; i < f.size(); i++) {
            String nameString = f.get(i).getName();
            listStr.add(nameString);
        }
        return listStr.toArray(new String[0]);
    }
    /**
     * 获取文件列表
     */
    public void GetFiles(  ){
        int i=0;
        File filePath=new File(Environment.getExternalStorageDirectory().getPath()+"/VideoRecorderTest");
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            if(filePath.listFiles()!=null){
                File[] files = filePath.listFiles();
                for(i=0;i<files.length;i++){
                    if(files[i].getName().toLowerCase().endsWith(".mp4")) {
                        videoList.add(files[i]);
                    }
                }
            }else{
                Toast.makeText(ShowVideoActivity.this,"目前文件夹还没有文件", Toast.LENGTH_SHORT).show();
            }
        }
        items = new ArrayList<Map<String,Object>>();
        for (int j = 0; j <i; j++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.folder);//添加图像资源的ID
            item.put("textItem",FileToStr(videoList)[j]);
            items.add(item);
        }

    }

}
