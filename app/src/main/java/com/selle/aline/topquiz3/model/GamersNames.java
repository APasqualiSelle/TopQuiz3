package com.selle.aline.topquiz3.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by Aline de Alexandria e Pasquali Selle - OpenClassrooms on 27/06/2018.
 */
public class GamersNames {

private ArrayList<String> mNames = new ArrayList<>();

public void addNames(String firstName){

    mNames.add(firstName);
    Collections.sort(mNames);
}

public String toString() {
    String resultat = "";


    for (String name : mNames) {
        resultat += name+"\n";
    }
    return resultat;


}
}
