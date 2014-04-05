package com.xgteam.data;

public class FriendObject {
	private int id;
	private String firstName;
	private String lastName;
	private boolean isOnline;
	public FriendObject(int id, String firstName, String lastName,
			boolean isOnline) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isOnline = isOnline;
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
}
