package com.frain.expriesbusniess.customView;

import com.frain.expriesbusniess.R;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BotoomMenuItem extends LinearLayout {



	TextView iconTextView;
	TextView contentTextView;
	
	public BotoomMenuItem(Context context) {
		super(context);
		initSubView(context);

		// TODO Auto-generated constructor stub
	}

	public BotoomMenuItem(Context context, AttributeSet attrs) {
		super(context, attrs);
		initSubView(context);

		// TODO Auto-generated constructor stub
	}
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public BotoomMenuItem(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initSubView(context);

		// TODO Auto-generated constructor stub
	}
	
	

	public void initSubView(Context context) {
		View subview = LayoutInflater.from(context).inflate(
				R.layout.view_menu_item, null);
		iconTextView = (TextView)subview.findViewById(R.id.menu_icon);
		contentTextView = (TextView)subview.findViewById(R.id.menu_txt);

		setBackgroundColor(getResources().getColor(android.R.color.white));
		setGravity(Gravity.CENTER);
		addView(subview);
	}

	public void setIcon(String text) {
		iconTextView.setText(text);

	}

	public void setContent(String text) {
		contentTextView.setText(text);
	}

	public void setSelect() {
		iconTextView.setTextColor(getResources().getColor(R.color.red));
		contentTextView.setTextColor(getResources().getColor(R.color.red));

	}

	public void setUnSelect() {
		iconTextView.setTextColor(getResources().getColor(R.color.gray));
		contentTextView.setTextColor(getResources().getColor(R.color.gray));
	}
}
