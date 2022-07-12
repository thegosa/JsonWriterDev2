package com.thegosa.jsonwriterdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_home_page);

        Button theme = findViewById(R.id.button2);
        Button wall = findViewById(R.id.button3);
        theme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(homePage.this, add_themes.class));
            }
        });
        wall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(homePage.this, add_wallpapers.class));
            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(homePage.this, add_wallpapers_wallcraft.class));
            }
        });

        findViewById(R.id.button5).setOnClickListener(v3434 ->{
            startActivity(new Intent(homePage.this, hw_themes.class));
        });

        findViewById(R.id.button6).setOnClickListener(v034 ->{
            startActivity(new Intent(this, hw_themes_umd.class));
        });

        findViewById(R.id.button7).setOnClickListener(v12 ->{
            startActivity(new Intent(this, hw_themes_sabur.class));
        });

        findViewById(R.id.button8).setOnClickListener(v14 ->{
            startActivity(new Intent(this, galaxythemes_add.class));
        });

        findViewById(R.id.button9).setOnClickListener(v -> {
            startActivity(new Intent(this, SpecialWalls.class));
        });
    }
}