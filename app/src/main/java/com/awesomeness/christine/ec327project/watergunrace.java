package com.awesomeness.christine.ec327project;

import android.app.Activity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import java.util.Random;
import android.view.View.OnTouchListener;
import android.view.MotionEvent;
import android.view.InputEvent;
import android.os.CountDownTimer;
import android.graphics.Canvas;
import android.graphics.BitmapFactory;
import android.view.SurfaceHolder;




public class watergunrace extends ActionBarActivity
{
    ImageButton ib1;
    ImageButton ib2;
    ImageButton ibc;
    int distance = 100;
    int step = 1;
    double distanceToGo1;
    double distanceToGo2;
    double speed2 = 1;
    TextView mTextField;


    public void startrace() {

        ib1 = (ImageButton) findViewById(R.id.watergunbutton);
        ibc = (ImageButton) findViewById(R.id.waterguncomputer);


        mTextField.setVisibility(View.VISIBLE);
        new CountDownTimer(4000, 1000) {
            public void onTick(long millisUntilFinished) {

                if (millisUntilFinished / 1000 == 3) {
                    mTextField.setText("Ready");

                } else if (millisUntilFinished / 1000 == 2) {
                    mTextField.setText("Set");

                } else if (millisUntilFinished / 1000 == 1) {
                    mTextField.setText("Go! ;)");

                }


            }

            public void onFinish() {

                mTextField.setVisibility(View.INVISIBLE);

                //set visibility for readysetgo to invisible

                //testing
                distanceToGo1 = distance;
                distanceToGo2 = distance;
                player1configurebutton();


                computermove();

            }

        }.start();
    }



    public void player1configurebutton()
    {
        ib1.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        ib1.setImageResource(R.drawable.watergunshooting);
                        distanceToGo1 = distanceToGo1-1;
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        ib1.setImageResource(R.drawable.watergun);
                        if(distanceToGo1<=0 && distanceToGo2<=0)
                        {
                            ib1.setEnabled(false);
                            mTextField.setVisibility(View.VISIBLE);
                            mTextField.setText("You tie!");
                        }
                        else if(distanceToGo1<=0)
                        {
                            ib1.setEnabled(false);
                            mTextField.setVisibility(View.VISIBLE);
                            mTextField.setText("You win!");

                        }
                        break;
                    }
                }
                return false;
            }
        });

    }

    public void computermove()
    {
        Random rand = new Random();
        speed2 = rand.nextDouble()*(2);
        distanceToGo2 = distanceToGo2-speed2;
        long computershootingtime = (long) (speed2 * 100);


        new CountDownTimer(computershootingtime, 1) {
            public void onTick(long millisUntilFinished) {
                ibc.setImageResource(R.drawable.watergunshooting);
            }
            public void onFinish() {
                ibc.setImageResource(R.drawable.watergun);
                if(distanceToGo1<=0 && distanceToGo2<=0) {
                }
                else if (distanceToGo1<=0)
                {
                }
                else if (distanceToGo2 > 0) {
                    new CountDownTimer(110, 100) {
                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            computermove();
                        }
                    }.start();
                }
                else
                {
                    mTextField.setVisibility(View.VISIBLE);
                    mTextField.setText("You lose!");
                    ib1.setEnabled(false);
                }
            }
        }.start();

        //learn how to physically move fish
    }

    public void player1move()
    {
        distanceToGo1 = distanceToGo1-1;

       //physically move fish here


    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watergunrace);
        //goto main???

        mTextField = (TextView) findViewById(R.id.readysetgo);

        startrace();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_watergunrace, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
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

    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.fish), 10, 10, null);
    }


}