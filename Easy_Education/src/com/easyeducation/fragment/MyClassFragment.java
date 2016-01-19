package com.easyeducation.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.easyeducation.activity.ClassGradeActivity;
import com.easyeducation.activity.HomeworkActivity;
import com.easyeducation.activity.ShowHomeWorkActivity;
import com.easyeducation.adapt.ASkAdapt;
import com.easyeducation.bean.asks.ASK;
import com.easyeducation.util.CommonUtil;
import com.easyeducation.widget.pullrefreshview.PullToRefreshBase;
import com.easyeducation.widget.pullrefreshview.PullToRefreshBase.OnRefreshListener;
import com.easyeducation.widget.pullrefreshview.PullToRefreshListView;
import com.hwd.cw.test.R;

public class MyClassFragment extends Fragment implements OnClickListener {

	private View view;
	private LinearLayout functionLLPublishProblem;
	private LinearLayout functionLLClassGrade;
	private LinearLayout functionLLCheckHomework;
	private PullToRefreshListView ptrlv;
	private ListView lv;
	private boolean isTeacher = false;

	public static MyClassFragment newInstance() {
		MyClassFragment myClassFragment = new MyClassFragment();
		return myClassFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_my_class, null);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initView();
		// TODO 初始化当前登陆用户是否是老师
		// isTeacher = ...

	}

	private void initView() {
		functionLLPublishProblem = (LinearLayout) view
				.findViewById(R.id.my_class_function_ll_publish_problem);
		functionLLClassGrade = (LinearLayout) view
				.findViewById(R.id.my_class_function_ll_class_grade);
		functionLLCheckHomework = (LinearLayout) view
				.findViewById(R.id.my_class_function_ll_check_homework);
		ptrlv = (PullToRefreshListView) view.findViewById(R.id.my_class_lv_ask);
		ptrlv.setPullLoadEnabled(true);
		ptrlv.setScrollLoadEnabled(false);
		ptrlv.setPullRefreshEnabled(true);
		ptrlv.setLastUpdatedLabel(CommonUtil.getStringDate());
		ptrlv.getRefreshableView().setOnItemClickListener(onItemClickListener);
		ptrlv.setOnRefreshListener(onRefreshListener);
		ptrlv.getRefreshableView().setAdapter(
				new ASkAdapt(ASK.asksList(), getActivity()));
		functionLLPublishProblem.setOnClickListener(this);
		functionLLClassGrade.setOnClickListener(this);
		functionLLCheckHomework.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.my_class_function_ll_publish_problem:

			break;
		case R.id.my_class_function_ll_class_grade:
			startActivity(new Intent(getActivity(), ClassGradeActivity.class));
			break;
		case R.id.my_class_function_ll_check_homework:
			if (isTeacher) {
				startActivity(new Intent(getActivity(),
						ShowHomeWorkActivity.class).putExtra("fragment",
						"HomeWorkToSee"));
			} else {
				startActivity(new Intent(getActivity(), HomeworkActivity.class));
			}
			break;
		}
	}

	OnItemClickListener onItemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View v, int pos, long id) {

		}

	};

	OnRefreshListener<ListView> onRefreshListener = new OnRefreshListener<ListView>() {

		@Override
		public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

		}

		@Override
		public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

		}
	};
}
