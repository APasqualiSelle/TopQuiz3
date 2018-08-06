package com.selle.aline.topquiz3.controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.selle.aline.topquiz3.R;
import com.selle.aline.topquiz3.model.Question;
import com.selle.aline.topquiz3.model.QuestionBank;

import java.util.Arrays;


public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mQuestionTextView;
    private Button mAnswerButton1;
    private Button mAnswerButton2;
    private Button mAnswerButton3;
    private Button mAnswerButton4;

    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;

    private int mScore;
    private int mNumberOfQuestions;

    private boolean mEnableTouchEvents;

    //creation d'un identifiant qui permet de recuperer le score en utilisant cet identifiant
    public static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE";
    public static final String BUNDLE_STATE_SCORE = "currentScore";
    public static final String BUNDLE_STATE_QUESTION = "currentQuestion";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_game );

        System.out.println( "GameActivity::onCreate()" );

        if(savedInstanceState != null) {

                mScore = savedInstanceState.getInt( BUNDLE_STATE_SCORE );
                mNumberOfQuestions = savedInstanceState.getInt( BUNDLE_STATE_QUESTION );

        }else {
            mScore=0;
            mNumberOfQuestions = 6;
        }
        mQuestionBank = this.generateQuestions();

        mEnableTouchEvents = true;

        // Wire widgets
        mQuestionTextView = (TextView) findViewById( R.id.activity_game_question_text );
        mAnswerButton1 = (Button) findViewById( R.id.activity_game_answer1_btn );
        mAnswerButton2 = (Button) findViewById( R.id.activity_game_answer2_btn );
        mAnswerButton3 = (Button) findViewById( R.id.activity_game_answer3_btn );
        mAnswerButton4 = (Button) findViewById( R.id.activity_game_answer4_btn );


        //Use the tag property to 'name'the buttons
        mAnswerButton1.setTag( 0 );
        mAnswerButton2.setTag( 1 );
        mAnswerButton3.setTag( 2 );
        mAnswerButton4.setTag( 3 );

        //Use the same listener for the four buttons
        //The tag value will be used to distinguish the button triggered
        mAnswerButton1.setOnClickListener( this );
        mAnswerButton2.setOnClickListener( this );
        mAnswerButton3.setOnClickListener( this );
        mAnswerButton4.setOnClickListener( this );


        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion( mCurrentQuestion );

    }



    //getChoiceList() is a method from the class Question that returns a list of String
    private void displayQuestion(final Question question) {
        mQuestionTextView.setText( question.getQuestion() );
        mAnswerButton1.setText( question.getChoiceList().get( 0 ) );
        mAnswerButton2.setText( question.getChoiceList().get( 1 ) );
        mAnswerButton3.setText( question.getChoiceList().get( 2 ) );
        mAnswerButton4.setText( question.getChoiceList().get( 3 ) );
    }

    private QuestionBank generateQuestions() {
        Question question1 = new Question( "What is the name of the current french president?",
                Arrays.asList( "François Hollande", "Emmanuel Macron", "Jacques Chirac", "François Mitterand" ),
                1 );

        Question question2 = new Question( "How many countries are there in the European Union?",
                Arrays.asList( "15", "24", "28", "32" ),
                2 );

        Question question3 = new Question( "Who is the creator of the Android operating system?",
                Arrays.asList( "Andy Rubin", "Steve Wozniak", "Jake Wharton", "Paul Smith" ),
                0 );

        Question question4 = new Question( "When did the first man land on the moon?",
                Arrays.asList( "1958", "1962", "1967", "1969" ),
                3 );

        Question question5 = new Question( "What is the capital of Romania?",
                Arrays.asList( "Bucarest", "Warsaw", "Budapest", "Berlin" ),
                0 );

        Question question6 = new Question( "Who did the Mona Lisa paint?",
                Arrays.asList( "Michelangelo", "Leonardo Da Vinci", "Raphael", "Carravagio" ),
                1 );

        Question question7 = new Question( "In which city is the composer Frédéric Chopin buried?",
                Arrays.asList( "Strasbourg", "Warsaw", "Paris", "Moscow" ),
                2 );

        Question question8 = new Question( "What is the country top-level domain of Belgium?",
                Arrays.asList( ".bg", ".bm", ".bl", ".be" ),
                3 );

        Question question9 = new Question( "What is the house number of The Simpsons?",
                Arrays.asList( "42", "101", "666", "742" ),
                3 );

        return new QuestionBank( Arrays.asList( question1,
                question2,
                question3,
                question4,
                question5,
                question6,
                question7,
                question8,
                question9 ) );
    }

    //the method onSaveInstanceState(Bundle outState) is used to avoid the changing question
    //when we turn the phone or portrait
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(BUNDLE_STATE_SCORE, mScore);
        outState.putInt(BUNDLE_STATE_QUESTION, mNumberOfQuestions);

        super.onSaveInstanceState( outState);
    }


    @Override
    public void onClick(View view) {
//Nous pouvons utiliser if else au lieu de créer un tag:
        /*int responseIndex;
        if(view == mAnswerButton1){
            responseIndex=0;
        }else if (view == mAnswerButton2){
            responseIndex=1;
        }else if(view == mAnswerButton3){
            responseIndex=2;
        }else if(view == mAnswerButton4){
            responseIndex=3;
        }else{
            responseIndex = -1;
        }
*/
        int responseIndex = (int) view.getTag();
        if (responseIndex == mCurrentQuestion.getCorrectAnswerIndex()) {
            //good answer
            Toast.makeText( this, "Correct", Toast.LENGTH_SHORT ).show();
            mScore++;
        } else {
            //wrong answer
            Toast.makeText( this, "Wrong answer!", Toast.LENGTH_SHORT ).show();
        }

        mEnableTouchEvents = false;
        //pour améliorer l'experience de l'utilisateur(UX)
        //la méthode new Handler va nous permettre d'afficher les questions plus lentement
        //2000 milis = 2 seconds long


        new Handler().postDelayed( new Runnable() {

            @Override
            public void run() {

                mEnableTouchEvents = true;
                //if this is the last question, ends de game.
                //else, display the next question.
                if (--mNumberOfQuestions == 0) {
                    //End the game
                    endGame();
                } else {
                    mCurrentQuestion = mQuestionBank.getQuestion();
                    displayQuestion( mCurrentQuestion );
                }

            }
        }, 2000 );//LENGHT_SHORT is usually 2 second long

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return mEnableTouchEvents && super.dispatchTouchEvent( ev );
    }


    private void endGame() {

        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setTitle( "Well done!" )
                .setMessage( "Your score is " + mScore )
                .setPositiveButton( "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //end the activity
                        Intent resultData = new Intent();
                        resultData.putExtra( BUNDLE_EXTRA_SCORE, mScore );
                        //methode setResult pour enregistrer cette methode auprès d'Android
                        setResult( RESULT_OK, resultData );
                        finish();

                    }
                } )
                //what is .setCancelable for?
                .setCancelable(false)
                .create()
                .show();
    }



    @Override
    protected void onStart() {
        super.onStart();

        System.out.println( "MainActivity::onStart()" );
    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println( "MainActivity::onResume()" );
    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println( "MainActivity::onPause()" );
    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println( "MainActivity::onStop()" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println( "MainActivity::onDestroy()" );
    }


}
