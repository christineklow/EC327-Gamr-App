package com.awesomeness.christine.ec327project;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View.OnTouchListener;
import android.view.MotionEvent;
import android.view.View;
import android.os.CountDownTimer;

import java.util.Random;


public class simonsays extends ActionBarActivity {

    ImageButton green;
    ImageButton blue;
    ImageButton yellow;
    ImageButton red;
    TextView message;
    int[] Pattern= new int[20];
    int[] userInput= new int[20];
    int count = 0;
    int usercount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simonsays);

        green.setEnabled(false);
        blue.setEnabled(false);
        yellow.setEnabled(false);
        red.setEnabled(false);

        green = (ImageButton)findViewById(R.id.green); //1
        blue = (ImageButton)findViewById(R.id.blue); //2
        yellow = (ImageButton)findViewById(R.id.yellow); //3
        red = (ImageButton)findViewById(R.id.red); //4
        message = (TextView)findViewById(R.id.simoninstructions);

        addpattern();
    }

    public void addpattern(){

        //create next pattern step
        Random random = new Random();
        Pattern[count] = random.nextInt(3)+1;
        green.setEnabled(false);
        blue.setEnabled(false);
        yellow.setEnabled(false);
        red.setEnabled(false);

        count++;

        new CountDownTimer(2000,1000) {

            public void onTick(long m){

            }

            public void onFinish() {
                //show the pattern
                for (
                        int i = 0;
                        i < count; i++)

                {
                    final int finalI = i;
                    new CountDownTimer(1000, 1000) {

                        public void onTick(long millisUntilFinished) {
                            showpattern(Pattern[finalI]);
                        }

                        public void onFinish() {
                            hidepattern(Pattern[finalI]);
                        }
                    }.start();
                    showpattern(Pattern[i]);
                }
            }
        }.start();

        playerturn();
    }

    //makes the buttons light up with automated pattern
    public void showpattern(int color){
        switch(color){
            case 1: green.setImageResource(R.drawable.simongreen);break;
            case 2: blue.setImageResource(R.drawable.simonblue); break;
            case 3: yellow.setImageResource(R.drawable.simonyellow);break;
            case 4: red.setImageResource(R.drawable.simonred);break;
        }
    }

    //turns the light off for next in sequence
    public void hidepattern(int color){
        switch(color){
            case 1: green.setImageResource(R.drawable.simongreenoff);break;
            case 2: blue.setImageResource(R.drawable.simonblueoff); break;
            case 3: yellow.setImageResource(R.drawable.simonyellowoff);break;
            case 4: red.setImageResource(R.drawable.simonredoff);break;
        }
    }

    //player's turn
    public boolean playerturn()
    {
        //count marks beginning of user's sequence
        usercount = 0;
        message.setText("Your turn.");

        //makes buttons clickable for player to replicate pattern
        configuregreen();
        configureblue();
        configureyellow();
        configurered();
        return true;
    }

    //check if player's input matches next in generated sequence
    public boolean checksequence(int i){
        if(userInput[i] == Pattern[i])
            return true;
        else
            return false;
    }

    public void gameover()
    {

    }

    public void configuregreen(){
        green.setEnabled(true);
        green.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        green.setImageResource(R.drawable.simongreen);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        green.setImageResource(R.drawable.simongreenoff);
                        if (checksequence(usercount))
                        {
                            //continue game
                            usercount++;
                        }

                        else
                        {
                            //display end of game
                        }
                        break;
                    }
                }
                return false;
            }
        });
    }

    public void configureblue(){
        blue.setEnabled(true);
        blue.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        blue.setImageResource(R.drawable.simonblue);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        blue.setImageResource(R.drawable.simonblueoff);
                        usercount++;
                        break;
                    }
                }
                return false;
            }
        });
    }

    public void configureyellow(){
        yellow.setEnabled(true);
        yellow.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        yellow.setImageResource(R.drawable.simonyellow);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        yellow.setImageResource(R.drawable.simonyellowoff);
                        usercount++;
                        break;
                    }
                }
                return false;
            }
        });
    }

    public void configurered(){
        red.setEnabled(true);
        red.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        red.setImageResource(R.drawable.simonred);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        red.setImageResource(R.drawable.simonredoff);
                        usercount++;
                        break;
                    }
                }
                return false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_simonsays, menu);
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
