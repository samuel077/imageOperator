package com.fantacygroup.imageoperation.util;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by samuel on 2015/4/12.
 */
public class ImageOperator implements IImageOperator {


    private static ImageOperator imageOperator = null;
    private ImageView imageView;
    private Context context;
    private String url;
    private String errorMsg = "image download fail";

    // singleton Function here.
    synchronized static public ImageOperator getInstance(){
        if( imageOperator == null ) {
            Log.d("image view", "imageOperator = null");
            return new ImageOperator();
        }
        return imageOperator;
    }

    synchronized  static public ImageOperator getInstance(Context context){
        if( imageOperator == null){
            Log.d("image view", "imageOperator = null");
            return new ImageOperator(context);
        }
        return imageOperator;
    }

    // empty constructor;
    public ImageOperator(){
    }

    // constructor with context.
    public ImageOperator(Context context){
        this.context = context;
    }

    // return ImageOperator with settled url;
    public ImageOperator grabImage(String url){
        this.url = url;
        return this;
    }

    // return ImageOperator with settled imageView
    public ImageOperator onImageView( ImageView imageView ){
        this.imageView = imageView;
        return this;
    }

    public ImageOperator withErrorMsg( String errorMsg ){
        this.errorMsg = errorMsg;
        return this;
    }

    // fetch image without grab it to local
    public void fetchImageFromUrl(Context context, ImageView imageView, String url, String errorMsg) {
        Log.d("image", "fetchImageFromUrl");
        DownloadImageTaskInDrawable downloadImageTaskDrawable = new DownloadImageTaskInDrawable(context, imageView);
        downloadImageTaskDrawable.setFetchImageFailureMessage(errorMsg);
        downloadImageTaskDrawable.execute(url);
    }

    @Override
    public void start() {
        Log.d("image"," start, url = " + url + " error message = " + this.errorMsg);
        fetchImageFromUrl(this.context, this.imageView, this.url, this.errorMsg);
    }

    @Override
    public void startWithCache(boolean isCacheTurnOn) {

    }
}
