package com.frain.expriesbusniess;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.alibaba.mobileim.YWIMCore;
import com.alibaba.mobileim.channel.event.IWxCallback;
import com.alibaba.wxlib.util.SysUtil;
import com.frain.expriesbusniess.simple.IMLoginHelper;

public class SuperApplication extends Application {
	public static  YWIMCore ywimCore;

	private static Context sContext;

	public static Context getContext() {
		return sContext;
	}

	public final static String APP_KEY = "23248895";

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();

		sContext = getApplicationContext();

		// 必须首先执行这部分代码, 如果在":TCMSSevice"进程中，无需进行openIM和app业务的初始化，以节省内存
		SysUtil.setApplication(this);
		if (SysUtil.isTCMSServiceProcess(this)) {
			return;
		}

		ywimCore = IMLoginHelper.init(this);

		String userId = "test1";
		String password = "openim";

		IMLoginHelper.LoginAcount(userId, password, ywimCore, iWxCallback);

	}

	IWxCallback iWxCallback = new IWxCallback() {

		@Override
		public void onSuccess(Object... arg0) {
			// 登录成功
			Log.i("登陆成功", "");
		}

		@Override
		public void onProgress(int arg0) {
			// TODO Auto-generated method stub
			Log.i("登陆进度", "");

		}

		@Override
		public void onError(int errCode, String description) {
			// 如果登录失败，errCode为错误码,description是错误的具体描述信息
			Log.i("登陆失败", "" + errCode + "desciption:" + description);

		}
	};

}
