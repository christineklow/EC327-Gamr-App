package com.awesomeness.christine.ec327project;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
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
    Button replay;
    TextView message;
    TextView ready;
    int[] Pattern;//= new int[200];
    int[] userInput;//= new int[200];
    int patterncount = 0;
    int count = 0;
    int usercount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simonsays);

        green = (ImageButton)findViewById(R.id.green); //1
        blue = (ImageButton)findViewById(R.id.blue); //2
        yellow = (ImageButton)findViewById(R.id.yellow); //3
        red = (ImageButton)findViewById(R.id.red); //4
        message = (TextView)findViewById(R.id.simoninstructions);
        ready = (TextView)findViewById(R.id.simonready);
        replay = (Button)findViewById(R.id.simonreplay);

        Pattern= new int[200];
        userInput= new int[200];

        new CountDownTimer(5000,1000) {

            public void onTick(long millisUntilFinished) {
                if (millisUntilFinished/1000 == 3)
                {
                    ready.setVisibility(View.VISIBLE);
                    ready.setText("Ready");
                }
                else if (millisUntilFinished/1000 == 2)
                {
                    ready.setText("Set");
                }
                else if (millisUntilFinished/1000 == 1)
                {
                    ready.setText("Go! ");
                }
            }

            public void onFinish() {
                ready.setVisibility(View.INVISIBLE);
                addpattern();
            }
        }.start();
    }

    public void addpattern(){

        green.setEnabled(false);
        blue.setEnabled(false);
        yellow.setEnabled(false);
        red.setEnabled(false);

        message.setText("Repeat the sequence");

        //create next pattern step
        Random random = new Random();
        Pattern[count] = random.nextInt(4)+1;

        final int time = (count+1)*1000;

        new CountDownTimer(1500,1000) {

            public void onTick(long millisUntilFinished) {
                if (count > 0)
                {
                    ready.setVisibility(View.VISIBLE);
                    ready.setText("Good Job");
                }

            }

            public void onFinish() {
                count++;
                ready.setVisibility(View.INVISIBLE);
                showpattern(Pattern[patterncount]);
            }
        }.start();
    }

    //makes the buttons light up with automated pattern
    public void showpattern(final int color){

        new CountDownTimer(1000, 500) {

            public void onTick(long millisUntilFinished) {
                switch(color){
                    case 1: green.setImageResource(R.drawable.simongreen);break;
                    case 2: blue.setImageResource(R.drawable.simonblue); break;
                    case 3: yellow.setImageResource(R.drawable.simonyellow);break;
                    case 4: red.setImageResource(R.drawable.simonred);break;
                }
            }

            public void onFinish() {
                hidepattern(color);
                if(patterncount < count)
                {
                    patterncount++;
                    showpattern(Pattern[patterncount]);
                }
                else
                {
                    patterncount = 0;
                    usercount = 0;
                    playerturn();
                }
            }
        }.start();
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
    public void playerturn()
    {
        //beginning of user's sequence
        message.setText("Your turn.");

        boolean check = false;

        //makes buttons clickable for player to replicate pattern
        configuregreen();
        configureblue();
        configureyellow();
        configurered();

        if (usercount == count)
        {
            addpattern();
        }
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
        green.setVisibility(View.GONE);
        blue.setVisibility(View.GONE);
        yellow.setVisibility(View.GONE);
        red.setVisibility(View.GONE);
        message.setVisibility(View.GONE);
        ready.setVisibility(View.VISIBLE);
        ready.setText("You lost. Can't you remember " + count + " numbers?");
        replay.setVisibility(View.VISIBLE);
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replay.setVisibility(View.INVISIBLE);
                reset();
            }
        });
    }

    public void reset()
    {
        count = 0;
        usercount = 0;
        patterncount = 0;
        green.setVisibility(View.VISIBLE);
        blue.setVisibility(View.VISIBLE);
        yellow.setVisibility(View.VISIBLE);
        red.setVisibility(View.VISIBLE);
        message.setVisibility(View.VISIBLE);
        ready.setVisibility(View.INVISIBLE);

        Pattern= new int[200];
        userInput= new int[200];

        message.setText("Repeat the sequence");

        new CountDownTimer(5000,1000) {

            public void onTick(long millisUntilFinished) {
                if (millisUntilFinished/1000 == 3)
                {
                    ready.setVisibility(View.VISIBLE);
                    ready.setText("Ready");
                }
                else if (millisUntilFinished/1000 == 2)
                {
                    ready.setText("Set");
                }
                else if (millisUntilFinished/1000 == 1)
                {
                    ready.setText("Go! ");
                }
            }

            public void onFinish() {
                ready.setVisibility(View.INVISIBLE);
                addpattern();
            }
        }.start();
    }

    public void configuregreen(){
        green.setEnabled(true);
        green.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        userInput[usercount] = 1;
                        green.setImageResource(R.drawable.simongreen);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        green.setImageResource(R.drawable.simongreenoff);
                        if (checksequence(usercount))
                        {
                            //continue game
                            usercount++;
                            playerturn();
                        }

                        else
                        {
                            //display end of game
                            gameover();
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
                        userInput[usercount] = 2;
                        blue.setImageResource(R.drawable.simonblue);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        blue.setImageResource(R.drawable.simonblueoff);
                        if (checksequence(usercount))
                        {
                            //continue game
                            usercount++;
                            playerturn();
                        }

                        else
                        {
                            //display end of game
                            gameover();
                        }
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
                        userInput[usercount] = 3;
                        yellow.setImageResource(R.drawable.simonyellow);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        yellow.setImageResource(R.drawable.simonyellowoff);
                        if (checksequence(usercount))
                        {
                            //continue game
                            usercount++;
                            playerturn();
                        }

                        else
                        {
                            //display end of game
                            gameover();
                        }
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
                        userInput[usercount] = 4;
                        red.setImageResource(R.drawable.simonred);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        red.setImageResource(R.drawable.simonredoff);
                        if (checksequence(usercount))
                        {
                            //continue game
                            usercount++;
                            playerturn();
                        }

                        else
                        {
                            //display end of game
                            gameover();
                        }
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
