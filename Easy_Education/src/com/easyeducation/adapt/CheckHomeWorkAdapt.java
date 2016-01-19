package com.easyeducation.adapt;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CheckHomeWorkAdapt extends FragmentPagerAdapter {

	private List<Fragment> fragments;
	private List<String> titles;

	public CheckHomeWorkAdapt(FragmentManager fm) {
		super(fm);
	}

	public CheckHomeWorkAdapt(FragmentManager fm, List<Fragment> fragments,
			List<String> titles) {
		super(fm);
		this.fragments = fragments;
		this.titles = titles;
	}

	@Override
	public Fragment getItem(int pos) {
		// TODO Auto-generated method stub
		return fragments.get(pos);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return null == fragments ? 0 : fragments.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		return titles.get(position);
	}

}
