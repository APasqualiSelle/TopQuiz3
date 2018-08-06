package com.selle.aline.topquiz3.model;

import java.util.Comparator;

/**
 * Created by Aline de Alexandria e Pasquali Selle - OpenClassrooms on 06/07/2018.
 */
public class MyNameComparator implements Comparator<Gamers> {


//la méthode compare défine l'ordre de deux objets de même type, c'est pour ça que nous
    //avons name1 et name2 du type Gamers (meme type)
    //compare retourne une valeur int qui par convention vaut -1, 0 ou 1;
    //-1 signifie que l'objet name1 est avant l'objet name2
    //0 signifie que les objets sont au même niveau
    //1 signifie que l'objet name1 est après l'objet name2
    @Override
    public int compare(Gamers name1, Gamers name2) {



        return name1.getName().compareTo( name2.getName() );
    }
}
