package com.xgteam.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.xgteam.data.FriendObject;
import com.xgteam.data.GroupObject;
import com.xgteam.data.UserObject;
import com.xgteam.data.WallObject;

public class ObjectConverter {
	public static UserObject convertToUserObject(String json){
		return new Gson().fromJson(json, UserObject.class);
	}
	
	public static FriendObject convertToFriendObject(String json){
		return new Gson().fromJson(json, FriendObject.class);
	}
	
	public static GroupObject convertToGroupObject(String json){
		return new Gson().fromJson(json, GroupObject.class);
	}
	
	public static WallObject convertToWallObject(String json){
		return new Gson().fromJson(json, WallObject.class);
	}
	
	public static UserObject convertToUserObject(JsonElement json){
		return new Gson().fromJson(json, UserObject.class);
	}
	
	public static FriendObject convertToFriendObject(JsonElement json){
		return new Gson().fromJson(json, FriendObject.class);
	}
	
	public static GroupObject convertToGroupObject(JsonElement json){
		return new Gson().fromJson(json, GroupObject.class);
	}
	
	public static WallObject convertToWallObject(JsonElement json){
		return new Gson().fromJson(json, WallObject.class);
	}
}
