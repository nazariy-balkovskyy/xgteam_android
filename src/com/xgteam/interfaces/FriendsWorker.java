package com.xgteam.interfaces;

import java.util.List;

import com.xgteam.data.FriendObject;

public interface FriendsWorker {
	List<FriendObject> getUserFriends(int userId);
	boolean addFriend(int userId);
	boolean removeFriend(int userId);
}
