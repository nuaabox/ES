package com.easyeducation.activity;

import java.io.FileNotFoundException;
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

import com.easyeducation.activity.edit_userinfo_activity.changeTask;
import com.easyeducation.util.ImageChange;
import com.hwd.cw.test.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Edit_artical_activity  extends Activity{
	
	private EditText title,content;
	private ImageView add,img1,img2,img3;
	private TextView tips;
	private int img_count=0;
	private int current_num;
	private ImageView delete;
	private ImageView back;
	private TextView commit_article;
	String title_str;
	String content_strl;
	String []imgs=new String[3];
	int img_num=0;
	private ProgressDialog progressBar;
	
	SharedPreferences easy_edu_pre; 
	SharedPreferences.Editor editor;
	protected void onCreate(Bundle savedInstanceState) {	
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.edit_article_xml);
		title=(EditText) this.findViewById(R.id.article_title);
		content=(EditText) this.findViewById(R.id.article_content);
		add=(ImageView) this.findViewById(R.id.article_addimg);
		img1=(ImageView)this.findViewById(R.id.article_img_1);
		img2=(ImageView)this.findViewById(R.id.article_img_2);
		img3=(ImageView)this.findViewById(R.id.article_img_3);
		delete=(ImageView)this.findViewById(R.id.delete_img);
		back=(ImageView) this.findViewById(R.id.article_back_main);
		commit_article=(TextView) this.findViewById(R.id.commit_article);
		 easy_edu_pre= getSharedPreferences("easy_edu",
					Activity.MODE_PRIVATE);
		 editor = easy_edu_pre.edit();
		
		
		content.setSingleLine(false);		
		content.setHorizontallyScrolling(false);
		
		img1.setDrawingCacheEnabled(true);
		img2.setDrawingCacheEnabled(true);
		img3.setDrawingCacheEnabled(true);
		back.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				finish();
			}
			
			
		});
		add.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				if(img_count>=3)
				{
					Toast.makeText(Edit_artical_activity.this, "只能添加三张图片哟", 1000).show();
				}
				else
				{		
			    Intent intent = new Intent(Intent.ACTION_PICK);  
			     intent.setType("image/*");//��Ƭ����  
			    startActivityForResult(intent, 0);
				}
			}
			
		});
		delete.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				switch(img_count){
				
				case 0:break;
				case 1:img1.setImageBitmap(null);
						img1.setTag(null);
						img_count--;
						img1.setVisibility(View.GONE);
				 		break;
				 case 2:
					 img2.setImageBitmap(null);
						img2.setTag(null);
						img_count--;
						img2.setVisibility(View.GONE);
			 			break;
				 case 3:
					 	img3.setImageBitmap(null);
						img3.setTag(null);
						img3.setVisibility(View.GONE);
						img_count--;
			 			break;
				}
				System.gc();
			}
			
			
		});
		
		img1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				
				Intent intent=new Intent();
				intent.setClass( Edit_artical_activity.this,bigimg_activity.class);
			    intent.setData((Uri)arg0.getTag());
				startActivity(intent);	
			}
			
		});
		
		
		img2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				current_num=2;
				Intent intent=new Intent();
				intent.setClass( Edit_artical_activity.this,bigimg_activity.class);
				 intent.setData((Uri)arg0.getTag());	
				startActivity(intent);	
				
			}
			
		});
		img3.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
			
				current_num=3;
				Intent intent=new Intent();
				intent.setClass( Edit_artical_activity.this,bigimg_activity.class);
				intent.setData((Uri)arg0.getTag());

				startActivity(intent);	
				
			}
			
		});
		commit_article.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				title_str=title.getText().toString();
				content_strl=content.getText().toString();
				for(int i=0;i<img_count;i++)
				{
					if(i==0)
					{
						img1.setDrawingCacheEnabled(true);
						Bitmap bitmap=img1.getDrawingCache();					
						imgs[0]=ImageChange.ImgtoByte(ImageChange.resiezeBitmap(bitmap));
						
					}
					if(i==1)
					{	
						img2.setDrawingCacheEnabled(true);
						Bitmap bitmap=img2.getDrawingCache();					
						imgs[1]=ImageChange.ImgtoByte(ImageChange.resiezeBitmap(bitmap));
					}
					if(i==2)
					{	
						img3.setDrawingCacheEnabled(true);
						Bitmap bitmap=img3.getDrawingCache();					
						imgs[2]=ImageChange.ImgtoByte(ImageChange.resiezeBitmap(bitmap));
					}
					System.gc();
				}
				commit_articleTask mytask=new commit_articleTask();                      
				mytask.executeOnExecutor(Executors.newCachedThreadPool());	
			}
			
		});
		
		
		
	}
	 protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		  if(resultCode!=0)
		  {
		  Bitmap cameraBitmap = null ;//= (Bitmap) data.getExtras().get("data"); 
		  Uri uri = data.getData();  
		  try {
			cameraBitmap=MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		 img_count++;
		 switch(img_count){
		 case 1:img1.setImageBitmap(cameraBitmap);
		 		img1.setTag(uri);
		 		img1.setVisibility(View.VISIBLE);
		 		break;
		 case 2:img2.setImageBitmap(cameraBitmap);
		 		img2.setTag(uri);
		 		img2.setVisibility(View.VISIBLE);
	 			break;
		 case 3:img3.setImageBitmap(cameraBitmap);
		 		img3.setTag(uri);
		 		img3.setVisibility(View.VISIBLE);
	 			break;
	 	
		 
		 }
	 }  
	 }
	 
	 
	 public class commit_articleTask extends AsyncTask<Object,Integer,String>
	 {
	
		@Override
		protected String doInBackground(Object... map) {
			// TODO 锟皆讹拷锟斤拷锟缴的凤拷锟斤拷锟斤拷锟�
			String url="http://easyeducation.sinaapp.com/action.php";
			HttpPost httpPost=new HttpPost(url);
			List<NameValuePair>param=new ArrayList<NameValuePair>();
			
			
			param.add(new BasicNameValuePair("action","commit_article"));
			param.add(new BasicNameValuePair("username",login_activity.userphone));
			param.add(new BasicNameValuePair("title",title_str));
			param.add(new BasicNameValuePair("content",content_strl));
			param.add(new BasicNameValuePair("img_num",Integer.toString(img_count)));
			param.add(new BasicNameValuePair("img1",imgs[0]));
			param.add(new BasicNameValuePair("img2",imgs[1]));
			param.add(new BasicNameValuePair("img3",imgs[2]));
		    
			for(int i=0;i<3;i++)
			{
				imgs[i]="";
			}
			
			
			HttpResponse httpResponse=null;
			String result=new String("");
		    try { 
	           
	            httpPost.setEntity(new UrlEncodedFormEntity(param, HTTP.UTF_8)); 
	            httpResponse = new DefaultHttpClient().execute(httpPost); 
	           
	            if (httpResponse.getStatusLine().getStatusCode() == 200) { 
	                
	                 result= EntityUtils.toString(httpResponse.getEntity()); 
	                System.out.println("commit artle result:" + result);             
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
				progressBar = new ProgressDialog(Edit_artical_activity.this);

				progressBar.setCancelable(true);

				progressBar.setMessage("发表中 ...");

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
