package com.selle.aline.topquiz3.model;


import java.util.Map;
import java.util.TreeMap;


/**
 * Created by Aline de Alexandria e Pasquali Selle - OpenClassrooms on 19/06/2018.
 */
public class TopGamers  {


    private Map<Gamers, String> mNamesList = new TreeMap<>(new MyName());
    private Map<Gamers, String> mScoreList = new TreeMap<>(new MyScore());


    public void addGamerNameAndScore(String firstName, Integer score) {

        mNamesList.put(new Gamers(firstName, score ),"Name");


    }
    public void addScoreAndGamer(Integer score, String firstName) {

        mScoreList.put(new Gamers(firstName,score ),"Score");

    }

    //methode for ordering a TreeMap in alphabetical order:
    public String printMapName() {
        String resultat = "";
        int i=0;
        for (Map.Entry<Gamers, String> entry : mNamesList.entrySet()) {
            resultat +=  entry.getKey() +
                      entry.getValue()+"\n";
            i++;
            if(i>4){
                break;
            }


        }
        return resultat;
    }

    public String printMapScore() {
        String resultat = "";
        int i=0;
        for (Map.Entry<Gamers, String> entry : mScoreList.entrySet()) {
            resultat +=  entry.getKey()
                     + entry.getValue()+"\n";
            i++;
            if(i>4){
                break;
            }
        }
        return resultat;
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


}