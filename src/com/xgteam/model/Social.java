package com.xgteam.model;

public class Social {
	private static Social instance=null;
	private Social(){}
	public static boolean login(String login,String password){
		if(login=="andrew" && password=="andrew"){
			User.setId(1);
			return true;
		}
		else if(login=="naz1k" && password=="naz1k"){
			User.setId(2);
			return true;
		}
		else return false;
	}
	public static boolean logout(){
		int id=User.getId();
		if(id>0){
			User.setId(0);
			return true;
		}
		else return false;
	}
	public static Social getInstance(){
		if(instance==null){
			instance=new Social();
		}
		return instance;
	}
}
