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

import com.easyeducation.MainActivity;
import com.easyeducation.util.ImageChange;
import com.easyeducation.view.CircleImageView;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class edit_userinfo_activity extends Activity{
	
	private ProgressDialog progressBar;
	CircleImageView headimg;
	private TextView edit_ok;
	private EditText username;
	private EditText studynum;
	private EditText qianmin;
	private EditText jieshao;
	String newnickname,newstudynum,newqianmin,newjieshao;
	String imgstr;
	  Bitmap cameraBitmap;
	  changeTask mytask;
	 private ImageView back;
	 private SharedPreferences static_userinfo;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.edit_userinfo_xml);
		username=(EditText) this.findViewById(R.id.newnickname);
		studynum=(EditText)this.findViewById(R.id.newschoolnumber);
		qianmin=(EditText)this.findViewById(R.id.newqianmin);
		jieshao=(EditText)this.findViewById(R.id.newintroduce);
		back=(ImageView) this.findViewById(R.id.edit_back_main);
		static_userinfo=getSharedPreferences("userinfo", Activity.MODE_PRIVATE);
		headimg=(CircleImageView) this.findViewById(R.id.edit_userhead);
		  
		edit_ok=(TextView)this.findViewById(R.id.edit_ok);
		back.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				finish();
				
			}});
		edit_ok.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				newnickname=username.getText().toString();
				newstudynum=studynum.getText().toString();
				newqianmin=qianmin.getText().toString();
				newjieshao=jieshao.getText().toString();
				 headimg.setDrawingCacheEnabled(true);
				imgstr=ImageChange.ImgtoByte(headimg.getDrawingCache());
				mytask=new changeTask();                      
				mytask.executeOnExecutor(Executors.newCachedThreadPool());	
			}
			
		});
		headimg.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
			    intent.addCategory(Intent.CATEGORY_OPENABLE);
			    intent.setType("image/*");
			    intent.putExtra("crop", "true");
			    intent.putExtra("aspectX", 1);
			    intent.putExtra("aspectY", 1);
			    intent.putExtra("outputX", 150);
			    intent.putExtra("outputY", 150);
			    intent.putExtra("scale", "true");
			    intent.putExtra("return-data", true);
			    startActivityForResult(intent, 0);
			    
			    
				
			}
			
		});
	}
	 protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		  if(resultCode!=0)
		  {
		  cameraBitmap = (Bitmap) data.getExtras().get("data");
		  headimg.setImageBitmap(cameraBitmap);
		  }
	 }
	 
	 public class changeTask extends AsyncTask<Object,Integer,String>
	 {
		@Override
		protected String doInBackground(Object... map) {
			// TODO 锟皆讹拷锟斤拷锟缴的凤拷锟斤拷锟斤拷锟�
			String url="http://easyeducation.sinaapp.com/action.php";
			HttpPost httpPost=new HttpPost(url);
			List<NameValuePair>param=new ArrayList<NameValuePair>();
			
			param.add(new BasicNameValuePair("action","changeuserinfo"));
			param.add(new BasicNameValuePair("username",static_userinfo.getString("phone", "")));
			param.add(new BasicNameValuePair("newnickname",newnickname));
			param.add(new BasicNameValuePair("newstudynum",newstudynum));
			param.add(new BasicNameValuePair("newqianmin",newqianmin));
			param.add(new BasicNameValuePair("newjieshao",newjieshao));
			param.add(new BasicNameValuePair("newheadimg",imgstr));

			HttpResponse httpResponse=null;
			String result=new String("");
		    try { 
	           
	            httpPost.setEntity(new UrlEncodedFormEntity(param, HTTP.UTF_8)); 
	            httpResponse = new DefaultHttpClient().execute(httpPost); 
	           
	            if (httpResponse.getStatusLine().getStatusCode() == 200) { 
	                
	                 result= EntityUtils.toString(httpResponse.getEntity()); 
	                System.out.println("changeuserinfo result:" + result);             
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
			
			
				
			
				progressBar.dismiss();
				Toast.makeText(edit_userinfo_activity.this, "修改成功", 500).show();
				
			} 
		 @Override  
		    protected void onPreExecute() {  
				progressBar = new ProgressDialog(edit_userinfo_activity.this);

				progressBar.setCancelable(true);

				progressBar.setMessage("修改中 ...");

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
