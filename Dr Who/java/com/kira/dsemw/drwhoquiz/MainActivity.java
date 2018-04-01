package com.kira.dsemw.drwhoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private QuestionBank nQuestionLibrary =new QuestionBank();
    private TextView nScoreView;    //view for toatal score
    private TextView nQuestionView; //current question to answer;
    private Button nButtonChoice1; //choice 1
    private Button nButtonChoice2; //choice 2
    private Button nButtonChoice3; //choice 3
    private Button nButtonChoice4; //choice 4

    private String nAnswer; //correct answer
    private int nScore=0; //current total score;
    private int nQuestionNumber=0; //cuurent question number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nScoreView = (TextView)findViewById(R.id.score);
        nQuestionView = (TextView)findViewById(R.id.Question);
        nButtonChoice1=(Button)findViewById(R.id.choice1);
        nButtonChoice2=(Button)findViewById(R.id.choice2);
        nButtonChoice3=(Button)findViewById(R.id.choice3);
        nButtonChoice4=(Button)findViewById(R.id.choice4);
        updateQuestion();
        updateScore(nScore);
    }
    public void updateQuestion()
    {
        if(nQuestionNumber < nQuestionLibrary.getLength())
        {
            nQuestionView.setText(nQuestionLibrary.getQuestion(nQuestionNumber));
            nButtonChoice1.setText(nQuestionLibrary.getChoice(nQuestionNumber,1));
            nButtonChoice2.setText(nQuestionLibrary.getChoice(nQuestionNumber,2));
            nButtonChoice3.setText(nQuestionLibrary.getChoice(nQuestionNumber,3));
            nButtonChoice4.setText(nQuestionLibrary.getChoice(nQuestionNumber,4));
            nAnswer=nQuestionLibrary.getCorrectAnswer(nQuestionNumber);
            nQuestionNumber++;
        }
        else
        {
            Toast.makeText(MainActivity.this, "It Was the Last question!", Toast.LENGTH_SHORT);
            Intent intent= new Intent(MainActivity.this,HighestScoreActivity.class);
            intent.putExtra("Score", nScore);
            startActivity(intent);
        }
    }
    public void updateScore(int point)
    {
        nScoreView.setText("" + nScore+"/"+nQuestionLibrary.getLength());
    }
    public void onClick(View view)
    {
        Button answer=(Button) view;
        if(answer.getText() == nAnswer)
        {
            nScore=nScore+1;
            Toast.makeText(MainActivity.this,"Correct!",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(MainActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
        }
        updateScore(nScore);
        updateQuestion();
    }
}
