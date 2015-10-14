package com.frain.expriesbusniess;

import com.frain.expriesbusniess.customView.BotoomMenuItem;
import com.frain.expriesbusniess.fragment.AddressBookFragment;
import com.frain.expriesbusniess.fragment.ChatFragment;
import com.frain.expriesbusniess.fragment.DiscoverFragment;
import com.frain.expriesbusniess.fragment.MineFragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

public class MainActivity extends Activity {
	ChatFragment chatFragment;
	AddressBookFragment addressBookFragment;
	DiscoverFragment discoverFragment;
	MineFragment mineFragment;

	BotoomMenuItem ChatBtn;
	BotoomMenuItem AddrBtn;
	BotoomMenuItem DiscBtn;
	BotoomMenuItem MineBtn;

	ViewPager viewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initSubView();

	}

	public void initSubView() {
		viewPager = (ViewPager) findViewById(R.id.viewpager);

		ChatBtn = (BotoomMenuItem) findViewById(R.id.chat_btn);
		AddrBtn = (BotoomMenuItem) findViewById(R.id.address_btn);
		DiscBtn = (BotoomMenuItem) findViewById(R.id.discover_btn);
		MineBtn = (BotoomMenuItem) findViewById(R.id.mine_btn);

	}

}
