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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simonsays);

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

        //show the pattern
        for( int i = 0 ; i < count ; i++)
        {
            showpattern(Pattern[i]);
        }

        playerturn();
    }

    public void showpattern(int color){
        switch(color){
            case 1: green.setImageResource(R.drawable.simongreen);break;
            case 2: blue.setImageResource(R.drawable.simonblue); break;
            case 3: yellow.setImageResource(R.drawable.simonyellow);break;
            case 4: red.setImageResource(R.drawable.simonred);break;
        }
    }

    public boolean playerturn()
    {
        message.setText("Your turn.");
        green.setEnabled(true);
        blue.setEnabled(true);
        yellow.setEnabled(true);
        red.setEnabled(true);
        return true;

    }

    public void configuregreen(){
        green.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        green.setImageResource(R.drawable.simongreen);
                        break;
                    case MotionEvent.ACTION_UP:
                        green.setImageResource(R.drawable.simongreenoff);
                        break;
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
