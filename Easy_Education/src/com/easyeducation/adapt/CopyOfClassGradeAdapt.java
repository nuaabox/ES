package com.easyeducation.adapt;

import java.util.ArrayList;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.easyeducation.bean.classgrade.Classgrade;
import com.hwd.cw.test.R;

public class CopyOfClassGradeAdapt extends BaseAdapter {
	private Activity activity;
	private ArrayList<Classgrade> datas;
	private ViewHolder holder;

	public CopyOfClassGradeAdapt(Activity activity, ArrayList<Classgrade> datas) {
		super();
		this.activity = activity;
		this.datas = datas;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return null == datas ? 0 : datas.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return datas.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (null == convertView) {
			LayoutInflater inflater = LayoutInflater.from(activity);
			convertView = inflater.inflate(R.layout.listview_item_class_grade,
					null);
			holder = new ViewHolder();
			initHolderView(convertView);
			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		Classgrade classgrade = (Classgrade) getItem(position);
		initViewData(classgrade);
		// TODO Auto-generated method stub
		return convertView;
	}

	private void initViewData(Classgrade classgrade) {
		if (null != classgrade) {

			if (!TextUtils.isEmpty(classgrade.chinese.topScore)) {
				holder.chineseLl.setVisibility(View.VISIBLE);
				holder.chineseTopScore.setText(classgrade.chinese.topScore);
				holder.chineseLowestScore
						.setText(classgrade.chinese.lowestScore);
				holder.chineseAverageScore
						.setText(classgrade.chinese.averageScore);
			} else {
				holder.chineseLl.setVisibility(View.GONE);
			}
			if (!TextUtils.isEmpty(classgrade.math.topScore)) {
				holder.mathLl.setVisibility(View.VISIBLE);
				holder.mathTopScore.setText(classgrade.math.topScore);
				holder.mathLowestScore.setText(classgrade.math.lowestScore);
				holder.mathAverageScore.setText(classgrade.math.averageScore);
			} else {
				holder.mathLl.setVisibility(View.GONE);
			}
			if (!TextUtils.isEmpty(classgrade.english.topScore)) {
				holder.englishLl.setVisibility(View.VISIBLE);
				holder.englishTopScore.setText(classgrade.english.topScore);
				holder.englishLowestScore
						.setText(classgrade.english.lowestScore);
				holder.englishAverageScore
						.setText(classgrade.english.averageScore);
			} else {
				holder.englishLl.setVisibility(View.GONE);
			}
			if (!TextUtils.isEmpty(classgrade.physics.topScore)) {
				holder.physicsLl.setVisibility(View.VISIBLE);
				holder.physicsTopScore.setText(classgrade.physics.topScore);
				holder.physicsLowestScore
						.setText(classgrade.physics.lowestScore);
				holder.physicsAverageScore
						.setText(classgrade.physics.averageScore);
			} else {
				holder.physicsLl.setVisibility(View.GONE);
			}
			if (!TextUtils.isEmpty(classgrade.chemistry.topScore)) {
				holder.chemistryLl.setVisibility(View.VISIBLE);
				holder.chemistryTopScore.setText(classgrade.chemistry.topScore);
				holder.chemistryLowestScore
						.setText(classgrade.chemistry.lowestScore);
				holder.chemistryAverageScore
						.setText(classgrade.chemistry.averageScore);
			} else {
				holder.chemistryLl.setVisibility(View.GONE);
			}
			if (!TextUtils.isEmpty(classgrade.biology.topScore)) {
				holder.biologyLl.setVisibility(View.VISIBLE);
				holder.biologyTopScore.setText(classgrade.biology.topScore);
				holder.biologyLowestScore
						.setText(classgrade.biology.lowestScore);
				holder.biologyAverageScore
						.setText(classgrade.biology.averageScore);
			} else {
				holder.biologyLl.setVisibility(View.GONE);
			}
			if (!TextUtils.isEmpty(classgrade.geography.topScore)) {
				holder.geographyLl.setVisibility(View.VISIBLE);
				holder.geographyTopScore.setText(classgrade.geography.topScore);
				holder.geographyLowestScore
						.setText(classgrade.geography.lowestScore);
				holder.geographyAverageScore
						.setText(classgrade.geography.averageScore);
			} else {
				holder.geographyLl.setVisibility(View.GONE);
			}
			if (!TextUtils.isEmpty(classgrade.history.topScore)) {
				holder.historyLl.setVisibility(View.VISIBLE);
				holder.historyTopScore.setText(classgrade.history.topScore);
				holder.historyLowestScore
						.setText(classgrade.history.lowestScore);
				holder.historyAverageScore
						.setText(classgrade.history.averageScore);
			} else {
				holder.historyLl.setVisibility(View.GONE);
			}
			if (!TextUtils.isEmpty(classgrade.politics.topScore)) {
				holder.politicsLl.setVisibility(View.VISIBLE);
				holder.politicsTopScore.setText(classgrade.politics.topScore);
				holder.politicsLowestScore
						.setText(classgrade.politics.lowestScore);
				holder.politicsAverageScore
						.setText(classgrade.politics.averageScore);
			} else {
				holder.politicsLl.setVisibility(View.GONE);
			}
			// chinese math english physics chemistry biology geography history
			// politics
			setData(classgrade.politics.topScore,
					classgrade.politics.lowestScore,
					classgrade.politics.averageScore, holder.politicsLl,
					holder.politicsTopScore, holder.politicsLowestScore,
					holder.politicsAverageScore);

		}

	}

	private void setData(String topScore, String lowestScore,
			String averageScore, LinearLayout ll, TextView tvTop,
			TextView tvLowest, TextView tvAverage) {
		if (!TextUtils.isEmpty(topScore)) {
			ll.setVisibility(View.VISIBLE);
			tvTop.setText(topScore);
			tvLowest.setText(lowestScore);
			tvAverage.setText(averageScore);
		} else {
			ll.setVisibility(View.GONE);
		}

	}

	private void initHolderView(View convertView) {
		holder.chineseLl = (LinearLayout) convertView
				.findViewById(R.id.class_grade_chinese_ll);
		holder.mathLl = (LinearLayout) convertView
				.findViewById(R.id.class_grade_math_ll);
		holder.englishLl = (LinearLayout) convertView
				.findViewById(R.id.class_grade_english_ll);
		holder.physicsLl = (LinearLayout) convertView
				.findViewById(R.id.class_grade_physics_ll);
		holder.chemistryLl = (LinearLayout) convertView
				.findViewById(R.id.class_grade_chemistry_ll);
		holder.biologyLl = (LinearLayout) convertView
				.findViewById(R.id.class_grade_biology_ll);
		holder.geographyLl = (LinearLayout) convertView
				.findViewById(R.id.class_grade_geography_ll);
		holder.historyLl = (LinearLayout) convertView
				.findViewById(R.id.class_grade_history_ll);
		holder.politicsLl = (LinearLayout) convertView
				.findViewById(R.id.class_grade_politics_ll);
		holder.chineseTopScore = (TextView) convertView
				.findViewById(R.id.class_grade_chinese_tv_top_score);
		holder.chineseLowestScore = (TextView) convertView
				.findViewById(R.id.class_grade_chinese_tv_lowest_score);
		holder.chineseAverageScore = (TextView) convertView
				.findViewById(R.id.class_grade_chinese_tv_average_score);
		holder.mathTopScore = (TextView) convertView
				.findViewById(R.id.class_grade_math_tv_top_score);
		holder.mathLowestScore = (TextView) convertView
				.findViewById(R.id.class_grade_math_tv_lowest_score);
		holder.mathAverageScore = (TextView) convertView
				.findViewById(R.id.class_grade_math_tv_average_score);
		holder.englishTopScore = (TextView) convertView
				.findViewById(R.id.class_grade_english_tv_top_score);
		holder.englishLowestScore = (TextView) convertView
				.findViewById(R.id.class_grade_english_tv_lowest_score);
		holder.englishAverageScore = (TextView) convertView
				.findViewById(R.id.class_grade_english_tv_average_score);
		holder.physicsTopScore = (TextView) convertView
				.findViewById(R.id.class_grade_physics_tv_top_score);
		holder.physicsLowestScore = (TextView) convertView
				.findViewById(R.id.class_grade_physics_tv_lowest_score);
		holder.physicsAverageScore = (TextView) convertView
				.findViewById(R.id.class_grade_physics_tv_average_score);
		holder.chemistryTopScore = (TextView) convertView
				.findViewById(R.id.class_grade_chemistry_tv_top_score);
		holder.chemistryLowestScore = (TextView) convertView
				.findViewById(R.id.class_grade_chemistry_tv_lowest_score);
		holder.chemistryAverageScore = (TextView) convertView
				.findViewById(R.id.class_grade_chemistry_tv_average_score);
		holder.biologyTopScore = (TextView) convertView
				.findViewById(R.id.class_grade_biology_tv_top_score);
		holder.biologyLowestScore = (TextView) convertView
				.findViewById(R.id.class_grade_biology_tv_lowest_score);
		holder.biologyAverageScore = (TextView) convertView
				.findViewById(R.id.class_grade_biology_tv_average_score);
		holder.geographyTopScore = (TextView) convertView
				.findViewById(R.id.class_grade_geography_tv_top_score);
		holder.geographyLowestScore = (TextView) convertView
				.findViewById(R.id.class_grade_geography_tv_lowest_score);
		holder.geographyAverageScore = (TextView) convertView
				.findViewById(R.id.class_grade_geography_tv_average_score);
		holder.historyTopScore = (TextView) convertView
				.findViewById(R.id.class_grade_history_tv_top_score);
		holder.historyLowestScore = (TextView) convertView
				.findViewById(R.id.class_grade_history_tv_lowest_score);
		holder.historyAverageScore = (TextView) convertView
				.findViewById(R.id.class_grade_history_tv_average_score);
		holder.politicsTopScore = (TextView) convertView
				.findViewById(R.id.class_grade_politics_tv_top_score);
		holder.politicsLowestScore = (TextView) convertView
				.findViewById(R.id.class_grade_politics_tv_lowest_score);
		holder.politicsAverageScore = (TextView) convertView
				.findViewById(R.id.class_grade_politics_tv_average_score);
	}

	// chinese math english physics chemistry biology geography history
	// politics
	class ViewHolder {
		TextView dateTag;
		TextView date;
		LinearLayout chineseLl;
		TextView chineseTopScore;
		TextView chineseLowestScore;
		TextView chineseAverageScore;
		LinearLayout mathLl;
		TextView mathTopScore;
		TextView mathLowestScore;
		TextView mathAverageScore;
		LinearLayout englishLl;
		TextView englishTopScore;
		TextView englishLowestScore;
		TextView englishAverageScore;
		LinearLayout physicsLl;
		TextView physicsTopScore;
		TextView physicsLowestScore;
		TextView physicsAverageScore;
		LinearLayout chemistryLl;
		TextView chemistryTopScore;
		TextView chemistryLowestScore;
		TextView chemistryAverageScore;
		LinearLayout biologyLl;
		TextView biologyTopScore;
		TextView biologyLowestScore;
		TextView biologyAverageScore;
		LinearLayout geographyLl;
		TextView geographyTopScore;
		TextView geographyLowestScore;
		TextView geographyAverageScore;
		LinearLayout historyLl;
		TextView historyTopScore;
		TextView historyLowestScore;
		TextView historyAverageScore;
		LinearLayout politicsLl;
		TextView politicsTopScore;
		TextView politicsLowestScore;
		TextView politicsAverageScore;

	}

}
