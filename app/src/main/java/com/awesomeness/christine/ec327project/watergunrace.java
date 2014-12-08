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
    int distance = 50;
    int step = 1;
    double distanceToGo1;
    double distanceToGo2;
    double speed2 = 1;
    TextView mTextField;


    public void startrace()
    {

        ib1 = (ImageButton)findViewById(R.id.watergunbutton);
        ibc = (ImageButton)findViewById(R.id.waterguncomputer);


        mTextField.setVisibility(View.VISIBLE);
        new CountDownTimer(5000, 1000) {
            public void onTick(long millisUntilFinished) {

                if (millisUntilFinished/1000 == 4)
                {
                    mTextField.setText("Ready");

                }

                else if (millisUntilFinished/1000 == 3)
                {
                    mTextField.setText("Set");

                }

                else if (millisUntilFinished/1000 == 2)
                {
                    mTextField.setText("Go! ;)");

                }

                else if (millisUntilFinished/1000 == 1)
                {
                    mTextField.setText(" ");

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
/*
                new CountDownTimer(4000, 100) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        computermove();
                    }
                }.start();

                for (int i = 0; i < distance; i++) {

                    player1configurebutton();
                    //timer to call the computer, delay it
                    new CountDownTimer(500, 100) {
                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            computermove();
                        }
                    }.start();

                    if (distanceToGo1 <= 0 && distanceToGo2 <= 0) {
                        mTextField.setVisibility(View.VISIBLE);
                        mTextField.setText("It's a tie");
                        break;

                    } else if (distanceToGo1 <= 0) {
                        mTextField.setVisibility(View.VISIBLE);
                        mTextField.setText("You won!");
                        break;

                    } else if (distanceToGo2 <= 0) {
                        mTextField.setVisibility(View.VISIBLE);
                        mTextField.setText("You lost! *Wah wah waaaaaaaaaaah*");
                        break;

                    }


                }*/
            }

        }.start();
/*
       distanceToGo1 = distance;
       distanceToGo2 = distance;

        player1configurebutton();

        new CountDownTimer(4000, 100) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                computermove();
            }
        }.start();

           for(int i = 0; i<distance; i++) {

               player1configurebutton();
               //timer to call the computer, delay it
               new CountDownTimer(500, 100) {
                   public void onTick(long millisUntilFinished) {
                   }

                   public void onFinish() {
                       computermove();
                   }
               }.start();

               if (distanceToGo1 <= 0 && distanceToGo2 <= 0) {
                   mTextField.setVisibility(View.VISIBLE);
                   mTextField.setText("It's a tie");
                   break;

               } else if (distanceToGo1 <= 0) {
                   mTextField.setVisibility(View.VISIBLE);
                   mTextField.setText("You won!");
                   break;

               } else if (distanceToGo2 <= 0) {
                   mTextField.setVisibility(View.VISIBLE);
                   mTextField.setText("You lost! *Wah wah waaaaaaaaaaah*");
                   break;

               }

           }*/


    }

    public void player1configurebutton()
    {
        ib1.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        ib1.setImageResource(R.drawable.watergunshooting);
                        player1move();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        ib1.setImageResource(R.drawable.watergun);
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
                /*Random rand = new Random();
                speed2 = rand.nextDouble()*(2);
                distanceToGo2 = distanceToGo2-speed2;*/
                if (distanceToGo2 != 0)
                {
                    computermove();
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