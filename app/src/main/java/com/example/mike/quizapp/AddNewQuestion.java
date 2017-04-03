package com.example.mike.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.google.gson.Gson;

import java.io.Serializable;

public class AddNewQuestion extends AppCompatActivity {

    private EditText question, answer1, answer2, answer3, answer4;
    private RadioButton r1, r2, r3, r4;
    private Question q;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_question);
        question = (EditText) findViewById(R.id.question);
        answer1 = (EditText) findViewById(R.id.answerText1);
        answer2 = (EditText) findViewById(R.id.answerText2);
        answer3 = (EditText) findViewById(R.id.answerText3);
        answer4 = (EditText) findViewById(R.id.answerText4);
        r1 = (RadioButton) findViewById(R.id.radioButton1);
        r2 = (RadioButton) findViewById(R.id.radioButton2);
        r3 = (RadioButton) findViewById(R.id.radioButton3);
        r4 = (RadioButton) findViewById(R.id.radioButton4);
    }
    public void setText(View view){
        Gson gson = new Gson();
        String ques = question.getText().toString();
        String a1 = answer1.getText().toString();
        boolean a1r = r1.isChecked();
        String a2 = answer2.getText().toString();
        boolean a2r = r2.isChecked();
        String a3 = answer3.getText().toString();
        boolean a3r = r3.isChecked();
        String a4 = answer4.getText().toString();
        boolean a4r = r4.isChecked();
        q = new Question(ques ,a1 ,a1r,a2 ,a2r ,a3 ,a3r,a4,a4r);
        String str = gson.toJson(q);
        Intent intent = new Intent();
        intent.putExtra("newQ", str);
        setResult(RESULT_OK, intent);
        finish();
    }

}
