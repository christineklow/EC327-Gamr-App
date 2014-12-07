package com.awesomeness.christine.ec327project;

import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import java.util.Random;
import java.util.Arrays;


public class matchingpairs extends ActionBarActivity {

    //declare variables
    int [] imagesArray;
    ImageButton button1;
    ImageButton button2;
    ImageButton button3;
    ImageButton button4;
    ImageButton button5;
    ImageButton button6;
    ImageButton button7;
    ImageButton button8;
    boolean c1 = false;
    boolean c2 = false;
    boolean c3 = false;
    boolean c4 = false;
    boolean c5 = false;
    boolean c6 = false;
    boolean c7 = false;
    boolean c8 = false;
    int card1 = 0;
    int card2 = 0;
    int click1 = 0;
    int click2 = 0;
    int point = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matchingpairs);

        main();

    }

    public void main()
    {
        //put cards in array
        imagesArray= new int[] {1,1,2,2,3,3,4,4};
        //shuffle cards
        ShuffleArray(imagesArray);
        configurecard1();
        configurecard2();
        configurecard3();
        configurecard4();
        configurecard5();
        configurecard5();
        configurecard6();
        configurecard7();
        configurecard8();
    }

    public void updatecards(){
        for(int i = 1 ; i < 9 ; i++){
            switch (i){
                case 1:{
                    if (!c1)
                    {
                        configurecard1();
                    }
                }
                case 2:{
                    if(!c2)
                    {
                        configurecard2();
                    }
                }
                case 3:{
                    if(!c3)
                    {
                        configurecard3();
                    }
                }
                case 4:{
                    if(!c4)
                    {
                        configurecard4();
                    }
                }
                case 5:{
                    if(!c5)
                    {
                        configurecard5();
                    }
                }
                case 6:{
                    if(!c6)
                    {
                        configurecard6();
                    }
                }
                case 7:{
                    if(!c7)
                    {
                        configurecard7();
                    }
                }
                case 8:{
                    if(!c8)
                    {
                        configurecard8();
                    }
                }
            }
        }
    }


    public void ShuffleArray(int[] array)
    {
        int index;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            if (index != i)
            {
                array[index] ^= array[i];
                array[i] ^= array[index];
                array[index] ^= array[i];
            }
        }
    }

    public boolean checkmatch(int first, int second){

        if( card1 == card2 ){
            switch (first){
                case 1: c1 = true; break;
                case 2: c2 = true; break;
                case 3: c3 = true; break;
                case 4: c4 = true; break;
                case 5: c5 = true; break;
                case 6: c6 = true; break;
                case 7: c7 = true; break;
                case 8: c8 = true; break;
            }
            switch (second){
                case 1: c1 = true; break;
                case 2: c2 = true; break;
                case 3: c3 = true; break;
                case 4: c4 = true; break;
                case 5: c5 = true; break;
                case 6: c6 = true; break;
                case 7: c7 = true; break;
                case 8: c8 = true; break;
            }
            return true;
        }
        else
        {
            return false;
        }
    }

    public void configurecard1(){
        final int cardID = imagesArray[0];
        button1 = (ImageButton) findViewById(R.id.cardone);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(cardID){
                    case 1: button1.setImageResource(R.drawable.cardspade); break;
                    case 2: button1.setImageResource(R.drawable.cardheart); break;
                    case 3: button1.setImageResource(R.drawable.cardclover); break;
                    case 4: button1.setImageResource(R.drawable.carddiamond); break;
                }
                button1.setEnabled(false);

                if(click1 == 0 && click2 == 0)
                {
                    click1 = 1; //this card number
                    card1 = cardID;
                }
                else if ( click1 != 0 && click2 == 0)
                {
                    click2 = 1; //this card number
                    card2 = cardID;

                    if (checkmatch(click1, click2)) {
                        button1.setEnabled(false);
                        point++;
                        click1 = 0;
                        click2 = 0;
                    }
                    else {
                        button1.setImageResource(R.drawable.card);
                        button1.setEnabled(true);
                        updatecards();
                        click1 = 0;
                        click2 = 0;
                    }
                }

            }
        });
    }

    public void configurecard2(){
        final int cardID = imagesArray[1];
        button2 = (ImageButton) findViewById(R.id.cardtwo);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(cardID){
                    case 1: button2.setImageResource(R.drawable.cardspade); break;
                    case 2: button2.setImageResource(R.drawable.cardheart); break;
                    case 3: button2.setImageResource(R.drawable.cardclover); break;
                    case 4: button2.setImageResource(R.drawable.carddiamond); break;
                }
                button2.setEnabled(false);
                if(click1 == 0 && click2 == 0)
                {
                    click1 = 2; //this card number
                    card1 = cardID;
                }
                else if ( click1 != 0 && click2 == 0)
                {
                    click2 = 2; //this card number
                    card2 = cardID;

                    if (checkmatch(click1, click2)) {
                        button2.setEnabled(false);
                        point++;
                        click1 = 0;
                        click2 = 0;
                    } else {
                        button2.setImageResource(R.drawable.card);
                        button2.setEnabled(true);
                        updatecards();
                        click1 = 0;
                        click2 = 0;
                    }
                }

            }
        });
    }

    public void configurecard3(){
        final int cardID = imagesArray[2];
        button3 = (ImageButton) findViewById(R.id.cardthree);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(cardID){
                    case 1: button3.setImageResource(R.drawable.cardspade); break;
                    case 2: button3.setImageResource(R.drawable.cardheart); break;
                    case 3: button3.setImageResource(R.drawable.cardclover); break;
                    case 4: button3.setImageResource(R.drawable.carddiamond); break;
                }
                button3.setEnabled(false);
                if(click1 == 0 && click2 == 0)
                {
                    click1 = 3; //this card number
                    card1 = cardID;
                }
                else if ( click1 != 0 && click2 == 0)
                {
                    click2 = 3; //this card number
                    card2 = cardID;

                    if (checkmatch(click1, click2)) {
                        button3.setEnabled(false);
                        point++;
                        click1 = 0;
                        click2 = 0;
                    } else {
                        button3.setImageResource(R.drawable.card);
                        button3.setEnabled(true);
                        updatecards();
                        click1 = 0;
                        click2 = 0;
                    }
                }
            }
        });
    }

    public void configurecard4(){
        final int cardID = imagesArray[3];
        button4 = (ImageButton) findViewById(R.id.cardfour);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(cardID){
                    case 1: button4.setImageResource(R.drawable.cardspade); break;
                    case 2: button4.setImageResource(R.drawable.cardheart); break;
                    case 3: button4.setImageResource(R.drawable.cardclover); break;
                    case 4: button4.setImageResource(R.drawable.carddiamond); break;
                }
                button4.setEnabled(false);
                if(click1 == 0 && click2 == 0)
                {
                    click1 = 4; //this card number
                    card1 = cardID;
                }
                else if ( click1 != 0 && click2 == 0)
                {
                    click2 = 4; //this card number
                    card2 = cardID;

                    if (checkmatch(click1, click2)) {
                        button4.setEnabled(false);
                        point++;
                        click1 = 0;
                        click2 = 0;
                    } else {
                        button4.setImageResource(R.drawable.card);
                        button4.setEnabled(true);
                        updatecards();
                        click1 = 0;
                        click2 = 0;
                    }
                }
            }
        });
    }

    public void configurecard5(){
        final int cardID = imagesArray[4];
        button5 = (ImageButton) findViewById(R.id.cardfive);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(cardID){
                    case 1: button5.setImageResource(R.drawable.cardspade); break;
                    case 2: button5.setImageResource(R.drawable.cardheart); break;
                    case 3: button5.setImageResource(R.drawable.cardclover); break;
                    case 4: button5.setImageResource(R.drawable.carddiamond); break;
                }
                button5.setEnabled(false);
                if(click1 == 0 && click2 == 0)
                {
                    click1 = 5; //this card number
                    card1 = cardID;
                }
                else if ( click1 != 0 && click2 == 0)
                {
                    click2 = 5; //this card number
                    card2 = cardID;

                    if (checkmatch(click1, click2)) {
                        button5.setEnabled(false);
                        point++;
                        click1 = 0;
                        click2 = 0;
                    } else {
                        button5.setImageResource(R.drawable.card);
                        button5.setEnabled(true);
                        updatecards();
                        click1 = 0;
                        click2 = 0;
                    }
                }
            }
        });
    }

    public void configurecard6(){
        final int cardID = imagesArray[5];
        button6 = (ImageButton) findViewById(R.id.cardsix);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(cardID){
                    case 1: button6.setImageResource(R.drawable.cardspade); break;
                    case 2: button6.setImageResource(R.drawable.cardheart); break;
                    case 3: button6.setImageResource(R.drawable.cardclover); break;
                    case 4: button6.setImageResource(R.drawable.carddiamond); break;
                }
                button6.setEnabled(false);
                if(click1 == 0 && click2 == 0)
                {
                    click1 = 6; //this card number
                    card1 = cardID;
                }
                else if ( click1 != 0 && click2 == 0)
                {
                    click2 = 6; //this card number
                    card2 = cardID;

                    if (checkmatch(click1, click2)) {
                        button6.setEnabled(false);
                        point++;
                        click1 = 0;
                        click2 = 0;
                    } else {
                        button6.setImageResource(R.drawable.card);
                        button6.setEnabled(true);
                        updatecards();
                        click1 = 0;
                        click2 = 0;
                    }
                }
            }
        });
    }

    public void configurecard7(){
        final int cardID = imagesArray[6];
        button7 = (ImageButton) findViewById(R.id.cardseven);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(cardID){
                    case 1: button7.setImageResource(R.drawable.cardspade); break;
                    case 2: button7.setImageResource(R.drawable.cardheart); break;
                    case 3: button7.setImageResource(R.drawable.cardclover); break;
                    case 4: button7.setImageResource(R.drawable.carddiamond); break;
                }
                button7.setEnabled(false);
                if(click1 == 0 && click2 == 0)
                {
                    click1 = 7; //this card number
                    card1 = cardID;
                }
                else if ( click1 != 0 && click2 == 0)
                {
                    click2 = 7; //this card number
                    card2 = cardID;

                    if (checkmatch(click1, click2)) {
                        button7.setEnabled(false);
                        point++;
                        click1 = 0;
                        click2 = 0;
                    } else {
                        button7.setImageResource(R.drawable.card);
                        button7.setEnabled(true);
                        updatecards();
                        click1 = 0;
                        click2 = 0;
                    }
                }
            }
        });
    }

    public void configurecard8(){
        final int cardID = imagesArray[7];
        button8 = (ImageButton) findViewById(R.id.cardeight);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(cardID){
                    case 1: button8.setImageResource(R.drawable.cardspade); break;
                    case 2: button8.setImageResource(R.drawable.cardheart); break;
                    case 3: button8.setImageResource(R.drawable.cardclover); break;
                    case 4: button8.setImageResource(R.drawable.carddiamond); break;
                }
                button8.setEnabled(false);
                if(click1 == 0 && click2 == 0)
                {
                    click1 = 8; //this card number
                    card1 = cardID;
                }
                else if ( click1 != 0 && click2 == 0)
                {
                    click2 = 8; //this card number
                    card2 = cardID;

                    if (checkmatch(click1, click2)) {
                        button8.setEnabled(false);
                        point++;
                        click1 = 0;
                        click2 = 0;
                    } else {
                        button8.setImageResource(R.drawable.card);
                        button8.setEnabled(true);
                        updatecards();
                        click1 = 0;
                        click2 = 0;
                    }
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_matchingpairs, menu);
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
