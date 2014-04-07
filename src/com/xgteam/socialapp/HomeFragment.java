package com.xgteam.socialapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.w3c.dom.Text;

import com.xgteam.adapter.UserWallListAdapter;
import com.xgteam.application.App;
import com.xgteam.model.*;
import com.xgteam.utils.DB;
import com.xgteam.utils.DownloadImageTask;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.util.LayoutDirection;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class HomeFragment extends Fragment {
	private ArrayList<UserWallListModel> wallList;
	public HomeFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        
		//get all resources
		View rootView = inflater.inflate(R.layout.fragment_home, container, false);
		final ListView listview =(ListView)rootView.findViewById(R.id.userWall);
		
		ImageView userPicture=(ImageView) rootView.findViewById(R.id.userPicture);
		TextView userName=(TextView) rootView.findViewById(R.id.userName);
		TextView userOnlineState=(TextView) rootView.findViewById(R.id.userOnlineState);
		
		Button userFriendsButton=(Button) rootView.findViewById(R.id.userFriendsButton);
		Button userGroupsButton=(Button) rootView.findViewById(R.id.userGroupsButton);
		Button userPicturesButton=(Button) rootView.findViewById(R.id.userPicturesButton);
		Button userWallInputButton=(Button) rootView.findViewById(R.id.userWallInputButton);
		
		final EditText userWallInputMessage=(EditText) rootView.findViewById(R.id.userWallInputMessage);
		
		final Resources res =getResources();
		final Activity thisActivity=this.getActivity();
		
		//user login and get profile information
		App app=App.getInstance();
		Social.login("andrew", "andrew");
		wallList=Wall.getUserWall();
		
		new DownloadImageTask(userPicture).execute(app.getUser().getPicture());
		
		userName.setText(app.getUser().getFirstName()+" "+app.getUser().getLastName());
		if (app.getUser().isOnline() == true) {
			userOnlineState.setText("Online");
		} else {
			userOnlineState.setText("Offline");
		}
		userFriendsButton.setText("Friends\n"+Friend.getFriendsCount());
		userGroupsButton.setText("Groups\n"+Group.getGroupsCount());
		userPicturesButton.setText("Pictures\n"+Picture.getPicturesCount());
		
		//user wall
		UserWallListAdapter adapter=new UserWallListAdapter( this.getActivity(), wallList,res );
		listview.setAdapter( adapter );
		
		//listeners
		userFriendsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	((MainActivity)getActivity()).displayView(1); 
            }
        });
		
		userGroupsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	((MainActivity)getActivity()).displayView(2);
            }
        });
		
		userPicturesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	((MainActivity)getActivity()).displayView(3);
            }
        });
		
		userWallInputButton.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				Editable message=userWallInputMessage.getText();
				if(message.length()>0){
					UserWallListModel sched = new UserWallListModel();
					sched.setUserName(User.getFirstName()+" "+User.getLastName());
		            sched.setImage(User.getPicture());
		            sched.setText(message.toString());
		            wallList.add(0,sched);
		            UserWallListAdapter adapter=new UserWallListAdapter( thisActivity, wallList,res);
		            listview.refreshDrawableState();
		    		listview.setAdapter(adapter);
				}
			}
		});
		
        return rootView;
    }

}