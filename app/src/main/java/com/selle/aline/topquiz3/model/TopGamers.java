package com.selle.aline.topquiz3.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * Created by Aline de Alexandria e Pasquali Selle - OpenClassrooms on 19/06/2018.
 */
public class TopGamers {


    private List<Gamers> mGamersList = new ArrayList<>();


    public void addGamerNameAndScore(String firstName, Integer score) {

        mGamersList.add( new Gamers( firstName, score ) );


    }

    /*public void addScoreAndGamer(Integer score, String firstName) {

        mGamersList.add( new Gamers( firstName, score ) );


    }*/

    //methode that returns a String for ordering for displaying a list:
    // we need a string for displaying the list
    public String printNameList() {
        String resultat = "";
        Collections.sort( mGamersList, new MyNameComparator() );
        for (int i = 0; i < mGamersList.size(); i++) {


            if (i > 4) {

                break;
            }
            resultat += mGamersList.get( i );

        }
        return resultat;
    }

    public String printScoreList() {

        String resultat = "";
        Collections.sort( mGamersList, new MyScoreComparator() );
        for (int i = 0; i < mGamersList.size(); i++) {

            if (i > 4) {

                break;
            }

            resultat += mGamersList.get( i );



        }
        return resultat;
    }
}







   /* public String toString() {

        String resultat = "";

        Set<String> nameValue = mNamesList.keySet();

        for (String i : nameValue) {

            resultat += i + " : "+ mNamesList.get(i)+" point(s).\n";

        }
return resultat;
    }*/

    /*public String toString2() {

        String resultat = "";

        Set<Integer> scoreValue = mScoreList.keySet();

        for (Integer i : scoreValue) {

            resultat += 0 -

                    i + " : " + mScoreList.get( i ) + " point(s).\n";

        }
        return resultat;
    }*/


