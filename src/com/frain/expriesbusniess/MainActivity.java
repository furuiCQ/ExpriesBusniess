package com.frain.expriesbusniess;

import java.util.ArrayList;
import java.util.List;

import com.frain.expriesbusniess.customView.BotoomMenuItem;
import com.frain.expriesbusniess.fragment.AddressBookFragment;
import com.frain.expriesbusniess.fragment.ChatFragment;
import com.frain.expriesbusniess.fragment.DiscoverFragment;
import com.frain.expriesbusniess.fragment.MineFragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends FragmentActivity {
	ChatFragment chatFragment;
	AddressBookFragment addressBookFragment;
	DiscoverFragment discoverFragment;
	MineFragment mineFragment;
	
	ArrayList<Fragment> fragments=new ArrayList<Fragment>();

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
	/**
	 * 初始化子view
	 */
	public void initSubView() {
		viewPager = (ViewPager) findViewById(R.id.viewpager);

		ChatBtn = (BotoomMenuItem) findViewById(R.id.chat_btn);
		AddrBtn = (BotoomMenuItem) findViewById(R.id.address_btn);
		DiscBtn = (BotoomMenuItem) findViewById(R.id.discover_btn);
		MineBtn = (BotoomMenuItem) findViewById(R.id.mine_btn);

		ChatBtn.setOnClickListener(clickListener);
		AddrBtn.setOnClickListener(clickListener);
		DiscBtn.setOnClickListener(clickListener);
		MineBtn.setOnClickListener(clickListener);
		
		
		chatFragment=new ChatFragment();
		addressBookFragment=new AddressBookFragment();
		discoverFragment=new DiscoverFragment();
		mineFragment=new MineFragment();
		//设置不显示时不加载数据
		addressBookFragment.setUserVisibleHint(false);
		discoverFragment.setUserVisibleHint(false);
		mineFragment.setUserVisibleHint(false);
		
		fragments.add(chatFragment);
		fragments.add(addressBookFragment);
		fragments.add(discoverFragment);
		fragments.add(mineFragment);
		
		viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return fragments.size();
			}
			
			@Override
			public Fragment getItem(int arg0) {
				// TODO Auto-generated method stub
				return fragments.get(arg0);
			}
		});
		viewPager.setOnPageChangeListener(pageChangeListener);
		viewPager.setCurrentItem(0);
		
	}
	
	
	OnPageChangeListener pageChangeListener=new OnPageChangeListener() {
		
		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			switch (arg0) {
			case 0:
				
				break;
			case 1:
				
				break;
			case 2:
				
				break;
				
			default:
				break;
			}
		}
		
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}
	};
	
	
	OnClickListener clickListener=new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.chat_btn:
				
				break;
			case R.id.address_btn:
				
				break;
			case R.id.discover_btn:
				
				break;
			case R.id.mine_btn:
				
				break;

			default:
				break;
			}
		}
	};

}
