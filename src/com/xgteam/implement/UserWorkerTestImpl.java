package com.xgteam.implement;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.xgteam.data.UserObject;
import com.xgteam.interfaces.UserWorker;
import com.xgteam.utils.ObjectConverter;
import com.xgteam.utils.Request;

public class UserWorkerTestImpl implements UserWorker{
	
	@Override
	public UserObject getUser(int userId,String accessToken) {
		try {
			String response=Request.sendGet("http://mob.xgenteam.com/users/get.json?uid="+userId+"&access_token="+accessToken);
			JSONObject jObject = new JSONObject(response);
			int success=jObject.getInt("success");
			if(success>0){
				return ObjectConverter.convertToUserObject(jObject.getJSONObject("user").toString());				
			}
			else{
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public UserObject login(String login, String password) {
		try {
			String response=Request.sendGet("http://mob.xgenteam.com/users/login.json?login="+login+"&password="+password);
			JSONObject jObject = new JSONObject(response);
			int success=jObject.getInt("success");
			if(success>0){
				return ObjectConverter.convertToUserObject(jObject.getJSONObject("user").toString());
			}
			else{
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<UserObject> getAll(String accessToken) {
		List<UserObject> users=new ArrayList<UserObject>();
		try {
			String response=Request.sendGet("http://mob.xgenteam.com/users/getAll.json?access_token="+accessToken);
			JSONObject jObject = new JSONObject(response);
			int success=jObject.getInt("success");
			if(success>0){
				JSONArray jArray=jObject.getJSONArray("users");
				int jArrayLength=jArray.length();
				for(int i=0;i<jArrayLength;i++){
					UserObject user=ObjectConverter.convertToUserObject(jObject.getJSONObject("user").toString());
					users.add(user);
				}
				return users;				
			}
			else{
				return users;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return users;
		}
	}

	@Override
	public UserObject logout(String accessToken) throws Exception {
		return null;
	}
}
