package com.easyeducation.home;

import java.util.ArrayList;
import java.util.List;

import android.R.drawable;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;


import com.easyeducation.activity.Edit_artical_activity;
import com.easyeducation.activity.MySyllabusActivity;
import com.easyeducation.activity.bigimg_activity;
import com.easyeducation.activity.colleciton_user_activity;
import com.easyeducation.activity.collection_article_activity;
import com.easyeducation.activity.myplan_activity;
import com.easyeducation.activity.userinfo_activity;
import com.easyeducation.base.BasePage;
import com.easyeducation.util.ImageChange;
import com.easyeducation.view.CircleImageView;
import com.easyeducation.view.LazyViewPager;

import com.hwd.cw.test.R;
public class third_page extends BasePage {
	public third_page(Context ct) {
		super(ct);
		initData();
		// TODO 鑷姩鐢熸垚鐨勬瀯閫犲嚱鏁板瓨鏍�?
	}


	private View mylearnView;
	private CircleImageView userhead;
	SharedPreferences easy_edu_pre; 
	SharedPreferences.Editor editor;
	private ImageView personinfo;
	private ImageView mycollection;//我的关注按钮
	private ImageView mycoarticle;//我的收藏按钮
	private TextView push_article;
	private TextView my_classtable;
	private TextView myplan;

	public View initView(LayoutInflater inflater) {
		mylearnView = inflater.inflate(R.layout.thirdpage, null);
		userhead=(CircleImageView) mylearnView.findViewById(R.id.mylearn_headsrc);	
		 easy_edu_pre= ct.getSharedPreferences("easy_edu",
					Activity.MODE_PRIVATE);
		 editor = easy_edu_pre.edit();
		personinfo=(ImageView)mylearnView.findViewById(R.id.mylearn_personinfo);
		mycollection=(ImageView)mylearnView.findViewById(R.id.mylearn_myfocus);
		mycoarticle=(ImageView)mylearnView.findViewById(R.id.mylearn_mycollect);
		push_article=(TextView)mylearnView.findViewById(R.id.mylearn_submit);
		my_classtable=(TextView)mylearnView.findViewById(R.id.mylearn_mytabletext);
		myplan=(TextView)mylearnView.findViewById(R.id.mylearn_myplantext);
		return mylearnView;
	}



	@Override
	public void initData() {
		// TODO 自动生成的方法存�?
		userhead.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
			Intent intent=new Intent();
			BitmapDrawable dr=(BitmapDrawable) userhead.getDrawable();
			Bitmap bp=dr.getBitmap();	
		    String img_str=ImageChange.ImgtoByte(bp);
		    editor.putString("img", img_str);
			editor.commit();
			intent.setClass(ct, bigimg_activity.class);
			ct.startActivity(intent);	
			}

		});
		personinfo.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent intent =new Intent();
				intent.setClass(ct, userinfo_activity.class);
				ct.startActivity(intent);
			}
			
			
		});
		
		mycollection.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				Intent intent=new Intent();
				intent.setClass(ct,colleciton_user_activity.class);
				ct.startActivity(intent);
			}
			
		});
		mycoarticle.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
				Intent intent=new Intent();
				intent.setClass(ct,collection_article_activity.class);
				ct.startActivity(intent);
			}
			
		});
		push_article.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent intent=new Intent();
				intent.setClass(ct, Edit_artical_activity.class);
				ct.startActivity(intent);
			}
			
		});
		my_classtable.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent intent=new Intent();
				intent.setClass(ct, MySyllabusActivity.class);
				ct.startActivity(intent);
			}
			
		});
		myplan.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent intent=new Intent();
				intent.setClass(ct, myplan_activity.class);
				ct.startActivity(intent);
			}
			
		});
		
	}
	

	

}
