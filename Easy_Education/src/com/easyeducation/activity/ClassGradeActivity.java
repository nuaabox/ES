package com.easyeducation.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.easyeducation.adapt.ClassGradeAdapt;
import com.easyeducation.bean.classgrade.Classgrade;
import com.easyeducation.bean.classgrade.Classgrades;
import com.easyeducation.util.CommonUtil;
import com.easyeducation.widget.pullrefreshview.PullToRefreshListView;
import com.hwd.cw.test.R;

/**
 * 班级成绩
 * 
 * @author Administrator
 */
public class ClassGradeActivity extends Activity implements OnClickListener {

	private PullToRefreshListView ptrlv;
	private ArrayList<Classgrade> dataList;
	private ClassGradeAdapt adapt;
	private ImageView titleIvBack;
	private TextView titleTvBackName;
	private TextView titleTvkName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_class_grade);
		initView();
	}

	private void initView() {
		titleIvBack = (ImageView) findViewById(R.id.common_title_back_iv);
		titleTvBackName = (TextView) findViewById(R.id.common_title_back_tv);
		titleTvkName = (TextView) findViewById(R.id.common_title_name_tv);
		titleIvBack.setBackgroundResource(R.drawable.ic_title_back);
		titleTvBackName.setText("班级学习");
		titleTvkName.setText("班级成绩");
		titleIvBack.setOnClickListener(this);
		ptrlv = (PullToRefreshListView) findViewById(R.id.class_grade_lv);
		ptrlv.setPullLoadEnabled(false);
		ptrlv.setScrollLoadEnabled(false);
		ptrlv.setPullRefreshEnabled(false);
		ptrlv.setLastUpdatedLabel(CommonUtil.getStringDate());
		// ptrlv.getRefreshableView().setOnItemClickListener(onItemClickListener);
		// ptrlv.setOnRefreshListener(onRefreshListener);
		dataList = Classgrades.classGrades();
		adapt = new ClassGradeAdapt(ClassGradeActivity.this, dataList);
		ptrlv.getRefreshableView().setAdapter(adapt);

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
