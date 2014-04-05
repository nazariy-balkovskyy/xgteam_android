package com.xgteam.model;

import java.util.ArrayList;


public class Wall {
	private static ArrayList<UserWallListModel> userWall=new ArrayList<UserWallListModel>();

	public static ArrayList<UserWallListModel> getUserWall() {
		userWall=new ArrayList<UserWallListModel>();
		int myId=User.getId();
		UserWallListModel sched;
		switch(User.getId()){
			case 1:{
				sched = new UserWallListModel();
				User.setId(1);
				sched.setUserName(User.getFirstName()+" "+User.getLastName());
	            sched.setImage(User.getPicture());
	            sched.setText("Hello it is my post");
	            userWall.add(sched);
	            
	            sched = new UserWallListModel();
				User.setId(2);
				sched.setUserName(User.getFirstName()+" "+User.getLastName());
	            sched.setImage(User.getPicture());
	            sched.setText("And this is my post");
	            userWall.add(sched);
	            
	            sched = new UserWallListModel();
				User.setId(1);
				sched.setUserName(User.getFirstName()+" "+User.getLastName());
	            sched.setImage(User.getPicture());
	            sched.setText("My first Android application");
	            userWall.add(sched);
	            
	            sched = new UserWallListModel();
				User.setId(2);
				sched.setUserName(User.getFirstName()+" "+User.getLastName());
	            sched.setImage(User.getPicture());
	            sched.setText("Good job");
	            userWall.add(sched);
	            
	            sched = new UserWallListModel();
				User.setId(1);
				sched.setUserName(User.getFirstName()+" "+User.getLastName());
	            sched.setImage(User.getPicture());
	            sched.setText("Hello everybody");
	            userWall.add(sched);
	            
				break;
			}
			case 2:{
				sched = new UserWallListModel();
				User.setId(1);
				sched.setUserName(User.getFirstName()+" "+User.getLastName());
	            sched.setImage(User.getPicture());
	            sched.setText("Hello it is my post");
	            userWall.add(sched);
	            
	            sched = new UserWallListModel();
				User.setId(2);
				sched.setUserName(User.getFirstName()+" "+User.getLastName());
	            sched.setImage(User.getPicture());
	            sched.setText("And this is my post");
	            userWall.add(sched);
	            
	            sched = new UserWallListModel();
				User.setId(2);
				sched.setUserName(User.getFirstName()+" "+User.getLastName());
	            sched.setImage(User.getPicture());
	            sched.setText("My first Android application");
	            userWall.add(sched);
	            
	            sched = new UserWallListModel();
				User.setId(2);
				sched.setUserName(User.getFirstName()+" "+User.getLastName());
	            sched.setImage(User.getPicture());
	            sched.setText("Good job");
	            userWall.add(sched);
	            
	            sched = new UserWallListModel();
				User.setId(2);
				sched.setUserName(User.getFirstName()+" "+User.getLastName());
	            sched.setImage(User.getPicture());
	            sched.setText("Hello everybody");
	            userWall.add(sched);
	            
				break;
			}
		}
		User.setId(myId);
		return userWall;
	}

	public static void setUserWall(ArrayList<UserWallListModel> userWall) {
		Wall.userWall = userWall;
	}
	
}
