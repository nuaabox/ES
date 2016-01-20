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

import com.easyeducation.util.ImageChange;
import com.hwd.cw.test.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class news_activity  extends Activity{
	
	private ViewPager advPager;
	private TextView title;
	private TextView date;
	private TextView author;
	private TextView content;
	private String id="";
	private ProgressDialog progressBar;
	private String title_str,date_str,author_str,content_str;
	private Bitmap[] images;
	private int imgnum;
	private ImageView back;
	private ImageView collect_btn;
	private int collect_num;
	private TextView number;
	ViewGroup group ;
	protected void onCreate(Bundle savedInstanceState) {	
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.article_detail_xml);
		Intent intent=this.getIntent();
		images=new Bitmap[3];
		if(intent !=null)
		{
			id=intent.getStringExtra("id");
			
		}
	
		title=(TextView) this.findViewById(R.id.article_title);
		back=(ImageView)this.findViewById(R.id.article_back);
		date=(TextView) this.findViewById(R.id.article_date);
		author=(TextView) this.findViewById(R.id.article_author);
		content=(TextView) this.findViewById(R.id.article_text);
		advPager=(ViewPager) this.findViewById(R.id.article_detail_pager);
		collect_btn=(ImageView)this.findViewById(R.id.collect_article);
		number=(TextView)this.findViewById(R.id.collect_num);
		collect_btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				collectTask mytask=new collectTask();
				mytask.executeOnExecutor(Executors.newCachedThreadPool());
				
				
			}
			
			
		});
		back.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
			finish();	
			}
			
		});
		
	}
	protected void onResume()
	{
		super.onResume();
		getdetailTask mytask=new getdetailTask();
		mytask.executeOnExecutor(Executors.newCachedThreadPool());
	}


	
	 public class getdetailTask extends AsyncTask<Object,Integer,String>
	 {
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
				title_str=data.getString("title");
				date_str=data.getString("date");
				author_str=data.getString("nickname");
				content_str=data.getString("content");
				imgnum=Integer.parseInt(data.getString("picnum"));
				images[0]=ImageChange.BytetoImg(data.getString("pic1"));
				images[1]=ImageChange.BytetoImg(data.getString("pic2"));
				images[2]=ImageChange.BytetoImg(data.getString("pic3"));
				collect_num=Integer.parseInt( data.getString("stored"));;
				
				title.setText(title_str);
				date.setText(date_str);
				author.setText(author_str);
				content.setText("  "+content_str);
				List<View> advPics = new ArrayList<View>();
				for(int i=0;i<imgnum;i++)
				{
					ImageView img1 = new ImageView(news_activity.this);
					img1.setImageBitmap(images[i]);
					advPics.add(img1);
				}
				if(imgnum==0)
				{
					ImageView img1 = new ImageView(news_activity.this);
					img1.setImageResource(R.drawable.bigimg1);
					advPics.add(img1);					
				}
				AdvAdapter advpter = new AdvAdapter(advPics);
				advPager.setAdapter(advpter);
				
				
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
	 private final class AdvAdapter extends PagerAdapter {
			private List<View> views = null;

			public AdvAdapter(List<View> views) {
				this.views = views;
			}

			public void destroyItem(View arg0, int arg1, Object arg2) {
				((ViewPager) arg0).removeView(views.get(arg1 % 5));
			}

			public void finishUpdate(View arg0) {

			}

			public int getCount() {
				return views.size();
			}

			@Override
			public Object instantiateItem(View arg0, int arg1) {

				View view1 = views.get(arg1);
				((ViewPager) arg0).addView(view1, 0);
				final int positon = arg1;
				view1.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO 自动生成的方法存根
					}
				});
				return view1;

			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}

			@Override
			public void restoreState(Parcelable arg0, ClassLoader arg1) {

			}

			@Override
			public Parcelable saveState() {
				return null;
			}

			@Override
			public void startUpdate(View arg0) {

			}
		}
	 public class collectTask extends AsyncTask<Object,Integer,String>
	 {
		@Override
		protected String doInBackground(Object... map) {
			// TODO 锟皆讹拷锟斤拷锟缴的凤拷锟斤拷锟斤拷锟�
			String url="http://easyeducation.sinaapp.com/action.php";
			HttpPost httpPost=new HttpPost(url);
			List<NameValuePair>param=new ArrayList<NameValuePair>();
			
			param.add(new BasicNameValuePair("action","collect_article"));
			param.add(new BasicNameValuePair("user_id", login_activity.userphone));
			param.add(new BasicNameValuePair("article_id", id));
			HttpResponse httpResponse=null;
			String result=new String("");
		    try { 
	           
	            httpPost.setEntity(new UrlEncodedFormEntity(param, HTTP.UTF_8)); 
	            httpResponse = new DefaultHttpClient().execute(httpPost); 
	           
	            if (httpResponse.getStatusLine().getStatusCode() == 200) { 
	                
	                 result= EntityUtils.toString(httpResponse.getEntity()); 
	                System.out.println("collect result:" + result);             
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
				if(data.get("code")=="1")
				{
					String num=number.getText().toString();
					int count=Integer.parseInt(num)+1;
					number.setText(count);
				}
				
			
			} catch (JSONException e) {
				
				e.printStackTrace();
			}  
		 }
		 @Override  
		    protected void onPreExecute() {  
		 }
		 
		 
		 
		 }
				
		  
		
	 

}
