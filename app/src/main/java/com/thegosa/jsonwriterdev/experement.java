package com.thegosa.jsonwriterdev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class experement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experement);


        ImageView imageView = findViewById(R.id.imageView3);
        Picasso.get().load("").into(imageView);
    }
}