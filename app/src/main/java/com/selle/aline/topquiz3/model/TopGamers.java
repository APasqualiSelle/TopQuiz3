package com.selle.aline.topquiz3.model;




import java.util.HashMap;
import java.util.Set;


/**
 * Created by Aline de Alexandria e Pasquali Selle - OpenClassrooms on 19/06/2018.
 */
public class TopGamers {

    private HashMap<String, Integer> mGamersList = new HashMap<>();


    public void addGamer(String firstName, Integer score) {
        mGamersList.put(firstName, score);
    }

    public String toString() {

        String resultat = "";

        Set<String> nameList = mGamersList.keySet();

        for (String i : nameList) {

            resultat += i + " : "+ mGamersList.get(i)+" point(s).\n";

        }
return resultat;
    }
}