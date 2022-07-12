package com.thegosa.jsonwriterdev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class galaxythemes_add extends AppCompatActivity {

    String whichcolor;
    List<Pojo> liste = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._galaxythemes_add);

        EditText themeLink = findViewById(R.id.textView4);
        EditText screenshots = findViewById(R.id.screenshots_id);
        TextView jsonText = findViewById(R.id.jsonviewtxt);

        RadioGroup rb =  findViewById(R.id.radios);


        String HI = "https://raw.githubusercontent.com/thegosa/theme_data/master/gthemes_data/gthemes.json";
        StringRequest stringRequest = new StringRequest(HI, response -> {
            try {
                JSONArray object = new JSONArray(response);
                for(int i = 0; i < object.length(); ++i) {
                    JSONObject itemObj = object.getJSONObject(i);
                    Pojo jojo = new Pojo();
                    jojo.setDesc(itemObj.getString("desc"));
                    liste.add(jojo);
                }
                findViewById(R.id.progressBar).setVisibility(View.GONE);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {

        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

        Calendar cal = Calendar.getInstance();
        String currectDate = String.valueOf(cal.get(Calendar.DAY_OF_YEAR));

        screenshots.setOnEditorActionListener((v, actionId, event) -> {
            String thlink = themeLink.getText().toString();
            String forsearch = thlink.substring(thlink.indexOf("appId=")+6);
            String themeTitle = thlink.substring(thlink.lastIndexOf(".")+1).trim();
            String screens = screenshots.getText().toString();

            String forOne = screens.substring(screens.indexOf("pe\" src=\"")+9);
            String one = forOne.split("\"><!-")[0];
            String forTwo = forOne.substring(forOne.indexOf("pe\" src=\"")+9);
            String two = forTwo.split("\"><!-")[0];
            String forThree = forTwo.substring(forTwo.indexOf("pe\" src=\"")+9);
            String three = forThree.split("\"><!-")[0];
            String forFour = forThree.substring(forThree.indexOf("pe\" src=\"")+9);
            String four = forFour.split("\"><!-")[0];
            String forFive = forFour.substring(forFour.indexOf("pe\" src=\"")+9);
            String five = forFive.split("\"><!-")[0];
            String forSix = forFive.substring(forFive.indexOf("pe\" src=\"")+9);
            String six = forSix.split("\"><!-")[0];

            int colorId = rb.getCheckedRadioButtonId();
            switch (colorId) {
                case 0:
                    whichcolor = "red";
                    break;
                case 1:
                    whichcolor = "black";
                    break;
                case 2:
                    whichcolor = "blue";
                    break;
                case 3:
                    whichcolor = "azure";
                    break;
                case 4:
                    whichcolor = "brown";
                    break;
                case 5:
                    whichcolor = "green";
                    break;
                case 6:
                    whichcolor = "silver";
                    break;
                case 7:
                    whichcolor = "orange";
                    break;
                case 8:
                    whichcolor = "pink";
                    break;
                case 9:
                    whichcolor = "purple";
                    break;
                case 10:
                    whichcolor = "yellow";
                    break;
                case 11:
                    whichcolor = "white";
                    break;
                default:
                    whichcolor = null;
                    break;
            }

            JSONObject theme_to_add = new JSONObject();
            try {
                theme_to_add.put("title", themeTitle);
                theme_to_add.put("desc", thlink);
                theme_to_add.put("color", whichcolor);
                theme_to_add.put("date_add", currectDate);
                theme_to_add.put("image", one);
                theme_to_add.put("img1", two);
                theme_to_add.put("img2", three);
                theme_to_add.put("img3", four);
                theme_to_add.put("img4", five);
                theme_to_add.put("img5", six);
                themeLink.setText("");
                screenshots.setText("");

            } catch (JSONException e){
                e.printStackTrace();
            }
            String jsonDone = theme_to_add.toString().replace("}","},\n");

            List<Pojo> filterModList = filter(liste, forsearch);
            if (filterModList.isEmpty()) {
                jsonText.append(jsonDone);
            } else {
                Toast.makeText(galaxythemes_add.this, "bu eyyam bar", Toast.LENGTH_SHORT).show();
            }

            return false;
        });
    }

    private List<Pojo>filter(List<Pojo>hi,String query){
        query=query.toLowerCase();
        final List<Pojo>filterModeList=new ArrayList<>();
        for (Pojo modal:hi){
            final String text=modal.getDesc().toLowerCase();
            if (text.contains(query)){
                filterModeList.add(modal);
            }
        }
        return filterModeList;
    }
}