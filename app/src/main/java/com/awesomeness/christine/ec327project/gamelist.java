package com.awesomeness.christine.ec327project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class gamelist extends Activity {

    ImageButton ticbutton;
    ImageButton numbersbutton;
    ImageButton matchpairsbutton;
    ImageButton watergunbutton;
    ImageButton dontpush;
    ImageButton simonsays;
    //Button wackamole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamelist);

        configuretictactoe();
        configurenumbers();
        configurematchpairs();
        configurewatergun();
        configuredontpush();
        configuresimon();
        //configurewackamole();
    }




    //Connecting to tictactoe
    public void configuretictactoe() {
        ticbutton = (ImageButton) findViewById(R.id.ticbutton);
        ticbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        ticbutton.setImageResource(R.drawable.buttontictactoeglow);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        ticbutton.setImageResource(R.drawable.buttontictactoe);
                        startActivity(new Intent("tictactoe"));

                    }
                }
                return false;
            }

        });
    }

    public void configurenumbers() {
        numbersbutton = (ImageButton) findViewById(R.id.numbersbutton);
        numbersbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        numbersbutton.setImageResource(R.drawable.buttonnumbersglow);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        numbersbutton.setImageResource(R.drawable.buttonnumbers);
                        startActivity(new Intent("numbers"));

                    }
                }
                return false;
            }

        });
            }

            public void configurematchpairs() {
                matchpairsbutton = (ImageButton) findViewById(R.id.matching);
                matchpairsbutton.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN: {
                                matchpairsbutton.setImageResource(R.drawable.buttonmatchingglow);
                                break;
                            }
                            case MotionEvent.ACTION_UP: {
                                matchpairsbutton.setImageResource(R.drawable.buttonmatching);
                                startActivity(new Intent("matchingpairs"));

                            }
                        }
                        return false;
                    }

                });
            }

            public void configurewatergun() {
                watergunbutton = (ImageButton) findViewById(R.id.waterrace);
                watergunbutton.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN: {
                                watergunbutton.setImageResource(R.drawable.buttonwaterfunglow);
                                break;
                            }
                            case MotionEvent.ACTION_UP: {
                                watergunbutton.setImageResource(R.drawable.buttonwaterfun);
                                startActivity(new Intent("watergunrace"));

                            }
                        }
                        return false;
                    }

                });
            }

            public void configuredontpush() {
                dontpush = (ImageButton) findViewById(R.id.buttongame);
                dontpush.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN: {
                                dontpush.setImageResource(R.drawable.buttonpushglow);
                                break;
                            }
                            case MotionEvent.ACTION_UP: {
                                dontpush.setImageResource(R.drawable.buttonpush);
                                startActivity(new Intent("dontpush"));

                            }
                        }
                        return false;
                    }

                });
            }

            public void configuresimon() {
                simonsays = (ImageButton) findViewById(R.id.simonsays);
                simonsays.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN: {
                                simonsays.setImageResource(R.drawable.buttonsimonglows);
                                break;
                            }
                            case MotionEvent.ACTION_UP: {
                                simonsays.setImageResource(R.drawable.buttonsimon);
                                startActivity(new Intent("simonsays"));

                            }
                        }
                        return false;
                    }

                });
            }


            @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.menu_gamelist, menu);
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

