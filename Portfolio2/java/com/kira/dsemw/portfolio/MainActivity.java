package com.kira.dsemw.portfolio;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openFb(View view)
    {
        ImageView imageView = (ImageView) findViewById(R.id.fb);
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse("https://www.facebook.com/daksh.semwal");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
    public void openIn(View view)
    {
        ImageView imageView = (ImageView) findViewById(R.id.in);
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse("https://www.instagram.com/daksh_semwal/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
    public void opentwitter(View view)
    {
        ImageView imageView = (ImageView) findViewById(R.id.tw);
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse("https://twitter.com/Dakshsemwal");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
