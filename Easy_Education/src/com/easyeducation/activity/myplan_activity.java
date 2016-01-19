package com.easyeducation.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Window;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.easyeducation.activity.collection_article_activity.MylistAdspter;
import com.easyeducation.adapt.myplan_listAdapter;
import com.hwd.cw.test.R;

public class myplan_activity extends Activity {
	

		private ListView myplan_listview;
		private  List<Map<String,Object>> datalist;	
		protected void onCreate(Bundle savedInstanceState) {	
			super.onCreate(savedInstanceState);
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			this.setContentView(R.layout.my_plan);
			myplan_listview=(ListView) this.findViewById(R.id.myplan_list);
			datalist=new ArrayList<Map<String,Object>>();
			initlistdata();

		}
		private void  initlistdata()
		{
			 for(int i=0;i<10;i++)
			 {
				 Map<String, Object> map=new HashMap<String, Object>();  
				 map.put("title", "学习计划");
				 map.put("content", "期末复习计...");
				 String time="2015/12/27     21:2";
				 time+=i;
				 map.put("time",time );
				 if(i%2==0)
				 map.put("isopen", true);
				 else map.put("isopen", false);
				 
				 datalist.add(map);		 
			 }
			 myplan_listAdapter adapter=new myplan_listAdapter(myplan_activity.this, datalist);
			 myplan_listview.setAdapter(adapter);
			 
			
		}
		
		
		
		
		
		

}
