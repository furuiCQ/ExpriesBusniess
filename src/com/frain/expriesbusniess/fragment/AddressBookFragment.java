package com.frain.expriesbusniess.fragment;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alibaba.mobileim.YWIMKit;
import com.alibaba.mobileim.lib.model.contact.Contact;
import com.alibaba.mobileim.lib.presenter.contact.IContactManager;
import com.frain.expriesbusniess.R;
import com.frain.expriesbusniess.SuperApplication;
import com.frain.expriesbusniess.adapter.ContactListViewAdapter;

/**
 * 通讯录界面
 * 
 * @author furui
 * 
 */


public class AddressBookFragment extends Fragment {

	YWIMKit ywimKit;
	ListView listView;
	
	
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		// TODO Auto-generated method stub
//		super.onCreate(savedInstanceState);
//	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			 ViewGroup container,  Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View contentView = inflater.inflate(R.layout.fragment_address_book, null);
		listView=(ListView)contentView.findViewById(R.id.contact_listvew);
		
		getContactList();
		
		
		return contentView;
	}

	private void getContactList() {
		// TODO Auto-generated method stub
		IContactManager contactManager = SuperApplication.ywimCore.getWXContactManager();
        List <Contact> contacts = contactManager.getContacts(IContactManager.TYPE_FRIEND);
   // 	Log.w("List size=====>", ""+contacts.size());

        ContactListViewAdapter adapter=new ContactListViewAdapter(getActivity().getApplicationContext(), contacts);
        
        listView.setAdapter(adapter);
	}
}
