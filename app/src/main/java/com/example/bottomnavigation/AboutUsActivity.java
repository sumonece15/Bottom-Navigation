package com.example.bottomnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutUsActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView nameTextView, universityTextView, subjectTextView, emailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        imageView = (ImageView) findViewById(R.id.imageViewId);
        nameTextView = (TextView) findViewById(R.id.nameTextViewId);
        universityTextView =(TextView) findViewById(R.id.universityTextViewId);
        subjectTextView =(TextView) findViewById(R.id.subjectTextViewId);
        emailTextView =(TextView) findViewById(R.id.emailTextViewId);
    }
}