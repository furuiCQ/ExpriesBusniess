package com.frain.expriesbusniess.simple;

import android.app.Application;
import android.util.Log;

import com.alibaba.mobileim.IYWLoginService;
import com.alibaba.mobileim.IYWPushListener;
import com.alibaba.mobileim.YWAPI;
import com.alibaba.mobileim.YWIMCore;
import com.alibaba.mobileim.YWLoginParam;
import com.alibaba.mobileim.channel.event.IWxCallback;
import com.alibaba.mobileim.contact.IYWContact;
import com.alibaba.mobileim.conversation.IYWConversationUnreadChangeListener;
import com.alibaba.mobileim.conversation.YWConversation;
import com.alibaba.mobileim.conversation.YWMessage;
import com.alibaba.mobileim.gingko.model.tribe.YWTribe;
import com.alibaba.mobileim.login.IYWConnectionListener;
import com.frain.expriesbusniess.SuperApplication;
/**
 * IM登陆插件
 * @author furui
 *
 */
public class IMLoginHelper {


	public static YWIMCore init(Application application) {

		YWAPI.init(application, SuperApplication.APP_KEY);

		final YWIMCore imCore = YWAPI.createIMCore();

		imCore.addConnectionListener(new IYWConnectionListener() {

			@Override
			public void onReConnecting() {
				// TODO Auto-generated method stub
				// 重新登陆
				Log.i("IYWConnectionListener", "重新登录");
			}

			@Override
			public void onReConnected() {
				// TODO Auto-generated method stub
				// 登陆成功
				Log.i("IYWConnectionListener", "登陆成功");

			}

			@Override
			public void onDisconnect(int arg0, String arg1) {
				// TODO Auto-generated method stub
				// 掉线
				Log.i("IYWConnectionListener", "已掉线");

			}
		});

		imCore.getConversationService().addPushListener(new IYWPushListener() {
			@Override
			// 收到单聊消息时会回调该方法，开发者可以在该方法内更新该会话的未读数
			public void onPushMessage(IYWContact arg0, YWMessage arg1) {
				// 单聊消息
				YWConversation conversation = imCore.getConversationService()
						.getConversationByUserId(arg0.getUserId());
				int unreadCount = conversation.getUnreadCount();
				// TODO 更新UI上该会话未读数
				Log.i("单聊消息会话未读数:", "" + unreadCount);

			}

			@Override
			// 收到群聊消息时会回调该方法，开发者可以在该方法内更新该会话的未读数
			public void onPushMessage(YWTribe arg0, YWMessage arg1) {
				// 群消息
				YWConversation conversation = imCore.getConversationService()
						.getTribeConversation(arg0.getTribeId());
				int unreadCount = conversation.getUnreadCount();
				// TODO 更新UI上该会话未读数
				Log.i("群消息会话未读数:", "" + unreadCount);

			}
		});

		// 注册消息未读总数监听
		imCore.getConversationService().addTotalUnreadChangeListener(
				new IYWConversationUnreadChangeListener() {
					@Override
					// 当前登录账号的未读消息总数发送变化时会回调该方法，用户可以再该方法中更新UI的未读数
					public void onUnreadChange() {
						int totalUnreadCount = imCore.getConversationService()
								.getAllUnreadCount();
						// TODO 更新UI的未读数
						Log.i("账号的未读消息总数:", "" + totalUnreadCount);

					}
				});
		
		
		return imCore;
	}
	
	public static void LoginAcount(String userId,String password,YWIMCore ywimCore,IWxCallback wxCallback){
		IYWLoginService loginService = ywimCore.getLoginService();
		YWLoginParam Param = YWLoginParam.createLoginParam(userId, password,SuperApplication.APP_KEY);
//		loginService.login(Param, new IWxCallback() {
//		 
//		    @Override
//		    public void onSuccess(Object... arg0) {
//		        //登录成功
//		    	Log.i("登陆成功", "");
//		    }
//		 
//		    @Override
//		    public void onProgress(int arg0) {
//		       // TODO Auto-generated method stub
//		    	Log.i("登陆进度", "");
//
//		    }
//		 
//		    @Override
//		    public void onError(int errCode, String description) {
//		       //如果登录失败，errCode为错误码,description是错误的具体描述信息
//		    	Log.i("登陆失败", ""+errCode+"desciption:"+description);
//
//		    }
//		});
		loginService.login(Param, wxCallback);
	}
}
