package com.easyeducation.activity;

import java.io.FileNotFoundException;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

import com.easyeducation.util.ImageChange;
import com.hwd.cw.test.R;

public class bigimg_activity  extends Activity{

	private ImageView img;
	SharedPreferences easy_edu_pre; 
	protected void onCreate(Bundle savedInstanceState) {	
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		easy_edu_pre= getSharedPreferences("easy_edu",
				Activity.MODE_PRIVATE); 
		this.setContentView(R.layout.bigimg_xml);
		
		img=(ImageView) this.findViewById(R.id.bigimg_img);
		
		Intent intent=getIntent();
		if(intent !=null)
			{
			if(intent.getData()==null)
			{
				String bitmap_str=easy_edu_pre.getString("img", "");		
				Bitmap bp=ImageChange.BytetoImg(bitmap_str);
				img.setImageBitmap(bp);
			}
			else {
				try {
					Bitmap bp=MediaStore.Images.Media.getBitmap(this.getContentResolver(), intent.getData());
					img.setImageBitmap(bp);
				} catch (FileNotFoundException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
				
			}
			}
		img.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
			
				finish();
			}
			
			
			
		});
		
		
	}
}
