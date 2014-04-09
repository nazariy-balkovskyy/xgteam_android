package com.xgteam.implement;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.xgteam.data.GroupObject;
import com.xgteam.data.UserObject;
import com.xgteam.interfaces.GroupsWorker;
import com.xgteam.utils.ObjectConverter;
import com.xgteam.utils.Request;

public class GroupsWorkerTestImpl implements GroupsWorker {

	private String accessToken;
	@Override
	public void setAccessToken(String accessToken){
		this.accessToken=accessToken;
	}
	@Override
	public GroupObject get(int groupId, String accessToken) {
		// TODO Auto-generated method stub
		try {
			String response=Request.sendGet("http://mob.xgenteam.com/groups/get.json?gid="+groupId+"&access_token="+accessToken);
			JSONObject jObject = new JSONObject(response);
			int success=jObject.getInt("success");
			if(success>0){
				return ObjectConverter.convertToGroupObject(jObject.getJSONArray("groups").getJSONObject(0).toString());				
			}
			else{
				return null;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<GroupObject> getUserGroups(int userId, String accessToken) {
		// TODO Auto-generated method stub
		try {
			String response=Request.sendGet("http://mob.xgenteam.com/groups/getByUserId.json?uid="+userId+"&access_token="+accessToken);
			JSONObject jObject = new JSONObject(response);
			int success=jObject.getInt("success");
			if(success>0){
				JSONArray groups=jObject.getJSONArray("groups");
				int groupsCount=groups.length();
				List<GroupObject> userGroups=new ArrayList<GroupObject>(); 
				for(int i=0;i<groupsCount;i++){
					GroupObject gObj=ObjectConverter.convertToGroupObject(groups.getJSONObject(i).toString());
					gObj.setUserSubscribed(true);
					userGroups.add(gObj);
				}
				return userGroups;				
			}
			else{
				return null;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean subscribe(int groupId, String accessToken) {
		// TODO Auto-generated method stub
		try {
			String response=Request.sendGet("http://mob.xgenteam.com/groups/subscribe.json?gid="+groupId+"&access_token="+accessToken);
			JSONObject jObject = new JSONObject(response);
			int success=jObject.getInt("success");
			if(success>0){
				return true;				
			}
			else{
				return false;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean unsubscribe(int groupId, String accessToken) {
		// TODO Auto-generated method stub
		try {
			String response=Request.sendGet("http://mob.xgenteam.com/groups/unsubscribe.json?gid="+groupId+"&access_token="+accessToken);
			JSONObject jObject = new JSONObject(response);
			int success=jObject.getInt("success");
			if(success>0){
				return true;				
			}
			else{
				return false;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<GroupObject> get(String accessToken) {
		// TODO Auto-generated method stub
		try {
			String response=Request.sendGet("http://mob.xgenteam.com/groups/get.json?access_token="+accessToken);
			JSONObject jObject = new JSONObject(response);
			int success=jObject.getInt("success");
			if(success>0){
				JSONArray groups=jObject.getJSONArray("groups");
				int groupsCount=groups.length();
				List<GroupObject> groupsList=new ArrayList<GroupObject>(); 
				for(int i=0;i<groupsCount;i++){
					groupsList.add(ObjectConverter.convertToGroupObject(groups.getJSONObject(i).toString()));
				}
				return groupsList;				
			}
			else{
				return null;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<GroupObject> getUserGroups(String accessToken) {
		// TODO Auto-generated method stub
		try {
			String response=Request.sendGet("http://mob.xgenteam.com/groups/getByUserId.json?access_token="+accessToken);
			JSONObject jObject = new JSONObject(response);
			int success=jObject.getInt("success");
			if(success>0){
				JSONArray groups=jObject.getJSONArray("groups");
				int groupsCount=groups.length();
				List<GroupObject> userGroups=new ArrayList<GroupObject>(); 
				for(int i=0;i<groupsCount;i++){
					GroupObject gObj=ObjectConverter.convertToGroupObject(groups.getJSONObject(i).toString());
					gObj.setUserSubscribed(true);
					userGroups.add(gObj);
				}
				return userGroups;				
			}
			else{
				return null;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
