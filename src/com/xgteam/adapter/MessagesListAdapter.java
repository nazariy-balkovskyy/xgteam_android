package com.xgteam.adapter;

import java.util.ArrayList;

import com.xgteam.data.MessageObject;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class MessagesListAdapter extends BaseAdapter{
	ArrayList<MessageObject> messages;
	@Override
	public int getCount() {
		return messages != null ? messages.size() : 0;
	}

	@Override
	public Object getItem(int position) {
		return messages != null ? messages.get(position) : null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		return null;
	}
	
}
