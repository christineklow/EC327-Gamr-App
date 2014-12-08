package com.awesomeness.christine.ec327project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;


public class mainscreen extends Activity /*implements View.OnClickListener*/ {

    ImageButton one_player;
    ImageButton two_player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        one_player = (ImageButton) findViewById(R.id.oneplayer);
        two_player = (ImageButton) findViewById(R.id.twoplayers);
        configureoneplayer();
        configuretwoplayer();
    }

    private void Player1() {
                startActivity(new Intent("gamelist"));
            }

    private void Player2(){
        startActivity(new Intent("gamelisttwoplayer"));
    }

    // 1 player button
    public void configureoneplayer(){
        one_player.setEnabled(true);
        one_player.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        one_player.setImageResource(R.drawable.oneplayerglow);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        one_player.setImageResource(R.drawable.one_player);
                        Player1();
                    }
                }
                return false;
            }
        });
    }

    // 2 players button
    public void configuretwoplayer(){
        two_player.setEnabled(true);
        two_player.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        two_player.setImageResource(R.drawable.twoplayerglow);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        two_player.setImageResource(R.drawable.twoplayer);
                        Player2();
                    }
                }
                return false;
            }
        });
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
