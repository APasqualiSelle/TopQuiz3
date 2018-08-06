package com.selle.aline.topquiz3.model;

/**
 * Created by Aline de Alexandria e Pasquali Selle - OpenClassrooms on 06/07/2018.
 */
public class Gamers {

    private String mName;
    private Integer mScore;

    public Gamers(String name, Integer score){

        this.mName = name;
        this.mScore = score;
    }

    public String getName() {

        return mName;
    }

    public void setName(String name) {

        this.mName = name;
    }

    public Integer getScore() {

        return mScore;
    }

    public void setScore(Integer score) {

        this.mScore = score;
    }

    @Override
    public String toString() {
        return
                mName + ":" +
                        mScore + " points.\n";
    }



}
