package com.fantacygroup.imageoperation.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;

/**
 * Created by samuel on 2015/4/7.
 */
public class DownloadImageTaskInDrawable extends AsyncTask< String, Void, Drawable> {

    // input : String
    // output : Drawable Object

    private ImageView imageView = null;
    private Context context = null;
    private String fetchImageFailureMessage = null;

    DownloadImageTaskInDrawable(Context context, ImageView imageView){
        Log.d("image view", "constructor");
        this.imageView = imageView;
        this.context = context;
    }

    @Override
    protected Drawable doInBackground(String... urls) {
        // we get urls, then, get image back from url.
        String urldisplay = urls[0];
        Drawable figure = null;
        Log.d("image view", "image, do in background");
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            figure = Drawable.createFromStream( in , "src name");
        } catch (Exception e) {
            Log.d("image view", "do in background exception");
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return figure;
    }

    // onPostExecute runs in main UI Thread
    @Override
    protected void onPostExecute(Drawable drawable) {
        Log.d("image view", "post execute");
        if(drawable == null){
            Toast.makeText(context, this.fetchImageFailureMessage , Toast.LENGTH_SHORT).show();
        }
        imageView.setImageDrawable(drawable);
    }

    public void setFetchImageFailureMessage(String message){
        this.fetchImageFailureMessage = message;
    }
}
