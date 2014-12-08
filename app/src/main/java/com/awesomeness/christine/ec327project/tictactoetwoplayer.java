package com.awesomeness.christine.ec327project;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class tictactoetwoplayer extends ActionBarActivity {

    ImageButton tic_1;
    ImageButton tic_2;
    ImageButton tic_3;
    ImageButton tic_4;
    ImageButton tic_5;
    ImageButton tic_6;
    ImageButton tic_7;
    ImageButton tic_8;
    ImageButton tic_9;
    Button replay;
    TextView wintext;
    TextView status;
    int[] gameboard = {0,1,2,3,4,5,6,7,8,9};
    int x,y,z;
    int turns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoetwoplayer);

        wintext=(TextView) findViewById(R.id.output);
        status=(TextView) findViewById(R.id.tictactoestatus);

        wintext.setVisibility(View.INVISIBLE);

        replay = (Button) findViewById(R.id.replaybutton);

        turns = 1;
        player1turn();
    }


    public void player1turn(){
        for(int i = 1 ; i <10 ; i++){
            switch (i){
                case 1:{
                    if (gameboard[i] == i){
                        configurebutton1();
                        break;
                    }
                }
                case 2: {
                    if (gameboard[i] == i) {
                        configurebutton2();
                        break;
                    }
                }
                case 3: {
                    if (gameboard[i] == i) {
                        configurebutton3();
                        break;
                    }
                }
                case 4: {
                    if (gameboard[i] == i) {
                        configurebutton4();
                        break;
                    }
                }
                case 5: {
                    if (gameboard[i] == i) {
                        configurebutton5();
                        break;
                    }
                }
                case 6: {
                    if (gameboard[i] == i) {
                        configurebutton6();
                        break;
                    }
                }
                case 7: {
                    if (gameboard[i] == i) {
                        configurebutton7();
                        break;
                    }
                }
                case 8: {
                    if (gameboard[i] == i) {
                        configurebutton8();
                        break;
                    }
                }
                case 9: {
                    if (gameboard[i] == i) {
                        configurebutton9();
                        break;
                    }
                }
            }
        }
    }

    public void player2turn(){
        for(int i = 1 ; i <10 ; i++){
            switch (i){
                case 1:{
                    if (gameboard[i] == i){
                        configurebutton1();
                        break;
                    }
                }
                case 2: {
                    if (gameboard[i] == i) {
                        configurebutton2();
                        break;
                    }
                }
                case 3: {
                    if (gameboard[i] == i) {
                        configurebutton3();
                        break;
                    }
                }
                case 4: {
                    if (gameboard[i] == i) {
                        configurebutton4();
                        break;
                    }
                }
                case 5: {
                    if (gameboard[i] == i) {
                        configurebutton5();
                        break;
                    }
                }
                case 6: {
                    if (gameboard[i] == i) {
                        configurebutton6();
                        break;
                    }
                }
                case 7: {
                    if (gameboard[i] == i) {
                        configurebutton7();
                        break;
                    }
                }
                case 8: {
                    if (gameboard[i] == i) {
                        configurebutton8();
                        break;
                    }
                }
                case 9: {
                    if (gameboard[i] == i) {
                        configurebutton9();
                        break;
                    }
                }
            }
        }
    }

    public boolean checkwin(int who){
        // 1 2 3
        // 4 5 6
        // 7 8 9

        boolean check = false;

        if(gameboard[1] == gameboard[2] && gameboard[1] == gameboard[3])
        {
            x=1;
            y=2;
            z=3;
            check = true;
        }
        else if(gameboard[1] == gameboard[4] && gameboard[1] == gameboard[7])
        {
            x=1;
            y=4;
            z=7;
            check = true;
        }
        else if(gameboard[1] == gameboard[5] && gameboard[1] == gameboard[9])
        {
            x=1;
            y=5;
            z=9;
            check = true;
        }
        else if(gameboard[4] == gameboard[5] && gameboard[4] == gameboard[6])
        {
            x=4;
            y=5;
            z=6;
            check = true;
        }
        else if(gameboard[7] == gameboard[8] && gameboard[7] == gameboard[9])
        {
            x=7;
            y=8;
            z=9;
            check = true;
        }
        else if(gameboard[2] == gameboard[5] && gameboard[2] == gameboard[8])
        {
            x=2;
            y=5;
            z=8;
            check = true;
        }
        else if(gameboard[3] == gameboard[6] && gameboard[3] == gameboard[9])
        {
            x=3;
            y=6;
            z=9;
            check = true;
        }
        else if(gameboard[3] == gameboard[5] && gameboard[3] == gameboard[7])
        {
            x=3;
            y=5;
            z=7;
            check = true;
        }


        if(check) {

            tic_1.setEnabled(false);
            tic_2.setEnabled(false);
            tic_3.setEnabled(false);
            tic_4.setEnabled(false);
            tic_5.setEnabled(false);
            tic_6.setEnabled(false);
            tic_7.setEnabled(false);
            tic_8.setEnabled(false);
            tic_9.setEnabled(false);

            switch (who) {
                case 1: {
                    //player
                    player1won(x, y, z);
                    wintext.setVisibility(View.VISIBLE);
                    status.setVisibility(View.INVISIBLE);
                    wintext.setText("Player 1 triumphs!");//player won
                    replay.setVisibility(View.VISIBLE);
                    replay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            restartgame();
                        }
                    });
                    break;
                }
                case 2: {
                    //computer
                    player2won(x, y, z);
                    wintext.setVisibility(View.VISIBLE);
                    status.setVisibility(View.INVISIBLE);
                    wintext.setText("Player 2 triumphs!");//computer won
                    replay.setVisibility(View.VISIBLE);
                    replay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            restartgame();
                        }
                    });
                    break;
                }
            }
        }


        if(!check && checktie()){
            wintext.setVisibility(View.VISIBLE);
            status.setVisibility(View.INVISIBLE);
            wintext.setText("You tied. Well this is awkward.");//tie
            replay.setVisibility(View.VISIBLE);
            replay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    restartgame();
                }
            });
        }

        return check;
    }

    public boolean checktie(){

        boolean check = true;
        for(int i = 1 ; i<10 ; i++)
        {
            if (gameboard[i] != 0 && gameboard[i] != 10)
            {
                check = false;
            }
        }

        return check;
    }

    public void player1won(int first, int second, int last){
        switch (first){
            case 1: tic_1.setImageResource(R.drawable.xcornerwin); break;
            case 2: tic_2.setImageResource(R.drawable.xtwoandeigthwin); break;
            case 3: tic_3.setImageResource(R.drawable.xcornerwin); break;
            case 4: tic_4.setImageResource(R.drawable.xfourwin); break;
            case 5: tic_5.setImageResource(R.drawable.xfivewin); break;
            case 6: tic_6.setImageResource(R.drawable.xsixwin); break;
            case 7: tic_7.setImageResource(R.drawable.xcornerwin); break;
            case 8: tic_8.setImageResource(R.drawable.xtwoandeigthwin); break;
            case 9: tic_9.setImageResource(R.drawable.xcornerwin); break;
        }
        switch (second){
            case 1: tic_1.setImageResource(R.drawable.xcornerwin); break;
            case 2: tic_2.setImageResource(R.drawable.xtwoandeigthwin); break;
            case 3: tic_3.setImageResource(R.drawable.xcornerwin); break;
            case 4: tic_4.setImageResource(R.drawable.xfourwin); break;
            case 5: tic_5.setImageResource(R.drawable.xfivewin); break;
            case 6: tic_6.setImageResource(R.drawable.xsixwin); break;
            case 7: tic_7.setImageResource(R.drawable.xcornerwin); break;
            case 8: tic_8.setImageResource(R.drawable.xtwoandeigthwin); break;
            case 9: tic_9.setImageResource(R.drawable.xcornerwin); break;
        }
        switch (last){
            case 1: tic_1.setImageResource(R.drawable.xcornerwin); break;
            case 2: tic_2.setImageResource(R.drawable.xtwoandeigthwin); break;
            case 3: tic_3.setImageResource(R.drawable.xcornerwin); break;
            case 4: tic_4.setImageResource(R.drawable.xfourwin); break;
            case 5: tic_5.setImageResource(R.drawable.xfivewin); break;
            case 6: tic_6.setImageResource(R.drawable.xsixwin); break;
            case 7: tic_7.setImageResource(R.drawable.xcornerwin); break;
            case 8: tic_8.setImageResource(R.drawable.xtwoandeigthwin); break;
            case 9: tic_9.setImageResource(R.drawable.xcornerwin); break;
        }
    }

    public void player2won(int first, int second, int last){
        switch (first){
            case 1: tic_1.setImageResource(R.drawable.ocornerwin); break;
            case 2: tic_2.setImageResource(R.drawable.otwoandeightwin); break;
            case 3: tic_3.setImageResource(R.drawable.ocornerwin); break;
            case 4: tic_4.setImageResource(R.drawable.ofourwin); break;
            case 5: tic_5.setImageResource(R.drawable.ofivewin); break;
            case 6: tic_6.setImageResource(R.drawable.osixwin); break;
            case 7: tic_7.setImageResource(R.drawable.ocornerwin); break;
            case 8: tic_8.setImageResource(R.drawable.otwoandeightwin); break;
            case 9: tic_9.setImageResource(R.drawable.ocornerwin); break;
        }
        switch (second){
            case 1: tic_1.setImageResource(R.drawable.ocornerwin); break;
            case 2: tic_2.setImageResource(R.drawable.otwoandeightwin); break;
            case 3: tic_3.setImageResource(R.drawable.ocornerwin); break;
            case 4: tic_4.setImageResource(R.drawable.ofourwin); break;
            case 5: tic_5.setImageResource(R.drawable.ofivewin); break;
            case 6: tic_6.setImageResource(R.drawable.osixwin); break;
            case 7: tic_7.setImageResource(R.drawable.ocornerwin); break;
            case 8: tic_8.setImageResource(R.drawable.otwoandeightwin); break;
            case 9: tic_9.setImageResource(R.drawable.ocornerwin); break;
        }
        switch (last){
            case 1: tic_1.setImageResource(R.drawable.ocornerwin); break;
            case 2: tic_2.setImageResource(R.drawable.otwoandeightwin); break;
            case 3: tic_3.setImageResource(R.drawable.ocornerwin); break;
            case 4: tic_4.setImageResource(R.drawable.ofourwin); break;
            case 5: tic_5.setImageResource(R.drawable.ofivewin); break;
            case 6: tic_6.setImageResource(R.drawable.osixwin); break;
            case 7: tic_7.setImageResource(R.drawable.ocornerwin); break;
            case 8: tic_8.setImageResource(R.drawable.otwoandeightwin); break;
            case 9: tic_9.setImageResource(R.drawable.ocornerwin); break;
        }
    }


    public void restartgame()
    {
        tic_1.setImageResource(R.drawable.corners);
        tic_1.setEnabled(true);

        tic_2.setImageResource(R.drawable.twoandeight);
        tic_2.setEnabled(true);

        tic_3.setImageResource(R.drawable.corners);
        tic_3.setEnabled(true);

        tic_4.setImageResource(R.drawable.side);
        tic_4.setEnabled(true);

        tic_5.setImageResource(R.drawable.five);
        tic_5.setEnabled(true);

        tic_6.setImageResource(R.drawable.side);
        tic_6.setEnabled(true);

        tic_7.setImageResource(R.drawable.corners);
        tic_7.setEnabled(true);

        tic_8.setImageResource(R.drawable.twoandeight);
        tic_8.setEnabled(true);

        tic_9.setImageResource(R.drawable.corners);
        tic_9.setEnabled(true);

        replay.setVisibility(View.INVISIBLE);
        wintext.setVisibility(View.INVISIBLE);
        status.setVisibility(View.VISIBLE);

        for(int i=1 ; i<10 ; i++)
        {
            gameboard[i]=i;
        }

        player1turn();
    }

    public void configurebutton1(){
        tic_1 = (ImageButton) findViewById(R.id.tic1);
        tic_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tic_1.setImageResource(R.drawable.xcorner);
                tic_1.setEnabled(false);
                gameboard[1]=0;
                if (!checkwin(1) && !checktie()) {
                    player2turn();
                }
            }
        });
    }

    public void configurebutton2(){
        tic_2 = (ImageButton) findViewById(R.id.tic2);
        tic_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tic_2.setImageResource(R.drawable.xtwoandeigth);
                tic_2.setEnabled(false);
                gameboard[2]=0;
                if (!checkwin(1) && !checktie()) {
                    player2turn();
                }
            }
        });
    }

    public void configurebutton3(){
        tic_3 = (ImageButton) findViewById(R.id.tic3);
        tic_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tic_3.setImageResource(R.drawable.xcorner);
                tic_3.setEnabled(false);
                gameboard[3]=0;
                if (!checkwin(1) && !checktie()) {
                    player2turn();
                }
            }
        });
    }

    public void configurebutton4(){
        tic_4 = (ImageButton) findViewById(R.id.tic4);
        tic_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tic_4.setImageResource(R.drawable.xfour);
                tic_4.setEnabled(false);
                gameboard[4]=0;
                if (!checkwin(1) && !checktie()) {
                    player2turn();
                }
            }
        });
    }

    //player buttons
    public void configurebutton5(){
        tic_5 = (ImageButton) findViewById(R.id.tic5);
        tic_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tic_5.setImageResource(R.drawable.xfive);
                tic_5.setEnabled(false);
                gameboard[5]=0;
                if (!checkwin(1) && !checktie()) {
                    player2turn();
                }
            }
        });
    }

    public void configurebutton6(){
        tic_6 = (ImageButton) findViewById(R.id.tic6);
        tic_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tic_6.setImageResource(R.drawable.xsix);
                tic_6.setEnabled(false);
                gameboard[6]=0;
                if (!checkwin(1) && !checktie()) {
                    player2turn();
                }
            }
        });
    }

    public void configurebutton7(){
        tic_7 = (ImageButton) findViewById(R.id.tic7);
        tic_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tic_7.setImageResource(R.drawable.xcorner);
                tic_7.setEnabled(false);
                gameboard[7]=0;
                if (!checkwin(1) && !checktie()) {
                    player2turn();
                }
            }
        });
    }

    public void configurebutton8(){
        tic_8 = (ImageButton) findViewById(R.id.tic8);
        tic_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tic_8.setImageResource(R.drawable.xtwoandeigth);
                tic_8.setEnabled(false);
                gameboard[8]=0;
                if (!checkwin(1) && !checktie()) {
                    player2turn();
                }
            }
        });
    }

    public void configurebutton9(){
        tic_9 = (ImageButton) findViewById(R.id.tic9);
        tic_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tic_9.setImageResource(R.drawable.xcorner);
                tic_9.setEnabled(false);
                gameboard[9]=0;
                if (!checkwin(1) && !checktie()) {
                    player2turn();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tictactoetwoplayer, menu);
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
