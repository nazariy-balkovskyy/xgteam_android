package com.xgteam.data;

public class GroupObject {
	private int id; 
	private String name;
	private String type;
	private int membersCount;
	private String picture;
	public GroupObject(int id, String name, String type, int membersCount,
			String picture) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.membersCount = membersCount;
		this.picture = picture;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getMembersCount() {
		return membersCount;
	}
	public void setMembersCount(int membersCount) {
		this.membersCount = membersCount;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
