package com.xgteam.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class User {
	private static int id=0;
	private static String picture;
	private static String firstName;
	private static String lastName;
	private static boolean onlineState;
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		User.id = id;
		switch(id){
			case 1:{
				picture="https://pp.vk.me/c320531/v320531750/2570/0PFIvRp2aho.jpg";
				firstName="Andrew";
				lastName="Dubytsky";
				onlineState=true;
				break;
			}
			case 2:{
				picture="https://lh6.googleusercontent.com/-sA_vl_s0Vso/UZ-fG2-X1vI/AAAAAAAAAEY/86sx6AoSg7U/w576-h577-no/hangout_snapshot_9.png";
				firstName="Nazar";
				lastName="Balkovsky";
				onlineState=true;
				break;
			}
		}
	}
	public static String getPicture() {
		return picture;
	}
	public static void setPicture(String picture) {
		User.picture = picture;
	}
	public static String getFirstName() {
		return firstName;
	}
	public static void setFirstName(String firstName) {
		User.firstName = firstName;
	}
	public static String getLastName() {
		return lastName;
	}
	public static void setLastName(String lastName) {
		User.lastName = lastName;
	}
	public static boolean getOnlineState() {
		return onlineState;
	}
	public static void setOnlineState(boolean onlineState) {
		User.onlineState = onlineState;
	}
}
