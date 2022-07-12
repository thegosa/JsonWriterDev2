package com.thegosa.jsonwriterdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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

public class add_themes extends AppCompatActivity {

    TextView showText;
    String stringdone, whichcolor, wichcaty;
    List<Pojo> liste = new ArrayList<>();
    int i = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button setBtn = findViewById(R.id.button);
        showText = findViewById(R.id.textView);
        findViewById(R.id.sdcsd).setVisibility(View.GONE);

        EditText all_text = findViewById(R.id.dssd);
        RadioGroup rb =  findViewById(R.id.radios);
        RadioGroup catyRadio = findViewById(R.id.radioscaty);
        TextView showthemecount = findViewById(R.id.textView2);
        showthemecount.setVisibility(View.VISIBLE);

        catyRadio.setOnCheckedChangeListener((radioGroup, i) -> {
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
        });
        rb.setOnCheckedChangeListener((group, checkedId) -> {
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
        });

        String HI = "https://raw.githubusercontent.com/thegosa/theme_data/master/miui_themes_data/miui_themes_all.json";
        StringRequest stringRequest = new StringRequest(HI, response -> {
            stringdone = response;
            setBtn.setVisibility(View.VISIBLE);
        }, error -> {

        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

        Calendar cal = Calendar.getInstance();
        String currectDate = String.valueOf(cal.get(Calendar.DAY_OF_YEAR));

        all_text.setOnEditorActionListener((v, actionId, event) -> {


            String sdf = all_text.getText().toString();
            String e_link = sdf.substring(sdf.indexOf("theme://") +8).split("';")[0];
            String theme_link = "http://" + e_link;

            String title1 = sdf.substring(sdf.indexOf("<title>") +7).split("-小米主题商店")[0].replace("_3MDS", "").replace("_3MDP", "")
                    .replace("_DWM2", "")
                    .replace("_", " ");
            String design1 = sdf.substring(sdf.indexOf("师：</span>") +9).split(" <br /> <span>制作者")[0];
            String size1 = sdf.substring(sdf.indexOf("小：</span>") +9).split(" <br /> <span>更")[0].replace("KB","");
            double  sizedigital =  Integer.parseInt(size1);
            if (sizedigital >= 1024){
                sizedigital = sizedigital/1024;
            }


            DecimalFormat form = new DecimalFormat("###.00");
            String sizeDone = form.format(sizedigital);
            String allimages = sdf.substring(sdf.indexOf("<img src=\"") +10).split("\" alt=\"\" />\n" +
                    "                                        <img src=\"https://r")[0];
            String image1 = allimages.split("\" alt=")[0];
            String image2 = allimages.substring(allimages.indexOf("<img src=\"") +10).split("\" alt=")[0];
            String readyforimg3 = allimages.substring(allimages.indexOf("<img src=\"") +10);
            String image3 = readyforimg3.substring(readyforimg3.indexOf("<img src=\"") +10).split("\" alt=")[0];
            String readyforimg4 = readyforimg3.substring(readyforimg3.indexOf("<img src=\"") +10);
            String image4 = readyforimg4.substring(readyforimg4.indexOf("<img src=\"") +10).split("\" alt=")[0];

            String readyforimage5 = readyforimg4.substring(readyforimg3.indexOf("<img src=\"") +10);
            String image5 = readyforimage5.substring(readyforimage5.indexOf("<img src=\"") +10).split("\" alt=")[0];


            if (!image4.startsWith("htt")){
                image4 = null;
            }
            if (!image5.startsWith("htt")){
                image5 = null;
            }

            JSONObject theme = new JSONObject();

            try {
                theme.put("title", title1);
                theme.put("desc", theme_link);
                theme.put("image", image2);
                theme.put("img1", image3);
                theme.put("img2", image1);
                if (image4 != null){
                    theme.put("img3", image4);
                }
                if (image5 != null){
                    theme.put("img4", image5);
                }
                if (design1 != null){
                    theme.put("design", design1);
                }
                if (sizedigital != 0){
                    theme.put("theme_size", sizeDone.replace(",",".").replace("/n", ""));
                }

                theme.put("color", whichcolor);

                if (wichcaty != null){
                    theme.put("category", wichcaty);
                }
                theme.put("date_add", currectDate);
                all_text.setText("");

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            String jsonStr = theme.toString().replace("{","{\n").replace(",",",\n").replace("}","\n},\n");

            try {
                JSONArray object = new JSONArray(stringdone);

               // showthemecount.setText(object.length());
                for(int i = 0; i < object.length(); ++i) {
                    JSONObject itemObj = object.getJSONObject(i);
                    Pojo jojo = new Pojo();
                    jojo.setDesc(itemObj.getString("desc"));
                    liste.add(jojo);



                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            final List<Pojo> filterModList = filter(liste, e_link.replace("zhuti.xiaomi.com/detail/", ""));
            if (filterModList.isEmpty()) {
                showText.append(jsonStr);
                showthemecount.setText("Added: "+String.valueOf(i++));
            } else {
                Toast.makeText(add_themes.this, "bu eyyam bar", Toast.LENGTH_SHORT).show();
            }
            return false;
        });

        setBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*
                breee++;
                try {
                    makJsonObject(new int[]{19}, new String[]{"Black Theme"}, new String[]{"2021yyl" + breee}, new String[]{"buda bir zat"}, new String[]{"ertang"}, 1);
                } catch (JSONException | IOException e) {
                    e.printStackTrace();
                }

                 */




                String sdf = all_text.getText().toString();
                String e_link = sdf.substring(sdf.indexOf("theme://") +8).split("';")[0];
                String theme_link = "http://" + e_link;

                String title1 = sdf.substring(sdf.indexOf("<title>") +7).split("-小米主题商店")[0].replace("_3MDS", "").replace("_3MDP", "")
                        .replace("_DWM2", "")
                        .replace("_", " ");
                String design1 = sdf.substring(sdf.indexOf("师：</span>") +9).split(" <br /> <span>制作者")[0];
                String size1 = sdf.substring(sdf.indexOf("小：</span>") +9).split(" <br /> <span>更")[0].replace("KB","");
                double  sizedigital =  Integer.parseInt(size1);
                if (sizedigital >= 1024){
                    sizedigital = sizedigital/1024;
                }


                DecimalFormat form = new DecimalFormat("###.00");
                String sizeDone = form.format(sizedigital);
                String allimages = sdf.substring(sdf.indexOf("<img src=\"") +10).split("\" alt=\"\" />\n" +
                        "                                        <img src=\"https://r")[0];
                String image1 = allimages.split("\" alt=")[0];
                String image2 = allimages.substring(allimages.indexOf("<img src=\"") +10).split("\" alt=")[0];
                String readyforimg3 = allimages.substring(allimages.indexOf("<img src=\"") +10);
                String image3 = readyforimg3.substring(readyforimg3.indexOf("<img src=\"") +10).split("\" alt=")[0];
                String readyforimg4 = readyforimg3.substring(readyforimg3.indexOf("<img src=\"") +10);
                String image4 = readyforimg4.substring(readyforimg4.indexOf("<img src=\"") +10).split("\" alt=")[0];

                String readyforimage5 = readyforimg4.substring(readyforimg3.indexOf("<img src=\"") +10);
                String image5 = readyforimage5.substring(readyforimage5.indexOf("<img src=\"") +10).split("\" alt=")[0];


                if (!image4.startsWith("htt")){
                    image4 = null;
                }
                if (!image5.startsWith("htt")){
                    image5 = null;
                }

                JSONObject theme = new JSONObject();

                try {
                        theme.put("title", title1);
                        theme.put("desc", theme_link);
                        theme.put("image", image2);
                        theme.put("img1", image3);
                        theme.put("img2", image1);
                        if (image4 != null){
                            theme.put("img3", image4);
                        }
                        if (image5 != null){
                            theme.put("img4", image5);
                        }
                        if (design1 != null){
                            theme.put("design", design1);
                        }
                        if (sizedigital != 0){
                            theme.put("theme_size", sizeDone.replace(",",".").replace("/n", ""));
                        }
                        if (whichcolor != null){
                            theme.put("color", whichcolor);
                        }
                        if (wichcaty != null){
                            theme.put("category", wichcaty);
                        }
                        theme.put("date_add", currectDate);
                        all_text.setText("");

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                String jsonStr = theme.toString().replace("{","{\n").replace(",",",\n").replace("}","\n},\n");

                try {
                    JSONArray object = new JSONArray(stringdone);

                    //showthemecount.setText(object.length());
                    for(int i = 0; i < object.length(); ++i) {
                        JSONObject itemObj = object.getJSONObject(i);
                        Pojo jojo = new Pojo();
                        jojo.setDesc(itemObj.getString("desc"));
                        liste.add(jojo);



                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                final List<Pojo> filterModList = filter(liste, e_link.replace("zhuti.xiaomi.com/detail/", ""));
                if (filterModList.isEmpty()) {
                    showText.append(jsonStr);
                    showthemecount.setText("Added: "+String.valueOf(i++));
                } else {
                    Toast.makeText(add_themes.this, "bu eyyam bar", Toast.LENGTH_SHORT).show();
                }

                /*
                JSONArray jsonArray = new JSONArray();
                jsonArray.put(theme);
                String jsonStr = jsonArray.toString();

                try {
                    save(MainActivity.this,jsonStr);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                showText.setText(jsonStr);
                System.out.println("jsonString: "+jsonStr);

                 */


            }
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
    
    
    public void save(Context context, String jsonString) throws IOException {
        File rootFolder = context.getExternalFilesDir(null);
        File jsonFile = new File(rootFolder, "file.json");
        FileWriter writer = new FileWriter(jsonFile);
        writer.write(jsonString);
        writer.close();
        //or IOUtils.closeQuietly(writer);
    }

    public JSONObject makJsonObject(int id[], String name[], String year[],
                                    String curriculum[], String birthday[], int numberof_students)
            throws JSONException, IOException {
        JSONObject obj = null;
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < numberof_students; i++) {
            obj = new JSONObject();
            try {
                obj.put("id", id[i]);
                obj.put("name", name[i]);
                obj.put("year", year[i]);
                obj.put("curriculum", curriculum[i]);
                obj.put("birthday", birthday[i]);

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            jsonArray.put(obj);
        }



        save(add_themes.this, String.valueOf(jsonArray));
        return obj;

    }
}