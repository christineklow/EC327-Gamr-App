package com.awesomeness.christine.ec327project;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;


public class tictactoe extends Activity {

    ImageButton tic_1;
    ImageButton tic_2;
    ImageButton tic_3;
    ImageButton tic_4;
    ImageButton tic_5;
    ImageButton tic_6;
    ImageButton tic_7;
    ImageButton tic_8;
    ImageButton tic_9;
    TextView wintext;
    int[] gameboard = {1,2,3,4,5,6,7,8,9};
    int computerinput=8;
    int x,y,z;
    int turns = 1;
    int winstatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe);

        do {
            playerturn();
            turns++;
            computerturn(computerinput);
            if (checkwin()) {
                //player won
                playerwon(x, y, z);
                winstatus=1;
                break;
            }
            computerinput = computerinput - 2;
            turns++;
            if (checkwin()) {
                //computer won
                computerwon(x, y, z);
                winstatus=2;
                break;
            }

            if(!checkwin() && turns==9){
                winstatus=3; //tie
            }

        }while(!checkwin() || turns<10);


        wintext=(TextView) findViewById(R.id.tictactoestatus);
        switch(winstatus){
            case 1: wintext.setText("You Won!");//player won
            case 2: wintext.setText("Haha, you can't beat a computer");//computer won
            case 3: wintext.setText("Well this is awkward.");//tie
        }

    }

    public void playerturn(){
        for(int i = 1 ; i <10 ; i++){
            switch (i){
                case 1:{
                    if (gameboard[i] == i){
                        configurebutton1();
                    }
                }
                case 2: {
                    if (gameboard[i] == i) {
                        configurebutton2();
                    }
                }
                case 3: {
                    if (gameboard[i] == i) {
                        configurebutton3();
                    }
                }
                case 4: {
                    if (gameboard[i] == i) {
                        configurebutton4();
                    }
                }
                case 5: {
                    if (gameboard[i] == i) {
                        configurebutton5();
                    }
                }
                case 6: {
                    if (gameboard[i] == i) {
                        configurebutton6();
                    }
                }
                case 7: {
                    if (gameboard[i] == i) {
                        configurebutton7();
                    }
                }
                case 8: {
                    if (gameboard[i] == i) {
                        configurebutton8();
                    }
                }
                case 9: {
                    if (gameboard[i] == i) {
                        configurebutton9();
                    }
                }
            }
        }
    }

    //computer turn
    public void computerturn(int turn){
        int[] availablespots=new int[turn];
        int count = 0;
        for(int i = 0 ; i <9 ; i++) {
            if (gameboard[i] != 0 && gameboard[i] != 10){
                availablespots[count] = gameboard[i];
                count++;
            }
        }

        Random random=new Random();
        int choice= random.nextInt(turn)+1;

        int place = availablespots[choice];

        switch(place){
            case 1:{
                tic_1.setImageResource(R.drawable.ocorner);
                tic_1.setEnabled(false);
                gameboard[1]=10;
            }
            case 2:{
                tic_2.setImageResource(R.drawable.otwoandeight);
                tic_2.setEnabled(false);
                gameboard[2]=10;
            }
            case 3:{
                tic_3.setImageResource(R.drawable.ocorner);
                tic_3.setEnabled(false);
                gameboard[3]=10;
            }
            case 4:{
                tic_4.setImageResource(R.drawable.ofour);
                tic_4.setEnabled(false);
                gameboard[4]=10;
            }
            case 5:{
                tic_5.setImageResource(R.drawable.ofive);
                tic_5.setEnabled(false);
                gameboard[5]=10;
            }
            case 6:{
                tic_6.setImageResource(R.drawable.osix);
                tic_6.setEnabled(false);
                gameboard[6]=10;
            }
            case 7:{
                tic_7.setImageResource(R.drawable.ocorner);
                tic_7.setEnabled(false);
                gameboard[7]=10;
            }
            case 8:{
                tic_8.setImageResource(R.drawable.otwoandeight);
                tic_8.setEnabled(false);
                gameboard[8]=10;
            }
            case 9:{
                tic_9.setImageResource(R.drawable.ocorner);
                tic_9.setEnabled(false);
                gameboard[9]=10;
            }
        }

    }

    //check if anybody won
    public boolean checkwin(){
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

        return check;
    }

    public void playerwon(int first, int second, int last){
        switch (first){
            case 1: tic_1.setImageResource(R.drawable.xcornerwin);
            case 2: tic_2.setImageResource(R.drawable.xtwoandeigthwin);
            case 3: tic_3.setImageResource(R.drawable.xcornerwin);
            case 4: tic_4.setImageResource(R.drawable.xfourwin);
            case 5: tic_5.setImageResource(R.drawable.xfivewin);
            case 6: tic_6.setImageResource(R.drawable.xsixwin);
            case 7: tic_7.setImageResource(R.drawable.xcornerwin);
            case 8: tic_8.setImageResource(R.drawable.xtwoandeigthwin);
            case 9: tic_9.setImageResource(R.drawable.xcornerwin);
        }
        switch (second){
            case 1: tic_1.setImageResource(R.drawable.xcornerwin);
            case 2: tic_2.setImageResource(R.drawable.xtwoandeigthwin);
            case 3: tic_3.setImageResource(R.drawable.xcornerwin);
            case 4: tic_4.setImageResource(R.drawable.xfourwin);
            case 5: tic_5.setImageResource(R.drawable.xfivewin);
            case 6: tic_6.setImageResource(R.drawable.xsixwin);
            case 7: tic_7.setImageResource(R.drawable.xcornerwin);
            case 8: tic_8.setImageResource(R.drawable.xtwoandeigthwin);
            case 9: tic_9.setImageResource(R.drawable.xcornerwin);
        }
        switch (last){
            case 1: tic_1.setImageResource(R.drawable.xcornerwin);
            case 2: tic_2.setImageResource(R.drawable.xtwoandeigthwin);
            case 3: tic_3.setImageResource(R.drawable.xcornerwin);
            case 4: tic_4.setImageResource(R.drawable.xfourwin);
            case 5: tic_5.setImageResource(R.drawable.xfivewin);
            case 6: tic_6.setImageResource(R.drawable.xsixwin);
            case 7: tic_7.setImageResource(R.drawable.xcornerwin);
            case 8: tic_8.setImageResource(R.drawable.xtwoandeigthwin);
            case 9: tic_9.setImageResource(R.drawable.xcornerwin);
        }
    }

    public void computerwon(int first, int second, int last){
        switch (first){
            case 1: tic_1.setImageResource(R.drawable.ocornerwin);
            case 2: tic_2.setImageResource(R.drawable.otwoandeightwin);
            case 3: tic_3.setImageResource(R.drawable.ocornerwin);
            case 4: tic_4.setImageResource(R.drawable.ofourwin);
            case 5: tic_5.setImageResource(R.drawable.ofivewin);
            case 6: tic_6.setImageResource(R.drawable.osixwin);
            case 7: tic_7.setImageResource(R.drawable.ocornerwin);
            case 8: tic_8.setImageResource(R.drawable.otwoandeightwin);
            case 9: tic_9.setImageResource(R.drawable.ocornerwin);
        }
        switch (second){
            case 1: tic_1.setImageResource(R.drawable.ocornerwin);
            case 2: tic_2.setImageResource(R.drawable.otwoandeightwin);
            case 3: tic_3.setImageResource(R.drawable.ocornerwin);
            case 4: tic_4.setImageResource(R.drawable.ofourwin);
            case 5: tic_5.setImageResource(R.drawable.ofivewin);
            case 6: tic_6.setImageResource(R.drawable.osixwin);
            case 7: tic_7.setImageResource(R.drawable.ocornerwin);
            case 8: tic_8.setImageResource(R.drawable.otwoandeightwin);
            case 9: tic_9.setImageResource(R.drawable.ocornerwin);
        }
        switch (last){
            case 1: tic_1.setImageResource(R.drawable.ocornerwin);
            case 2: tic_2.setImageResource(R.drawable.otwoandeightwin);
            case 3: tic_3.setImageResource(R.drawable.ocornerwin);
            case 4: tic_4.setImageResource(R.drawable.ofourwin);
            case 5: tic_5.setImageResource(R.drawable.ofivewin);
            case 6: tic_6.setImageResource(R.drawable.osixwin);
            case 7: tic_7.setImageResource(R.drawable.ocornerwin);
            case 8: tic_8.setImageResource(R.drawable.otwoandeightwin);
            case 9: tic_9.setImageResource(R.drawable.ocornerwin);
        }
    }


    public void configurebutton1(){
        tic_1 = (ImageButton) findViewById(R.id.tic1);
        tic_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tic_1.setImageResource(R.drawable.xcorner);
                tic_1.setEnabled(false);
                gameboard[1]=0;
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
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tictactoe, menu);
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

