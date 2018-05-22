package com.examlpe.android.ballcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Add three points when tapped to team A

    public void addThreeToA(View view){
        scoreTeamA+=3;
        displayScoreTeamA(scoreTeamA);
    }

    public void addTwoToA(View view){
        scoreTeamA+=2;
        displayScoreTeamA(scoreTeamA);
    }

    public void addOneToTeamA(View view){
        scoreTeamA+=1;
        displayScoreTeamA(scoreTeamA);
    }

    private void displayScoreTeamA(int number){
        TextView teamAScore = (TextView) findViewById(R.id.team_a_score);
        teamAScore.setText(String.valueOf(number));

    }
}
