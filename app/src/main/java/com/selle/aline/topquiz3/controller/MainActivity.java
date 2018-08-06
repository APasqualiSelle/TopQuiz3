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
import com.selle.aline.topquiz3.model.TopGamers;
import com.selle.aline.topquiz3.model.User;

public class MainActivity extends AppCompatActivity {


    private TextView mDisplayGreetingTxt;
    private EditText mNameInput;
    private Button mPlayButton;
    private Button mTopJoeursButton;
    private User mUser;
    private TopGamers mGamers;


    //variable pour recuperer un resultat dans ActivityResult()
    public static final int GAME_ACTIVITY_REQUEST_CODE = 42;
    //creation d'un identifiant qui permet de recuperer le score en utilisant cet identifiant
    public static final String BUNDLE_EXTRA_FIRSTNAME = "BUNDLE_EXTRA_FIRSTNAME";
    private SharedPreferences mPreferences;
    public static final String PREF_KEY_TOP_JOUEURS = "PREF_KEY_TOP_JOUEURS";
    public static final String PREF_TOP_TOP_JOUEURS_SCORE = "PREF_KEY_TOP_JOUEURS_SCORE";
    public static final String PREF_KEY_FIRSTNAME = "PREF_KEY_FIRSTNAME";
    public static final String PREF_KEY_SCORE = "PREF_KEY_SCORE";



    //pour recuperer une valeur d'une autre activity nous utilisons la methode
    //onActivityResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (GAME_ACTIVITY_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
            //Fetch the score from the Intent
            int score = data.getIntExtra( GameActivity.BUNDLE_EXTRA_SCORE, 0 );
            mPreferences.edit().putInt(PREF_KEY_SCORE, score).apply();
            mGamers.addGamerNameAndScore( mUser.getFirstName(), score );
            //  mGamers.addScoreAndGamer( score, mUser.getFirstName() );
            mPreferences.edit().putString( PREF_TOP_TOP_JOUEURS_SCORE, mGamers.printScoreList() ).apply();
            mPreferences.edit().putString( PREF_KEY_TOP_JOUEURS, mGamers.printNameList() ).apply();
            mTopJoeursButton.setVisibility( View.VISIBLE );
            mPreferences.edit().putString(PREF_KEY_FIRSTNAME, mUser.getFirstName()).apply();
            greetUser();

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        System.out.println( "MainActivity::OnCreate()" );
        //initliaser le type User dans la méthode OnCreate
        mUser = new User();
        //initialiser le type TopGamers dans la méthode OnCreate
        mGamers = new TopGamers();
        //initialiser le type TopGamers dans la méthode OnCreate

//avant cetait juste getPreferences. Desormais, on a utilisé getSharedPreferences
        //qui nous permet de créer une cle, donc 'PREF_KEY_TOP_JOUEURS'. Cette clé
        //permet aux autres activités d'acceder au même fichier que mPreferences
        //utilise
        mPreferences = getSharedPreferences( PREF_KEY_TOP_JOUEURS, MODE_PRIVATE );
        mDisplayGreetingTxt = findViewById( R.id.activity_main_greeting_txt );
        mNameInput = findViewById( R.id.activity_main_name_input );
        mPlayButton = findViewById( R.id.activity_main_play_btn );
        mTopJoeursButton = findViewById( R.id.activity_main_meilleur_joueur_btn );


        //pour recuperer la list de Joueurs qui a été sauvegardé en preferences:
        //mNameList = mPreferences.getString(PREF_KEY_NAME, "Player's list: ");
        //pour afficher les donnés recuperees:

        mDisplayGreetingTxt.setText( " Welcome on  OnCreateActivity()" );

        //pour inactiver le boutton
        mPlayButton.setEnabled( false );
        //pour rendre le boutton invisible
        mTopJoeursButton.setVisibility( View.GONE );

        //pour activer le boutton lorsqu'un utilisateur tape un charactere dans le clavier
        mNameInput.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //setEnabled: méthode pour activer le bouton dès que l'utilisateur tape
                //le premier caractere de son nom
                mPlayButton.setEnabled( s.toString().length() != 0 );


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        } );
//methode pour ajouter un listener au bouton. Cette methode va être appelé à chaque fois
        //qui l'utilisateur taper sur le bouton . Declaring anonymous class
        mPlayButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mémoriser le prenom du jouer dans l'objet mUser lorsqu'il clique sur le bouton
                mUser.setFirstName( mNameInput.getText().toString() );
                mPreferences.edit().putString(PREF_KEY_FIRSTNAME, mUser.getFirstName()).apply();
                //pour demarrer la GameActivity
                Intent gameActivityIntent = new Intent( MainActivity.this, GameActivity.class );

                // j ai bessoin que tu me communique un resultat
                startActivityForResult( gameActivityIntent, GAME_ACTIVITY_REQUEST_CODE );

            }
        } );


        mTopJoeursButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent topJoueursIntent = new Intent( MainActivity.this, TopJoueurs.class );
                //avant startActivity, nous pouvons ajouter de données dans l'intent, example:
                //à travers de la méthode putExtra
                // topJoueursIntent.putExtra(BUNDLE_EXTRA_FIRSTNAME,mFirstName);
                startActivity( topJoueursIntent );

            }
        } );

        }

    private void greetUser() {
        String firstname = mPreferences.getString( PREF_KEY_FIRSTNAME, null );

        if (null != firstname) {
            int score = mPreferences.getInt( PREF_KEY_SCORE, 0 );

            String fulltext = "Welcome back, " + firstname
                    + "!\nYour last score was " + score
                    + ", will you do better this time?";
            mDisplayGreetingTxt.setText( fulltext );
            mNameInput.setText( firstname );
            mNameInput.setSelection( firstname.length() );
            mPlayButton.setEnabled( true );
        }
    }

    @Override
    protected void onStart () {
        super.onStart();

        System.out.println( "MainActivity::onStart()" );
    }

    @Override
    protected void onResume () {
        super.onResume();

        System.out.println( "MainActivity::onResume()" );
    }

    @Override
    protected void onPause () {
        super.onPause();

        System.out.println( "MainActivity::onPause()" );
    }

    @Override
    protected void onStop () {
        super.onStop();

        System.out.println( "MainActivity::onStop()" );
    }

    @Override
    protected void onDestroy () {
        super.onDestroy();

        System.out.println( "MainActivity::onDestroy()" );
    }


}




