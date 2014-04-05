package com.xgteam.data;

import com.google.gson.annotations.SerializedName;

public class UserObject {
	@SerializedName("id_user")
	private int id;
	
	@SerializedName("first_name")
	private String firstName;
	
	@SerializedName("last_name")
	private String lastName;
	
	@SerializedName("online_state")
	private boolean isOnline;
	
	@SerializedName("access_token")
	private String token;
	
	@SerializedName("picture")
	private String picture;
	
	private int friendsCount;
	private int groupsCount;
	private boolean isRootUser;
	
	public UserObject(int id, String firstName, String lastName,
			boolean isOnline, String token, int friendsCount, int groupsCount,
			String picture, boolean isRootUser) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isOnline = isOnline;
		this.token = token;
		this.friendsCount = friendsCount;
		this.groupsCount = groupsCount;
		this.picture = picture;
		this.isRootUser = isRootUser;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isOnline() {
		return isOnline;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
	public String getGetToken() {
		return token;
	}
	public void setGetToken(String getToken) {
		this.token = getToken;
	}
	public int getUserCount() {
		return friendsCount;
	}
	public void setUserCount(int userCount) {
		this.friendsCount = userCount;
	}
	public int getGroupsCount() {
		return groupsCount;
	}
	public void setGroupsCount(int groupsCount) {
		this.groupsCount = groupsCount;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public boolean isRootUser() {
		return isRootUser;
	}
	public void setRootUser(boolean isRootUser) {
		this.isRootUser = isRootUser;
	}
}
