package com.easyeducation.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.easyeducation.home.first_page.MylistAdspter;
import com.easyeducation.home.first_page.MylistAdspter.Zujian;
import com.hwd.cw.test.R;

public class colleciton_user_activity extends Activity{
	private ListView co_user_list; 
	private List<Map<String, Object>> datalist=new ArrayList<Map<String,Object>>();  
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.co_user);
		co_user_list=(ListView) this.findViewById(R.id.co_user_list);
		initlistdata();
	}
	
	
	private void  initlistdata()
	{
		 for(int i=0;i<10;i++)
		 {
			 Map<String, Object> map=new HashMap<String, Object>();  
			 map.put("username", "陆俊鹏");
			 datalist.add(map);		 
		 }
		 MylistAdspter newsAdapter=new MylistAdspter(this,datalist);
		 co_user_list.setAdapter(newsAdapter);
		
		
	}
	
	
	 public class MylistAdspter extends BaseAdapter {  
	        
	        private List<Map<String, Object>> data;  
	        private LayoutInflater layoutInflater;  
	        private Context context;  
	        public MylistAdspter(Context context,List<Map<String, Object>> data){  
	            this.context=context;  
	            this.data=data;  
	            this.layoutInflater=LayoutInflater.from(context);  
	        }  
	        /** 
	         * ������ϣ���Ӧlist.xml�еĿؼ� 
	         * @author Administrator 
	         */  
	        public final class Zujian{  
	            public ImageView headimg;  
	            public TextView  username;  
	            
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
	                convertView=layoutInflater.inflate(R.layout.co_list, null);  
	                zujian.headimg=(ImageView)convertView.findViewById(R.id.co_list_img);
	                zujian.username=(TextView)convertView.findViewById(R.id.co_list_text);
	            
	                convertView.setTag(zujian);  
	            }else{  
	                zujian=(Zujian)convertView.getTag();  
	            }  
	            //������  	            
	            zujian.username.setText((String)data.get(position).get("username"));
	            Bitmap bitmap=(Bitmap)data.get(position).get("headimg");
	            if(bitmap!=null)
	            {
	            zujian.headimg.setImageBitmap((Bitmap)data.get(position).get("headimg"));
	            }
	            else zujian.headimg.setBackgroundResource(R.drawable.lst_usrimg1);	      
	          

	            return convertView;  
	        }  

	    }  
}
