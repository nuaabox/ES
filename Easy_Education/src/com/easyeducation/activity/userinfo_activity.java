package com.easyeducation.activity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

import com.easyeducation.util.ImageChange;
import com.google.gson.JsonObject;
import com.hwd.cw.test.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class userinfo_activity  extends Activity{
	
	
	private TextView edit;
	private ProgressDialog progressBar;
	 private SharedPreferences static_userinfo;
	 private ImageView headimage;
	 private TextView nickname,studyid,school,sign,description,myarticle;
	 
	protected void onCreate(Bundle savedInstanceState) {	
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.userinfo_xml);
		static_userinfo=getSharedPreferences("userinfo", Activity.MODE_PRIVATE);
		edit=(TextView) this.findViewById(R.id.edit_userinfo);
		headimage=(ImageView) this.findViewById(R.id.userspage_userhead);
		nickname=(TextView) this.findViewById(R.id.userspage_username);
		studyid=(TextView)this.findViewById(R.id.userspage_usernumb);
		school=(TextView)this.findViewById(R.id.userspage_school);
		sign=(TextView)this.findViewById(R.id.userinfo_sentence);
		description=(TextView)this.findViewById(R.id.userinfo_introduction);
		
		myarticle=(TextView)this.findViewById(R.id.userinfo_myarticle);
		myarticle.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent intent=new Intent();
				intent.setClass(userinfo_activity.this, Myarticle_activity.class);
				startActivity(intent);
			}
			
		});
		edit.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				Intent intent=new Intent();
				intent.setClass(userinfo_activity.this, edit_userinfo_activity.class);
				startActivity(intent);
				
			}});
	}
	@Override
	protected void onResume()
	{
		super.onResume();
		getinfoTask mytask=new getinfoTask();
		mytask.executeOnExecutor(Executors.newCachedThreadPool());	
	}

	public class getinfoTask extends AsyncTask<Object,Integer,String>
	 {
		@Override
		protected String doInBackground(Object... map) {
			// TODO 锟皆讹拷锟斤拷锟缴的凤拷锟斤拷锟斤拷锟�
			String url="http://easyeducation.sinaapp.com/action.php";
			HttpPost httpPost=new HttpPost(url);
			List<NameValuePair>param=new ArrayList<NameValuePair>();
			
			param.add(new BasicNameValuePair("action","getuserinfo"));
			param.add(new BasicNameValuePair("username",static_userinfo.getString("phone", "")));
			
			HttpResponse httpResponse=null;
			String result=new String("");
		    try { 
	           
	            httpPost.setEntity(new UrlEncodedFormEntity(param, HTTP.UTF_8)); 
	            httpResponse = new DefaultHttpClient().execute(httpPost); 
	           
	            if (httpResponse.getStatusLine().getStatusCode() == 200) { 
	                
	                 result= EntityUtils.toString(httpResponse.getEntity()); 
	                System.out.println("getuserinfo result:" + result);             
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
				JSONObject data=new JSONObject(result);
				String nickname_s=data.getString("nickname");
				String studyid_s=data.getString("studyid");
				String sign_s=data.getString("sign");
				String description_s=data.getString("description");
				String school_s=data.getString("school");
				Bitmap bitmap=ImageChange.BytetoImg(data.getString("headsrc"));
						
				headimage.setImageBitmap(bitmap);
				nickname.setText(nickname_s);
				studyid.setText(studyid_s);
				school.setText(school_s);
				sign.setText(sign_s);
				description.setText(description_s);
						
				
				
				
				
			} catch (JSONException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			
				
			
				progressBar.dismiss();
				
			} 
		 @Override  
		    protected void onPreExecute() {  
				progressBar = new ProgressDialog(userinfo_activity.this);

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

	 
	
	
	
	
	
}


