package com.easyeducation.fragment;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.easyeducation.adapt.ClassAssignmentAdapt;
import com.easyeducation.bean.classassignment.ClassAssignment;
import com.easyeducation.bean.classassignment.ClassAssignments;
import com.easyeducation.util.CommonUtil;
import com.easyeducation.widget.pullrefreshview.PullToRefreshListView;
import com.hwd.cw.test.R;

public class CopyOfClassAssignmentsFragment extends Fragment {

	private View view;
	private PullToRefreshListView ptrlv;
	private List<ClassAssignment> dataList;
	private ClassAssignmentAdapt adapt;

	public static CopyOfClassAssignmentsFragment newInstance() {
		CopyOfClassAssignmentsFragment fragment = new CopyOfClassAssignmentsFragment();
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_classassignments, null);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initView();
	}

	private void initView() {
		ptrlv = (PullToRefreshListView) view
				.findViewById(R.id.class_assignments_lv);
		ptrlv.setPullLoadEnabled(false);
		ptrlv.setScrollLoadEnabled(false);
		ptrlv.setPullRefreshEnabled(false);
		ptrlv.setLastUpdatedLabel(CommonUtil.getStringDate());
		// ptrlv.getRefreshableView().setOnItemClickListener(onItemClickListener);
		// ptrlv.setOnRefreshListener(onRefreshListener);
		dataList = ClassAssignments.classAssignments();
		adapt = new ClassAssignmentAdapt(getActivity(), dataList, false);
		ptrlv.getRefreshableView().setAdapter(adapt);

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (Activity.RESULT_OK == resultCode) {
			if (1 == requestCode) {
				String course = data.getStringExtra("Course");
				String content = data.getStringExtra("Content");
				if ("语文".equals(course)) {
					dataList.get(0).chinese.assignmentContent = content;
				}
				if ("数学".equals(course)) {
					dataList.get(0).math.assignmentContent = content;
				}
				if ("英语".equals(course)) {
					dataList.get(0).english.assignmentContent = content;
				}
				if ("物理".equals(course)) {
					dataList.get(0).physics.assignmentContent = content;
				}
				if ("化学".equals(course)) {
					dataList.get(0).chemistry.assignmentContent = content;
				}
				if ("生物".equals(course)) {
					dataList.get(0).biology.assignmentContent = content;
				}
				if ("地理".equals(course)) {
					dataList.get(0).geography.assignmentContent = content;
				}
				if ("历史".equals(course)) {
					dataList.get(0).history.assignmentContent = content;
				}
				if ("政治".equals(course)) {
					dataList.get(0).politics.assignmentContent = content;
				}
				adapt.setData(dataList);
			}
		}
	}
}
