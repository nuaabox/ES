package com.easyeducation.home;

import java.util.ArrayList;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.easyeducation.MainActivity;
import com.easyeducation.adapt.CheckHomeWorkAdapt;
import com.easyeducation.base.BasePage;
import com.easyeducation.fragment.MyClassFragment;
import com.easyeducation.fragment.MySchoolFragment;
import com.easyeducation.widget.pagerindicator.TabPageIndicator;
import com.hwd.cw.test.R;

public class Second_page extends BasePage {

	private ArrayList<Fragment> fragments;
	private ArrayList<String> titles;
	private TabPageIndicator tabPageIndicator;
	private ViewPager viewPage;

	public Second_page(Context ct) {
		super(ct);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View initView(LayoutInflater inflater) {
		View view = inflater.inflate(R.layout.activity_school, null);
		tabPageIndicator = (TabPageIndicator) view
				.findViewById(R.id.check_homework_indicator);
		viewPage = (ViewPager) view.findViewById(R.id.check_homework_viewpager);
		initData();
		return view;
	}

	@Override
	public void initData() {
		fragments = new ArrayList<Fragment>();
		titles = new ArrayList<String>();
		fragments.add(MySchoolFragment.newInstance());
		fragments.add(MyClassFragment.newInstance());
		titles.add("我的学校");
		titles.add("我的班级");
		CheckHomeWorkAdapt adapt = new CheckHomeWorkAdapt(
				((MainActivity) ct).getSupportFragmentManager(), fragments,
				titles);
		viewPage.removeAllViews();
		viewPage.setAdapter(adapt);
		tabPageIndicator.setVisibility(View.VISIBLE);
		tabPageIndicator.setViewPager(viewPage);
		tabPageIndicator.setCurrentItem(0);
	}
}
