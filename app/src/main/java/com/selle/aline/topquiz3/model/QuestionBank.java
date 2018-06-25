package com.selle.aline.topquiz3.model;

import java.util.Collections;
import java.util.List;

/**
 * Created by Aline de Alexandria e Pasquali Selle - OpenClassrooms on 09/06/2018.
 */
public class QuestionBank {

    private List<Question>mQuestionList;
    private int mNextQuestionIndex;

    public QuestionBank(List<Question>questionList){

        mQuestionList = questionList;

        Collections.shuffle(mQuestionList);
        mNextQuestionIndex = 0;
    }

    public Question getQuestion(){

    if(mNextQuestionIndex == mQuestionList.size()){
        mNextQuestionIndex=0;
    }

    return   mQuestionList.get(mNextQuestionIndex++);
    }
}
