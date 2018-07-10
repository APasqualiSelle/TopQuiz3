package com.selle.aline.topquiz3.model;

import java.util.Comparator;

/**
 * Created by Aline de Alexandria e Pasquali Selle - OpenClassrooms on 06/07/2018.
 */
public class MyNameComparator implements Comparator<Gamers> {


    @Override
    public int compare(Gamers name1, Gamers name2) {


        return name1.getName().compareTo(name2.getName());
    }
}
