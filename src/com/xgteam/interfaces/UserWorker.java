package com.xgteam.interfaces;

import java.util.List;

import com.xgteam.data.UserObject;

public interface UserWorker {
	UserObject getUser(int userId,String accessToken);
	List<UserObject> getAll(String accessToken);
	UserObject login(String login, String password) throws Exception;
	UserObject logout(String accessToken) throws Exception;
}
