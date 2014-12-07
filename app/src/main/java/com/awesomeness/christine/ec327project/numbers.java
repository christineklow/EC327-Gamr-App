package com.awesomeness.christine.ec327project;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class numbers extends Activity {

    TextView num_1;
    TextView op_1;
    TextView num_2;
    TextView op_2;
    TextView num_3;
    EditText answer;
    Button enter;
    int num1;
    int num2;
    int num3;
    int num4;
    int num5;
    String[] args;
    int result = 0;
    int point = 0;
    int n = 0;
    //int num6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        configurenum1(num1);
        configureop1(num2);
        configurenum2(num3);
        configureop2(num4);
        configurenum3(num5);
        configureresult();
        configurebutton();
        check();
        main(args);
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

     int ans;
    public int configureresult() {
        answer = (EditText) findViewById(R.id.answerspace);
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans = Integer.parseInt(answer.getText().toString());
            }
        });
        answer.setText("" + ans);
        return ans;
    }

    public boolean configurebutton(){
        enter = (Button) findViewById(R.id.enterbutton);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check();
            }
        });
        return true;
    }

    public void check() {
        if (configurebutton())
        {
            enter.setEnabled(false);

            if (configureresult() == result) {
                //System.out.println("Good Job!");
                point++;
                //n++;

            } else {
                point = 0;
                //n++;
            }
        }
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

    public void main(String[] args) {
       // do {
        for(n = 1; n <= 10; n++) {
            Random random = new Random();

            int a = random.nextInt(20) + 1;//1-20 int number
            configurenum1(a);
            int b = random.nextInt(2);//0,1,0 stands for +,1 for -
            configureop1(b);
            int c = random.nextInt(20) + 1;
            configurenum2(c);
            int d;
            if (n <= 5) {
                d = random.nextInt(2);
                configureop2(d);
            } else {
                d = random.nextInt(4);//2 stands for *,3 stands for %
                configureop2(d);
            }
            //here is something that I want to create in the game, the first 5 problems created will be simple(only + and -), and the rest would be more difficult
            //the numbers are 1-20, and if we have two multiply is somehow too difficult(like 19*18*17), so i think just one multiply is enough
            //the reason we have % instead of / is easy to figure out
            int e = random.nextInt(20) + 1;
            configurenum3(e);
            //we have all the variables now, show them in the board
            //int user = 0;
            //int result = 0;
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
                    if (b == 0)
                        result = a + c * e;
                    else
                        result = a - c * e;
                    break;
                case 3:
                    if (b == 0)
                        result = a + c % e;
                    else
                        result = a - c % e;
                    break;
            }
            check();

        }
            //while(n<=10);
            //while ((current-start_time)<=30000)
                //The game is just 10 problems, I think too many problems would be boring, and the we record the time each player used to finish this game
            //output the time user use,using variable timer.time, which is the total seconds cost
            //end the game!
        }
    }



