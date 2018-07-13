package com.selle.aline.topquiz3.controller;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.selle.aline.topquiz3.R;

import java.util.Collections;

public class TopJoueurs extends AppCompatActivity implements View.OnClickListener {

    private TextView mDisplayText;
    private String mGamersListScore;
    private String mNameList;

    private Button mScoreButton;
    private Button mNameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_top_joueurs );

        mNameButton = findViewById( R.id.activity_top_joueur_ordreAlphabetique_btn );
        mScoreButton = findViewById( R.id.activity_top_joueurs_score_btn );
        mDisplayText = findViewById( R.id.activity_top_joueur_txt );


        mNameButton.setOnClickListener( this );
        mScoreButton.setOnClickListener( this );

        SharedPreferences mPreferencesTopJoueurs = getSharedPreferences( MainActivity.PREF_KEY_TOP_JOUEURS, MODE_PRIVATE );

        mGamersListScore = mPreferencesTopJoueurs.getString(MainActivity.PREF_TOP_TOP_JOUEURS_SCORE,"0 points");

        mNameList = mPreferencesTopJoueurs.getString( MainActivity.PREF_KEY_TOP_JOUEURS, "Por enquanto ninguém" );
        //pour afficher dans le TextView
        //mGamersListScore = mPreferencesTopJoueurs.getString( MainActivity.PREF_TOP_TOP_JOUEURS_SCORE, "Omg" );

    }



    @Override
    public void onClick(View v) {


        int buttonClicked = v.getId();
        switch (buttonClicked) {
            case R.id.activity_top_joueur_ordreAlphabetique_btn:

                    mDisplayText.setText( mNameList );


                break;
            case R.id.activity_top_joueurs_score_btn:

                    mDisplayText.setText( mGamersListScore );

                break;

        }
    }
}