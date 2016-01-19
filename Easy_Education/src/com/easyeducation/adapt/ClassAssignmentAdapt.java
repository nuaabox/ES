package com.easyeducation.adapt;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.easyeducation.activity.ClassAssignmentChangeActivity;
import com.easyeducation.bean.classassignment.ClassAssignment;
import com.hwd.cw.test.R;

public class ClassAssignmentAdapt extends BaseAdapter {

	private Activity activity;
	private List<ClassAssignment> dataList;
	private ViewHolder holder;
	private ClassAssignment assignment;

	private boolean isAllowModification = false;
	private boolean isTeacher = false;

	public ClassAssignmentAdapt(Activity activity,
			List<ClassAssignment> dataList, boolean isTeacher) {
		this.activity = activity;
		this.dataList = dataList;
		this.isTeacher = isTeacher;
	}

	@Override
	public int getCount() {
		return null == dataList ? 0 : dataList.size();
	}

	@Override
	public Object getItem(int pos) {
		return dataList.get(pos);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (null == convertView) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(activity).inflate(
					R.layout.listview_item_classassignment, null);
			initHolderView(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		assignment = (ClassAssignment) getItem(position);
		isAllowModification = "true".equals(assignment.isAllowModification) ? true
				: false;
		initData(assignment);

		if (!isAllowModification) {
			initUnModView();
			initAssignmentFinishTag();
		} else {
			if (isTeacher) {
				initTeacherView();
				initTeacherModify();
			} else {
				initStudentView();
				initStudentChange();
			}
		}
		return convertView;
	}

	private void initHolderView(View convertView) {

		holder.data = (TextView) convertView
				.findViewById(R.id.classassignment_head_tv_data);
		holder.dataTag = (TextView) convertView
				.findViewById(R.id.classassignment_head_tv_data_tag);
		holder.chineseTvName = (TextView) convertView
				.findViewById(R.id.classassignment_chinese_tv_name);
		holder.chineseCbFinish = (CheckBox) convertView
				.findViewById(R.id.classassignment_chinese_cb_finish);
		holder.chineseIvModify = (ImageView) convertView
				.findViewById(R.id.classassignment_chinese_iv_modify);
		holder.chineseLl = (LinearLayout) convertView
				.findViewById(R.id.classassignment_chinese_ll);
		holder.mathTvName = (TextView) convertView
				.findViewById(R.id.classassignment_math_tv_name);
		holder.mathCbFinish = (CheckBox) convertView
				.findViewById(R.id.classassignment_math_cb_finish);
		holder.mathIvModify = (ImageView) convertView
				.findViewById(R.id.classassignment_math_iv_modify);
		holder.mathLl = (LinearLayout) convertView
				.findViewById(R.id.classassignment_math_ll);
		holder.englishTvName = (TextView) convertView
				.findViewById(R.id.classassignment_english_tv_name);
		holder.englishCbFinish = (CheckBox) convertView
				.findViewById(R.id.classassignment_english_cb_finish);
		holder.englishIvModify = (ImageView) convertView
				.findViewById(R.id.classassignment_english_iv_modify);
		holder.englishLl = (LinearLayout) convertView
				.findViewById(R.id.classassignment_english_ll);
		holder.physicsTvName = (TextView) convertView
				.findViewById(R.id.classassignment_physics_tv_name);
		holder.physicsCbFinish = (CheckBox) convertView
				.findViewById(R.id.classassignment_physics_cb_finish);
		holder.physicsIvModify = (ImageView) convertView
				.findViewById(R.id.classassignment_physics_iv_modify);
		holder.physicsLl = (LinearLayout) convertView
				.findViewById(R.id.classassignment_physics_ll);
		holder.chemistryTvName = (TextView) convertView
				.findViewById(R.id.classassignment_chemistry_tv_name);
		holder.chemistryCbFinish = (CheckBox) convertView
				.findViewById(R.id.classassignment_chemistry_cb_finish);
		holder.chemistryIvModify = (ImageView) convertView
				.findViewById(R.id.classassignment_chemistry_iv_modify);
		holder.chemistryLl = (LinearLayout) convertView
				.findViewById(R.id.classassignment_chemistry_ll);
		holder.biologyTvName = (TextView) convertView
				.findViewById(R.id.classassignment_biology_tv_name);
		holder.biologyCbFinish = (CheckBox) convertView
				.findViewById(R.id.classassignment_biology_cb_finish);
		holder.biologyIvModify = (ImageView) convertView
				.findViewById(R.id.classassignment_biology_iv_modify);
		holder.biologyLl = (LinearLayout) convertView
				.findViewById(R.id.classassignment_biology_ll);
		holder.geographyTvName = (TextView) convertView
				.findViewById(R.id.classassignment_geography_tv_name);
		holder.geographyCbFinish = (CheckBox) convertView
				.findViewById(R.id.classassignment_geography_cb_finish);
		holder.geographyIvModify = (ImageView) convertView
				.findViewById(R.id.classassignment_geography_iv_modify);
		holder.geographyLl = (LinearLayout) convertView
				.findViewById(R.id.classassignment_geography_ll);
		holder.historyTvName = (TextView) convertView
				.findViewById(R.id.classassignment_history_tv_name);
		holder.historyCbFinish = (CheckBox) convertView
				.findViewById(R.id.classassignment_history_cb_finish);
		holder.historyIvModify = (ImageView) convertView
				.findViewById(R.id.classassignment_history_iv_modify);
		holder.historyLl = (LinearLayout) convertView
				.findViewById(R.id.classassignment_history_ll);
		holder.politicsTvName = (TextView) convertView
				.findViewById(R.id.classassignment_politics_tv_name);
		holder.politicsCbFinish = (CheckBox) convertView
				.findViewById(R.id.classassignment_politics_cb_finish);
		holder.politicsIvModify = (ImageView) convertView
				.findViewById(R.id.classassignment_politics_iv_modify);
		holder.politicsLl = (LinearLayout) convertView
				.findViewById(R.id.classassignment_politics_ll);
		holder.chineseIvFinishTag = (ImageView) convertView
				.findViewById(R.id.classassignment_chinese_iv_finish_tag);
		holder.mathIvFinishTag = (ImageView) convertView
				.findViewById(R.id.classassignment_math_iv_finish_tag);
		holder.englishIvFinishTag = (ImageView) convertView
				.findViewById(R.id.classassignment_english_iv_finish_tag);
		holder.physicsIvFinishTag = (ImageView) convertView
				.findViewById(R.id.classassignment_physics_iv_finish_tag);
		holder.chemistryIvFinishTag = (ImageView) convertView
				.findViewById(R.id.classassignment_chemistry_iv_finish_tag);
		holder.biologyIvFinishTag = (ImageView) convertView
				.findViewById(R.id.classassignment_biology_iv_finish_tag);
		holder.geographyIvFinishTag = (ImageView) convertView
				.findViewById(R.id.classassignment_geography_iv_finish_tag);
		holder.historyIvFinishTag = (ImageView) convertView
				.findViewById(R.id.classassignment_history_iv_finish_tag);
		holder.politicsIvFinishTag = (ImageView) convertView
				.findViewById(R.id.classassignment_politics_iv_finish_tag);
	}

	private void initData(ClassAssignment assignment) {

		holder.data.setText(assignment.data);
		holder.dataTag.setText(assignment.dataTag);

		if (!TextUtils.isEmpty(assignment.chinese.assignmentContent)) {
			holder.chineseLl.setVisibility(View.VISIBLE);
			holder.chineseTvName.setText("语文："
					+ assignment.chinese.assignmentContent);
		} else {
			holder.chineseLl.setVisibility(View.GONE);
		}
		if (!TextUtils.isEmpty(assignment.math.assignmentContent)) {
			holder.mathLl.setVisibility(View.VISIBLE);
			holder.mathTvName
					.setText("数学：" + assignment.math.assignmentContent);
		} else {
			holder.mathLl.setVisibility(View.GONE);
		}
		if (!TextUtils.isEmpty(assignment.english.assignmentContent)) {
			holder.englishLl.setVisibility(View.VISIBLE);
			holder.englishTvName.setText("英语："
					+ assignment.english.assignmentContent);
		} else {
			holder.englishLl.setVisibility(View.GONE);
		}
		if (!TextUtils.isEmpty(assignment.physics.assignmentContent)) {
			holder.physicsLl.setVisibility(View.VISIBLE);
			holder.physicsTvName.setText("物理："
					+ assignment.physics.assignmentContent);
		} else {
			holder.physicsLl.setVisibility(View.GONE);
		}
		if (!TextUtils.isEmpty(assignment.chemistry.assignmentContent)) {
			holder.chemistryLl.setVisibility(View.VISIBLE);
			holder.chemistryTvName.setText("化学："
					+ assignment.chemistry.assignmentContent);
		} else {
			holder.chemistryLl.setVisibility(View.GONE);
		}
		if (!TextUtils.isEmpty(assignment.biology.assignmentContent)) {
			holder.biologyLl.setVisibility(View.VISIBLE);
			holder.biologyTvName.setText("生物："
					+ assignment.biology.assignmentContent);
		} else {
			holder.biologyLl.setVisibility(View.GONE);
		}
		if (!TextUtils.isEmpty(assignment.geography.assignmentContent)) {
			holder.geographyLl.setVisibility(View.VISIBLE);
			holder.geographyTvName.setText("地理："
					+ assignment.geography.assignmentContent);
		} else {
			holder.geographyLl.setVisibility(View.GONE);
		}
		if (!TextUtils.isEmpty(assignment.history.assignmentContent)) {
			holder.historyLl.setVisibility(View.VISIBLE);
			holder.historyTvName.setText("历史："
					+ assignment.history.assignmentContent);
		} else {
			holder.historyLl.setVisibility(View.GONE);
		}
		if (!TextUtils.isEmpty(assignment.politics.assignmentContent)) {
			holder.politicsLl.setVisibility(View.VISIBLE);
			holder.politicsTvName.setText("政治："
					+ assignment.politics.assignmentContent);
		} else {
			holder.politicsLl.setVisibility(View.GONE);
		}
	}

	private void initStudentView() {
		holder.chineseCbFinish.setVisibility(View.VISIBLE);
		holder.chineseIvModify.setVisibility(View.GONE);
		holder.chineseIvFinishTag.setVisibility(View.GONE);
		holder.mathCbFinish.setVisibility(View.VISIBLE);
		holder.mathIvModify.setVisibility(View.GONE);
		holder.mathIvFinishTag.setVisibility(View.GONE);
		holder.englishCbFinish.setVisibility(View.VISIBLE);
		holder.englishIvModify.setVisibility(View.GONE);
		holder.englishIvFinishTag.setVisibility(View.GONE);
		holder.physicsCbFinish.setVisibility(View.VISIBLE);
		holder.physicsIvModify.setVisibility(View.GONE);
		holder.physicsIvFinishTag.setVisibility(View.GONE);
		holder.chemistryCbFinish.setVisibility(View.VISIBLE);
		holder.chemistryIvModify.setVisibility(View.GONE);
		holder.chemistryIvFinishTag.setVisibility(View.GONE);
		holder.biologyCbFinish.setVisibility(View.VISIBLE);
		holder.biologyIvModify.setVisibility(View.GONE);
		holder.biologyIvFinishTag.setVisibility(View.GONE);
		holder.geographyCbFinish.setVisibility(View.VISIBLE);
		holder.geographyIvModify.setVisibility(View.GONE);
		holder.geographyIvFinishTag.setVisibility(View.GONE);
		holder.historyCbFinish.setVisibility(View.VISIBLE);
		holder.historyIvModify.setVisibility(View.GONE);
		holder.historyIvFinishTag.setVisibility(View.GONE);
		holder.politicsCbFinish.setVisibility(View.VISIBLE);
		holder.politicsIvModify.setVisibility(View.GONE);
		holder.politicsIvFinishTag.setVisibility(View.GONE);
	}

	private void initTeacherView() {
		holder.chineseCbFinish.setVisibility(View.GONE);
		holder.chineseIvModify.setVisibility(View.VISIBLE);
		holder.chineseIvFinishTag.setVisibility(View.GONE);
		holder.mathCbFinish.setVisibility(View.GONE);
		holder.mathIvModify.setVisibility(View.VISIBLE);
		holder.mathIvFinishTag.setVisibility(View.GONE);
		holder.englishCbFinish.setVisibility(View.GONE);
		holder.englishIvModify.setVisibility(View.VISIBLE);
		holder.englishIvFinishTag.setVisibility(View.GONE);
		holder.physicsCbFinish.setVisibility(View.GONE);
		holder.physicsIvModify.setVisibility(View.VISIBLE);
		holder.physicsIvFinishTag.setVisibility(View.GONE);
		holder.chemistryCbFinish.setVisibility(View.GONE);
		holder.chemistryIvModify.setVisibility(View.VISIBLE);
		holder.chemistryIvFinishTag.setVisibility(View.GONE);
		holder.biologyCbFinish.setVisibility(View.GONE);
		holder.biologyIvModify.setVisibility(View.VISIBLE);
		holder.biologyIvFinishTag.setVisibility(View.GONE);
		holder.geographyCbFinish.setVisibility(View.GONE);
		holder.geographyIvModify.setVisibility(View.VISIBLE);
		holder.geographyIvFinishTag.setVisibility(View.GONE);
		holder.historyCbFinish.setVisibility(View.GONE);
		holder.historyIvModify.setVisibility(View.VISIBLE);
		holder.historyIvFinishTag.setVisibility(View.GONE);
		holder.politicsCbFinish.setVisibility(View.GONE);
		holder.politicsIvModify.setVisibility(View.VISIBLE);
		holder.politicsIvFinishTag.setVisibility(View.GONE);
	}

	private void initStudentChange() {
		holder.chineseCbFinish
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (isChecked) {
							assignment.chinese.isComplete = "true";
						} else {
							assignment.chinese.isComplete = "false";
						}
						// 发送网络请求--锁死屏幕
						// assignment.classAssignmentId
						// assignment.chinese.courseTag;
						// assignment.chinese.isComplete
					}
				});
		holder.mathCbFinish
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (isChecked) {
							assignment.math.isComplete = "true";
						} else {
							assignment.math.isComplete = "false";
						}
						// 发送网络请求--锁死屏幕
						// assignment.classAssignmentId
						// assignment.chinese.courseTag;
						// assignment.chinese.isComplete
					}
				});
		holder.englishCbFinish
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (isChecked) {
							assignment.english.isComplete = "true";
						} else {
							assignment.english.isComplete = "false";
						}
						// 发送网络请求--锁死屏幕
						// assignment.classAssignmentId
						// assignment.chinese.courseTag;
						// assignment.chinese.isComplete
					}
				});
		holder.physicsCbFinish
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (isChecked) {
							assignment.physics.isComplete = "true";
						} else {
							assignment.physics.isComplete = "false";
						}
						// 发送网络请求--锁死屏幕
						// assignment.classAssignmentId
						// assignment.chinese.courseTag;
						// assignment.chinese.isComplete
					}
				});
		holder.chemistryCbFinish
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (isChecked) {
							assignment.chemistry.isComplete = "true";
						} else {
							assignment.chemistry.isComplete = "false";
						}
						// 发送网络请求--锁死屏幕
						// assignment.classAssignmentId
						// assignment.chinese.courseTag;
						// assignment.chinese.isComplete
					}
				});
		holder.biologyCbFinish
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (isChecked) {
							assignment.biology.isComplete = "true";
						} else {
							assignment.biology.isComplete = "false";
						}
						// 发送网络请求--锁死屏幕
						// assignment.classAssignmentId
						// assignment.chinese.courseTag;
						// assignment.chinese.isComplete
					}
				});
		holder.geographyCbFinish
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (isChecked) {
							assignment.geography.isComplete = "true";
						} else {
							assignment.geography.isComplete = "false";
						}
						// 发送网络请求--锁死屏幕
						// assignment.classAssignmentId
						// assignment.chinese.courseTag;
						// assignment.chinese.isComplete
					}
				});
		holder.historyCbFinish
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (isChecked) {
							assignment.history.isComplete = "true";
						} else {
							assignment.history.isComplete = "false";
						}
						// 发送网络请求--锁死屏幕
						// assignment.classAssignmentId
						// assignment.chinese.courseTag;
						// assignment.chinese.isComplete
					}
				});
		holder.politicsCbFinish
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (isChecked) {
							assignment.politics.isComplete = "true";
						} else {
							assignment.politics.isComplete = "false";
						}
						// 发送网络请求--锁死屏幕
						// assignment.classAssignmentId
						// assignment.chinese.courseTag;
						// assignment.chinese.isComplete
					}
				});
		// chinese math english physics chemistry biology geography history
		// politics
	}

	private void initTeacherModify() {
		holder.chineseIvModify.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startDialog("change", "语文",
						assignment.chinese.assignmentContent, 1);
			}
		});
		holder.mathIvModify.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startDialog("change", "数学", assignment.math.assignmentContent,
						1);
			}
		});
		holder.englishIvModify.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startDialog("change", "英语",
						assignment.english.assignmentContent, 1);
			}
		});
		holder.physicsIvModify.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startDialog("change", "物理",
						assignment.physics.assignmentContent, 1);
			}
		});
		holder.chemistryIvModify.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startDialog("change", "化学",
						assignment.chemistry.assignmentContent, 1);
			}
		});
		holder.biologyIvModify.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startDialog("change", "生物",
						assignment.biology.assignmentContent, 1);
			}
		});
		holder.geographyIvModify.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startDialog("change", "地理",
						assignment.geography.assignmentContent, 1);
			}
		});
		holder.historyIvModify.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startDialog("change", "历史",
						assignment.history.assignmentContent, 1);
			}
		});
		holder.politicsIvModify.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startDialog("change", "政治",
						assignment.politics.assignmentContent, 1);
			}
		});

	}

	private void initUnModView() {
		holder.chineseCbFinish.setVisibility(View.GONE);
		holder.chineseIvModify.setVisibility(View.GONE);
		holder.chineseIvFinishTag.setVisibility(View.VISIBLE);
		holder.mathCbFinish.setVisibility(View.GONE);
		holder.mathIvModify.setVisibility(View.GONE);
		holder.mathIvFinishTag.setVisibility(View.VISIBLE);
		holder.englishCbFinish.setVisibility(View.GONE);
		holder.englishIvModify.setVisibility(View.GONE);
		holder.englishIvFinishTag.setVisibility(View.VISIBLE);
		holder.physicsCbFinish.setVisibility(View.GONE);
		holder.physicsIvModify.setVisibility(View.GONE);
		holder.physicsIvFinishTag.setVisibility(View.VISIBLE);
		holder.chemistryCbFinish.setVisibility(View.GONE);
		holder.chemistryIvModify.setVisibility(View.GONE);
		holder.chemistryIvFinishTag.setVisibility(View.VISIBLE);
		holder.biologyCbFinish.setVisibility(View.GONE);
		holder.biologyIvModify.setVisibility(View.GONE);
		holder.biologyIvFinishTag.setVisibility(View.VISIBLE);
		holder.geographyCbFinish.setVisibility(View.GONE);
		holder.geographyIvModify.setVisibility(View.GONE);
		holder.geographyIvFinishTag.setVisibility(View.VISIBLE);
		holder.historyCbFinish.setVisibility(View.GONE);
		holder.historyIvModify.setVisibility(View.GONE);
		holder.historyIvFinishTag.setVisibility(View.VISIBLE);
		holder.politicsCbFinish.setVisibility(View.GONE);
		holder.politicsIvModify.setVisibility(View.GONE);
		holder.politicsIvFinishTag.setVisibility(View.VISIBLE);
	}

	private void initAssignmentFinishTag() {
		if ("true".equals(assignment.chinese.isComplete)) {
			holder.chineseIvFinishTag
					.setBackgroundResource(R.drawable.ic_assignment_finish);
		} else {
			holder.chineseIvFinishTag
					.setBackgroundResource(R.drawable.ic_assignment_unfinish);
		}
		if ("true".equals(assignment.math.isComplete)) {
			holder.mathIvFinishTag
					.setBackgroundResource(R.drawable.ic_assignment_finish);
		} else {
			holder.mathIvFinishTag
					.setBackgroundResource(R.drawable.ic_assignment_unfinish);
		}
		if ("true".equals(assignment.english.isComplete)) {
			holder.englishIvFinishTag
					.setBackgroundResource(R.drawable.ic_assignment_finish);
		} else {
			holder.englishIvFinishTag
					.setBackgroundResource(R.drawable.ic_assignment_unfinish);
		}
		if ("true".equals(assignment.physics.isComplete)) {
			holder.physicsIvFinishTag
					.setBackgroundResource(R.drawable.ic_assignment_finish);
		} else {
			holder.physicsIvFinishTag
					.setBackgroundResource(R.drawable.ic_assignment_unfinish);
		}
		if ("true".equals(assignment.chemistry.isComplete)) {
			holder.chemistryIvFinishTag
					.setBackgroundResource(R.drawable.ic_assignment_finish);
		} else {
			holder.chemistryIvFinishTag
					.setBackgroundResource(R.drawable.ic_assignment_unfinish);
		}
		if ("true".equals(assignment.biology.isComplete)) {
			holder.biologyIvFinishTag
					.setBackgroundResource(R.drawable.ic_assignment_finish);
		} else {
			holder.biologyIvFinishTag
					.setBackgroundResource(R.drawable.ic_assignment_unfinish);
		}
		if ("true".equals(assignment.geography.isComplete)) {
			holder.geographyIvFinishTag
					.setBackgroundResource(R.drawable.ic_assignment_finish);
		} else {
			holder.geographyIvFinishTag
					.setBackgroundResource(R.drawable.ic_assignment_unfinish);
		}
		if ("true".equals(assignment.history.isComplete)) {
			holder.historyIvFinishTag
					.setBackgroundResource(R.drawable.ic_assignment_finish);
		} else {
			holder.historyIvFinishTag
					.setBackgroundResource(R.drawable.ic_assignment_unfinish);
		}
		if ("true".equals(assignment.politics.isComplete)) {
			holder.politicsIvFinishTag
					.setBackgroundResource(R.drawable.ic_assignment_finish);
		} else {
			holder.politicsIvFinishTag
					.setBackgroundResource(R.drawable.ic_assignment_unfinish);
		}
	}

	/**
	 * 
	 * @param Type
	 *            :change-->修改作业,default||other-->添加
	 * @param course
	 * @param content
	 * @param requestCode
	 *            0:add,1:change
	 */
	private void startDialog(String type, String course, String content,
			int requestCode) {
		Intent intent = new Intent(activity,
				ClassAssignmentChangeActivity.class);
		intent.putExtra("fragmentName", "classAssignment");
		intent.putExtra("Type", type);
		intent.putExtra("Course", course);
		intent.putExtra("Content", content);
		activity.startActivityForResult(intent, requestCode);
	}

	class ViewHolder {
		TextView dataTag;
		TextView data;
		TextView chineseTvName;
		CheckBox chineseCbFinish;
		ImageView chineseIvModify;
		ImageView chineseIvFinishTag;
		TextView mathTvName;
		CheckBox mathCbFinish;
		ImageView mathIvModify;
		ImageView mathIvFinishTag;
		TextView englishTvName;
		CheckBox englishCbFinish;
		ImageView englishIvModify;
		ImageView englishIvFinishTag;
		TextView physicsTvName;
		CheckBox physicsCbFinish;
		ImageView physicsIvModify;
		ImageView physicsIvFinishTag;
		TextView chemistryTvName;
		CheckBox chemistryCbFinish;
		ImageView chemistryIvModify;
		ImageView chemistryIvFinishTag;
		TextView biologyTvName;
		CheckBox biologyCbFinish;
		ImageView biologyIvModify;
		ImageView biologyIvFinishTag;
		TextView geographyTvName;
		CheckBox geographyCbFinish;
		ImageView geographyIvModify;
		ImageView geographyIvFinishTag;
		TextView historyTvName;
		CheckBox historyCbFinish;
		ImageView historyIvModify;
		ImageView historyIvFinishTag;
		TextView politicsTvName;
		CheckBox politicsCbFinish;
		ImageView politicsIvModify;
		ImageView politicsIvFinishTag;
		LinearLayout chineseLl;
		LinearLayout mathLl;
		LinearLayout englishLl;
		LinearLayout physicsLl;
		LinearLayout chemistryLl;
		LinearLayout biologyLl;
		LinearLayout geographyLl;
		LinearLayout historyLl;
		LinearLayout politicsLl;
	}

	public void setData(List<ClassAssignment> dataList) {
		this.dataList = dataList;
		notifyDataSetChanged();
	}

}
