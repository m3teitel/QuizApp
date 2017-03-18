package com.example.mike.quizapp;

/**
 * Created by Mike on 2017-03-17.
 */

public class Answer {
    private String answer;
    private boolean right;

    public Answer(String answer, boolean right){
        this.answer = answer;
        this.right = right;
    }
    public boolean getRight(){
        return right;
    }
    public String getAnswer(){
        return answer;
    }
}
