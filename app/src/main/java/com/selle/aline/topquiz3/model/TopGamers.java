package com.selle.aline.topquiz3.model;


import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static java.util.Collections.*;


/**
 * Created by Aline de Alexandria e Pasquali Selle - OpenClassrooms on 19/06/2018.
 */
public class TopGamers {

    private Map<String, Integer> mGamersNameAndScore = new TreeMap<>(
    );
    private Map<Integer, String> mGamersScoreAndName = new TreeMap<>(
            new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            }
    );

    public void addGamerNameAndScore(String firstName, Integer score) {

        mGamersNameAndScore.put( firstName, score );

    }

    public void addScoreAndGamer(Integer score, String firstName) {

        mGamersScoreAndName.put( score, firstName );

    }

    //methode for ordering a TreeMap in alphabetical order:
    public String printMapName() {
        String resultat = "";
        for (Map.Entry<String, Integer> entry : mGamersNameAndScore.entrySet()) {
            resultat += "Joeur: " + entry.getKey() +
                    " Score : " + entry.getValue()+"\n";
        }
        return resultat;
    }

    public String printMapScore() {
        String resultat = "";
        for (Map.Entry<Integer, String> entry : mGamersScoreAndName.entrySet()) {
            resultat += "Score: " + entry.getKey() +
                    " Joueur : " + entry.getValue()+"\n";
        }
        return resultat;
    }


   /* public String toString() {

        String resultat = "";

        Set<String> nameValue = mGamersNameAndScore.keySet();

        for (String i : nameValue) {

            resultat += i + " : "+ mGamersNameAndScore.get(i)+" point(s).\n";

        }
return resultat;
    }*/

    public String toString2() {

        String resultat = "";

        Set<Integer> scoreValue = mGamersScoreAndName.keySet();

        for (Integer i : scoreValue) {

            resultat += 0 -

                    i + " : " + mGamersScoreAndName.get( i ) + " point(s).\n";

        }
        return resultat;
    }


}