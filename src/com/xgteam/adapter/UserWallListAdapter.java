package com.xgteam.adapter;

import java.util.ArrayList;
import java.util.List;

import com.xgteam.data.WallObject;
import com.xgteam.model.User;
import com.xgteam.model.UserWallListModel;
import com.xgteam.socialapp.R;
import com.xgteam.utils.DownloadImageTask;

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
import android.widget.ImageView;
import android.widget.TextView;

public class UserWallListAdapter extends BaseAdapter   implements OnClickListener {
    
    /*********** Declare Used Variables *********/
    private Activity activity;
    private List<WallObject> data=new ArrayList<WallObject>();
    private static LayoutInflater inflater=null;
    public Resources res;
    WallObject tempValues=null;
    int i=0;
     
    /*************  CustomAdapter Constructor *****************/
    public UserWallListAdapter(Activity a, List<WallObject> d,Resources resLocal) {
         
           /********** Take passed values **********/
            activity = a;
            data=d;
            res = resLocal;
         
            /***********  Layout inflator to call external xml layout () ***********/
             inflater = ( LayoutInflater )activity.
                                         getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         
    }
 
    /******** What is the size of Passed Arraylist Size ************/
    public int getCount() {
         
    	if(data==null){
    		return 0;
    	}
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
     
    /********* Create a holder Class to contain inflated xml file elements *********/
    public static class ViewHolder{
         
        public TextView wallUserName;
        public TextView wallText;
        public ImageView wallUserPicture;
 
    }
 
    /****** Depends upon data size called for each row , Create each ListView row *****/
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         
        View vi = convertView;
        ViewHolder holder;
         
        if(convertView==null){
             
            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            vi = inflater.inflate(R.layout.user_wall_list_item, null);
             
            /****** View Holder Object to contain tabitem.xml file elements ******/

            holder = new ViewHolder();
            holder.wallUserName = (TextView) vi.findViewById(R.id.userName);
            holder.wallText=(TextView)vi.findViewById(R.id.text);
            holder.wallUserPicture=(ImageView)vi.findViewById(R.id.image);
             
           /************  Set holder with LayoutInflater ************/
            vi.setTag( holder );
        }
        else 
            holder=(ViewHolder)vi.getTag();
         
        if(data.size()<=0)
        {
            holder.wallText.setText("No Data");
             
        }
        else
        {
            /***** Get each Model object from Arraylist ********/
            tempValues=null;
            tempValues = ( WallObject ) data.get( position );
             
            /************  Set Model values in Holder elements ***********/

             holder.wallUserName.setText( tempValues.getUser().getFirstName()+" "+tempValues.getUser().getLastName() );
             holder.wallText.setText( tempValues.getMessage() );
             new DownloadImageTask(holder.wallUserPicture).execute(tempValues.getUser().getPicture());//doInBackground(User.getPicture());
              
             /******** Set Item Click Listner for LayoutInflater for each row *******/

             //vi.setOnClickListener((android.view.View.OnClickListener) new OnItemClickListener( position ));
        }
        return vi;
    }
     
    public void onClick(View v) {
            Log.v("CustomAdapter", "=====Row button clicked=====");
    }
     
    /********* Called when Item click in ListView ************/
    private class OnItemClickListener  implements OnClickListener{           
        private int mPosition;
         
        OnItemClickListener(int position){
             mPosition = position;
        }
         
        public void onClick(View arg0) {

   
          //UserWallList sct = (UserWallList) activity;

         /****  Call  onItemClick Method inside CustomListViewAndroidExample Class ( See Below )****/

            //sct.onItemClick(mPosition);
        }

		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			
		}               
    }

	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
	}

}