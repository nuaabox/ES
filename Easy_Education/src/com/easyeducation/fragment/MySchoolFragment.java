package com.easyeducation.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.easyeducation.activity.MySyllabusActivity;
import com.hwd.cw.test.R;

public class MySchoolFragment extends Fragment implements OnClickListener {

	private View view;
	private RelativeLayout schoolRlSafePassageway;

	public static MySchoolFragment newInstance() {
		MySchoolFragment myClassFragment = new MySchoolFragment();
		return myClassFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_my_school, null);
		schoolRlSafePassageway = (RelativeLayout) view
				.findViewById(R.id.school_rl_safe_passageway);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initViewData();

	}

	private void initViewData() {
		schoolRlSafePassageway.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getActivity().startActivity(
						new Intent(getActivity(), MySyllabusActivity.class));
			}
		});
	}

	@Override
	public void onClick(View v) {
	}
}
