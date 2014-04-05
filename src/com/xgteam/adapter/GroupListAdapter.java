package com.xgteam.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.xgteam.model.GroupListModel;
import com.xgteam.model.UserWallListModel;
import com.xgteam.socialapp.R;
import com.xgteam.utils.DownloadImageTask;

public class GroupListAdapter extends BaseAdapter  {
    
    /*********** Declare Used Variables *********/
    private Activity activity;
    private ArrayList data;
    private static LayoutInflater inflater=null;
    public Resources res;
    GroupListModel tempValues=null;
    int i=0;
     
    /*************  CustomAdapter Constructor *****************/
    public GroupListAdapter(Activity a, ArrayList d,Resources resLocal) {
         
           /********** Take passed values **********/
            activity = a;
            data=d;
            res = resLocal;
         
            /***********  Layout inflator to call external xml layout () ***********/
             inflater = ( LayoutInflater )activity.
                                         getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         
    }
 
    public int getCount() {
         
        if(data.size()<=0)
            return 1;
        return data.size();
    }
 
    public Object getItem(int position) {
        return position;
    }
 
    public long getItemId(int position) {
        return position;
    }
     
    public static class ViewHolder{
         
        public TextView groupName;
        public ImageView groupImage;
        public Button groupAction;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         
        View vi = convertView;
        ViewHolder holder;
         
        if(convertView==null){
            vi = inflater.inflate(R.layout.group_list_item, null);
        }
        holder = new ViewHolder();
        holder.groupName = (TextView) vi.findViewById(R.id.groupName);
        holder.groupImage =(ImageView)vi.findViewById(R.id.groupImage);
        //holder.groupAction=(Button) vi.findViewById(R.id.groupSubscriptionButton);
        if(data.size()>0){
            tempValues=null;
            tempValues = ( GroupListModel ) data.get( position );
	         holder.groupName.setText(tempValues.getName());
	         new DownloadImageTask(holder.groupImage).execute(tempValues.getImage());//doInBackground(User.getPicture());
//	         if(tempValues.isSubscribed()){
//	        	 holder.groupAction.setText("Unsubscribe");
//	         }
//	         else{
//	        	 holder.groupAction.setText("Subscribe");
//	         }
        }
        //vi.setOnClickListener((android.view.View.OnClickListener) new OnItemClickListener( position ));
        vi.setTag(data.get(position));
        return vi;
    }
}