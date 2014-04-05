package com.xgteam.utils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;
    public DownloadImageTask(ImageView bmImage) {
        this.bmImage = bmImage;
    }
    public Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
        	if(!DownloadImageCache.hash.containsKey(urldisplay)){
        		InputStream in = new java.net.URL(urldisplay).openStream();
        		mIcon11 = BitmapFactory.decodeStream(in);
        		DownloadImageCache.hash.put(urldisplay, mIcon11);
        	}
        	else{
        		mIcon11=(Bitmap) DownloadImageCache.hash.get(urldisplay);
        	}
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);
    }
}