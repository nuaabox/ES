package com.easyeducation.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.easyeducation.bean.mysyllabus.BaseSyllabus;
import com.hwd.cw.test.R;

/**
 * 添加/修改作业
 * 
 * @author Administrator Type:change-->修改作业,default||other-->添加
 */
public class SyllabusChangeActivity extends Activity implements OnClickListener {
	private TextView cCTvTitle;
	private EditText cCEtCourse;
	private EditText cCEtContent;
	private TextView cCTvConfirm;
	private ImageView cCIvCancel;
	private Activity activity;
	private BaseSyllabus syllabus;
	private String type;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dialog_syllabus_change);
		activity = this;
		Intent intent = getIntent();
		syllabus = new BaseSyllabus();
		syllabus.courseName = intent.getStringExtra("courseName");
		syllabus.teacherName = intent.getStringExtra("teacherName");
		type = intent.getStringExtra("type");
		cCTvTitle = (TextView) findViewById(R.id.dialg_syllabus_change_tv_title);
		cCEtCourse = (EditText) findViewById(R.id.dialg_syllabus_change_et_course);
		cCEtContent = (EditText) findViewById(R.id.dialg_syllabus_change_et_teacher);
		cCTvConfirm = (TextView) findViewById(R.id.dialg_syllabus_change_tv_confirm);
		cCIvCancel = (ImageView) findViewById(R.id.dialg_syllabus_change_iv_cancel);
		if ("add".equals(type))
			cCTvTitle.setText(R.string.syllabus_add);
		else {
			cCTvTitle.setText(R.string.syllabus_change);
		}
		if (null != syllabus) {
			cCEtCourse.setText(syllabus.courseName);
			cCEtContent.setText(syllabus.teacherName);
		} else {
			syllabus = new BaseSyllabus();
		}
		cCTvConfirm.setOnClickListener(this);
		cCIvCancel.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.dialg_syllabus_change_tv_confirm:
			syllabus.courseName = cCEtCourse.getText().toString().trim();
			syllabus.teacherName = cCEtContent.getText().toString().trim();
			if (!TextUtils.isEmpty(syllabus.courseName)
					&& !TextUtils.isEmpty(syllabus.teacherName)) {
				// TODO 进行数据库更新操作
				startResultOk(syllabus);
			} else {
				Toast.makeText(activity, "请确认课程表信息...", Toast.LENGTH_SHORT)
						.show();
			}
			break;
		case R.id.dialg_syllabus_change_iv_cancel:
			setResult(Activity.RESULT_CANCELED);
			this.finish();
			break;
		}

	}

	private void startResultOk(BaseSyllabus syllabus) {
		Intent intent = new Intent();
		intent.putExtra("courseName", syllabus.courseName);
		intent.putExtra("teacherName", syllabus.teacherName);
		setResult(Activity.RESULT_OK, intent);
		this.finish();
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		setResult(Activity.RESULT_CANCELED);
	}
}
