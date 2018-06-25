package com.selle.aline.topquiz3.controller;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.selle.aline.topquiz3.R;
import com.selle.aline.topquiz3.model.TopGamers;

public class TopJoueurs extends AppCompatActivity {

    public static final String TAG = "TopJoueursActivity";
    private TextView mDisplayPlayerName;
    private SharedPreferences mPreferencesTopJoueurs;
    private String mGamerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_joueurs);

        mDisplayPlayerName = findViewById(R.id.activity_top_joueur_txt);

        mPreferencesTopJoueurs = getSharedPreferences(MainActivity.PREFERENCES_FILE, MODE_PRIVATE);

       /* //j'ai besoin d'affecter les preferences dans le type String mLastPlayerName
        mLastPlayerName = mPreferencesTopJoueurs.getString(MainActivity.PREF_KEY_FIRST_NAME, "Top Joueurs");

        mLastScore = mPreferencesTopJoueurs.getInt(MainActivity.PREF_KEY_SCORE, 0);
        //La façon de recuperer de données de l'intent de la main Activity
        //mLastPlayerName = getIntent().getStringExtra(MainActivity.BUNDLE_EXTRA_FIRSTNAME);
*/
        mGamerList = mPreferencesTopJoueurs.getString(MainActivity.PREF_KEY_TOP_JOUEURS,"Por enquanto ninguém");
        //pour afficher dans le TextView
         mDisplayPlayerName.setText(mGamerList.toString());





    }
}
