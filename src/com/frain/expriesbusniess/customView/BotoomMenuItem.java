package com.frain.expriesbusniess.customView;

import com.frain.expriesbusniess.R;

import android.content.Context;
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

	public void initSubView(Context context) {
		View subview = LayoutInflater.from(context).inflate(
				R.layout.view_menu_item, null);
		iconTextView = (TextView) findViewById(R.id.menu_icon);
		contentTextView = (TextView) findViewById(R.id.menu_txt);
		
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

}
