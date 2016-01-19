package com.easyeducation.activity;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.easyeducation.adapt.CheckHomeWorkAdapt;
import com.easyeducation.fragment.ClassAssignmentsFragment;
import com.easyeducation.fragment.CopyOfClassAssignmentsFragment;
import com.easyeducation.widget.pagerindicator.TabPageIndicator;
import com.hwd.cw.test.R;

/**
 * 查看作业
 * 
 * @author Administrator
 */
public class HomeworkActivity extends FragmentActivity implements
		OnClickListener {
	private ArrayList<Fragment> fragments = new ArrayList<Fragment>();
	private ArrayList<String> titles = new ArrayList<String>();
	private TabPageIndicator tabPageIndicator;
	private ViewPager viewPage;
	private CheckHomeWorkAdapt adapt;
	private ClassAssignmentsFragment classAssignmentsFragment;
	private ImageView titleIvBack;
	private TextView titleTvBackName;
	private TextView titleTvkName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_check_homework);
		initView();
		initData();
	}

	private void initData() {
		classAssignmentsFragment = ClassAssignmentsFragment.newInstance(true);
		fragments.add(classAssignmentsFragment);
		fragments.add(CopyOfClassAssignmentsFragment.newInstance());
		titles.add("班级作业");
		titles.add("课堂作业");
		adapt = new CheckHomeWorkAdapt(getSupportFragmentManager(), fragments,
				titles);
		viewPage.removeAllViews();
		viewPage.setAdapter(adapt);
		tabPageIndicator.setViewPager(viewPage);
		tabPageIndicator.setCurrentItem(0);
	}

	private void initView() {
		tabPageIndicator = (TabPageIndicator) findViewById(R.id.check_homework_indicator);
		viewPage = (ViewPager) findViewById(R.id.check_homework_viewpager);
		titleIvBack = (ImageView) findViewById(R.id.common_title_back_iv);
		titleTvBackName = (TextView) findViewById(R.id.common_title_back_tv);
		titleTvkName = (TextView) findViewById(R.id.common_title_name_tv);
		titleIvBack.setBackgroundResource(R.drawable.ic_title_back);
		titleTvBackName.setText("我的班级");
		titleTvkName.setText("查看作业");
		titleIvBack.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.common_title_back_iv:
			finish();
			break;

		default:
			break;
		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (RESULT_OK == resultCode) {
			if (1 == requestCode) {
				if (null != data) {
					if ("classAssignment".equals(data
							.getStringExtra("fragmentName")))
						classAssignmentsFragment.onActivityResult(requestCode,
								resultCode, data);
				}
			}
		}
	}

}
