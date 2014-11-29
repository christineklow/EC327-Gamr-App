package com.awesomeness.christine.ec327project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class mainscreen extends Activity implements View.OnClickListener {

    ImageButton one_player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        one_player = (ImageButton) findViewById(R.id.oneplayer);
        one_player.setOnClickListener(this);
    }

    private void configurePlayer1() {
                startActivity(new Intent("gamelist"));
            }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.oneplayer:
                configurePlayer1();
                break;
        }
    }

            @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.menu_mainscreen, menu);
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
