package com.xgteam.socialapp;

import java.util.ArrayList;

import com.xgteam.adapter.UserWallListAdapter;
import com.xgteam.model.GroupListModel;
import com.xgteam.model.User;
import com.xgteam.model.UserWallListModel;
import com.xgteam.model.Wall;
import com.xgteam.utils.DownloadImageTask;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class GroupFragment  extends Fragment{
	private ArrayList<UserWallListModel> wallList;
	private static GroupListModel group=null;
	public GroupFragment(){}
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_group, container, false);
		if(group!=null){
			ImageView groupImage=(ImageView) rootView.findViewById(R.id.groupImage);
			TextView groupName=(TextView) rootView.findViewById(R.id.groupName);
			new DownloadImageTask(groupImage).execute(group.getImage());//doInBackground(User.getPicture());
			groupName.setText(group.getName());
			
			final ListView listview =(ListView)rootView.findViewById(R.id.groupWall);
			wallList=Wall.getUserWall();
			final Resources res =getResources();
			UserWallListAdapter adapter=new UserWallListAdapter( this.getActivity(), wallList,res );
			listview.setAdapter( adapter );
			
			Button groupWallInputButton=(Button) rootView.findViewById(R.id.groupWallInputButton);
			
			final EditText groupWallInputMessage=(EditText) rootView.findViewById(R.id.groupWallInputMessage);
			final Activity thisActivity=this.getActivity();
			groupWallInputButton.setOnClickListener(new View.OnClickListener() {			
				@Override
				public void onClick(View v) {
					Editable message=groupWallInputMessage.getText();
					if(message.length()>0){
						UserWallListModel sched = new UserWallListModel();
						sched.setUserName(User.getFirstName()+" "+User.getLastName());
			            sched.setImage(User.getPicture());
			            sched.setText(message.toString());
			            wallList.add(0,sched);
			            UserWallListAdapter adapter=new UserWallListAdapter( thisActivity, wallList,res);
			            listview.refreshDrawableState();
			    		listview.setAdapter( adapter );
					}
				}
			});
		}
		return rootView;
	}
	public static GroupListModel getGroup() {
		return group;
	}
	public static void setGroup(GroupListModel group) {
		GroupFragment.group = group;
	}
}
