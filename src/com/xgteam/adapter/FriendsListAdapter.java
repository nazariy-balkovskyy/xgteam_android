package com.xgteam.adapter;

import java.util.ArrayList;

import com.xgteam.data.FriendObject;
import com.xgteam.socialapp.R;
import com.xgteam.utils.DownloadImageTask;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FriendsListAdapter extends BaseAdapter {
	Context context;
	ArrayList<FriendObject> items;

	public FriendsListAdapter(Context context,ArrayList<FriendObject> items){
		this.context = context;
		this.items = items;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			LayoutInflater mInflater = (LayoutInflater) context
					.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView = mInflater.inflate(R.layout.friend_item, null);
		}
		((TextView) convertView.findViewById(R.id.friend_name)).setText(String
				.format("%s %s", items.get(position).getFirstName(),
						items.get(position).getLastName()));
		((TextView) convertView.findViewById(R.id.friend_online_status))
				.setText(items.get(position).isOnline() ? "online" : "");
		new DownloadImageTask(
				((ImageView) convertView.findViewById(R.id.friend_image)))
				.execute(items.get(position).getPicture());
		return convertView;
	}
	
	public void setItems(ArrayList<FriendObject> items){
		this.items = items;
	}
}
