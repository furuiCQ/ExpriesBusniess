package com.frain.expriesbusniess.fragment;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.mobileim.YWIMCore;
import com.alibaba.mobileim.channel.event.IWxCallback;
import com.alibaba.mobileim.conversation.IYWConversationListener;
import com.alibaba.mobileim.conversation.IYWConversationService;
import com.alibaba.mobileim.conversation.IYWConversationUnreadChangeListener;
import com.alibaba.mobileim.conversation.YWConversation;
import com.alibaba.mobileim.conversation.YWConversationBody;
import com.alibaba.mobileim.conversation.YWConversationType;
import com.alibaba.mobileim.conversation.YWMessage;
import com.alibaba.mobileim.conversation.YWMessageLoader;
import com.alibaba.mobileim.conversation.YWMessageSender;
import com.alibaba.mobileim.lib.model.message.Message;
import com.frain.expriesbusniess.R;
import com.frain.expriesbusniess.SuperApplication;
import com.frain.expriesbusniess.adapter.ChatListViewAdapter;
import com.frain.expriesbusniess.customView.ChatListView;

/**
 * 聊天界面
 * 
 * @author furui
 * 
 */
public class ChatFragment extends Fragment {

	ChatListView listView;
	ChatListViewAdapter adapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			 ViewGroup container,  Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View contentView = inflater.inflate(R.layout.fragment_chat, null);
		listView=(ChatListView)contentView.findViewById(R.id.chat_listview);
		getConverSationList();
		
		
		return contentView;
	}

	private void getConverSationList() {
		// TODO Auto-generated method stub
		IYWConversationService iywConversationService=SuperApplication.ywimCore.getConversationService();
		iywConversationService.addConversationListener(new IYWConversationListener() {
			
			@Override
			public void onItemUpdated() {
				// TODO Auto-generated method stub
			// 会话列表有变更，如果ISV开发者拿list来做ui展现用，可以直接调用BaseAdapter.notifyDataSetChanged()即可。
				adapter.notifyDataSetChanged();
			}
		});
		
		List<YWConversation> list=iywConversationService.getConversationList();
	//	Log.w("List size=====>", ""+list.size());
	//	list.add(arg0);
		adapter=new ChatListViewAdapter(getActivity().getApplicationContext(), list);
		
		listView.setAdapter(adapter);
	
	}
	
}
