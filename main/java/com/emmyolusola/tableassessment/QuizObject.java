package com.emmyolusola.tableassessment;

import android.widget.Button;

import java.util.List;

/**
 * Created by Emmyolusola on 5/4/2016.
 */
public class QuizObject {

    String questions;
    List<String[]> options;
    String answer;

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public List<String[]> getOptions() {
        return options;
    }

    public void setOptions(List<String[]> options) {
        this.options = options;
    }

    public QuizObject(String questions, List<String[]> options, String answer) {
        this.questions = questions;
        this.options = options;
        this.answer = answer;
    }

    public String getAnswer() {

        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
