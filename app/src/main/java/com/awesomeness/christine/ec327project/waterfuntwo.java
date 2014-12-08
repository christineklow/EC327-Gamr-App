package com.awesomeness.christine.ec327project;

import android.app.Activity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View.OnTouchListener;
import android.view.MotionEvent;
import android.os.CountDownTimer;
import android.widget.ImageView;



public class waterfuntwo extends ActionBarActivity {
    ImageButton ib1;
    ImageButton ib2;
    Button replay;
    ImageView fishone;
    ImageView fish2;
    int distance = 100;
    double distanceToGo1;
    double distanceToGo2;
    TextView mTextField;
    TextView mTextField2;
    public void startrace() {

        fish2 = (ImageView) findViewById(R.id.p2fish);
        fishone = (ImageView) findViewById(R.id.p1fish);
        ib1 = (ImageButton) findViewById(R.id.watergunbuttonbottom);
        ib2 = (ImageButton) findViewById(R.id.watergunbuttontop);
        distanceToGo1 = distance;
        distanceToGo2 = distance;

        mTextField.setVisibility(View.VISIBLE);
        mTextField2.setVisibility(View.VISIBLE);
        new CountDownTimer(4000, 1000) {
            public void onTick(long millisUntilFinished) {

                if (millisUntilFinished / 1000 == 3) {
                    mTextField.setText("Ready");
                    mTextField2.setText("Ready");

                } else if (millisUntilFinished / 1000 == 2) {
                    mTextField.setText("Set");
                    mTextField2.setText("Set");

                } else if (millisUntilFinished / 1000 == 1) {
                    mTextField.setText("Go!");
                    mTextField2.setText("Go!");
                }
            }

            public void onFinish() {
                mTextField.setVisibility(View.INVISIBLE);
                mTextField2.setVisibility(View.INVISIBLE);
                ib1.setEnabled(true);
                ib2.setEnabled(true);
                player1move();
                player2move();

            }

        }.start();
    }


