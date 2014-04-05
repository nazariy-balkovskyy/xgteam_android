package com.xgteam.socialapp;

import java.util.ArrayList;

import com.xgteam.adapter.GroupListAdapter;
import com.xgteam.adapter.UserWallListAdapter;
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
		if(User.getId()==0)
		{
			Social.login("andrew", "andrew");
		}
		final Resources res =getResources();
		final Activity thisActivity=this.getActivity();
		groupList=Group.getUserGroups();
		/*listview.setOnItemClickListener(new OnItemClickListener() {
			@Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				GroupListModel entry = (GroupListModel) parent.getItemAtPosition(position);
				GroupFragment.setGroup(entry);
				((MainActivity)getActivity()).displayView(-1);
            }
		});*/
		GroupListAdapter adapter=new GroupListAdapter( this.getActivity(), groupList,res );
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(this);
		myGroupsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	groupList=new ArrayList<GroupListModel>();
            	groupList=Group.getUserGroups();
        		GroupListAdapter adapter=new GroupListAdapter( thisActivity, groupList,res );
        		listview.refreshDrawableState();
        		listview.setAdapter(adapter);
            }
        });
		allGroupsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	groupList=new ArrayList<GroupListModel>();
            	groupList=Group.getAll();
        		GroupListAdapter adapter=new GroupListAdapter( thisActivity, groupList,res );
        		listview.refreshDrawableState();
        		listview.setAdapter(adapter);
            }
        });
		return rootView;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {
		// TODO Auto-generated method stub
		GroupListModel entry = (GroupListModel) v.getTag();
		GroupFragment.setGroup(entry);
		((MainActivity)getActivity()).displayView(-1);
	}
}
