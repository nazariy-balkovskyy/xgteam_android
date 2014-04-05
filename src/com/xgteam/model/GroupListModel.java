package com.xgteam.model;

public class GroupListModel {
	private int id=0;
	private  String name="";
    private  String image="";
    private boolean isSubscribed=false;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public boolean isSubscribed() {
		return isSubscribed;
	}
	public void setSubscribed(boolean isSubscribed) {
		this.isSubscribed = isSubscribed;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
