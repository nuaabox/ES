package com.easyeducation.application;

import io.rong.imkit.RongIM;
import cn.smssdk.SMSSDK;
import android.app.Application;

public class EasyEducationApplication extends Application {
	private static EasyEducationApplication application = null;

	public static EasyEducationApplication getInstance() {
		return application;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		application = this;

		try {
			RongIM.init(this);
			SMSSDK.initSDK(this, "ae76b1166d70",
					"8f9bad769ce69be6b0cc2205dc452fda");
		} catch (Exception x) {
			x.printStackTrace();
		}
	}
}
