package com.example.mike.quizapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mike on 2017-03-17.
 */

public class Question {
    private String question;
    private Answer a1, a2, a3, a4;
    private ArrayList<Answer> answers;

    public Question(String question, String answer1, boolean right1,String answer2, boolean right2,String answer3, boolean right3,String answer4, boolean right4){
        answers = new ArrayList<>();
        this.question = question;
        a1 = new Answer(answer1, right1);
        a2 = new Answer(answer2, right2);
        a3 = new Answer(answer3, right3);
        a4 = new Answer(answer4, right4);
        answers.add(a1);
        answers.add(a2);
        answers.add(a3);
        answers.add(a4);
    }
    public String getQuestion(){
        return question;
    }
    public String getAnswer(int i){
        return answers.get(i).getAnswer();
    }
    public boolean isRight(String a){
        boolean right = false;
        for(int i = 0; i < answers.size(); i++){
            if(answers.get(i).getAnswer().equals(a)){
               return answers.get(i).getRight();
               }
            }
        return right;
        }
    }


