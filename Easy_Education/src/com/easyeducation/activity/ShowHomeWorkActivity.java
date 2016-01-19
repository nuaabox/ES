package com.easyeducation.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.easyeducation.fragment.ClassAssignmentsFragment;
import com.hwd.cw.test.R;

/**
 * 教师查看作业
 * 
 * @author Administrator
 * 
 */
public class ShowHomeWorkActivity extends FragmentActivity implements
		OnClickListener {

	private Fragment mfragment;
	private ImageView titleIvBack;
	private TextView titleTvBackName;
	private TextView titleTvName;
	private TextView titleTvFunction;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_syllabus_main);

		initTitle();

		FragmentManager manager = getSupportFragmentManager();
		mfragment = manager.findFragmentById(R.id.content_frame);
		if (null == mfragment) {
			mfragment = getFragment(getIntent().getStringExtra("fragment"));
			manager.beginTransaction().add(R.id.content_frame, mfragment)
					.commitAllowingStateLoss();
		}

	}

	private void initTitle() {
		titleIvBack = (ImageView) findViewById(R.id.common_title_back_iv);
		titleTvBackName = (TextView) findViewById(R.id.common_title_back_tv);
		titleTvName = (TextView) findViewById(R.id.common_title_name_tv);
		titleTvFunction = (TextView) findViewById(R.id.common_title_function_tv_function2);
		titleIvBack.setBackgroundResource(R.drawable.ic_title_back);
		titleIvBack.setOnClickListener(this);
		titleTvFunction.setOnClickListener(this);

	}

	private Fragment getFragment(String name) {
		if ("HomeWorkToSee".equals(name)) {
			titleTvBackName.setText("我的班级");
			titleTvName.setText("查看作业");
			titleTvFunction.setText("留作业");
			titleTvFunction.setVisibility(View.VISIBLE);
			return ClassAssignmentsFragment.newInstance(true);
		}
		return ClassAssignmentsFragment.newInstance(true);

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (Activity.RESULT_OK == resultCode) {
			if (1 == requestCode)
				Log.i("----", "语文.equals(course)");
			mfragment.onActivityResult(requestCode, resultCode, data);
		}
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
}
