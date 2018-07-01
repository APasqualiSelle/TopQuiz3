package com.selle.aline.topquiz3.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.selle.aline.topquiz3.R;
import com.selle.aline.topquiz3.model.TopGamers;

import java.util.Collections;

public class TopJoueurs extends AppCompatActivity implements View.OnClickListener {

    private TextView mDisplayPlayersNames;
    private TextView mDisplayPlayerScore;
    private String mGamersName;
    private String mGamersScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_top_joueurs );

        Button nameButton = findViewById( R.id.activity_top_joueur_ordreAlphabetique_btn );
        Button scoreButton = findViewById( R.id.activity_top_joueurs_score_btn );

        mDisplayPlayersNames = findViewById( R.id.activity_top_joueur_name_txt );
        mDisplayPlayerScore = findViewById( R.id.activity_top_joueuer_score_txt);
        TextView displayPlayerNameAndScore = findViewById( R.id.activity_top_joueur_txt );
        nameButton.setOnClickListener( this );
        scoreButton.setOnClickListener( this );

        SharedPreferences mPreferencesTopJoueurs = getSharedPreferences( MainActivity.PREF_KEY_TOP_JOUEURS, MODE_PRIVATE );

       /* //j'ai besoin d'affecter les preferences dans le type String mLastPlayerName
        mLastPlayerName = mPreferencesTopJoueurs.getString(MainActivity.PREF_KEY_FIRST_NAME, "Top Joueurs");

        mLastScore = mPreferencesTopJoueurs.getInt(MainActivity.PREF_KEY_SCORE, 0);
        //La façon de recuperer de données de l'intent de la main Activity
        //mLastPlayerName = getIntent().getStringExtra(MainActivity.BUNDLE_EXTRA_FIRSTNAME);
*/
        String gamerList = mPreferencesTopJoueurs.getString( MainActivity.PREF_KEY_TOP_JOUEURS, "Por enquanto ninguém" );
        //pour afficher dans le TextView
        displayPlayerNameAndScore.setText( gamerList );
        mGamersScore = mPreferencesTopJoueurs.getString( MainActivity.PREF_KEY_SCORE, "List of score:" );
        mGamersName = mPreferencesTopJoueurs.getString( MainActivity.PREF_KEY_NAME, "List of names:" );
    }

    @Override
    public void onClick(View v) {

        int buttonClicked = v.getId();
        switch (buttonClicked) {
            case R.id.activity_top_joueur_ordreAlphabetique_btn:
                mDisplayPlayersNames.setText(mGamersName);
                break;
            case R.id.activity_top_joueurs_score_btn:
                mDisplayPlayerScore.setText(mGamersScore);
                break;

        }
    }
}