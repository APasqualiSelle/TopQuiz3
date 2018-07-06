package com.selle.aline.topquiz3.model;

import java.util.Comparator;

/**
 * Created by Aline de Alexandria e Pasquali Selle - OpenClassrooms on 06/07/2018.
 */
public class MyScore implements Comparator<Gamers> {


    @Override
    public int compare(Gamers score1, Gamers score2) {

        if(score1.getScore()<score2.getScore()){
            return 1;
        }else {
            return -1;
        }


    }


}
