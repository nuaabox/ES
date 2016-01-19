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

import com.hwd.cw.test.R;

/**
 * 添加/修改作业
 * 
 * @author Administrator Type:change-->修改作业,default||other-->添加
 */
public class ClassAssignmentChangeActivity extends Activity implements
		OnClickListener {

	private String type;
	private String classAssignmentContent = "";
	private String classCourse;
	private TextView cCTvTitle;
	private TextView cCTvCourse;
	private EditText cCEtContent;
	private TextView cCTvConfirm;
	private ImageView cCIvCancel;
	private Activity activity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dialog_class_assignment_change);
		activity = this;
		Intent intent = getIntent();
		type = intent.getStringExtra("Type");
		classCourse = intent.getStringExtra("Course");
		classAssignmentContent = intent.getStringExtra("Content");
		cCTvTitle = (TextView) findViewById(R.id.dialg_class_change_tv_title);
		cCTvCourse = (TextView) findViewById(R.id.dialg_class_change_tv_course);
		cCEtContent = (EditText) findViewById(R.id.dialg_class_change_et_content);
		cCTvConfirm = (TextView) findViewById(R.id.dialg_class_change_tv_confirm);
		cCIvCancel = (ImageView) findViewById(R.id.dialg_class_change_iv_cancel);
		cCTvTitle.setText(R.string.assignment_add);
		if (!TextUtils.isEmpty(type) && "change".equals(type)) {
			cCTvTitle.setText(R.string.assignment_change);
		}
		if (!TextUtils.isEmpty(classCourse)) {
			cCTvCourse.setText(classCourse);
			if (null != classAssignmentContent)
				cCEtContent.setText(classAssignmentContent);
		}
		cCTvConfirm.setOnClickListener(this);
		cCIvCancel.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.dialg_class_change_tv_confirm:
			String content = cCEtContent.getText().toString().trim();
			if (!TextUtils.isEmpty(content)) {
				// 发送修改/添加请求
				startResultOk(classCourse, content);
			} else {
				Toast.makeText(activity, "请确认作业内容...", Toast.LENGTH_SHORT)
						.show();
			}
			break;
		case R.id.dialg_class_change_iv_cancel:
			setResult(Activity.RESULT_CANCELED);
			this.finish();
			break;
		}

	}

	private void startResultOk(String course, String content) {
		Intent intent = new Intent();
		intent.putExtra("fragmentName", "classAssignment");
		intent.putExtra("Course", course);
		intent.putExtra("Content", content);
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
