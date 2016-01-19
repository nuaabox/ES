package com.easyeducation.adapt;

import java.util.List;
import java.util.Map;

import com.easyeducation.activity.colleciton_user_activity.MylistAdspter.Zujian;
import com.hwd.cw.test.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class myplan_listAdapter extends BaseAdapter {  
    
    private List<Map<String, Object>> data;  
    private LayoutInflater layoutInflater;  
    private Context context;  
    public myplan_listAdapter(Context context,List<Map<String, Object>> data){  
        this.context=context;  
        this.data=data;  
        this.layoutInflater=LayoutInflater.from(context);  
    }  
    
    public final class Zujian{  
        public ImageView plan_clock;  
        public TextView  title;
        public TextView  content;
        public TextView time;
        private boolean isopen;
        
    }  
    @Override  
    public int getCount() {  
        return data.size();  
    }  
    /** 
     * ���ĳһλ�õ����� 
     */  
    @Override  
    public Object getItem(int position) {  
        return data.get(position);  
    }  
    /** 
     * ���Ψһ��ʶ 
     */  
    @Override  
    public long getItemId(int position) {  
        return position;  
    }  
  
    @Override  
    public View getView(int position, View convertView, ViewGroup parent) {  
        Zujian zujian=null;  
        if(convertView==null){  
            zujian=new Zujian();  
            //��������ʵ�������  
            convertView=layoutInflater.inflate(R.layout.myplan_list_xml, null);  
            zujian.plan_clock=(ImageView)convertView.findViewById(R.id.myplan_clock);
            zujian.title=(TextView)convertView.findViewById(R.id.myplan_title);
            zujian.content=(TextView)convertView.findViewById(R.id.myplan_content);
            zujian.time=(TextView)convertView.findViewById(R.id.myplan_time);
        
            convertView.setTag(zujian);  
        }else{  
            zujian=(Zujian)convertView.getTag();  
        }  
        //������  	            
        zujian.title.setText((String)data.get(position).get("title"));
        zujian.isopen=(Boolean)data.get(position).get("isopen");
        zujian.time.setText((String)data.get(position).get("time"));
        zujian.content.setText((String)data.get(position).get("content"));
        if(zujian.isopen==true)zujian.plan_clock.setImageResource(R.drawable.icon_clockin);
        else zujian.plan_clock.setImageResource(R.drawable.icon_clockout);
           
      

        return convertView;  
    }  

}  