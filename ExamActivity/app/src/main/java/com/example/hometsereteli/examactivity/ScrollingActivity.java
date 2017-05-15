package com.example.hometsereteli.examactivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.Rating;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.accessibility.AccessibilityNodeInfo;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ScrollingActivity extends AppCompatActivity {
    RatingBar mainRatingBar,miniRatingBar;
    TextView ratingInfo;
    String ToastMessage;
    String snackBarMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        ratingInfo = (TextView)findViewById(R.id.showMainRating);
        mainRatingBar = (RatingBar)findViewById(R.id.mainRatingBar);
        mainRatingBar.setNumStars(5);
        miniRatingBar = (RatingBar)findViewById(R.id.miniRatingBar);
        miniRatingBar.setNumStars(5);

        mainRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingInfo.setText(String.valueOf(rating));
                miniRatingBar.setRating(rating);
                Toast.makeText(ScrollingActivity.this, "App Rated " + rating, Toast.LENGTH_SHORT).show();
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
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

    public void onBtnClickListener(View v){
        int clickedObjectID = v.getId();

        switch(clickedObjectID){
            case R.id.openBtn:
            case R.id.uninstalBtn:
                snackBarMessage = "you clicked " + ((Button)v).getText().toString() + " button";
                break;
            case R.id.travelBtn:
                snackBarMessage = "you clicked travel & Local button";
                break;
            case R.id.similarBtn:
                snackBarMessage = "you clicked Similar Button";
                break;
            case R.id.readMore:
                snackBarMessage = "you clicked " + ((TextView)v).getText().toString() + " Button";
                break;
            default:
                snackBarMessage = "warning: Unexpected Message From Snackbar. ";
        }

        Snackbar.make(v,snackBarMessage,Snackbar.LENGTH_SHORT)
                .setAction("Action",null).show();
    }


}
