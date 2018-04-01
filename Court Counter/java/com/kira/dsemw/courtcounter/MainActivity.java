package com.kira.dsemw.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    int teamA=0;
    int teamB=0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void  addThreePointsforTeamA(View v)
    {
        teamA=teamA+3;
        displayForTeamA(teamA);
    }
    public void  addTwoPointsforTeamA(View v)
    {
        teamA=teamA+2;
        displayForTeamA(teamA);
    }
    public void  addOnePointsforTeamA(View v)
    {
        teamA=teamA+1;
        displayForTeamA(teamA);
    }
    public void  addThreePointsforTeamB(View v)
    {
        teamB=teamB+3;
        displayForTeamB(teamB);
    }
    public void  addTwoPointsforTeamB(View v)
    {
        teamB=teamB+2;
        displayForTeamB(teamB);
    }
    public void  addOnePointsforTeamB(View v)
    {
        teamB=teamB+1;
        displayForTeamB(teamB);
    }
    public void  resetScore(View v)
    {
        teamA=0;
        teamB=0;
        displayForTeamA(teamA);
        displayForTeamB(teamB);
    }
    public void displayForTeamA(int score)
    {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    public void displayForTeamB(int score)
    {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}
