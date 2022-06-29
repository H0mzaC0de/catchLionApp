package com.example.catchlion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button start;
TextView score;
ImageButton cases[]=new ImageButton[12];
CountDownTimer timer;
int c=-1;
int d=0;
int point=0;
int animals[]= {R.drawable.camel, R.drawable.coala, R.drawable.fox, R.drawable.monkey, R.drawable.wolf,
        R.drawable.camel, R.drawable.coala, R.drawable.fox, R.drawable.monkey, R.drawable.wolf,R.drawable.monkey,R.drawable.monkey};
boolean y=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score=findViewById(R.id.score);
        start=findViewById(R.id.start);
        start.setOnClickListener(this);
        for(int i=0;i<cases.length;i++){
            int id=getResources().getIdentifier("ib"+i,"id",getPackageName());
            cases[i]=findViewById(id);
            cases[i].setOnClickListener(this);
        }
        timer=new CountDownTimer(1000000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                moveLion();

            }

            @Override
            public void onFinish() {

            }
        };
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==start.getId()){
            timer.start();
            for(int i=0;i<cases.length;i++){
                cases[i].setImageResource(animals[i]);
                cases[i].setTag("n");
            }

        }
        for(int i=0;i<12;i++){
            if(v.getId()==cases[i].getId()){
                if(cases[i].getTag()=="y"){
                    point++;
                    score.setText(""+point);
                    if(point==10){
                        d+=3000;
                        timer=new CountDownTimer(1000000,d) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                moveLion();

                            }

                            @Override
                            public void onFinish() {

                            }
                        };
                    }
                    if(point>=50){
                        d+=7000;
                        timer=new CountDownTimer(1000000,d) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                moveLion();

                            }

                            @Override
                            public void onFinish() {

                            }
                        };
                    }
                }else{
                    point--;
                    score.setText(""+point);
                }
            }
        }
    }
    void moveLion(){
                if(c!=-1){
                    cases[c].setImageResource(animals[c]);
                    cases[c].setTag("n");
                }
                c=(int)Math.floor(Math.random()*11);
                cases[c].setImageResource(R.drawable.lion);
                cases[c].setTag("y");


    }
}