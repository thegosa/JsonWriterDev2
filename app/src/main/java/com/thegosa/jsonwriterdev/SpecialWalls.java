package com.thegosa.jsonwriterdev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class SpecialWalls extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_walls);

        EditText editText = findViewById(R.id.editTextTextMultiLine);
        TextView textView = findViewById(R.id.textView5);
        Calendar cal = Calendar.getInstance();
        String currectDate = String.valueOf(cal.get(Calendar.DAY_OF_YEAR));

        editText.setOnEditorActionListener((v, actionId, event) -> {
            String dotext = editText.getText().toString();

            String newww = dotext.replace("https:", "{\"image\":\"https:");
            String donne =  newww.replace(".jpg", ".jpg\", \"special_wall\": true, \"date_add\":\""+currectDate+"\"},");

            textView.append(donne);

            return false;
        });

    }
}