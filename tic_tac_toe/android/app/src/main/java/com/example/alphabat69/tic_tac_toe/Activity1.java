package com.example.alphabat69.tic_tac_toe;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.HashMap;

public class Activity1 extends AppCompatActivity implements View.OnClickListener{
    ImageButton zero,one,two,three,four,five,six,seven,eight;
    int layout[] = {0,0,0
                   ,0,0,0
                   ,0,0,0};
    int chance=9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        zero=(ImageButton)findViewById(R.id.zero);
        one=(ImageButton)findViewById(R.id.one);
        two=(ImageButton)findViewById(R.id.two);
        three=(ImageButton)findViewById(R.id.three);
        four=(ImageButton)findViewById(R.id.four);
        five=(ImageButton)findViewById(R.id.five);
        six=(ImageButton)findViewById(R.id.six);
        seven=(ImageButton)findViewById(R.id.seven);
        eight=(ImageButton)findViewById(R.id.eight);

        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        boolean b=false;
        if(chance%2==1)
            b=true;
        switch(v.getId()){
            case R.id.zero:{
                if(b) {
                    //zero.setBackgroundColor(Color.BLUE);
                    zero.setBackgroundResource(R.drawable.o);
                    layout[0]++;
                }
                else {
                    zero.setBackgroundResource(R.drawable.x);
                    layout[0]+=2;
                }
                zero.setClickable(false);
                break;
            }
            case R.id.one:{
                if(b) {
                    one.setBackgroundResource(R.drawable.o);
                    layout[1]++;
                }
                else {
                    one.setBackgroundResource(R.drawable.x);
                    layout[1]+=2;
                }
                one.setClickable(false);
                break;
            }
            case R.id.two:{
                if(b) {
                    two.setBackgroundResource(R.drawable.o);
                    layout[2]++;
                }
                else {
                    two.setBackgroundResource(R.drawable.x);
                    layout[2]+=2;
                }
                two.setClickable(false);
                break;
            }
            case R.id.three:{
                if(b) {
                    three.setBackgroundResource(R.drawable.o);
                    layout[3]++;
                }
                else {
                    three.setBackgroundResource(R.drawable.x);
                    layout[3]+=2;
                }
                three.setClickable(false);
                break;
            }
            case R.id.four:{
                if(b) {
                    four.setBackgroundResource(R.drawable.o);
                    layout[4]++;
                }
                else {
                    four.setBackgroundResource(R.drawable.x);
                    layout[4]+=2;
                }
                four.setClickable(false);
                break;
            }
            case R.id.five:{
                if(b) {
                    five.setBackgroundResource(R.drawable.o);
                    layout[5]++;
                }
                else {
                    five.setBackgroundResource(R.drawable.x);
                    layout[5]+=2;
                }
                five.setClickable(false);
                break;
            }
            case R.id.six:{
                if(b) {
                    six.setBackgroundResource(R.drawable.o);
                    layout[6]++;
                }
                else {
                    six.setBackgroundResource(R.drawable.x);
                    layout[6]+=2;
                }
                six.setClickable(false);
                break;
            }
            case R.id.seven:{
                if(b) {
                    seven.setBackgroundResource(R.drawable.o);
                    layout[7]++;
                }
                else {
                    seven.setBackgroundResource(R.drawable.x);
                    layout[7]+=2;
                }
                seven.setClickable(false);
                break;
            }
            case R.id.eight:{
                if(b) {
                    eight.setBackgroundResource(R.drawable.o);
                    layout[8]++;
                }
                else {
                    eight.setBackgroundResource(R.drawable.x);
                    layout[8]+=2;
                }
                eight.setClickable(false);
                break;
            }
        }
        chance--;
        result();
    }
    public void pass(boolean b){
        String str="";
        if(b) str="Player One(OctoCat) Wins!";
        else str="Player Two(Cross) Wins!";
        final AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(Activity1.this).setTitle("Congratulations!").setMessage(str)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Activity1.this,Activity1.class));
                        finish();
                    }
                });
        final AlertDialog dialog=builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.show();
    }
    public void tie(){
        final AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(Activity1.this).setTitle("Oh bhai bhai bhai bhai!").setMessage("It's a tie!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Activity1.this,Activity1.class));
                        finish();
                    }
                });
        final AlertDialog dialog=builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.show();
    }
    public void result(){
        int ret=check();
        if(ret==0 && chance==0)
            tie();
    }
    public int check(){
        int res=0;
        if(layout[0]==1&&layout[1]==1&&layout[2]==1){
            pass(true);res++;
        }
        else if(layout[3]==1&&layout[4]==1&&layout[5]==1){
            pass(true);res++;
        }
        else if(layout[6]==1&&layout[7]==1&&layout[8]==1){
            pass(true);res++;
        }
        else if(layout[0]==1&&layout[3]==1&&layout[6]==1){
            pass(true);res++;
        }
        else if(layout[1]==1&&layout[4]==1&&layout[7]==1){
            pass(true);res++;
        }
        else if(layout[2]==1&&layout[5]==1&&layout[8]==1){
            pass(true);res++;
        }
        else if(layout[0]==1&&layout[4]==1&&layout[8]==1){
            pass(true);res++;
        }
        else if(layout[2]==1&&layout[4]==1&&layout[6]==1){
            pass(true);res++;
        }
        else if(layout[0]==2&&layout[1]==2&&layout[2]==2){
            pass(false);res++;
        }
        else if(layout[3]==2&&layout[4]==2&&layout[5]==2){
            pass(false);res++;
        }
        else if(layout[6]==2&&layout[7]==2&&layout[8]==2){
            pass(false);res++;
        }
        else if(layout[0]==2&&layout[3]==2&&layout[6]==2){
            pass(false);res++;
        }
        else if(layout[1]==2&&layout[4]==2&&layout[7]==2){
            pass(false);res++;
        }
        else if(layout[2]==2&&layout[5]==2&&layout[8]==2){
            pass(false);res++;
        }
        else if(layout[0]==2&&layout[4]==2&&layout[8]==2){
            pass(false);res++;
        }
        else if(layout[2]==2&&layout[4]==2&&layout[6]==2){
            pass(false);res++;
        }
        return res;
    }
}