    public void player1move() {
        ib1.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        ib1.setImageResource(R.drawable.watergunshooting);
                        distanceToGo1 = distanceToGo1 - 1;
                        player1movefish();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        ib1.setImageResource(R.drawable.watergun);
                        if (distanceToGo1 <= 0 && distanceToGo2 <= 0) {
                            ib1.setEnabled(false);
                            ib2.setEnabled(false);
                            mTextField.setVisibility(View.VISIBLE);
                            mTextField2.setVisibility(View.VISIBLE);
                            new CountDownTimer(2000, 1000) {
                                public void onTick(long millisUntilFinished) {
                                    mTextField.setText("You tie!");
                                    mTextField2.setText("You tie!");
                                }

                                public void onFinish() {
                                    configureReplayButton();
                                }
                            }.start();
                        } else if (distanceToGo1 <= 0) {
                            ib1.setEnabled(false);
                            ib2.setEnabled(false);
                            mTextField.setVisibility(View.VISIBLE);
                            mTextField2.setVisibility(View.VISIBLE);
                            new CountDownTimer(2000, 1000) {
                                public void onTick(long millisUntilFinished) {
                                    mTextField2.setText("You Win!");
                                    mTextField.setText("You Lose!");
                                }

                                public void onFinish() {
                                    configureReplayButton();

                                }
                            }.start();

                        }
                        break;
                    }
                }
                return false;
            }
        });

    }
    public void player2move() {
        ib2.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        ib2.setImageResource(R.drawable.watergunshooting);
                        distanceToGo2 = distanceToGo2 - 1;
                        player2movefish();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        ib2.setImageResource(R.drawable.watergun);
                        if (distanceToGo1 <= 0 && distanceToGo2 <= 0) {
                            ib1.setEnabled(false);
                            ib2.setEnabled(false);
                            mTextField.setVisibility(View.VISIBLE);
                            mTextField2.setVisibility(View.VISIBLE);
                            new CountDownTimer(2000, 1000) {
                                public void onTick(long millisUntilFinished) {
                                    mTextField.setText("You tie!");
                                    mTextField2.setText("You tie!");
                                }

                                public void onFinish() {
                                    configureReplayButton();
                                }
                            }.start();
                        } else if (distanceToGo2 <= 0) {
                            ib1.setEnabled(false);
                            ib2.setEnabled(false);
                            mTextField.setVisibility(View.VISIBLE);
                            mTextField2.setVisibility(View.VISIBLE);
                            new CountDownTimer(2000, 1000) {
                                public void onTick(long millisUntilFinished) {
                                    mTextField.setText("You Win!");
                                    mTextField2.setText("You Lose!");

                                }

                                public void onFinish() {
                                    configureReplayButton();

                                }
                            }.start();

                        }
                        break;
                    }
                }
                return false;
            }
        });

    }


    public void configureReplayButton() {
        replay = (Button) findViewById(R.id.replay);
        replay.setVisibility(View.VISIBLE);
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replay.setVisibility(View.INVISIBLE);
                ib1.setEnabled(false);
                ib2.setEnabled(false);
                startrace();

            }
        });
        fishone.setBackgroundResource(R.drawable.fone);
        fish2.setBackgroundResource(R.drawable.fone);

    }

    public void player1movefish() {
        //fishone = (ImageView) findViewById(R.id.p1fish);


        if (distanceToGo1 <= 100 && distanceToGo1 > 98) {
            fishone.setBackgroundResource(R.drawable.fone);
        } else if (distanceToGo1 <= 98 && distanceToGo1 > 96) {
            fishone.setBackgroundResource(R.drawable.ftwo);
        } else if (distanceToGo1 <= 96 && distanceToGo1 > 94) {
            fishone.setBackgroundResource(R.drawable.fthree);
        } else if (distanceToGo1 <= 94 && distanceToGo1 > 92) {
            fishone.setBackgroundResource(R.drawable.ffour);
        } else if (distanceToGo1 <= 92 && distanceToGo1 > 90) {
            fishone.setBackgroundResource(R.drawable.ffive);
        } else if (distanceToGo1 <= 90 && distanceToGo1 > 88) {
            fishone.setBackgroundResource(R.drawable.fsix);
        } else if (distanceToGo1 <= 88 && distanceToGo1 > 86) {
            fishone.setBackgroundResource(R.drawable.fseven);
        } else if (distanceToGo1 <= 86 && distanceToGo1 > 84) {
            fishone.setBackgroundResource(R.drawable.feight);
        } else if (distanceToGo1 <= 84 && distanceToGo1 > 82) {
            fishone.setBackgroundResource(R.drawable.fnine);
        } else if (distanceToGo1 <= 82 && distanceToGo1 > 80) {
            fishone.setBackgroundResource(R.drawable.ften);
        } else if (distanceToGo1 <= 80 && distanceToGo1 > 78) {
            fishone.setBackgroundResource(R.drawable.feleven);
        } else if (distanceToGo1 <= 78 && distanceToGo1 > 76) {
            fishone.setBackgroundResource(R.drawable.ftwelve);
        } else if (distanceToGo1 <= 76 && distanceToGo1 > 74) {
            fishone.setBackgroundResource(R.drawable.fthirteen);
        } else if (distanceToGo1 <= 74 && distanceToGo1 > 72) {
            fishone.setBackgroundResource(R.drawable.ffourteen);
        } else if (distanceToGo1 <= 72 && distanceToGo1 > 70) {
            fishone.setBackgroundResource(R.drawable.ffifteen);
        } else if (distanceToGo1 <= 70 && distanceToGo1 > 68) {
            fishone.setBackgroundResource(R.drawable.fsixteen);
        } else if (distanceToGo1 <= 68 && distanceToGo1 > 66) {
            fishone.setBackgroundResource(R.drawable.fseventeen);
        } else if (distanceToGo1 <= 66 && distanceToGo1 > 64) {
            fishone.setBackgroundResource(R.drawable.feighteen);
        } else if (distanceToGo1 <= 64 && distanceToGo1 > 62) {
            fishone.setBackgroundResource(R.drawable.fnineteen);
        } else if (distanceToGo1 <= 62 && distanceToGo1 > 60) {
            fishone.setBackgroundResource(R.drawable.ftwenty);
        } else if (distanceToGo1 <= 60 && distanceToGo1 > 58) {
            fishone.setBackgroundResource(R.drawable.ftwentyone);
        } else if (distanceToGo1 <= 58 && distanceToGo1 > 56) {
            fishone.setBackgroundResource(R.drawable.ftwentytwo);
        } else if (distanceToGo1 <= 56 && distanceToGo1 > 54) {
            fishone.setBackgroundResource(R.drawable.ftwentythree);
        } else if (distanceToGo1 <= 54 && distanceToGo1 > 52) {
            fishone.setBackgroundResource(R.drawable.ftwentyfour);
        } else if (distanceToGo1 <= 52 && distanceToGo1 > 50) {
            fishone.setBackgroundResource(R.drawable.ftwentyfive);
        } else if (distanceToGo1 <= 50 && distanceToGo1 > 48) {
            fishone.setBackgroundResource(R.drawable.ftwentysix);
        } else if (distanceToGo1 <= 48 && distanceToGo1 > 46) {
            fishone.setBackgroundResource(R.drawable.ftwentyseven);
        } else if (distanceToGo1 <= 46 && distanceToGo1 > 44) {
            fishone.setBackgroundResource(R.drawable.ftwentyeight);
        } else if (distanceToGo1 <= 44 && distanceToGo1 > 42) {
            fishone.setBackgroundResource(R.drawable.ftwentynine);
        } else if (distanceToGo1 <= 42 && distanceToGo1 > 40) {
            fishone.setBackgroundResource(R.drawable.fthirty);
        } else if (distanceToGo1 <= 40 && distanceToGo1 > 38) {
            fishone.setBackgroundResource(R.drawable.fthirtyone);
        } else if (distanceToGo1 <= 38 && distanceToGo1 > 36) {
            fishone.setBackgroundResource(R.drawable.fthirtytwo);
        } else if (distanceToGo1 <= 36 && distanceToGo1 > 34) {
            fishone.setBackgroundResource(R.drawable.fthirtythree);
        } else if (distanceToGo1 <= 34 && distanceToGo1 > 32) {
            fishone.setBackgroundResource(R.drawable.fthirtyfour);
        } else if (distanceToGo1 <= 32 && distanceToGo1 > 30) {
            fishone.setBackgroundResource(R.drawable.fthirtyfive);
        } else if (distanceToGo1 <= 30 && distanceToGo1 > 28) {
            fishone.setBackgroundResource(R.drawable.fthirtysix);
        } else if (distanceToGo1 <= 28 && distanceToGo1 > 26) {
            fishone.setBackgroundResource(R.drawable.fthirtyseven);
        } else if (distanceToGo1 <= 26 && distanceToGo1 > 24) {
            fishone.setBackgroundResource(R.drawable.fthirtyeight);
        } else if (distanceToGo1 <= 24 && distanceToGo1 > 22) {
            fishone.setBackgroundResource(R.drawable.fthirtynine);
        } else if (distanceToGo1 <= 22 && distanceToGo1 > 20) {
            fishone.setBackgroundResource(R.drawable.ffourty);
        } else if (distanceToGo1 <= 20 && distanceToGo1 > 18) {
            fishone.setBackgroundResource(R.drawable.ffourtyone);
        } else if (distanceToGo1 <= 18 && distanceToGo1 > 16) {
            fishone.setBackgroundResource(R.drawable.ffourtytwo);
        } else if (distanceToGo1 <= 16 && distanceToGo1 > 14) {
            fishone.setBackgroundResource(R.drawable.ffourtythree);
        } else if (distanceToGo1 <= 14 && distanceToGo1 > 12) {
            fishone.setBackgroundResource(R.drawable.ffourtyfour);
        } else if (distanceToGo1 <= 12 && distanceToGo1 > 10) {
            fishone.setBackgroundResource(R.drawable.ffourtyfive);
        } else if (distanceToGo1 <= 10 && distanceToGo1 > 8) {
            fishone.setBackgroundResource(R.drawable.ffourtysix);
        } else if (distanceToGo1 <= 8 && distanceToGo1 > 6) {
            fishone.setBackgroundResource(R.drawable.ffourtyseven);
        } else if (distanceToGo1 <= 6 && distanceToGo1 > 4) {
            fishone.setBackgroundResource(R.drawable.ffourtyeight);
        } else if (distanceToGo1 <= 4 && distanceToGo1 > 2) {
            fishone.setBackgroundResource(R.drawable.ffourtynine);
        } else if (distanceToGo1 <= 2 && distanceToGo1 > 0) {
            fishone.setBackgroundResource(R.drawable.ffifty);
        }


        //physically move fish here

    }

    public void player2movefish() {
        //fish2 = (ImageView) findViewById(R.id.p2fish);
        if (distanceToGo2 <= 100 && distanceToGo2 > 98) {
            fish2.setBackgroundResource(R.drawable.fone);
        } else if (distanceToGo2 <= 98 && distanceToGo2 > 96) {
            fish2.setBackgroundResource(R.drawable.ftwo);
        } else if (distanceToGo2 <= 96 && distanceToGo2 > 94) {
            fish2.setBackgroundResource(R.drawable.fthree);
        } else if (distanceToGo2 <= 94 && distanceToGo2 > 92) {
            fish2.setBackgroundResource(R.drawable.ffour);
        } else if (distanceToGo2 <= 92 && distanceToGo2 > 90) {
            fish2.setBackgroundResource(R.drawable.ffive);
        } else if (distanceToGo2 <= 90 && distanceToGo2 > 88) {
            fish2.setBackgroundResource(R.drawable.fsix);
        } else if (distanceToGo2 <= 88 && distanceToGo2 > 86) {
            fish2.setBackgroundResource(R.drawable.fseven);
        } else if (distanceToGo2 <= 86 && distanceToGo2 > 84) {
            fish2.setBackgroundResource(R.drawable.feight);
        } else if (distanceToGo2 <= 84 && distanceToGo2 > 82) {
            fish2.setBackgroundResource(R.drawable.fnine);
        } else if (distanceToGo2 <= 82 && distanceToGo2 > 80) {
            fish2.setBackgroundResource(R.drawable.ften);
        } else if (distanceToGo2 <= 80 && distanceToGo2 > 78) {
            fish2.setBackgroundResource(R.drawable.feleven);
        } else if (distanceToGo2 <= 78 && distanceToGo2 > 76) {
            fish2.setBackgroundResource(R.drawable.ftwelve);
        } else if (distanceToGo2 <= 76 && distanceToGo2 > 74) {
            fish2.setBackgroundResource(R.drawable.fthirteen);
        } else if (distanceToGo2 <= 74 && distanceToGo2 > 72) {
            fish2.setBackgroundResource(R.drawable.ffourteen);
        } else if (distanceToGo2 <= 72 && distanceToGo2 > 70) {
            fish2.setBackgroundResource(R.drawable.ffifteen);
        } else if (distanceToGo2 <= 70 && distanceToGo2 > 68) {
            fish2.setBackgroundResource(R.drawable.fsixteen);
        } else if (distanceToGo2 <= 68 && distanceToGo2 > 66) {
            fish2.setBackgroundResource(R.drawable.fseventeen);
        } else if (distanceToGo2 <= 66 && distanceToGo2 > 64) {
            fish2.setBackgroundResource(R.drawable.feighteen);
        } else if (distanceToGo2 <= 64 && distanceToGo2 > 62) {
            fish2.setBackgroundResource(R.drawable.fnineteen);
        } else if (distanceToGo2 <= 62 && distanceToGo2 > 60) {
            fish2.setBackgroundResource(R.drawable.ftwenty);
        } else if (distanceToGo2 <= 60 && distanceToGo2 > 58) {
            fish2.setBackgroundResource(R.drawable.ftwentyone);
        } else if (distanceToGo2 <= 58 && distanceToGo2 > 56) {
            fish2.setBackgroundResource(R.drawable.ftwentytwo);
        } else if (distanceToGo2 <= 56 && distanceToGo2 > 54) {
            fish2.setBackgroundResource(R.drawable.ftwentythree);
        } else if (distanceToGo2 <= 54 && distanceToGo2 > 52) {
            fish2.setBackgroundResource(R.drawable.ftwentyfour);
        } else if (distanceToGo2 <= 52 && distanceToGo2 > 50) {
            fish2.setBackgroundResource(R.drawable.ftwentyfive);
        } else if (distanceToGo2 <= 50 && distanceToGo2 > 48) {
            fish2.setBackgroundResource(R.drawable.ftwentysix);
        } else if (distanceToGo2 <= 48 && distanceToGo2 > 46) {
            fish2.setBackgroundResource(R.drawable.ftwentyseven);
        } else if (distanceToGo2 <= 46 && distanceToGo2 > 44) {
            fish2.setBackgroundResource(R.drawable.ftwentyeight);
        } else if (distanceToGo2 <= 44 && distanceToGo2 > 42) {
            fish2.setBackgroundResource(R.drawable.ftwentynine);
        } else if (distanceToGo2 <= 42 && distanceToGo2 > 40) {
            fish2.setBackgroundResource(R.drawable.fthirty);
        } else if (distanceToGo2 <= 40 && distanceToGo2 > 38) {
            fish2.setBackgroundResource(R.drawable.fthirtyone);
        } else if (distanceToGo2 <= 38 && distanceToGo2 > 36) {
            fish2.setBackgroundResource(R.drawable.fthirtytwo);
        } else if (distanceToGo2 <= 36 && distanceToGo2 > 34) {
            fish2.setBackgroundResource(R.drawable.fthirtythree);
        } else if (distanceToGo2 <= 34 && distanceToGo2 > 32) {
            fish2.setBackgroundResource(R.drawable.fthirtyfour);
        } else if (distanceToGo2 <= 32 && distanceToGo2 > 30) {
            fish2.setBackgroundResource(R.drawable.fthirtyfive);
        } else if (distanceToGo2 <= 30 && distanceToGo2 > 28) {
            fish2.setBackgroundResource(R.drawable.fthirtysix);
        } else if (distanceToGo2 <= 28 && distanceToGo2 > 26) {
            fish2.setBackgroundResource(R.drawable.fthirtyseven);
        } else if (distanceToGo2 <= 26 && distanceToGo2 > 24) {
            fish2.setBackgroundResource(R.drawable.fthirtyeight);
        } else if (distanceToGo2 <= 24 && distanceToGo2 > 22) {
            fish2.setBackgroundResource(R.drawable.fthirtynine);
        } else if (distanceToGo2 <= 22 && distanceToGo2 > 20) {
            fish2.setBackgroundResource(R.drawable.ffourty);
        } else if (distanceToGo2 <= 20 && distanceToGo2 > 18) {
            fish2.setBackgroundResource(R.drawable.ffourtyone);
        } else if (distanceToGo2 <= 18 && distanceToGo2 > 16) {
            fish2.setBackgroundResource(R.drawable.ffourtytwo);
        } else if (distanceToGo2 <= 16 && distanceToGo2 > 14) {
            fish2.setBackgroundResource(R.drawable.ffourtythree);
        } else if (distanceToGo2 <= 14 && distanceToGo2 > 12) {
            fish2.setBackgroundResource(R.drawable.ffourtyfour);
        } else if (distanceToGo2 <= 12 && distanceToGo2 > 10) {
            fish2.setBackgroundResource(R.drawable.ffourtyfive);
        } else if (distanceToGo2 <= 10 && distanceToGo2 > 8) {
            fish2.setBackgroundResource(R.drawable.ffourtysix);
        } else if (distanceToGo2 <= 8 && distanceToGo2 > 6) {
            fish2.setBackgroundResource(R.drawable.ffourtyseven);
        } else if (distanceToGo2 <= 6 && distanceToGo2 > 4) {
            fish2.setBackgroundResource(R.drawable.ffourtyeight);
        } else if (distanceToGo2 <= 4 && distanceToGo2 > 2) {
            fish2.setBackgroundResource(R.drawable.ffourtynine);
        } else if (distanceToGo2 <= 2 && distanceToGo2 > 0) {
            fish2.setBackgroundResource(R.drawable.ffifty);
        }


        //physically move fish here

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterfuntwo);
        //goto main???

        mTextField = (TextView) findViewById(R.id.readysetgo);
        mTextField2 = (TextView) findViewById(R.id.readysetgotop);
        startrace();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_waterfuntwo, menu);
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