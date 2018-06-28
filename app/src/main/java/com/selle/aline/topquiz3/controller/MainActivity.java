package com.selle.aline.topquiz3.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.selle.aline.topquiz3.R;
import com.selle.aline.topquiz3.model.GamersNamesAndScore;
import com.selle.aline.topquiz3.model.TopGamers;
import com.selle.aline.topquiz3.model.User;

public class MainActivity extends AppCompatActivity {


    private TextView mDisplayGreetingTxt;
    private EditText mNameInput;
    private Button mPlayButton;
    private Button mTopJoeursButton;

    private User mUser;
    private TopGamers mGamers;
    private GamersNamesAndScore mNameList;
    public String mName;
    private int mScore;

    //variable pour recuperer un resultat dans ActivityResult()
    public static final int GAME_ACTIVITY_REQUEST_CODE = 42;
    //creation d'un identifiant qui permet de recuperer le score en utilisant cet identifiant
    public static final String BUNDLE_EXTRA_FIRSTNAME = "BUNDLE_EXTRA_FIRSTNAME";
    public static final String PREF_KEY_NAME = "PREF_KEY_NAME"; // name of the file that stock preferences
    private SharedPreferences mPreferences;
    public static final String PREF_KEY_TOP_JOUEURS = "PREF_KEY_TOP_JOUEURS";
    public static final String PREF_KEY_FIRST_NAME = "PREF_KEY_FIRST_NAME";

    //pour recuperer une valeur d'une autre activity nous utilisons la methode
    //onActivityResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (GAME_ACTIVITY_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
            //Fetch the score from the Intent
            int score = data.getIntExtra(GameActivity.BUNDLE_EXTRA_SCORE, 0);
            mGamers.addGamerNameAndScore(mUser.getFirstName(), score);
            mNameList.addNames(mUser.getFirstName());
            mPreferences.edit().putString(PREF_KEY_NAME, mNameList.toString()).apply();
            mPreferences.edit().putString(PREF_KEY_TOP_JOUEURS, mGamers.toString()).apply();
            mDisplayGreetingTxt.setText(mGamers.toString() + " estou no onActivityResult :-)");

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initliaser le type User dans la méthode OnCreate
        mUser = new User();

        //initialiser le type TopGamers dans la méthode OnCreate
        mGamers = new TopGamers();

        //initialiser le type Name dans la méthode onCreate
        mNameList = new GamersNamesAndScore();

//avant cetait juste getPreferences. Desormais, on a utilisé getSharedPreferences
        //qui nous permet de créer une cle, donc 'PREFERENCES_FILE'. Cette clé
        //permet aux autres activités d'acceder au même fichier que mPreferences
        //utilise
        mPreferences = getSharedPreferences(PREF_KEY_TOP_JOUEURS, MODE_PRIVATE);
        mDisplayGreetingTxt = findViewById(R.id.activity_main_greeting_txt);
        mNameInput = findViewById(R.id.activity_main_name_input);
        mPlayButton = findViewById(R.id.activity_main_play_btn);
        mTopJoeursButton = findViewById(R.id.activity_main_meilleur_joueur_btn);


        //pour recuperer la list de Joueurs qui a été sauvegardé en preferences:
        //mNameList = mPreferences.getString(PREF_KEY_NAME, "Player's list: ");
        //pour afficher les donnés recuperees
        mDisplayGreetingTxt.setText("Oi, estou no método OnCreate, lala ;-) Welcome" +
                " " + mGamers.toString());

        //pour inactiver le boutton
        mPlayButton.setEnabled(false);
        // mTopJoeursButton.setVisibility(View.GONE);

        //pour activer le boutton lorsqu'un utilisateur tape un charactere dans le clavier
        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPlayButton.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
//methode pour ajouter un listener au bouton. Cette methode va être appelé à chaque fois
        //qui l'utilisateur taper sur le bouton . Declaring anonymous class
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mémoriser le prenom du jouer dans l'objet mUser lorsqu'il clique sur le bouton
                mUser.setFirstName(mNameInput.getText().toString());

                //copier le nom du utilisateur dans la mémoire permanente du téléphone à travers
                //du SharedPreferences API
                mPreferences.edit().putString(PREF_KEY_FIRST_NAME, mUser.getFirstName()).apply();
                //edit()-->je souhaite éditer les valeurs de mPreferences
                //putString-->je veux mettre une valeur dans mPreferences qui est du type String
                //firstname --> s --> cest un nom attribuée à cette valeur, une clé creé par moi
                //mUser.getFirstName()-->je recupere le nom du utilisateur dans le modele User
                // a travers de la variable mUser qui a été crée dans le controller
                //apply()--> appliquer les modifications sur mPreferences


                //pour demarrer la GameActivity
                Intent gameActivityIntent = new Intent(MainActivity.this, GameActivity.class);

                // j ai bessoin que tu me communique un resultat
                startActivityForResult(gameActivityIntent, GAME_ACTIVITY_REQUEST_CODE);

            }
        });

        mTopJoeursButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent topJoueursIntent = new Intent(MainActivity.this, TopJoueurs.class);
                //avant startActivity, nous pouvons ajouter de données dans l'intent
                //à travers de la méthode putExtra
                // topJoueursIntent.putExtra(BUNDLE_EXTRA_FIRSTNAME,mFirstName);
                startActivity(topJoueursIntent);

            }
        });


    }


}

