package com.awesomeness.christine.ec327project;

import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class dontpush extends ActionBarActivity {

    ImageButton button;
    ImageView command;
    ImageView pushmessage;
    TextView wait;
    Button replay;
    boolean dontcheck = false;
    boolean check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dontpush);

        button = (ImageButton) findViewById(R.id.dontpressbutton);
        command = (ImageView) findViewById(R.id.dontpresstitle);
        replay = (Button) findViewById(R.id.pushreplay);
        wait = (TextView) findViewById(R.id.wait);

        //configuredontpush();
        dontpushtimer();
    }

    public void dontpushtimer()
    {
        Random random = new Random();
        int time = (random.nextInt(10)+1) * 1000;

        configuredontpush();
        wait.setVisibility(View.VISIBLE);

        new CountDownTimer(time,1000) {

            int i = 0;

            public void onTick(long millisUntilFinished) {
                if(!dontcheck) {
                    switch (i) {
                        case 0:
                            wait.setText("Wait");
                            i++;
                            break;
                        case 1:
                            wait.setText("Wait.");
                            i++;
                            break;
                        case 2:
                            wait.setText("Wait..");
                            i++;
                            break;
                        case 3:
                            wait.setText("Wait...");
                            i = 0;
                            break;
                    }
                }
            }

            public void onFinish() {
                if(!dontcheck) {
                    pushtimer();
                }
            }
        }.start();
    }

    public void pushtimer()
    {
        configurepush();
        wait.setText("NOW.");

            new CountDownTimer(400, 400) {

                public void onTick(long millisUntilFinished) {
                }

                public void onFinish() {
                    if (!check) {
                        dontpushtimer();
                    }
                }
            }.start();

    }

    public void configuredontpush(){
        command.setImageResource(R.drawable.dontpresstitle);
        pushmessage = (ImageView) findViewById(R.id.buttonmessage1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setVisibility(View.GONE);
                command.setVisibility(View.GONE);
                pushmessage.setVisibility(View.VISIBLE);
                pushmessage.setImageResource(R.drawable.buttonmessage);
                replay.setVisibility(View.VISIBLE);
                wait.setVisibility(View.INVISIBLE);
                dontcheck = true;
                configurereplay();
            }
        });
    }

    public void configurereplay(){
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setreplay();
            }
        });
    }

    public void configurepush(){
        command.setImageResource(R.drawable.pushbutton);
        pushmessage = (ImageView) findViewById(R.id.buttonmessage1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setVisibility(View.GONE);
                command.setVisibility(View.GONE);
                pushmessage.setVisibility(View.VISIBLE);
                pushmessage.setImageResource(R.drawable.buttonmessagepush);
                replay.setVisibility(View.VISIBLE);
                wait.setVisibility(View.INVISIBLE);
                configurereplay();
                check = true;
            }
        });
    }

    public void setreplay()
    {
        check = false;
        dontcheck = false;
        button.setVisibility(View.VISIBLE);
        command.setVisibility(View.VISIBLE);
        replay.setVisibility(View.INVISIBLE);
        pushmessage.setVisibility(View.INVISIBLE);
        dontpushtimer();
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
