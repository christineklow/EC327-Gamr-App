package com.awesomeness.christine.ec327project;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class gamelisttwoplayer extends ActionBarActivity {

    ImageButton ticbutton;
    ImageButton waterrace;

    public void configuretictactoe(){
        ticbutton = (ImageButton) findViewById(R.id.ticbutton2);
        ticbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        waterrace.setImageResource(R.drawable.buttontictactoeglow);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        waterrace.setImageResource(R.drawable.buttontictactoe);
                        startActivity(new Intent("tictactoetwoplayer"));
                    }
                }
                return false;
            }

        });
    }

    public void configurewaterrace(){
        waterrace = (ImageButton) findViewById(R.id.waterrace2);
        waterrace.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        waterrace.setImageResource(R.drawable.buttonwaterfunglow);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        waterrace.setImageResource(R.drawable.buttonwaterfun);
                        startActivity(new Intent("waterrace2"));
                    }
                }
                return false;
            }

        });
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamelisttwoplayer);

        configuretictactoe();
        configurewaterrace();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gamelisttwoplayer, menu);
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
