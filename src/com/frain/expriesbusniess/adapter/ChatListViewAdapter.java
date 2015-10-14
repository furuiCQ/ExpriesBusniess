package com.frain.expriesbusniess.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.frain.expriesbusniess.R;

public class ChatListViewAdapter extends BaseAdapter {
	List<String> DataList;
	Context context;

	public ChatListViewAdapter(Context c, List<String> list) {
		DataList = list;
		context = c;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return DataList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return DataList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View converView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHolder holder=new ViewHolder();
		if (converView == null) {
			LayoutInflater inflater = LayoutInflater.from(context);
			converView = inflater.inflate(R.layout.chatlistvew_item, null);
			holder.iconView=(ImageView)converView.findViewById(R.id.item_icon);
			holder.nameView=(TextView)converView.findViewById(R.id.item_name);
			holder.contentView=(TextView)converView.findViewById(R.id.item_content);
			holder.timeView=(TextView)converView.findViewById(R.id.item_time);
			holder.ringView=(TextView)converView.findViewById(R.id.item_ring);
			
			converView.setTag(holder);
			
		}else{
			holder=(ViewHolder)converView.getTag();
		}

		return converView;
	}

	private class ViewHolder {
		ImageView iconView;
		TextView nameView;
		TextView contentView;
		TextView timeView;
		TextView ringView;
	}

}
