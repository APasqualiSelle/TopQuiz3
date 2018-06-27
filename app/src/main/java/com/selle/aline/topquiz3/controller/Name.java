package com.selle.aline.topquiz3.controller;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.selle.aline.topquiz3.R;
import com.selle.aline.topquiz3.model.User;

public class Name extends AppCompatActivity {

    private SharedPreferences mPreferencesNames;
    private  String mGamersName;

    private TextView mDisplayPlayersNames;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        mDisplayPlayersNames = findViewById(R.id.name_main_namesList_txt);

         mPreferencesNames = getSharedPreferences(MainActivity.PREF_KEY_TOP_JOUEURS,MODE_PRIVATE);

         mGamersName = mPreferencesNames.getString(MainActivity.PREF_KEY_NAME,"List of names:");
         mDisplayPlayersNames.setText("List de joueurs:\n"+ mGamersName);


    }
}
