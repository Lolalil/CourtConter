package com.example.android.courtconter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String STATE_SCORESHAHAR = "scoreShahar";
    static final String STATE_SCORESHIRA = "scoreShira";
    int scoreShahar = 0;
    int scoreShira = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt(STATE_SCORESHAHAR , scoreShahar);
        savedInstanceState.putInt(STATE_SCORESHIRA , scoreShira);

        //Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState){
        //Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        //Restore state members from saved instance
        scoreShahar = savedInstanceState.getInt(STATE_SCORESHAHAR);
        scoreShira = savedInstanceState.getInt(STATE_SCORESHIRA);

        displayForShahar(scoreShahar);
        displayForShira(scoreShira);
    }


    /**
     * Displays the given score for Team A.
     */
    public void displayForShahar(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_shahar_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * when Shahar is right she gets a point
     */
    public void pointsUpShahar(View view) {
        scoreShahar = scoreShahar + 1;
        displayForShahar(scoreShahar);
    }

    /**
     * when Shahar is wrong she lose a point
     */
    public void pointsDownShahar(View view) {
        scoreShahar = scoreShahar - 1;
        displayForShahar(scoreShahar);
    }

    /**
     * when Shahar answer right to hard questions  she get a bonus point
     */
    public void pointsBonusShahar(View view) {
        scoreShahar = scoreShahar + 2;
        displayForShahar(scoreShahar);
    }

    /**
     * Displays the given score for Shira
     */
    public void displayForShira(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_shira_score);
        scoreView.setText(String.valueOf(score));
    }


    /**
     * when Shira is right she gets a point
     */
    public void pointsUpShira(View view) {
        scoreShira = scoreShira + 1;
        displayForShira(scoreShira);
    }

    /**
     * when Shira is wrong she lose a point
     */
    public void pointsDownShira(View view) {
        scoreShira = scoreShira - 1;
        displayForShira(scoreShira);
    }

    /**
     * when Shira answer right to hard questions  she get a bonus point
     */
    public void pointsBonusShira(View view) {
        scoreShira = scoreShira + 2;
        displayForShira(scoreShira);
    }

    /**
     * this will reset the score for both girls
     */
    public void resetButton(View view) {
        scoreShahar = 0;
        scoreShira = 0;
        displayForShahar(scoreShahar);
        displayForShira(scoreShira);
        findViewById(R.id.winner).setVisibility(View.INVISIBLE);
    }

    /**
     * this will show the winner the score for both girls
     */
    public void winnerButton(View view) {
        TextView winnerTeam = (TextView) findViewById(R.id.winner);

        if (scoreShahar > scoreShira) {
            winnerTeam.setText(R.string.shahar);
            winnerTeam.setBackgroundResource(R.color.Bright);
            findViewById(R.id.winner).setVisibility(View.VISIBLE);
        }
        if (scoreShira > scoreShahar) {
            winnerTeam.setText(R.string.shira);
            winnerTeam.setBackgroundResource(R.color.Bright);
            findViewById(R.id.winner).setVisibility(View.VISIBLE);
        }
        if (scoreShahar == scoreShira) {
            winnerTeam.setText(R.string.tie);
            winnerTeam.setBackgroundResource(R.color.Bright);
            findViewById(R.id.winner).setVisibility(View.VISIBLE);
        }

    }





}
