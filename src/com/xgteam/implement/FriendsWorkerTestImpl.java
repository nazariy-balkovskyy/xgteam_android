package com.xgteam.implement;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import com.xgteam.application.App;
import com.xgteam.data.FriendObject;
import com.xgteam.interfaces.FriendsWorker;
import com.xgteam.utils.ObjectConverter;
import com.xgteam.utils.Request;

public class FriendsWorkerTestImpl implements FriendsWorker {

	@Override
	public List<FriendObject> getUserFriends(int userId) {
		// TODO Auto-generated method stub
		List<FriendObject> users = new ArrayList<FriendObject>();
		try {
			String response = Request
					.sendGet(String
							.format("http://mob.xgenteam.com/friends/get.json?uid=%s&access_token=%s",
									userId, App.getInstance().getUser()
											.getGetToken()));
			JSONObject jObject = new JSONObject(response);
			int success = jObject.getInt("success");
			if (success > 0) {
				JSONArray jArray = jObject.getJSONArray("users");
				int jArrayLength = jArray.length();
				for (int i = 0; i < jArrayLength; i++) {
					FriendObject user = ObjectConverter
							.convertToFriendObject(jObject.getJSONObject("user")
									.toString());
					users.add(user);
					
				}
			}
			return users;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return users;
		}
	}

	@Override
	public boolean addFriend(int userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeFriend(int userId) {
		// TODO Auto-generated method stub
		return false;
	}

}
