package com.thegosa.jsonwriterdev;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class hw_themes extends AppCompatActivity {

    TextView showText;
    String stringdone, whichcolor, wichcaty;
    List<Pojo> liste = new ArrayList<>();
    int clickcount;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button setBtn = findViewById(R.id.button);
        showText = findViewById(R.id.textView);

        setBtn.setVisibility(View.GONE);


        EditText all_text = findViewById(R.id.dssd);
        RadioGroup rb =  findViewById(R.id.radios);
        RadioGroup catyRadio = findViewById(R.id.radioscaty);
        EditText numbertema = findViewById(R.id.textdigtl);
        EditText dwLink = findViewById(R.id.textsd);
        Button startnow = findViewById(R.id.startatt);
        numbertema.setVisibility(View.VISIBLE);
        dwLink.setVisibility(View.VISIBLE);
        startnow.setVisibility(View.VISIBLE);

        startnow.setOnClickListener(v12 ->{
            startnow.setVisibility(View.GONE);
            clickcount= Integer.parseInt(numbertema.getText().toString());
        });

        rb.setOnCheckedChangeListener((group, checkedId) -> {
            View radioButton = rb.findViewById(checkedId);
            int index = rb.indexOfChild(radioButton);
            switch (index) {
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
                    Toast.makeText(this, "4nji", Toast.LENGTH_SHORT).show();
                    whichcolor = "azure";
                    break;
                case 4:
                    Toast.makeText(this, "5nji", Toast.LENGTH_SHORT).show();
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
            }
        });

        String HI = "https://raw.githubusercontent.com/thegosa/theme_data/master/h_data/h_ths.json";
        StringRequest stringRequest = new StringRequest(HI, response -> {
            stringdone = response;
          //  setBtn.setVisibility(View.VISIBLE);
        }, error -> {

        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

        Calendar cal = Calendar.getInstance();
        String currectDate = String.valueOf(cal.get(Calendar.DAY_OF_YEAR));


        all_text.setOnEditorActionListener((v, actionId, event) -> {


            String linker = "https://raw.githubusercontent.com/thegosa/temalaryng-suraty/master/hw_themes_screens/hw_themes/";
            clickcount = clickcount-1;
            numbertema.setText(String.valueOf(clickcount));
/*
        String ree = "https://themes.cloud.huawei.ru/servicesupport/share/getSharing?type=4&hitopID=101699497&themeVersion=10.0&isoCode=RU&language=en_RU&shareTitle=Teddy-Gift&imgUrl=https%3A%2F%2Fcontentcenter-drru.dbankcdn.ru%2Fpub_15%2FHW-Themes_ThemeContentFile_901_9%2F71%2Fv3%2Ftheme_700391715%2Fpreview_unlock_0.jpg;"+
                "https://themes.cloud.huawei.ru/servicesupport/share/getSharing?type=4&hitopID=101733631&themeVersion=10.0&isoCode=RU&language=en_RU&shareTitle=El+Club+Visibles&imgUrl=https%3A%2F%2Fcontentcenter-drru.dbankcdn.ru%2Fpub_15%2FHW-Themes_ThemeContentFile_901_9%2Fc2%2Fv3%2Ftheme_700417913%2Fpreview_unlock_0.jpg";
                https://themes.cloud.huawei.com/servicesupport/share/getSharing?type=4&hitopID=2158669929&themeVersion=10.0&isoCode=RU&language=en_RU&shareTitle=Magic+butterfly&imgUrl=https%3A%2F%2Ftheme.dbankcdn.com%2Fhitop%2Ftheme%2F701828533%2Fpreview_unlock_0.jpg
                https://themes.cloud.huawei.com/servicesupport/share/getSharing?type=4&hitopID=102001771&themeVersion=10.0&isoCode=RU&language=en_RU&shareTitle=Wavy&imgUrl=https%3A%2F%2Ftheme.dbankcdn.com%2Fhitop%2Ftheme%2F700459274%2Fpreview_unlock_0.jpg
                https://contentcenter-drru.dbankcdn.ru/pub_15/HW-Themes_ThemeContentFile_901_9/f8/v3/theme_700459274/preview_widget_0.jpg
                https://contentcenter-drru.dbankcdn.ru/pub_15/HW-Themes_ThemeContentFile_901_9/99/v3/theme_701828533/preview_widget_0.jpg
        String ere = "https://contentcenter-drru.dbankcdn.ru/pub_15/HW-Themes_ThemeContentFile_901_9/71/v3/theme_700391715/preview_widget_0.jpg";
        String dfgdf = "https://contentcenter-drru.dbankcdn.ru/pub_15/HW-Themes_ThemeContentFile_901_9/71/v3/theme_700391715/preview_unlock_0.jpg";
        String dfg = "https://contentcenter-drru.dbankcdn.ru/pub_15/HW-Themes_ThemeContentFile_901_9/c2/v3/theme_700417913/preview_widget_0.jpg";
                   https:\/\/contentcenter-drru.dbankcdn.ru\/pub_15\/HW-Themes_ThemeContentFile_901_9\/c2\/v3\/theme_700417913\/preview_widget_0.jpg
        https://https:\/\/contentcenter-drru.dbankcdn.ru\/pub_15\/HW-Themes_ThemeContentFile_901_9\/c2\/theme_700417913\/preview_widget_0.jpg


https://themes.cloud.huawei.com/servicesupport/share/getSharing?type=4&hitopID=2154157489&themeVersion=10.0&isoCode=RU&language=en_RU&shareTitle=Flowers+bloom+and+meet+again&imgUrl=https%3A%2F%2Ftheme.dbankcdn.com%2Fhitop%2Ftheme%2F701541412%2Fpreview_unlock_0.jpg
https://contentcenter-drru.dbankcdn.ru/pub_15/HW-Themes_ThemeContentFile_901_9/25/v3/theme_701541412/preview_widget_0.jpg
*/
            String alltxt = all_text.getText().toString();

            String title = alltxt.substring(alltxt.indexOf("tle=") +4).split("&imgUrl")[0].replace("+", " ");
            String theId = alltxt.substring(alltxt.indexOf("v3%2F") +5).split("%2Fpr")[0];
            String  spic = alltxt.substring(alltxt.indexOf("9%2F") +4).split("%2Fv3")[0];
            String dw = linker +  dwLink.getText().toString() + clickcount + ".hwt";
            String image = "https://contentcenter-drru.dbankcdn.ru/pub_15/HW-Themes_ThemeContentFile_901_9/" + spic +"/v3/" +theId + "/preview_widget_0.jpg";
            String img = "https://contentcenter-drru.dbankcdn.ru/pub_15/HW-Themes_ThemeContentFile_901_9/" + spic +"/v3/"+ theId + "/preview_unlock_0.jpg";
            String img1 = "https://contentcenter-drru.dbankcdn.ru/pub_15/HW-Themes_ThemeContentFile_901_9/" + spic +"/v3/"+ theId + "/preview_icons_0.jpg";

        /*
        JSONObject theme = new JSONObject();

        try {
            theme.put("title", title);
          //  theme.put("dw", dw);
            theme.put("image", image);
            theme.put("img", img);
            theme.put("img1", img1);
            theme.put("date_add", currectDate);
            if (whichcolor != null){
                theme.put("color", whichcolor);
            }
            if (wichcaty != null){
                theme.put("category", wichcaty);
            }
            save(hw_themes.this, theme.toString());
            all_text.setText("");

        } catch (JSONException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String jsonStr = theme.toString().replace("{","{\n").replace(",",",\n").replace("}","\n},\n");*/

            try {
                JSONArray object = new JSONArray(stringdone);

                for(int i = 0; i < object.length(); ++i) {
                    JSONObject itemObj = object.getJSONObject(i);
                    Pojo jojo = new Pojo();
                    jojo.setImage(itemObj.getString("image"));
                    liste.add(jojo);



                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            String donee = "{\"title\":\"" + title+"\",\n" + "\"dw\":\"" + dw + "\",\n"+ "\"image\":\"" + image + "\",\n"+ "\"img\":\"" + img + "\",\n"+ "\"img1\":\"" + img1 + "\",\n"+ "\"date_add\":\"" + currectDate + "\",\n" + "\"color\":\"" + whichcolor + "\"},\n";

            final List<Pojo> filterModList = filter(liste, theId);
            if (filterModList.isEmpty()) {
                showText.append(donee);


            } else {
                Toast.makeText(hw_themes.this, "bu eyyam bar", Toast.LENGTH_SHORT).show();
            }
            all_text.setText("");
            return false;
        });


    }

    private List<Pojo>filter(List<Pojo>hi,String query){
        query=query.toLowerCase();
        final List<Pojo>filterModeList=new ArrayList<>();
        for (Pojo modal:hi){
            final String text=modal.getImage().toLowerCase();
            if (text.contains(query)){
                filterModeList.add(modal);
            }
        }
        return filterModeList;
    }


    public void save(Context context, String jsonString) throws IOException {
        File rootFolder = context.getExternalFilesDir(null);
        File jsonFile = new File(rootFolder, "file.json");
        FileWriter writer = new FileWriter(jsonFile);
        writer.write(jsonString);
        writer.close();
    }
}

