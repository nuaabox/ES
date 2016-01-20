package com.easyeducation.activity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.easyeducation.activity.colleciton_user_activity.MylistAdspter;
import com.easyeducation.activity.colleciton_user_activity.MylistAdspter.Zujian;
import com.hwd.cw.test.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Myarticle_activity  extends Activity{
	
	private ListView article_list;
	private ImageView back;
	 private ProgressDialog progressBar;
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();  
	protected void onCreate(Bundle savedInstanceState) {	
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.myarticle_xml);
		article_list=(ListView) this.findViewById(R.id.myarticle_list);
		                          
		back=(ImageView) this.findViewById(R.id.myarticle_back_userinfo);
		back.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				finish();
			}
		});
		getmyarticleTask mytask=new getmyarticleTask();
		mytask.executeOnExecutor(Executors.newCachedThreadPool());
		article_list.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO 自动生成的方法存根
				TextView title=(TextView) arg1.findViewById(R.id.first_list_newstitle);
				String id=(String)title.getTag();
				System.out.println("article_id="+id);
				Intent intent =new Intent();
				intent.setClass(Myarticle_activity.this, news_activity.class);
				intent.putExtra("id", id);
				startActivity(intent);
			}
			
		});
		
			
		
		


	}
	


public class getmyarticleTask extends AsyncTask<Object,Integer,String>
	 {
		
		
		 
		 
		@Override
		protected String doInBackground(Object... map) {
			// TODO 锟皆讹拷锟斤拷锟缴的凤拷锟斤拷锟斤拷锟
			String url="http://easyeducation.sinaapp.com/action.php";
			HttpPost httpPost=new HttpPost(url);
			List<NameValuePair>param=new ArrayList<NameValuePair>();
			
			param.add(new BasicNameValuePair("action","getuserarticle"));
			param.add(new BasicNameValuePair("username",login_activity.userphone));
			
			
			
			HttpResponse httpResponse=null;
			String result=new String("");
		    try { 
	           
	            httpPost.setEntity(new UrlEncodedFormEntity(param, HTTP.UTF_8)); 
	            httpResponse = new DefaultHttpClient().execute(httpPost); 
	           
	            if (httpResponse.getStatusLine().getStatusCode() == 200) { 
	                
	                 result= EntityUtils.toString(httpResponse.getEntity()); 
	                System.out.println("myarticle_result:" + result);             
	            } 
	        } catch (ClientProtocolException e) { 
	            e.printStackTrace(); 
	        } catch (IOException e) { 
	            e.printStackTrace(); 
	        } 							
			return result;
		} 
		 @SuppressWarnings({ "unchecked", "unchecked" })
		@SuppressLint("ShowToast")
		@Override  
	        protected void onPostExecute(String result) {  
			
			 try {
				JSONObject data = new JSONObject(result);	
			
				progressBar.dismiss();
				
				JSONObject arts=data.getJSONObject("arts");
				int n=arts.getInt("n");
				System.out.println("n="+n);
				for(int i=0;i<n;i++)
				{
					
					JSONObject current=arts.getJSONObject(String.valueOf(i+1));
					
					String title=current.getString("title");
					
			        String time=current.getString("date");
					
					String id=current.getString("id");
				
					Map<String, Object> map=new HashMap<String, Object>();
					map.put("id", id);
					map.put("time",time);
					map.put("title", title);
					list.add(map);
				}
				
				MylistAdspter adapter=new MylistAdspter(Myarticle_activity.this, list);
				article_list.setAdapter(adapter);
			
			
				
			} catch (JSONException e) {
				
				e.printStackTrace();
			}  
		 }
		 @Override  
		    protected void onPreExecute() {  
				progressBar = new ProgressDialog(Myarticle_activity.this);

				progressBar.setCancelable(true);

				progressBar.setMessage("获取中 ...");

				progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);

				progressBar.setProgress(0);

				progressBar.setMax(100);

				progressBar.show(); 
		    }  
		  
		 @Override  
		    protected void onProgressUpdate(Integer... values) {  
		        int vlaue = values[0];  
		        progressBar.setProgress(vlaue);  
		    }  
	 }


public class MylistAdspter extends BaseAdapter {

	private List<Map<String, Object>> data;
	private LayoutInflater layoutInflater;
	private Context context;

	public MylistAdspter(Context context, List<Map<String, Object>> data) {
		this.context = context;
		this.data = data;
		this.layoutInflater = LayoutInflater.from(context);
	}

	/**
	 * 组件集合，对应list.xml中的控件
	 * 
	 * @author Administrator
	 */
	public final class Zujian {
		public ImageView headimg;
		public TextView username;
		public TextView texttitle;
		public TextView nowtime;

	}

	@Override
	public int getCount() {
		return data.size();
	}

	/**
	 * 获得某一位置的数据
	 */
	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	/**
	 * 获得唯一标识
	 */
	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Zujian zujian = null;
		if (convertView == null) {
			zujian = new Zujian();
			// 获得组件，实例化组件
			convertView = layoutInflater.inflate(R.layout.firstpage_list,
					null);
			zujian.headimg = (ImageView) convertView
					.findViewById(R.id.first_list_headimg);
			zujian.username = (TextView) convertView
					.findViewById(R.id.first_list_username);
			zujian.texttitle = (TextView) convertView
					.findViewById(R.id.first_list_newstitle);
			zujian.nowtime = (TextView) convertView
					.findViewById(R.id.first_list_newstime);
			convertView.setTag(zujian);
		} else {
			zujian = (Zujian) convertView.getTag();
		}
		// 绑定数据
		zujian.username
				.setText((String) data.get(data.size()-1-position).get(
						"title"));
		zujian.texttitle.setTag((String) data.get(data.size()-1-position).get("id"));
		zujian.texttitle.setText("");      
		zujian.nowtime.setText((String) data.get(data.size()-1-position).get("time"));
		zujian.headimg.setImageBitmap(userinfo_activity.userheadimg);

		return convertView;
	}

}
}
