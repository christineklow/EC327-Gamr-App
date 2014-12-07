package com.awesomeness.christine.ec327project;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*import java.lang.Object;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import  java.util.Timer;*/

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
            main();

        /*TimeUnit.SECONDS.sleep(30);
        Thread.sleep(30000, 0);
        clearscreen();*/


    }

   /* public  long timer() {

        long lDateTime = new Date().getTime();

        Calendar lCDateTime = Calendar.getInstance();
        return lCDateTime.getTimeInMillis();

    }*/

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
                        status.setText("Good Job! Your Score is: " + point + ". I bet you feel smart.");
                    } else {
                        status.setText("Wrong. Your Score is: " + point + ", aka your IQ.");
                    }
                    count++;
                    if (count < 11) {
                        main();
                        answer.getText().clear();
                        //status.setText("Don't Cheat!");
                    }
                    if (count >= 11) {
                        clearscreen();
                    }
                }
            }
        });
    }

    public void clearscreen(){
        num_1.setVisibility(View.GONE);
        op_1.setVisibility(View.GONE);
        num_2.setVisibility(View.GONE);
        op_2.setVisibility(View.GONE);
        num_3.setVisibility(View.GONE);
        status.setVisibility(View.GONE);
        answer.setVisibility(View.GONE);
        enter.setVisibility(View.GONE);
        equalsign.setVisibility(View.GONE);
        gameover.setVisibility(View.VISIBLE);
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
        int d;
        if (n <= 5) {
            d = random.nextInt(2);
            configureop2(d);
        } else {
            d = random.nextInt(4);//2 stands for *,3 stands for %
            configureop2(d);
        }

        int e;
        if(d == 2){
            e = random.nextInt(10) + 1;
        }
        else {
            e = random.nextInt(2) + 1;
        }
        configurenum3(e);
        //we have all the variables now, show them in the board
        //int user = 0;
        //int result = 0;
        //configurebutton();
        switch (d) {
            case 0:
                if (b == 0)
                {
                    result = a + c + e;
                } else
                {
                    result = a - c + e;
                }
                break;
            case 1:
                if (b == 0)
                {
                    result = a + c - e;
                } else
                {
                    result = a - c - e;
                }
                break;
            case 2:
                if (b == 0)
                {
                    result = a + (c * e);
                }
                else
                {
                    result = a - (c * e);
                }
                break;
            case 3:
                if (b == 0)
                {
                    result = a + (c / e);
                }
                else
                {
                    result = a - (c / e);
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




