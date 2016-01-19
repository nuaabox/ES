package com.easyeducation.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.easyeducation.bean.mysyllabus.BaseSyllabus;
import com.easyeducation.bean.mysyllabus.Syllabus;
import com.easyeducation.manager.DataManager;
import com.easyeducation.manager.SharedPreferenceManager;
import com.hwd.cw.test.R;

/**
 * 我的课程表
 * 
 * @author Administrator
 */
public class MySyllabusActivity extends Activity implements OnClickListener {

	private LayoutParams params;
	private LinearLayout syllabusLlTitle;
	private TextView tvWightGet;
	private LinearLayout syllabusLlOne;
	private LinearLayout syllabusLlTwo;
	private LinearLayout syllabusLlThree;
	private LinearLayout syllabusLlFour;
	private LinearLayout syllabusLlfive;
	private LinearLayout syllabusLlSix;
	private LinearLayout syllabusLlSeven;
	private LinearLayout syllabusLlEight;
	private LinearLayout syllabusLlNine;
	private LinearLayout syllabusLlTen;
	private LinearLayout courseLlOne;
	private LinearLayout courseLlTwo;
	private LinearLayout courseLlThree;
	private LinearLayout courseLlFour;
	private LinearLayout courseLlfive;
	private LinearLayout courseLlSix;
	private LinearLayout courseLlSeven;
	private LinearLayout courseLlEight;
	private LinearLayout courseLlNine;
	private LinearLayout courseLlTen;
	private ImageView titleIvBack;
	private TextView titleTvBackName;
	private TextView titleTvkName;
	private ImageView titleIvFunction;
	private int[] unitsBg;
	private View currentClickTv;
	private Syllabus mSyllabus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_syllabus);
		initCourseViewBgData();
		initView();
	}

	private void initCourseViewBgData() {
		unitsBg = new int[] { R.drawable.bg_syllabus_aa89bd,
				R.drawable.bg_syllabus_f19ec2, R.drawable.bg_syllabus_7ecef5,
				R.drawable.bg_syllabus_f39c9f, R.drawable.bg_syllabus_89c997,
				R.drawable.bg_syllabus_ec6941, R.drawable.bg_syllabus_f39b76,
				R.drawable.bg_syllabus_f6b37f, R.drawable.bg_syllabus_88abda,
				R.drawable.bg_syllabus_8f82bc };
	}

	private void initView() {
		titleIvFunction = (ImageView) findViewById(R.id.common_title_function_iv_function1);
		titleIvBack = (ImageView) findViewById(R.id.common_title_back_iv);
		titleTvBackName = (TextView) findViewById(R.id.common_title_back_tv);
		titleTvkName = (TextView) findViewById(R.id.common_title_name_tv);
		titleIvBack.setBackgroundResource(R.drawable.icon_back);
		titleIvFunction.setVisibility(View.VISIBLE);
		titleIvFunction.setBackgroundResource(R.drawable.ic_channe_forward);
		// TODO 进行数据更新
		titleIvFunction.setOnClickListener(this);
		titleTvBackName.setText("我的学习");
		titleTvkName.setText("我的课程表");

		syllabusLlTitle = (LinearLayout) findViewById(R.id.syllabus_ll_title);
		syllabusLlOne = (LinearLayout) findViewById(R.id.syllabus_ll_one);
		syllabusLlTwo = (LinearLayout) findViewById(R.id.syllabus_ll_two);
		syllabusLlThree = (LinearLayout) findViewById(R.id.syllabus_ll_three);
		syllabusLlFour = (LinearLayout) findViewById(R.id.syllabus_ll_four);
		syllabusLlfive = (LinearLayout) findViewById(R.id.syllabus_ll_five);
		syllabusLlSix = (LinearLayout) findViewById(R.id.syllabus_ll_six);
		syllabusLlSeven = (LinearLayout) findViewById(R.id.syllabus_ll_seven);
		syllabusLlEight = (LinearLayout) findViewById(R.id.syllabus_ll_eight);
		syllabusLlNine = (LinearLayout) findViewById(R.id.syllabus_ll_nine);
		syllabusLlTen = (LinearLayout) findViewById(R.id.syllabus_ll_ten);
		tvWightGet = (TextView) findViewById(R.id.syllabus_title_tv_wight_get);
		courseLlOne = (LinearLayout) findViewById(R.id.syllabus_course_ll_one);
		courseLlTwo = (LinearLayout) findViewById(R.id.syllabus_course_ll_two);
		courseLlThree = (LinearLayout) findViewById(R.id.syllabus_course_ll_three);
		courseLlFour = (LinearLayout) findViewById(R.id.syllabus_course_ll_four);
		courseLlfive = (LinearLayout) findViewById(R.id.syllabus_course_ll_five);
		courseLlSix = (LinearLayout) findViewById(R.id.syllabus_course_ll_six);
		courseLlSeven = (LinearLayout) findViewById(R.id.syllabus_course_ll_seven);
		courseLlEight = (LinearLayout) findViewById(R.id.syllabus_course_ll_eight);
		courseLlNine = (LinearLayout) findViewById(R.id.syllabus_course_ll_nine);
		courseLlTen = (LinearLayout) findViewById(R.id.syllabus_course_ll_ten);
		initDB();
		initDBData();
	}

	private void initCourseData() {
		tvWightGet.post(new Runnable() {
			@Override
			public void run() {
				params = syllabusLlTitle.getLayoutParams();
				params.height = tvWightGet.getWidth();
				syllabusLlTitle.setLayoutParams(params);
				syllabusLlOne.setLayoutParams(params);
				syllabusLlTwo.setLayoutParams(params);
				syllabusLlThree.setLayoutParams(params);
				syllabusLlFour.setLayoutParams(params);
				syllabusLlfive.setLayoutParams(params);
				syllabusLlSix.setLayoutParams(params);
				syllabusLlSeven.setLayoutParams(params);
				syllabusLlEight.setLayoutParams(params);
				syllabusLlNine.setLayoutParams(params);
				syllabusLlTen.setLayoutParams(params);
				initViewData();
			}

		});
	}

	private void initViewData() {
		courseLlOne.removeAllViews();
		courseLlTwo.removeAllViews();
		courseLlThree.removeAllViews();
		courseLlFour.removeAllViews();
		courseLlfive.removeAllViews();
		courseLlSix.removeAllViews();
		courseLlSeven.removeAllViews();
		courseLlEight.removeAllViews();
		courseLlNine.removeAllViews();
		courseLlTen.removeAllViews();
		for (int i = 0; i < 10; i++) {
			switch (i) {
			case 0:
				setData(i, courseLlOne);
				break;
			case 1:
				setData(i, courseLlTwo);
				break;
			case 2:
				setData(i, courseLlThree);
				break;
			case 3:
				setData(i, courseLlFour);
				break;
			case 4:
				setData(i, courseLlfive);
				break;
			case 5:
				setData(i, courseLlSix);
				break;
			case 6:
				setData(i, courseLlSeven);
				break;
			case 7:
				setData(i, courseLlEight);
				break;
			case 8:
				setData(i, courseLlNine);
				break;
			case 9:
				setData(i, courseLlTen);
				break;
			}
		}
	}

	// monday tuesday wednesday thursday friday saturday sunday
	private void initDBData() {
		mSyllabus = new Syllabus();
		mSyllabus.monday = DataManager.getInstance().selectSyllabusTable(
				new String[] { "monday" });
		mSyllabus.tuesday = DataManager.getInstance().selectSyllabusTable(
				new String[] { "tuesday" });
		mSyllabus.wednesday = DataManager.getInstance().selectSyllabusTable(
				new String[] { "wednesday" });
		mSyllabus.thursday = DataManager.getInstance().selectSyllabusTable(
				new String[] { "thursday" });
		mSyllabus.friday = DataManager.getInstance().selectSyllabusTable(
				new String[] { "friday" });
		mSyllabus.saturday = DataManager.getInstance().selectSyllabusTable(
				new String[] { "saturday" });
		mSyllabus.sunday = DataManager.getInstance().selectSyllabusTable(
				new String[] { "sunday" });
		initCourseData();
	}

	private void initDB() {
		if (SharedPreferenceManager.getInstance().getBoolean("isNeedToInitDB",
				true)) {
			// 进行数据库数据初始化
			for (int i = 0; i < 10; i++) {
				BaseSyllabus syllabus = new BaseSyllabus();
				syllabus.Tag = "monday";
				syllabus.courseId = syllabus.Tag + String.valueOf(i);
				DataManager.getInstance().insertInToSyllabusTable(syllabus);
				syllabus = new BaseSyllabus();
				syllabus.Tag = "tuesday";
				syllabus.courseId = syllabus.Tag + String.valueOf(i);
				DataManager.getInstance().insertInToSyllabusTable(syllabus);
				syllabus = new BaseSyllabus();
				syllabus.Tag = "wednesday";
				syllabus.courseId = syllabus.Tag + String.valueOf(i);
				DataManager.getInstance().insertInToSyllabusTable(syllabus);
				syllabus = new BaseSyllabus();
				syllabus.Tag = "thursday";
				syllabus.courseId = syllabus.Tag + String.valueOf(i);
				DataManager.getInstance().insertInToSyllabusTable(syllabus);
				syllabus = new BaseSyllabus();
				syllabus.Tag = "friday";
				syllabus.courseId = syllabus.Tag + String.valueOf(i);
				DataManager.getInstance().insertInToSyllabusTable(syllabus);
				syllabus = new BaseSyllabus();
				syllabus.Tag = "saturday";
				syllabus.courseId = syllabus.Tag + String.valueOf(i);
				DataManager.getInstance().insertInToSyllabusTable(syllabus);
				syllabus = new BaseSyllabus();
				syllabus.Tag = "sunday";
				syllabus.courseId = syllabus.Tag + String.valueOf(i);
				DataManager.getInstance().insertInToSyllabusTable(syllabus);
			}
			SharedPreferenceManager.getInstance().putBoolean("isNeedToInitDB",
					false);
		}
	}

	private void setData(int i, LinearLayout ll) {
		addTextView(mSyllabus.monday.get(i).courseName,
				mSyllabus.monday.get(i), ll);
		addTextView(mSyllabus.tuesday.get(i).courseName,
				mSyllabus.tuesday.get(i), ll);
		addTextView(mSyllabus.wednesday.get(i).courseName,
				mSyllabus.wednesday.get(i), ll);
		addTextView(mSyllabus.thursday.get(i).courseName,
				mSyllabus.thursday.get(i), ll);
		addTextView(mSyllabus.friday.get(i).courseName,
				mSyllabus.friday.get(i), ll);
		addTextView(mSyllabus.saturday.get(i).courseName,
				mSyllabus.saturday.get(i), ll);
		addTextView(mSyllabus.sunday.get(i).courseName,
				mSyllabus.sunday.get(i), ll);
	}

	private void addTextView(String name, BaseSyllabus obj, LinearLayout ll) {
		TextView textView = new TextView(MySyllabusActivity.this);
		LayoutParams params = new LayoutParams(tvWightGet.getWidth(),
				tvWightGet.getHeight());
		textView.setLayoutParams(params);
		if (TextUtils.isEmpty(name)) {
			textView.setBackgroundResource(R.drawable.bg_syllabus_ffffff);
			textView.setText("");
		} else {
			textView.setBackgroundResource(unitsBg[(int) (Math.random() * 10)]);
			textView.setText(name);
		}
		textView.setSingleLine();
		textView.setEllipsize(TruncateAt.END);
		textView.setGravity(Gravity.CENTER);
		textView.setId(R.id.syllabus_tv);
		textView.setTag(obj);
		textView.setOnClickListener(this);
		ll.addView(textView);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.syllabus_tv:
			BaseSyllabus syllabus = (BaseSyllabus) v.getTag();
			// 判断用户是否点击过
			if (null != currentClickTv) {
				currentClickTv
						.setBackgroundResource(R.drawable.bg_syllabus_ffffff);
				// 判断改次点击的是否是之前点击的
				if (!"true".equals(syllabus.isAdding)
						|| !TextUtils.isEmpty(syllabus.courseName)) {
					BaseSyllabus baseSyllabus = (BaseSyllabus) currentClickTv
							.getTag();
					baseSyllabus.isAdding = "";
					currentClickTv.setTag(baseSyllabus);
				}
			}
			currentClickTv = v;
			if (null == syllabus || TextUtils.isEmpty(syllabus.courseName)) {
				if (null == syllabus || TextUtils.isEmpty(syllabus.isAdding)
						|| !"true".equals(syllabus.isAdding)) {
					((TextView) v)
							.setBackgroundResource(R.drawable.ic_syllabus_add);
					syllabus.isAdding = "true";
					v.setTag(syllabus);
				} else {
					showDialog(v, null, "add");
				}
			} else {
				showDialog(v, syllabus, "change");
			}
			break;

		case R.id.common_title_function_iv_function1:
			// TODO 发送请求,进行数据更新
			// Syllabus updataSyllabus = new Syllabus();
			// updataDBCourse(updataSyllabus.monday, "monday");
			// updataDBCourse(updataSyllabus.tuesday, "tuesday");
			// updataDBCourse(updataSyllabus.wednesday, "wednesday");
			// updataDBCourse(updataSyllabus.thursday, "thursday");
			// updataDBCourse(updataSyllabus.friday, "friday");
			// updataDBCourse(updataSyllabus.saturday, "saturday");
			// updataDBCourse(updataSyllabus.sunday, "sunday");
			// initViewData();
			break;
		}
	}

	private void updataDBCourse(ArrayList<BaseSyllabus> datas, String Tag) {
		for (int i = 0; i < datas.size(); i++) {
			DataManager.getInstance().updateSyllabus(Tag + i,
					datas.get(i).courseName, datas.get(i).teacherName);
		}

	}

	private void showDialog(View v, BaseSyllabus syllabus, String type) {
		String courseName = "";
		String teacherName = "";
		if (null != syllabus) {
			courseName = syllabus.courseName;
			teacherName = syllabus.teacherName;
		}
		startActivityForResult(
				new Intent(MySyllabusActivity.this,
						SyllabusChangeActivity.class)
						.putExtra("courseName", courseName)
						.putExtra("teacherName", teacherName)
						.putExtra("type", type), 1);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (Activity.RESULT_OK == resultCode)
			if (1 == requestCode)
				if (null != data) {
					TextView tv = (TextView) currentClickTv;
					BaseSyllabus syllabus = (BaseSyllabus) tv.getTag();
					syllabus.courseName = data.getStringExtra("courseName");
					syllabus.teacherName = data.getStringExtra("teacherName");
					tv.setTag(syllabus);
					tv.setText(syllabus.courseName);
					tv.setBackgroundResource(unitsBg[(int) (Math.random() * 10)]);
					// 进行数据库数据更新操作
					upDataDBCourse(syllabus);
				}
		if (TextUtils
				.isEmpty(((BaseSyllabus) currentClickTv.getTag()).courseName)) {
			BaseSyllabus baseSyllabus = (BaseSyllabus) currentClickTv.getTag();
			baseSyllabus.isAdding = "";
			currentClickTv.setTag(baseSyllabus);
		}
		currentClickTv = null;
	}

	private void upDataDBCourse(BaseSyllabus syllabus) {
		DataManager.getInstance().updateSyllabus(syllabus.courseId,
				syllabus.courseName, syllabus.teacherName);
	}
}
