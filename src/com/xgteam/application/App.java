package com.xgteam.application;

import android.widget.Toast;

import com.xgteam.data.UserObject;
import com.xgteam.implement.FriendsWorkerTestImpl;
import com.xgteam.implement.GroupsWorkerTestImpl;
import com.xgteam.implement.UserWorkerTestImpl;
import com.xgteam.interfaces.FriendsWorker;
import com.xgteam.interfaces.GroupsWorker;
import com.xgteam.interfaces.UserWorker;

public class App {
	private static App instance;
	private App(){ init();}
	public static App getInstance(){
		if(instance == null){
			instance = new App();
		}
		return instance;
	}
	private String login="admin";
	private String password="admin";
	private UserWorker _users;
	private FriendsWorker _friends;
	private GroupsWorker _groups;
	private UserObject User;
	private void init(){
		_users = new UserWorkerTestImpl();
		_friends = new FriendsWorkerTestImpl();
		_groups = new GroupsWorkerTestImpl();
		try {
			setUser(_users.login(login, password));
			_groups.setAccessToken(User.getToken());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Toast.makeText(null, "Error: "+e.getMessage(), Toast.LENGTH_LONG).show();
		}
	}
	public UserObject getUser() {
		return User;
	}
	private void setUser(UserObject user) {
		User = user;
	}
	public UserWorker Users() {
		return _users;
	}
	public FriendsWorker Friends(){
		return _friends;
	}
	public GroupsWorker Groups(){
		return _groups;
	}
	
	
}