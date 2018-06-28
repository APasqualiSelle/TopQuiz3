package com.selle.aline.topquiz3.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Aline de Alexandria e Pasquali Selle - OpenClassrooms on 27/06/2018.
 */
public class GamersNamesAndScore {

private ArrayList<String> mNamesList = new ArrayList<>();
private ArrayList<Integer> mScoreList = new ArrayList<>();

public void addNames(String firstName){

    mNamesList.add(firstName);
    Collections.sort(mNamesList);
}

public void addScore(int score){

    mScoreList.add(score);
    Collections.sort(mScoreList,Collections.reverseOrder());
}



public String toString() {
    String resultat = "";


    for (String name : mNamesList) {
        resultat += name+"\n";
    }
    return resultat;


}

//on a besoin d'un toString pour le score egalement, car nous voulons afficher une liste (de score)
public String toStringScore(){

    String resultat ="";
    for(Integer score:mScoreList){
        resultat += score+"\n";
    }

    return resultat;
}



}