/*public class tictactoe {

    public static void main(String[] args) {
        //display the board
        //let the player choose the mode(player vs.player, player vs computer(player go first),player vs computer(computer go first))
        if(//pvp(player vs.player))
        do{
            //user input,get the board[]

        }while(check()==false);
        //}end the game

        if (//player vs.computer, player go first(i.e player is the x)){
        int step=0;
        do{
            //user input,get the board[]
            if(check()==true)
                break;
            step=minimax_min();
            //put the step on the board and get the board[]
        }while(check()==false);
        //}end the game

        if (//player vs.computer, computer go first(i.e player is the p)){
        int step=0;
        //randomly pick place to place a x
        do{
            //user input,get the board[]
            if(check()==true)
                break;
            step=minimax_max();
            //put the step on the board and get the board[]
        }while(check()==false);
        //}end the game


    }


//Assume this game is start by player, X goes first(player), O is computer goes behind.
    //using Minimax Search Algorithm



    static final int[][] WIN_STATUS = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
    };
    //0,1,2
    //3,4,5
    //6,7,8  is the Number for the game button


    public static int gameState(int board[]){
        //function to check if one lose/win
        int result=0;
        for(int[] status:WIN_STATUS){

            int i=0 ;
            int j=0;
            for(i=0; i<status.length; i++){
                j=j+board[status[i]];
                //here, button[i] is the int number for each cell(0 for empty, 1 for x, -1 for o)

            }
            if(j=3)
                result++;
            if(j=-3)
                result--;

        }
        return result;//here, result=0 indicats tie, result>0 indicates x win, else o win;
    }


    public boolean check(board[]){
        if(gameState()>0)
            //output the X win
            return true;
        if(gameState()<0)
            //output for o win
            return true;
        if(//the board is full){
        if(gameState()=0){
            //output for tie
            return true;
        }
    }
    return false;
}

    public int minimax_min(){
        int[] board=new int[9];
        //board==input;
        //get the board work here, for example board=(0,0,0,0,0,0,0,0,0)
        //which means the board is clear, and 1 for X, -1 for o that already exist
        int[] board1=new int[9];
        int i=0;
        int judge=-10000;
        int postion;
        for(i:board){//find a non-empty place to put o, and do the check ,find the minmum value place
            if(board[i]!=0)
                continue;
            board1=board;
            board1[i]=-1;
            int judge1=max(board1)+min(board1);
            if(judge1<judge){
                judge=judge1;
                postion =i
            }
        }
        return postion;
    }
    public int minimax_max(){
        int[] board=new int[9];
        //board==input;
        //get the board work here, for example board=(0,0,0,0,0,0,0,0,0)
        //which means the board is clear, and 1 for X, -1 for o that already exist
        int[] board1=new int[9];
        int i=0;
        int judge=-10000;
        int postion;
        for(i:board){//find a non-empty place to put x, and do the check ,find the maxmium value place
            if(board[i]!=0)
                continue;
            board1=board;
            board1[i]=1;
            int judge1=max(board1)+min(board1);
            if(judge1>judge){
                judge=judge1;
                postion =i
            }
        }
        return postion;
    }


    public int max(board2[]){
        int i=0
        for(i:board2){
            if( board2[i]==0)
                board2[i]==1;
        }//get all the empty cells of board1 full of X
        int m
        m=gameState(board2);
        return m;
    }


    public int min(board3[]){
        int i=0;
        for(i:board3){
            if(board3[i]==0)
                board3[i]=-1
        }//get all the empty cells of board1 full of o
        n=gameState(board3);
        return n;
    }
















}*/
