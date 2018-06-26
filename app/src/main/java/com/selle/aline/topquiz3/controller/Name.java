package com.selle.aline.topquiz3.controller;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.selle.aline.topquiz3.R;

public class Name extends AppCompatActivity {

    private SharedPreferences mPreferencesNames;
    private  String mNamesList;
    private TextView mDisplayPlayersNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        mDisplayPlayersNames = findViewById(R.id.name_main_namesList_txt);
        mPreferencesNames = PreferenceManager.getDefaultSharedPreferences(this);
        mNamesList = mPreferencesNames.getString(MainActivity.PREF_KEY_FIRST_NAME, "Names' list: ");
        mDisplayPlayersNames.setText(mNamesList);

    }
}
