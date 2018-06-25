package com.selle.aline.topquiz3.model;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


/**
 * Created by Aline de Alexandria e Pasquali Selle - OpenClassrooms on 19/06/2018.
 */
public class TopGamers {

    private HashMap<String, Integer> gamersList = new HashMap<>();


    public void addGamer(String firstName, Integer score) {
        gamersList.put(firstName, score);
    }

    public String toString() {

        String resultat = "";

        Set<String> nameList = gamersList.keySet();

        for (String i : nameList) {

            resultat += i + " : "+ gamersList.get(i);

        }
return resultat;
    }
}