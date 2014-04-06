package com.xgteam.implement;

import java.util.List;

import com.xgteam.data.GroupObject;
import com.xgteam.data.UserObject;
import com.xgteam.interfaces.GroupsWorker;

public class GroupsWorkerTestImpl implements GroupsWorker {
	
	@Override
	public List<GroupObject> getUserGroups(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserObject> getMembers(int groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean subscribeGroup(int groupId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unsubscribeGroup(int groupId) {
		// TODO Auto-generated method stub
		return false;
	}

}
