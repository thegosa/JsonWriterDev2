package com.thegosa.jsonwriterdev;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.content.ClipDescription.MIMETYPE_TEXT_PLAIN;

public class hw_themes_umd extends AppCompatActivity {


    TextView showText;
    String stringdone, whichcolor, wichcaty;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button setBtn = findViewById(R.id.button);
        showText = findViewById(R.id.textView);


        EditText all_text = findViewById(R.id.dssd);
        RadioGroup rb = findViewById(R.id.radios);
        RadioGroup catyRadio = findViewById(R.id.radioscaty);
        EditText numbertema = findViewById(R.id.textdigtl);
        EditText dwLink = findViewById(R.id.textsd);
        Button startnow = findViewById(R.id.startatt);
        ImageView preview = findViewById(R.id.imageView);
        ImageView preview1 = findViewById(R.id.imageView1);
        ImageView preview2 = findViewById(R.id.imageView2);
        numbertema.setVisibility(View.GONE);
        dwLink.setVisibility(View.GONE);
        startnow.setVisibility(View.GONE);
        preview.setVisibility(View.VISIBLE);

        preview1.setVisibility(View.VISIBLE);
        preview2.setVisibility(View.VISIBLE);

        rb.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case 1:
                        whichcolor = "red";
                        break;
                    case 2:
                        whichcolor = "black";
                        break;
                    case 3:
                        whichcolor = "blue";
                        break;
                    case 4:
                        whichcolor = "azure";
                        break;
                    case 5:
                        whichcolor = "brown";
                        break;
                    case 6:
                        whichcolor = "green";
                        break;
                    case 7:
                        whichcolor = "silver";
                        break;
                    case 8:
                        whichcolor = "orange";
                        break;
                    case 9:
                        whichcolor = "pink";
                        break;
                    case 10:
                        whichcolor = "purple";
                        break;
                    case 11:
                        whichcolor = "yellow";
                        break;
                    case 12:
                        whichcolor = "white";
                        break;
                    default:
                        whichcolor = null;
                        break;
                }
            }

        });
        catyRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case 1:
                        wichcaty = "simple";
                        break;
                    case 2:
                        wichcaty = "modern";
                        break;
                    case 3:
                        wichcaty = "illustration";
                        break;
                    case 4:
                        wichcaty = "technology";
                        break;
                    default:
                        wichcaty = null;
                        break;
                }
            }
        });

        Calendar cal = Calendar.getInstance();
        String currectDate = String.valueOf(cal.get(Calendar.DAY_OF_YEAR));

        all_text.setOnTouchListener((v, event) -> {

            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            String pasteData = "";

            // If it does contain data, decide if you can handle the data.
            if (!(clipboard.hasPrimaryClip())) {

            } else if (!(clipboard.getPrimaryClipDescription().hasMimeType(MIMETYPE_TEXT_PLAIN))) {

                // since the clipboard has data but it is not plain text

            } else {

                //since the clipboard contains plain text.
                ClipData.Item item = clipboard.getPrimaryClip().getItemAt(0);

                // Gets the clipboard as text.
                pasteData = item.getText().toString();
                all_text.setText(item.getText());
            }


            String title = pasteData.substring(pasteData.indexOf("name_") +5).split("_end")[0].replace("+", " ");
            String forImages = title.toLowerCase().replace(" ","_");
            String image = "https://github.com/najdimu/h_themes_by_umidjan/raw/main/done_hw_theme/" + forImages + "/preview_widget_0.jpg";
            String img = "https://github.com/najdimu/h_themes_by_umidjan/raw/main/done_hw_theme/" + forImages + "/preview_unlock_0.jpg";
            String img1 = "https://github.com/najdimu/h_themes_by_umidjan/raw/main/done_hw_theme/" + forImages + "/preview_systemui_0.jpg";
            Picasso.get().load(image).fit().centerCrop().into(preview);
            Picasso.get().load(img).fit().centerCrop().into(preview1);
            Picasso.get().load(img1).fit().centerCrop().into(preview2);

            return false;
        });

        setBtn.setOnClickListener(v45 ->{
            String linker = "https://raw.githubusercontent.com/thegosa/temalaryng-suraty/master/hw_themes_screens/";



            String alltxt = all_text.getText().toString();

            String title = alltxt.substring(alltxt.indexOf("name_") +5).split("_end")[0].replace("+", " ");
            String forImages = title.toLowerCase().replace(" ","_");
            String image = "https://github.com/najdimu/h_themes_by_umidjan/raw/main/done_hw_theme/" + forImages + "/preview_widget_0.jpg";
            String img = "https://github.com/najdimu/h_themes_by_umidjan/raw/main/done_hw_theme/" + forImages + "/preview_unlock_0.jpg";
            String img1 = "https://github.com/najdimu/h_themes_by_umidjan/raw/main/done_hw_theme/" + forImages + "/preview_systemui_0.jpg";
            String dw = "https://github.com/najdimu/h_themes_by_umidjan/raw/main/done_hw_theme/" + forImages + "/" +forImages + ".hwt";

            JSONObject theme = new JSONObject();

            try {
                theme.put("title", title);
                theme.put("paid", dw);
                theme.put("image", image);
                theme.put("img", img);
                theme.put("img1", img1);
                theme.put("rewardAd", "ca-app-pub-5858473276365866/8028198792");
                theme.put("date_add", currectDate);
                if (whichcolor != null){
                    theme.put("color", whichcolor);
                }
                if (wichcaty != null){
                    theme.put("category", wichcaty);
                }

                all_text.setText("");

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            String jsonStr = theme.toString().replace("{","{\n").replace(",",",\n").replace("}","\n},\n");
            showText.append(jsonStr);
        });
    }
}
