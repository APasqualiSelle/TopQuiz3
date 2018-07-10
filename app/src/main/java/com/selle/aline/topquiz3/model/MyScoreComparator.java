package com.selle.aline.topquiz3.model;

import java.util.Comparator;

/**
 * Created by Aline de Alexandria e Pasquali Selle - OpenClassrooms on 06/07/2018.
 */
public class MyScoreComparator implements Comparator<Gamers> {


    @Override
    public int compare(Gamers score1, Gamers score2) {

        //les valeurs de retour 1 ou -1 servent à indiquer l'ordre des objets.Dans ce cas
        //la, si le score1 est inférieur au score2, le premier vient devant.
        if(score1.getScore()<score2.getScore()){
            return 1;
        }else {
            return -1;
        }


    }


}
