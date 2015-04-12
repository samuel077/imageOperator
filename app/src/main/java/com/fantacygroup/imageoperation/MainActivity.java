package com.fantacygroup.imageoperation;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.fantacygroup.imageoperation.util.ImageOperator;


public class MainActivity extends ActionBarActivity {

    private ImageView imageView = null;
    private Button btnGetImage = null;
    private String url = null;
    private String errorMsg = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){

        url = "https://s1.yimg.com/rz/d/yahoo_frontpage_zh-Hant-TW_s_f_p_350x40_frontpage_2x.png";
        errorMsg = "Fetch Image Failure. Please check the resource.";

        imageView = (ImageView) findViewById(R.id.imageView);

        btnGetImage = (Button) findViewById(R.id.btnGetImage);
        btnGetImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("image", "on click function");
                getImage(imageView, url, errorMsg);
            }
        });
    }

    // fetch image from url, and put it into imageView
    private void getImage(ImageView imageView, String url, String errorMsg){
        // initial with context
        Log.d("image"," get Image, later constructor");
        ImageOperator imageOperator = ImageOperator.getInstance(getApplicationContext());
        Log.d("image"," get Image, setter.");
        imageOperator.grabImage(url).onImageView(imageView).withErrorMsg(errorMsg).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
