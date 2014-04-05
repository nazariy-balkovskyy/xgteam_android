package com.xgteam.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Friend {
	private static int friendsCount;

	public static int getFriendsCount() {
		switch(User.getId()){
			case 1:{
				friendsCount=175;
				break;
			}
			case 2:{
				friendsCount=200;
				break;
			}
			default:{
				friendsCount=0;
				break;
			}
		}
		return friendsCount;
	}

	public static void setFriendsCount(int friendsCount) {
		Friend.friendsCount = friendsCount;
	}
	
}
