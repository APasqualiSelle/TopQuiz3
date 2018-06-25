package com.selle.aline.topquiz3.model;

import android.widget.TextView;

import java.util.List;

/**
 * Created by Aline de Alexandria e Pasquali Selle - OpenClassrooms on 08/06/2018.
 */
public class User  {

    private String mFirstName;

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    @Override
    public String toString() {
        return "User{"+
                "mFirstName='"+ mFirstName + '\''+
                '}';
    }
}
