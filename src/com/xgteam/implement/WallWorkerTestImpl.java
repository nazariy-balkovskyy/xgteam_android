package com.xgteam.implement;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.net.Uri;

import com.xgteam.data.WallObject;
import com.xgteam.interfaces.WallWorker;
import com.xgteam.utils.ObjectConverter;
import com.xgteam.utils.Request;

public class WallWorkerTestImpl implements WallWorker {

	@Override
	public List<WallObject> get(String type, int tid, String accessToken) {
		try {
			String response=Request.sendGet("http://mob.xgenteam.com/wall/get.json?type="+type+"&tid="+tid+"&access_token="+accessToken);
			JSONObject jObject = new JSONObject(response);
			int success=jObject.getInt("success");
			if(success>0){
				JSONArray posts=jObject.getJSONArray("posts");
				int postCount=posts.length();
				List<WallObject> wall=new ArrayList<WallObject>();
				for(int i=0;i<postCount;i++){
					WallObject wallObj=ObjectConverter.convertToWallObject(posts.get(i).toString());
					wall.add(wallObj);
				}
				return wall;				
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
	public void write(String type, int tid, String message, String accessToken) {
		try {
			Request.sendGet("http://mob.xgenteam.com/wall/write.json?type="+type+"&tid="+tid+"&access_token="+accessToken+"&message="+Uri.encode(message));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
