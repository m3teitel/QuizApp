package com.example.mike.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView question, response;
    Button choice1, choice2, choice3, choice4;
    Question q1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        q1 = new Question("Press 2", "1", false, "2", true, "3", false, "4", false);
        setAllText();
    }
   public void button1(View v){
        response = (TextView) findViewById(R.id.textView2);
        if(q1.isRight((String)choice1.getText()))
            response.setText("correct");
       else
            response.setText("Wrong");
   }
    public void button2(View v){
        response = (TextView) findViewById(R.id.textView2);
        if(q1.isRight((String)choice2.getText()))
            response.setText("correct");
        else
            response.setText("Wrong");
    }
    public void button3(View v){
        response = (TextView) findViewById(R.id.textView2);
        if(q1.isRight((String)choice3.getText()))
            response.setText("correct");
        else
            response.setText("Wrong");
    }
    public void button4(View v){
        response = (TextView) findViewById(R.id.textView2);
        if(q1.isRight((String)choice4.getText()))
            response.setText("correct");
        else
            response.setText("Wrong");
    }
    public void setAllText(){
        question = (TextView) findViewById(R.id.textView);
        question.setText(q1.getQuestion());
        choice1 = (Button) findViewById(R.id.button);
        choice1.setText(q1.getAnswer(0));
        choice2 = (Button) findViewById(R.id.button2);
        choice2.setText(q1.getAnswer(1));
        choice3 = (Button) findViewById(R.id.button3);
        choice3.setText(q1.getAnswer(2));
        choice4 = (Button) findViewById(R.id.button4);
        choice4.setText(q1.getAnswer(3));
    }
}
