package com.xgteam.socialapp;

import java.util.ArrayList;

import com.xgteam.adapter.FriendsListAdapter;
import com.xgteam.application.App;
import com.xgteam.data.FriendObject;
import com.xgteam.loaders.FriendsLoader;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class FriendsListFragment extends Fragment{
	ArrayList<FriendObject> friends = new ArrayList<FriendObject>();
	FriendsListAdapter adapter;
	public FriendsListFragment(){
		super();
	}
	
	public FriendsListFragment setOnlineMode(){
		return this;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_friends_list, container,
				false);
		ListView listView = (ListView) rootView.findViewById(R.id.friends_list_view);
		adapter = new FriendsListAdapter(getActivity()
				.getApplicationContext(), friends);
		new FriendsLoader().setAdapter(adapter).execute(String.valueOf(App.getInstance().getUser().getId()));
		listView.setAdapter(adapter);
		return rootView;
	}
}
