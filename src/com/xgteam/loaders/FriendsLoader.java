package com.xgteam.loaders;

import java.util.ArrayList;

import com.xgteam.adapter.FriendsListAdapter;
import com.xgteam.application.App;
import com.xgteam.data.FriendObject;
import com.xgteam.implement.FriendsWorkerTestImpl;

import android.os.AsyncTask;

public class FriendsLoader extends AsyncTask<String, Void, ArrayList<FriendObject>>{
	
	private FriendsListAdapter adapter;
	public FriendsLoader setAdapter(FriendsListAdapter adapter){
		this.adapter = adapter;
		return this;
	}
	
	@Override
	protected void onPostExecute(ArrayList<FriendObject> result) {   
		super.onPostExecute(result);
		this.adapter.setItems(result);
		this.adapter.notifyDataSetChanged();
	}
	@Override
	protected ArrayList<FriendObject> doInBackground(String... params) {
		// TODO Auto-generated method stub
		return (ArrayList<FriendObject>) App.getInstance().Friends().getUserFriends(Integer.valueOf(params[0]));
	}
	
}
