package com.easyeducation.activity;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Window;

import com.easyeducation.adapt.CheckHomeWorkAdapt;
import com.easyeducation.fragment.MyClassFragment;
import com.easyeducation.fragment.MySchoolFragment;
import com.easyeducation.widget.pagerindicator.TabPageIndicator;
import com.hwd.cw.test.R;

/**
 * 查看作业
 * 
 * @author Administrator
 */
public class MySchoolActivity extends FragmentActivity {
	private ArrayList<Fragment> fragments = new ArrayList<Fragment>();
	private ArrayList<String> titles = new ArrayList<String>();
	private TabPageIndicator tabPageIndicator;
	private ViewPager viewPage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_school);
		initView();
		initData();
	}

	private void initData() {
		fragments.add(MySchoolFragment.newInstance());
		fragments.add(MyClassFragment.newInstance());
		titles.add("我的学校");
		titles.add("我的班级");
		CheckHomeWorkAdapt adapt = new CheckHomeWorkAdapt(
				getSupportFragmentManager(), fragments, titles);
		viewPage.removeAllViews();
		viewPage.setAdapter(adapt);
		tabPageIndicator.setViewPager(viewPage);
		tabPageIndicator.setCurrentItem(0);
	}

	private void initView() {
		tabPageIndicator = (TabPageIndicator) findViewById(R.id.check_homework_indicator);
		viewPage = (ViewPager) findViewById(R.id.check_homework_viewpager);
	}

}
