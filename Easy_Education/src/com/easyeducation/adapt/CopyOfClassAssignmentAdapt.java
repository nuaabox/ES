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

public class CopyOfClassAssignmentAdapt extends BaseAdapter {

	private Activity activity;
	private List<ClassAssignment> dataList;
	private ViewHolder holder;
	private ClassAssignment assignment;

	private boolean isAllowModification = false;
	private boolean isTeacher = false;

	public CopyOfClassAssignmentAdapt(Activity activity,
			List<ClassAssignment> dataList, boolean isTeacher) {
		this.activity = activity;
		this.dataList = dataList;
		this.isTeacher = isTeacher;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return null == dataList ? 0 : dataList.size();
	}

	@Override
	public Object getItem(int pos) {
		// TODO Auto-generated method stub
		return dataList.get(pos);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (null == convertView) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(activity).inflate(
					R.layout.listview_item_classassignment, null);
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
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		assignment = (ClassAssignment) getItem(position);
		isAllowModification = "ture".equals(assignment.isAllowModification) ? true
				: false;

		if (TextUtils.isEmpty(assignment.chinese.assignmentContent)) {
			holder.chineseLl.setVisibility(View.GONE);
		} else {
			holder.chineseLl.setVisibility(View.VISIBLE);
			holder.chineseTvName.setText("语文："
					+ assignment.chinese.assignmentContent);

			if (isTeacher && isAllowModification) {
				holder.chineseIvModify.setVisibility(View.VISIBLE);
				holder.chineseCbFinish.setVisibility(View.GONE);
			} else {
				holder.chineseIvModify.setVisibility(View.GONE);
				holder.chineseCbFinish.setVisibility(View.VISIBLE);
				if ("true".equals(assignment.chinese.isComplete)) {
					holder.chineseCbFinish.setChecked(true);
				} else {
					holder.chineseCbFinish.setChecked(false);
				}
			}

		}
		if (TextUtils.isEmpty(assignment.math.assignmentContent)) {
			holder.mathLl.setVisibility(View.GONE);
		} else {
			holder.mathLl.setVisibility(View.VISIBLE);
			holder.mathTvName
					.setText("数学：" + assignment.math.assignmentContent);

			if (isTeacher && isAllowModification) {
				holder.mathIvModify.setVisibility(View.VISIBLE);
				holder.mathCbFinish.setVisibility(View.GONE);
			} else {
				holder.mathIvModify.setVisibility(View.GONE);
				holder.mathCbFinish.setVisibility(View.VISIBLE);

				if ("true".equals(assignment.math.isComplete)) {
					holder.mathCbFinish.setChecked(true);
				} else {
					holder.mathCbFinish.setChecked(false);
				}
			}
		}
		if (TextUtils.isEmpty(assignment.english.assignmentContent)) {
			holder.englishLl.setVisibility(View.GONE);
		} else {
			holder.englishLl.setVisibility(View.VISIBLE);
			holder.englishTvName.setText("英语："
					+ assignment.english.assignmentContent);
			if (isTeacher && isAllowModification) {
				holder.englishIvModify.setVisibility(View.VISIBLE);
				holder.englishCbFinish.setVisibility(View.GONE);
			} else {
				holder.englishIvModify.setVisibility(View.GONE);
				holder.englishCbFinish.setVisibility(View.VISIBLE);

				if ("true".equals(assignment.english.isComplete)) {
					holder.englishCbFinish.setChecked(true);
				} else {
					holder.englishCbFinish.setChecked(false);
				}
			}
		}
		if (TextUtils.isEmpty(assignment.physics.assignmentContent)) {
			holder.physicsLl.setVisibility(View.GONE);
		} else {
			holder.physicsLl.setVisibility(View.VISIBLE);
			holder.physicsTvName.setText("物理："
					+ assignment.physics.assignmentContent);
			if (isTeacher && isAllowModification) {
				holder.physicsIvModify.setVisibility(View.VISIBLE);
				holder.physicsCbFinish.setVisibility(View.GONE);
			} else {
				holder.physicsIvModify.setVisibility(View.GONE);
				holder.physicsCbFinish.setVisibility(View.VISIBLE);

				if ("true".equals(assignment.physics.isComplete)) {
					holder.physicsCbFinish.setChecked(true);
				} else {
					holder.physicsCbFinish.setChecked(false);
				}
			}
		}
		if (TextUtils.isEmpty(assignment.chemistry.assignmentContent)) {
			holder.chemistryLl.setVisibility(View.GONE);
		} else {
			holder.chemistryLl.setVisibility(View.VISIBLE);
			holder.chemistryTvName.setText("化学："
					+ assignment.chemistry.assignmentContent);

			if (isTeacher && isAllowModification) {
				holder.chemistryIvModify.setVisibility(View.VISIBLE);
				holder.chemistryCbFinish.setVisibility(View.GONE);
			} else {
				holder.chemistryIvModify.setVisibility(View.GONE);
				holder.chemistryCbFinish.setVisibility(View.VISIBLE);
				if ("true".equals(assignment.chemistry.isComplete)) {
					holder.chemistryCbFinish.setChecked(true);
				} else {
					holder.chemistryCbFinish.setChecked(false);
				}
			}
		}
		if (TextUtils.isEmpty(assignment.biology.assignmentContent)) {
			holder.biologyLl.setVisibility(View.GONE);
		} else {
			holder.biologyLl.setVisibility(View.VISIBLE);
			holder.biologyTvName.setText("生物："
					+ assignment.biology.assignmentContent);
			if (isTeacher && isAllowModification) {
				holder.biologyIvModify.setVisibility(View.VISIBLE);
				holder.biologyCbFinish.setVisibility(View.GONE);
			} else {
				holder.biologyIvModify.setVisibility(View.GONE);
				holder.biologyCbFinish.setVisibility(View.VISIBLE);
				if ("true".equals(assignment.biology.isComplete)) {
					holder.biologyCbFinish.setChecked(true);
				} else {
					holder.biologyCbFinish.setChecked(false);
				}
			}
		}
		if (TextUtils.isEmpty(assignment.geography.assignmentContent)) {
			holder.geographyLl.setVisibility(View.GONE);
		} else {
			holder.geographyLl.setVisibility(View.VISIBLE);
			holder.geographyTvName.setText("地理："
					+ assignment.geography.assignmentContent);
			if (isTeacher && isAllowModification) {
				holder.geographyIvModify.setVisibility(View.VISIBLE);
				holder.geographyCbFinish.setVisibility(View.GONE);
			} else {
				holder.geographyIvModify.setVisibility(View.GONE);
				holder.geographyCbFinish.setVisibility(View.VISIBLE);
				if ("true".equals(assignment.geography.isComplete)) {
					holder.geographyCbFinish.setChecked(true);
				} else {
					holder.geographyCbFinish.setChecked(false);
				}
			}
		}
		if (TextUtils.isEmpty(assignment.history.assignmentContent)) {
			holder.historyLl.setVisibility(View.GONE);
		} else {
			holder.historyLl.setVisibility(View.VISIBLE);
			holder.historyTvName.setText("历史："
					+ assignment.history.assignmentContent);
			if (isTeacher && isAllowModification) {
				holder.historyIvModify.setVisibility(View.VISIBLE);
				holder.historyCbFinish.setVisibility(View.GONE);
			} else {
				holder.historyIvModify.setVisibility(View.GONE);
				holder.historyCbFinish.setVisibility(View.VISIBLE);
				if ("true".equals(assignment.history.isComplete)) {
					holder.historyCbFinish.setChecked(true);
				} else {
					holder.historyCbFinish.setChecked(false);
				}
			}
		}
		if (TextUtils.isEmpty(assignment.politics.assignmentContent)) {
			holder.politicsLl.setVisibility(View.GONE);
		} else {
			holder.politicsLl.setVisibility(View.VISIBLE);
			holder.politicsTvName.setText("政治："
					+ assignment.politics.assignmentContent);
			if (isTeacher && isAllowModification) {
				holder.politicsIvModify.setVisibility(View.VISIBLE);
				holder.politicsCbFinish.setVisibility(View.GONE);
			} else {
				holder.politicsIvModify.setVisibility(View.GONE);
				holder.politicsCbFinish.setVisibility(View.VISIBLE);
				if ("true".equals(assignment.politics.isComplete)) {
					holder.politicsCbFinish.setChecked(true);
				} else {
					holder.politicsCbFinish.setChecked(false);
				}
			}
		}

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
		holder.chineseIvModify.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startDialog("change", "语文",
						assignment.chinese.assignmentContent, 1);
			}
		});

		return convertView;
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
		TextView mathTvName;
		CheckBox mathCbFinish;
		ImageView mathIvModify;
		TextView englishTvName;
		CheckBox englishCbFinish;
		ImageView englishIvModify;
		TextView physicsTvName;
		CheckBox physicsCbFinish;
		ImageView physicsIvModify;
		TextView chemistryTvName;
		CheckBox chemistryCbFinish;
		ImageView chemistryIvModify;
		TextView biologyTvName;
		CheckBox biologyCbFinish;
		ImageView biologyIvModify;
		TextView geographyTvName;
		CheckBox geographyCbFinish;
		ImageView geographyIvModify;
		TextView historyTvName;
		CheckBox historyCbFinish;
		ImageView historyIvModify;
		TextView politicsTvName;
		CheckBox politicsCbFinish;
		ImageView politicsIvModify;
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

}
