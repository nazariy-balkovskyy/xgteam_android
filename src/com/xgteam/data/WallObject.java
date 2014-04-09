package com.xgteam.data;

import com.google.gson.annotations.SerializedName;
import com.xgteam.utils.ObjectConverter;

public class WallObject {
	@SerializedName("id_wall_post")
	private int id;
	
	@SerializedName("user")
	private UserObject user;
	
	@SerializedName("message")
	private String message;
	
	@SerializedName("created_at")
	private String createdAt;
	
	public WallObject(){}
	public WallObject(int id, UserObject user, String message, String createdAt,
			String picture) {
		super();
		this.setId(id);
		//this.setUser(ObjectConverter.convertToUserObject(user));
		this.setUser(user);
		this.setMessage(message);
		this.setCreatedAt(createdAt);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserObject getUser() {
		return user;
	}

	public void setUser(UserObject user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
}
