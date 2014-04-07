package com.xgteam.interfaces;

import java.util.List;

import com.xgteam.data.GroupObject;
import com.xgteam.data.UserObject;

public interface GroupsWorker {
	void setAccessToken(String accessToken);
	GroupObject get(int groupId,String accessToken);
	List<GroupObject> get(String accessToken);
	List<GroupObject> getUserGroups(int userId,String accessToken);
	List<GroupObject> getUserGroups(String accessToken);
	boolean subscribe(int groupId,String accessToken);
	boolean unsubscribe(int groupId,String accessToken);
}
