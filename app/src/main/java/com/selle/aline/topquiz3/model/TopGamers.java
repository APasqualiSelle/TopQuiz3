package com.selle.aline.topquiz3.model;




import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static java.util.Collections.*;


/**
 * Created by Aline de Alexandria e Pasquali Selle - OpenClassrooms on 19/06/2018.
 */
public class TopGamers {

    private Map<String, Integer> mGamersNameAndScore = new TreeMap<>();
    private  List<String>mGamersName = new ArrayList<>();


    public void addGamerNameAndScore(String firstName, Integer score) {
        mGamersNameAndScore.put(firstName, score);

        }

    public void addGamerName(String firstName){
        mGamersName.add(firstName);
        Collections.sort(mGamersName);
    }

    public String toString() {

        String resultat = "";

        Set<String> nameList = mGamersNameAndScore.keySet();

        for (String i : nameList) {

            resultat += i + " : "+ mGamersNameAndScore.get(i)+" point(s).\n";

        }
return resultat;
    }

    public String toStringNamePlayers(){

        String resultat = "";
        for(String i: mGamersName){

            resultat+= i + " ";
        }

        return resultat;

    }



}