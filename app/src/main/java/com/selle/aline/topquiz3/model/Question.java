package com.selle.aline.topquiz3.model;

import java.util.List;

/**
 * Created by Aline de Alexandria e Pasquali Selle - OpenClassrooms on 09/06/2018.
 */
public class Question {

    private String mQuestion;
    private List<String> mChoiceList;//Lista de possíveis respostas
    private int mCorrectAnswerIndex;//index de la réponse correcte

    public Question(String question, List<String> choiceList, int correctAnswerIndex) {
        this.setQuestion(question);
        this.setChoiceList(choiceList);
        this.setCorrectAnswerIndex(correctAnswerIndex);
    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }

    public List<String> getChoiceList() {
        return mChoiceList;
    }

    public void setChoiceList(List<String> choiceList) {
        if (choiceList == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        mChoiceList = choiceList;
    }

    public int getCorrectAnswerIndex() {

        return mCorrectAnswerIndex;
    }

    public void setCorrectAnswerIndex(int correctAnswerIndex) {
        if (correctAnswerIndex < 0 || correctAnswerIndex >= mChoiceList.size()) {
            throw new IllegalArgumentException("Answer index is out of bound");
        }

        mCorrectAnswerIndex = correctAnswerIndex;
    }

    @Override
    public String toString() {
        return "Question{" +
                "mQuestion='" + mQuestion + '\'' +
                ", mChoiceList=" + mChoiceList +
                ", mCorrectAnswerIndex=" + mCorrectAnswerIndex +
                '}';
    }
}