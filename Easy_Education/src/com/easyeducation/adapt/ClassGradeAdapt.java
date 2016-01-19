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

public class ClassGradeAdapt extends BaseAdapter {
	private Activity activity;
	private ArrayList<Classgrade> datas;
	private ViewHolder holder;

	public ClassGradeAdapt(Activity activity, ArrayList<Classgrade> datas) {
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
		initViewData(classgrade, holder);
		// TODO Auto-generated method stub
		return convertView;
	}

	private void initViewData(Classgrade classgrade, ViewHolder holder) {
		if (null != classgrade) {
			// chinese math english physics chemistry biology geography history
			// politics
			setData(classgrade.chinese.topScore,
					classgrade.chinese.lowestScore,
					classgrade.chinese.averageScore, holder.chineseLl,
					holder.chineseTopScore, holder.chineseLowestScore,
					holder.chineseAverageScore);
			setData(classgrade.math.topScore, classgrade.math.lowestScore,
					classgrade.math.averageScore, holder.mathLl,
					holder.mathTopScore, holder.mathLowestScore,
					holder.mathAverageScore);
			setData(classgrade.english.topScore,
					classgrade.english.lowestScore,
					classgrade.english.averageScore, holder.englishLl,
					holder.englishTopScore, holder.englishLowestScore,
					holder.englishAverageScore);
			setData(classgrade.physics.topScore,
					classgrade.physics.lowestScore,
					classgrade.physics.averageScore, holder.physicsLl,
					holder.physicsTopScore, holder.physicsLowestScore,
					holder.physicsAverageScore);
			setData(classgrade.chemistry.topScore,
					classgrade.chemistry.lowestScore,
					classgrade.chemistry.averageScore, holder.chemistryLl,
					holder.chemistryTopScore, holder.chemistryLowestScore,
					holder.chemistryAverageScore);
			setData(classgrade.biology.topScore,
					classgrade.biology.lowestScore,
					classgrade.biology.averageScore, holder.biologyLl,
					holder.biologyTopScore, holder.biologyLowestScore,
					holder.biologyAverageScore);
			setData(classgrade.geography.topScore,
					classgrade.geography.lowestScore,
					classgrade.geography.averageScore, holder.geographyLl,
					holder.geographyTopScore, holder.geographyLowestScore,
					holder.geographyAverageScore);
			setData(classgrade.history.topScore,
					classgrade.history.lowestScore,
					classgrade.history.averageScore, holder.historyLl,
					holder.historyTopScore, holder.historyLowestScore,
					holder.historyAverageScore);
			setData(classgrade.politics.topScore,
					classgrade.politics.lowestScore,
					classgrade.politics.averageScore, holder.politicsLl,
					holder.politicsTopScore, holder.politicsLowestScore,
					holder.politicsAverageScore);
			setData(classgrade.total.topScore, classgrade.total.lowestScore,
					classgrade.total.averageScore, holder.totalLl,
					holder.totalTopScore, holder.totalLowestScore,
					holder.totalAverageScore);
			holder.date.setText(classgrade.data);
			holder.dateTag.setText(classgrade.dataTag);
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
		holder.date = (TextView) convertView
				.findViewById(R.id.class_grade_date_tv);
		holder.dateTag = (TextView) convertView
				.findViewById(R.id.class_grade_date_tv_tag);
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
		holder.totalLl = (LinearLayout) convertView
				.findViewById(R.id.class_grade_total_ll);
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
		holder.totalTopScore = (TextView) convertView
				.findViewById(R.id.class_grade_total_tv_top_score);
		holder.totalLowestScore = (TextView) convertView
				.findViewById(R.id.class_grade_total_tv_lowest_score);
		holder.totalAverageScore = (TextView) convertView
				.findViewById(R.id.class_grade_total_tv_average_score);
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
		LinearLayout totalLl;
		TextView totalTopScore;
		TextView totalLowestScore;
		TextView totalAverageScore;

	}

}
