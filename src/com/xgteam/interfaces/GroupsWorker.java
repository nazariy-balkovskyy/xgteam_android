package com.xgteam.interfaces;

import java.util.List;

import com.xgteam.data.GroupObject;
import com.xgteam.data.UserObject;

public interface GroupsWorker {
	List<GroupObject> getUserGroups(int userId);
	List<UserObject> getMembers(int groupId);
	boolean subscribeGroup(int groupId);
	boolean unsubscribeGroup(int groupId);
}
