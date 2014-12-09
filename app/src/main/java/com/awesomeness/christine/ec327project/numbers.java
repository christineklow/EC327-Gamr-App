package com.awesomeness.christine.ec327project;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.CountDownTimer;


import java.util.Random;


public class numbers extends Activity {

    TextView num_1;
    TextView op_1;
    TextView num_2;
    TextView op_2;
    TextView num_3;
    TextView status;
    TextView equalsign;
    EditText answer;
    Button enter;
    Button replay;
    TextView gameover;
    int num1;
    int num2;
    int num3;
    int num4;
    int num5;
    int result;
    int point = 0;
    int n;
    int count=1;
    int ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        status = (TextView) findViewById(R.id.status);
        equalsign = (TextView) findViewById(R.id.equalsign);
        gameover = (TextView) findViewById(R.id.gameover);
        replay = (Button)findViewById((R.id.replaynumbers));
        main();

    }


    public void configurenum1(int num1) {
        num_1 = (TextView) findViewById(R.id.firstnum);
        num_1.setText("" + num1);
    }

    public void configureop1(int num2) {
        op_1 = (TextView) findViewById(R.id.firstoperation);
        if (num2 == 0) {
            op_1.setText(" + ");
        } else {
            op_1.setText(" - ");
        }
    }

    public void configurenum2(int num3) {
        num_2 = (TextView) findViewById(R.id.secondnum);
        num_2.setText("" + num3);
    }

    public void configureop2(int num4) {
        op_2 = (TextView) findViewById(R.id.secondoperation);
        switch (num4) {
            case 0:
                op_2.setText(" + ");
                break;
            case 1:
                op_2.setText(" - ");
                break;
            case 2:
                op_2.setText(" x ");
                break;
            case 3:
                op_2.setText(" / ");
                break;
        }
    }

    public void configurenum3(int num5) {
        num_3 = (TextView) findViewById(R.id.thirdnum);
        num_3.setText("" + num5);
    }

    public boolean configureresult() {
        answer = (EditText) findViewById(R.id.answerspace);
        if (answer.getText().length() > 0 ){
            ans = Integer.parseInt(answer.getText().toString());
            return true;
        }
        else
        {
            return false;
        }
    }

    public void configurebutton() {
        enter = (Button) findViewById(R.id.enterbutton);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (configureresult()) {
                    if (ans == result) {
                        point++;
                        status.setText("Good Job! Your Score is: " + point + "/10. I bet you feel smart.");
                    } else {
                        status.setText("Wrong. Your Score is: " + point + "/10, aka your IQ.");
                    }
                    count++;
                    if (count < 11) {
                        main();
                        answer.getText().clear();
                    }
                    if (count >= 11) {
                        clearscreen();
                    }
                }
            }
        });
    }

    public void clearscreen(){
        num_1.setVisibility(View.INVISIBLE);
        op_1.setVisibility(View.INVISIBLE);
        num_2.setVisibility(View.INVISIBLE);
        op_2.setVisibility(View.INVISIBLE);
        num_3.setVisibility(View.INVISIBLE);
        status.setVisibility(View.INVISIBLE);
        answer.setVisibility(View.GONE);
        enter.setVisibility(View.INVISIBLE);
        equalsign.setVisibility(View.INVISIBLE);
        gameover.setVisibility(View.VISIBLE);
        if (point == 10) {
            gameover.setText("Good Job. You just finished a fourth grader's homework.");
        }
        else if (point == 0)
        {
            gameover.setText("You got nothing correct. You failed. Go back to first grade.");
        }
        else if (point >=1 && point < 5)
        {
            gameover.setText("You got " +point+ "/10. Are you even trying?");
        }
        else if (point == 5)
        {
            gameover.setText("50%. That's pretty high considering you're playing this.");
        }
        else if (point > 5 && point < 8)
        {
            gameover.setText("" + point +"/10. You passed. Go hang your score up on a fridge.");
        }
        else if (point >= 8 && point < 10)
        {
            gameover.setText("" + point +"/10. You must be proud of yourself.");
        }
        replay.setVisibility(View.VISIBLE);
        replay.setEnabled(true);
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaynumbers();
            }
        });
    }

    public void replaynumbers(){
        answer.setText("");
        num_1.setVisibility(View.VISIBLE);
        op_1.setVisibility(View.VISIBLE);
        num_2.setVisibility(View.VISIBLE);
        op_2.setVisibility(View.VISIBLE);
        num_3.setVisibility(View.VISIBLE);
        status.setVisibility(View.VISIBLE);
        answer.setVisibility(View.VISIBLE);
        equalsign.setVisibility(View.VISIBLE);
        enter.setVisibility(View.VISIBLE);
        gameover.setVisibility(View.INVISIBLE);
        replay.setVisibility(View.INVISIBLE);
        status.setText("Really? You actually want to do more math?");
        main();
        count = 0;
        point = 0;
    }

    public void main()
    {
                Random random = new Random();

                int a = random.nextInt(10) + 1;//1-20 int number
                configurenum1(a);
                int b = random.nextInt(2);//0,1,0 stands for +,1 for -
                configureop1(b);
                int c = random.nextInt(10) + 1;
                configurenum2(c);
                int d = random.nextInt(3);//2 stands for *
                configureop2(d);

                int e;
                if (d == 2) {
                    e = random.nextInt(10) + 1;
                } else {
                    e = random.nextInt(2) + 1;
                }
                configurenum3(e);

                switch (d) {
                    case 0:
                        if (b == 0) {
                            result = a + c + e;
                        } else {
                            result = a - c + e;
                        }
                        break;
                    case 1:
                        if (b == 0) {
                            result = a + c - e;
                        } else {
                            result = a - c - e;
                        }
                        break;
                    case 2:
                        if (b == 0) {
                            result = a + (c * e);
                        } else {
                            result = a - (c * e);
                        }
                        break;
                }
                configurebutton();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_numbers, menu);
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




