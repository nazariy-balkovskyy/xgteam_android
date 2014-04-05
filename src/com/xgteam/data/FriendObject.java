package com.xgteam.data;

import com.google.gson.annotations.SerializedName;

public class FriendObject {
	@SerializedName("id_user")
	private int id;
	@SerializedName("first_name")
	private String firstName;
	@SerializedName("last_name")
	private String lastName;
	@SerializedName("online_state")
	private boolean isOnline;
	@SerializedName("picture")
	private String picture;
	
	public FriendObject(int id, String firstName, String lastName,
			boolean isOnline, String picture) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isOnline = isOnline;
		this.picture = picture;
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
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
}
