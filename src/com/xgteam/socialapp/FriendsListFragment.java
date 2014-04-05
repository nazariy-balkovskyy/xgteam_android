package com.xgteam.socialapp;

import java.util.ArrayList;

import com.xgteam.adapter.FriendsListAdapter;
import com.xgteam.model.FriendItem;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class FriendsListFragment extends Fragment{
	ArrayList<FriendItem> friends = new ArrayList<FriendItem>();
	public FriendsListFragment(){
		super();
		friends.add(new FriendItem(1,"Nazar","Balkovsky",true,"http://cghub.com/outgoing/presskit/CGHUB_50x50_botCG.gif"));
		friends.add(new FriendItem(2,"Andrew","Dubitskyy",true,"http://bingbangstudios.com/press/fork/fork_icon50x50.jpg"));
		friends.add(new FriendItem(3,"Nazar","Ivashiv",true,"http://cghub.com/outgoing/presskit/CGHUB_50x50_botCG.gif"));
		friends.add(new FriendItem(4,"Nazar","Balkovsky",false,"http://bingbangstudios.com/press/fork/fork_icon50x50.jpg"));
		friends.add(new FriendItem(5,"Andrew","Dubitskyy",false,"http://cghub.com/outgoing/presskit/CGHUB_50x50_botCG.gif"));
		friends.add(new FriendItem(6,"Nazar","Ivashiv",false,"http://cghub.com/outgoing/presskit/CGHUB_50x50_botCG.gif"));
		friends.add(new FriendItem(7,"Nazar","Balkovsky",false,"http://bingbangstudios.com/press/fork/fork_icon50x50.jpg"));
		friends.add(new FriendItem(8,"Andrew","Dubitskyy",false,"http://cghub.com/outgoing/presskit/CGHUB_50x50_botCG.gif"));
		friends.add(new FriendItem(9,"Nazar","Ivashiv",false,"http://bingbangstudios.com/press/fork/fork_icon50x50.jpg"));
		friends.add(new FriendItem(10,"Nazar","Balkovsky",false,"http://cghub.com/outgoing/presskit/CGHUB_50x50_botCG.gif"));
		friends.add(new FriendItem(11,"Andrew","Dubitskyy",false,"http://cghub.com/outgoing/presskit/CGHUB_50x50_botCG.gif"));
		friends.add(new FriendItem(12,"Nazar","Ivashiv",false,"http://cghub.com/outgoing/presskit/CGHUB_50x50_botCG.gif"));
	}
	
	public FriendsListFragment setOnlineMode(){
		friends.clear();
		friends.add(new FriendItem(1,"Nazar","Balkovsky",true,"http://cghub.com/outgoing/presskit/CGHUB_50x50_botCG.gif"));
		friends.add(new FriendItem(2,"Andrew","Dubitskyy",true,"http://cghub.com/outgoing/presskit/CGHUB_50x50_botCG.gif"));
		friends.add(new FriendItem(3,"Nazar","Ivashiv",true,"http://cghub.com/outgoing/presskit/CGHUB_50x50_botCG.gif"));
		return this;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_friends_list, container,
				false);
		ListView listView = (ListView) rootView.findViewById(R.id.friends_list_view);
		FriendsListAdapter adapter = new FriendsListAdapter(getActivity()
				.getApplicationContext(), friends);
		listView.setAdapter(adapter);
		return rootView;
	}
}
