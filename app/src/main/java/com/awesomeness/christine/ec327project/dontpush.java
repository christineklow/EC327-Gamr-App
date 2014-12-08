package com.awesomeness.christine.ec327project;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;


public class dontpush extends ActionBarActivity {

    ImageButton button;
    ImageView initial;
    ImageView pushmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dontpush);

        button = (ImageButton) findViewById(R.id.dontpressbutton);
        initial = (ImageView) findViewById(R.id.dontpresstitle);

        configuredontpush();
    }

    public void configuredontpush(){
        pushmessage = (ImageView) findViewById(R.id.buttonmessage1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setVisibility(View.GONE);
                initial.setVisibility(View.GONE);
                pushmessage.setVisibility(View.VISIBLE);
                pushmessage.setBackgroundResource(R.drawable.buttonmessage);
            }
        });
    }

    public void configurepush(){
        pushmessage = (ImageView) findViewById(R.id.buttonmessage1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setVisibility(View.GONE);
                initial.setVisibility(View.GONE);
                pushmessage.setVisibility(View.VISIBLE);
                pushmessage.setBackgroundResource(R.drawable.buttonmessagepush);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dontpush, menu);
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
