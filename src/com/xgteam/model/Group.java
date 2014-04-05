package com.xgteam.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Group {
	private static int groupsCount=0;
	private static ArrayList<GroupListModel> userGroups=new ArrayList<GroupListModel>();
	private static ArrayList<GroupListModel> allGroups=new ArrayList<GroupListModel>();
	
	public static int getGroupsCount() {
		switch(User.getId()){
			case 1:{
				groupsCount=12;
				break;
			}
			case 2:{
				groupsCount=345;
				break;
			}
			default:{
				groupsCount=0;
				break;
			}
		}
		return groupsCount;
	}

	public static ArrayList<GroupListModel> getUserGroups() {
		int userGroupsCount=Group.getGroupsCount();
		GroupListModel sched;
		List<String> images=new ArrayList<String>();
		images.add("https://pp.vk.me/c606826/v606826349/2b27/Zg-5AmvoZ2M.jpg");
		images.add("https://pp.vk.me/c620617/v620617355/213/2m1DD23H20M.jpg");
		images.add("https://pp.vk.me/c310126/v310126750/8fac/lqP5HC2NAyw.jpg");
		images.add("https://pp.vk.me/c317621/v317621894/9efe/N0Bp_9nZRYM.jpg");
		images.add("https://pp.vk.me/c416118/v416118419/1cac/g3EkUsQX9PE.jpg");
		images.add("https://pp.vk.me/c408327/v408327186/a896/oM-LQEOwdfk.jpg");
		images.add("https://pp.vk.me/c616923/v616923993/6120/Vfyvi7GF5k4.jpg");
		images.add("https://pp.vk.me/c311231/v311231973/6bab/PPT4w70x5uI.jpg");
		int tmp=0;
		if(userGroups.size()<userGroupsCount){
			userGroups.clear();
			for(int i=0;i<userGroupsCount;i++){
				sched = new GroupListModel();
				sched.setName("Group "+i);
	            sched.setImage(images.get(tmp));
	            sched.setSubscribed(true);
	            tmp++;
	            if(tmp>7) tmp=0;
	            userGroups.add(sched);
			}
		}
		return userGroups;
	}

	public static ArrayList<GroupListModel> getAll() {
		int userGroupsCount=Group.getGroupsCount();
		GroupListModel sched;
		List<String> images=new ArrayList<String>();
		images.add("https://pp.vk.me/c606622/v606622420/35cb/WKUb2vLYzyY.jpg");
		images.add("https://pp.vk.me/c620917/v620917064/546/9xqOMm2-kRQ.jpg");
		images.add("https://pp.vk.me/c311620/v311620100/8b72/mChIOGYpJ2k.jpg");
		images.add("https://pp.vk.me/c406931/v406931642/d6e8/io5NKfkEtL0.jpg");
		images.add("https://pp.vk.me/c412129/v412129558/6ce6/mzCjQkMZGrs.jpg");
		images.add("https://pp.vk.me/c311716/v311716824/9822/MLO19zUMtbc.jpg");
		images.add("https://pp.vk.me/c616522/v616522712/72d0/FbrqU7j5xqQ.jpg");
		images.add("https://pp.vk.me/c11159/g20629724/d_3084d9fe.jpg");
		int tmp=0;
		if(allGroups.size()<200){
			allGroups.clear();
			for(int i=0;i<200;i++){
				sched = new GroupListModel();
				sched.setName("Group "+i);
	            sched.setImage(images.get(tmp));
	            sched.setSubscribed(false);
	            tmp++;
	            if(tmp>7) tmp=0;
	            allGroups.add(sched);
			}
		}
		return allGroups;
	}
	
}
