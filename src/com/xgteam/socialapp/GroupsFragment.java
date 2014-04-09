package com.xgteam.socialapp;

import java.util.ArrayList;
import java.util.List;

import com.xgteam.adapter.GroupListAdapter;
import com.xgteam.adapter.UserWallListAdapter;
import com.xgteam.application.App;
import com.xgteam.data.GroupObject;
import com.xgteam.implement.GroupsWorkerTestImpl;
import com.xgteam.interfaces.GroupsWorker;
import com.xgteam.model.Group;
import com.xgteam.model.GroupListModel;
import com.xgteam.model.Social;
import com.xgteam.model.User;
import com.xgteam.model.UserWallListModel;
import com.xgteam.model.Wall;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class GroupsFragment extends Fragment  implements OnItemClickListener{
	private ArrayList<GroupListModel> groupList;
	public GroupsFragment(){}
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_groups, container, false);
		Button myGroupsButton=(Button) rootView.findViewById(R.id.myGroupsButton);
		Button allGroupsButton=(Button) rootView.findViewById(R.id.allGroupsButton);
		final ListView listview =(ListView)rootView.findViewById(R.id.groupsList);
		List<GroupObject> groupsList = App.getInstance().Groups().getUserGroups(App.getInstance().getUser().getToken());
		
		final Resources res =getResources();
		final Activity thisActivity=this.getActivity();
		GroupListAdapter adapter=new GroupListAdapter( thisActivity, groupsList,res );
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(this);
		myGroupsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	List<GroupObject> groupsList = App.getInstance().Groups().getUserGroups(App.getInstance().getUser().getToken());
            	GroupListAdapter adapter=new GroupListAdapter( thisActivity, groupsList,res );
        		listview.setAdapter(adapter);
            }
        });
		allGroupsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	List<GroupObject> groupsList = App.getInstance().Groups().get(App.getInstance().getUser().getToken());
            	GroupListAdapter adapter=new GroupListAdapter( thisActivity, groupsList,res);
        		listview.setAdapter(adapter);
            }
        });
		return rootView;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {
		// TODO Auto-generated method stub
		GroupObject entry = (GroupObject) v.getTag();
		GroupFragment.setGroup(entry);
		((MainActivity)getActivity()).displayView(-1);
	}
}
