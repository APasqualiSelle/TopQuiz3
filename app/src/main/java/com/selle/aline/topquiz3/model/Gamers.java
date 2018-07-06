package com.selle.aline.topquiz3.model;

/**
 * Created by Aline de Alexandria e Pasquali Selle - OpenClassrooms on 06/07/2018.
 */
public class Gamers {

    private String name;
    private Integer score;

    public Gamers(String name, Integer score){

        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return
                name + ":" +
                score + " points.";
    }


}
