package com.easyeducation.activity;

import java.io.IOException;
import java.util.ArrayList;
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

import com.hwd.cw.test.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class news_activity  extends Activity{
	
	private ViewPager article_viewpage;
	private TextView title;
	private TextView date;
	private TextView author;
	private TextView content;
	private String id="";
	private ProgressDialog progressBar;
	
	protected void onCreate(Bundle savedInstanceState) {	
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.article_detail_xml);
		Intent intent=this.getIntent();
		if(intent !=null)
		{
			id=intent.getStringExtra("id");
			
		}
		article_viewpage=(ViewPager) this.findViewById(R.id.article_detail_viewpage);
		title=(TextView) this.findViewById(R.id.article_title);
		date=(TextView) this.findViewById(R.id.article_date);
		author=(TextView) this.findViewById(R.id.article_author);
		content=(TextView) this.findViewById(R.id.article_text);
		
	}
	protected void onResume()
	{
		super.onResume();
		getdetailTask mytask=new getdetailTask();
		mytask.executeOnExecutor(Executors.newCachedThreadPool());
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 public class getdetailTask extends AsyncTask<Object,Integer,String>
	 {
		
		     int type; //0 st 1pt 2tc
		  	 String studyid;
			 String idcard;
			 String phone;
			 String passcode;

	
		@Override
		protected String doInBackground(Object... map) {
			// TODO 锟皆讹拷锟斤拷锟缴的凤拷锟斤拷锟斤拷锟�
			String url="http://easyeducation.sinaapp.com/action.php";
			HttpPost httpPost=new HttpPost(url);
			List<NameValuePair>param=new ArrayList<NameValuePair>();
			
			param.add(new BasicNameValuePair("action","getarticle"));
			param.add(new BasicNameValuePair("id", id));
			HttpResponse httpResponse=null;
			String result=new String("");
		    try { 
	           
	            httpPost.setEntity(new UrlEncodedFormEntity(param, HTTP.UTF_8)); 
	            httpResponse = new DefaultHttpClient().execute(httpPost); 
	           
	            if (httpResponse.getStatusLine().getStatusCode() == 200) { 
	                
	                 result= EntityUtils.toString(httpResponse.getEntity()); 
	                System.out.println("get article result:" + result);             
	            } 
	        } catch (ClientProtocolException e) { 
	            e.printStackTrace(); 
	        } catch (IOException e) { 
	            e.printStackTrace(); 
	        } 							
			return result;
		} 
		 @SuppressLint("ShowToast")
		@Override  
	        protected void onPostExecute(String result) {  
			
			 try {
				JSONObject data = new JSONObject(result);		
				
				progressBar.dismiss();
				
			} catch (JSONException e) {
				
				e.printStackTrace();
			}  
		 }
		 @Override  
		    protected void onPreExecute() {  
				progressBar = new ProgressDialog(news_activity.this);

				progressBar.setCancelable(true);

				progressBar.setMessage("加载中 ...");

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
			

}
