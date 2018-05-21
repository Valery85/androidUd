package com.examlpe.android.ballcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addThreeToA(View view){
        displayScoreTeamA(3);
    }
    public void addTwoToA(View view){
        displayScoreTeamA(2);
    }
    public void addOneToA(View view){
        displayScoreTeamA(1);
    }

    private void displayScoreTeamA(int number){
        TextView teamAScore = (TextView) findViewById(R.id.team_a_score);
        teamAScore.setText(String.valueOf(number));

    }
}
