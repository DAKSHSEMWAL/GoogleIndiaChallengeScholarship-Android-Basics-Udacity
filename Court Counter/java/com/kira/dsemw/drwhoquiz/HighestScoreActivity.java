package com.kira.dsemw.drwhoquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HighestScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highest_score);

        TextView txtScore = (TextView) findViewById(R.id.textScore);
        TextView txtHighestScore = (TextView) findViewById(R.id.highestScore);
        Intent intent = getIntent();
        int score = intent.getIntExtra("Score",0);
        txtScore.setText("Your Score:"+score);

        //use Share prefrences to save the best score
        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
        int highscore = mypref.getInt("highscore",0);
        if(highscore>=score)
        {
            txtHighestScore.setText("High Score:"+highscore);
        }
        else
        {
            txtHighestScore.setText("New High Score: "+score);
            SharedPreferences.Editor editor = mypref.edit();
            editor.putInt("highscore",score);
            editor.commit();
        }
    }

    public void retry(View view)
    {
        Intent intent = new Intent(HighestScoreActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
