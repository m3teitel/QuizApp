package com.example.mike.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class MainActivity extends AppCompatActivity {
    private TextView question, response;
    private  Button choice1, choice2, choice3, choice4;
    private Question q1;
    private String strQ;
    private final int SET_QUESTION = 1;
    private Gson gson;
    public static final String EXTRA_MESSAGE = "com.example.mike.quizapp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gson = new Gson();
        q1 = new Question("Press 2", "1", false, "2", true, "3", false, "4", false);
        setAllText();
        readFile();
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
    public void setQ(String q, String an1, Boolean a1r, String an2, Boolean a2r,String an3, Boolean a3r,String an4, Boolean a4r){
        q1 = new Question(q, an1, a1r, an2, a2r, an3, a3r, an4, a4r);
    }
    public void addQ(View view){
        Intent intent = new Intent(this, AddNewQuestion.class);
        startActivityForResult(intent, SET_QUESTION);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SET_QUESTION){
            if(resultCode == RESULT_OK){
                strQ = data.getStringExtra("newQ");
                putNewQ();
            }
        }
    }
    public void putNewQ(){
        q1 = gson.fromJson(strQ, Question.class);
        writeFile();
        setAllText();
    }
    public void readFile(){
        try {
            FileReader fr = new FileReader(new File(this.getFilesDir(), "Question.quiz"));
            BufferedReader br = new BufferedReader(fr);
            strQ = br.readLine();
            putNewQ();
            fr.close();
            br.close();
        } catch (Exception e){
            Toast toast = Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    public void writeFile(){
        try{
            FileWriter fw = new FileWriter(new File(this.getFilesDir(), "Question.quiz"));
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(strQ);
            bw.close();
            fw.close();
        } catch (Exception e){
            Toast toast = Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
