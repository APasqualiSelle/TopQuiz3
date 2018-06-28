package com.selle.aline.topquiz3.controller;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.selle.aline.topquiz3.R;

public class NameAndScore extends AppCompatActivity {
    private SharedPreferences mPreferencesNames;
    private String mGamersName;

    private TextView mDisplayPlayersNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_and_score);


        mDisplayPlayersNames = findViewById(R.id.activity_name_and_score_txt);

        mPreferencesNames = getSharedPreferences(MainActivity.PREF_KEY_TOP_JOUEURS, MODE_PRIVATE);

        mGamersName = mPreferencesNames.getString(MainActivity.PREF_KEY_NAME, "List of names:");
        mDisplayPlayersNames.setText("List de joueurs:\n" + mGamersName);


    }


}

