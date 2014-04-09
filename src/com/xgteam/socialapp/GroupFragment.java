package com.xgteam.socialapp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.xgteam.adapter.UserWallListAdapter;
import com.xgteam.application.App;
import com.xgteam.data.GroupObject;
import com.xgteam.data.WallObject;
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
	private List<WallObject> wallList;
	private static GroupObject group=null;
	public GroupFragment(){}
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_group, container, false);
		if(group!=null){
			ImageView groupImage=(ImageView) rootView.findViewById(R.id.groupImage);
			TextView groupName=(TextView) rootView.findViewById(R.id.groupName);
			Button groupSubscriptionButton=(Button) rootView.findViewById(R.id.groupSubscriptionButton);
			if(group.isUserSubscribed()){
				groupSubscriptionButton.setText("Відписатися");
			}
			else{
				groupSubscriptionButton.setText("Підписатися");
			}
			new DownloadImageTask(groupImage).execute(group.getPicture());//doInBackground(User.getPicture());
			groupName.setText(group.getName());
			
			final ListView listview =(ListView)rootView.findViewById(R.id.groupWall);
			wallList=App.getInstance().Wall().get("group", group.getId(), App.getInstance().getUser().getToken());
			final Resources res =getResources();
			UserWallListAdapter adapter=new UserWallListAdapter( this.getActivity(), wallList,res );
			listview.setAdapter( adapter );
			
			Button groupWallInputButton=(Button) rootView.findViewById(R.id.groupWallInputButton);
			
			final EditText groupWallInputMessage=(EditText) rootView.findViewById(R.id.groupWallInputMessage);
			final Activity thisActivity=this.getActivity();
			groupSubscriptionButton.setOnClickListener(new View.OnClickListener() {			
				@Override
				public void onClick(View v) {
					if(group.isUserSubscribed()){
						App.getInstance().Groups().unsubscribe(group.getId(), App.getInstance().getUser().getToken());
					}
					else{
						App.getInstance().Groups().subscribe(group.getId(), App.getInstance().getUser().getToken());
					}
					((MainActivity)getActivity()).displayView(2);
				}
			});
			groupWallInputButton.setOnClickListener(new View.OnClickListener() {			
				@Override
				public void onClick(View v) {
					Editable message=groupWallInputMessage.getText();
					if(message.length()>0){
			            WallObject sched = new WallObject();
						sched.setUser(App.getInstance().getUser());
						SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
						sched.setCreatedAt(dateFormat.format(Calendar.getInstance().getTime()));
						sched.setMessage(message.toString());
			            wallList.add(0,sched);
			            App.getInstance().Wall().write("group", group.getId(), message.toString(), App.getInstance().getUser().getToken());
			            UserWallListAdapter adapter=new UserWallListAdapter( thisActivity, wallList,res);
			            listview.refreshDrawableState();
			    		listview.setAdapter(adapter);
					}
				}
			});
		}
		return rootView;
	}
	public static GroupObject getGroup() {
		return group;
	}
	public static void setGroup(GroupObject group) {
		GroupFragment.group = group;
	}
}
