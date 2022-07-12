package com.thegosa.jsonwriterdev;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.content.ClipDescription.MIMETYPE_TEXT_PLAIN;

public class add_wallpapers_wallcraft extends AppCompatActivity {

    TextView showText;
    String stringdone, whichcolor, wichcaty;
    List<Pojo> liste = new ArrayList<>();
    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button setBtn = findViewById(R.id.button);
        showText = findViewById(R.id.textView);

        EditText all_text = findViewById(R.id.dssd);
        RadioGroup rb =  findViewById(R.id.radios);
        RadioGroup catyRadio = findViewById(R.id.radioscaty);

/*
        all_text.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ClipboardManager clipboard = (ClipboardManager)
                        getSystemService(Context.CLIPBOARD_SERVICE);

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
                    all_text.setText(pasteData);

                }

                return false;
            }
        });


 */


        Calendar cal = Calendar.getInstance();
        String currectDate = String.valueOf(cal.get(Calendar.DAY_OF_YEAR));


        rb.setVisibility(View.GONE);
        catyRadio.setVisibility(View.GONE);

        String HI = "https://raw.githubusercontent.com/thegosa/theme_data/master/miui_themes_data/wall_for_miui.json";
        StringRequest stringRequest = new StringRequest(HI, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                stringdone = response;
                setBtn.setVisibility(View.VISIBLE);
            }
        }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


        setBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String all_textToString = all_text.getText().toString();
                String wall1 = all_textToString.substring(all_textToString.indexOf("__image\" src=\"") + 14);
                String wall_1 = wall1.split("\" alt")[0].replace("300x300", "2780x2780");
                String wall2 = wall1.substring(wall1.indexOf("__image\" src=\"") + 14);
                String wall_2 = wall2.split("\" alt")[0].replace("300x300", "2780x2780");
                String wall3 = wall2.substring(wall2.indexOf("__image\" src=\"") + 14);
                String wall_3 = wall3.split("\" alt")[0].replace("300x300", "2780x2780");
                String wall4 = wall3.substring(wall3.indexOf("__image\" src=\"") + 14);
                String wall_4 = wall4.split("\" alt")[0].replace("300x300", "2780x2780");

                String wall5 = wall4.substring(wall4.indexOf("__image\" src=\"") + 14);
                String wall_5 = wall5.split("\" alt")[0].replace("300x300", "2780x2780");
                String wall6 = wall5.substring(wall5.indexOf("__image\" src=\"") + 14);
                String wall_6 = wall6.split("\" alt")[0].replace("300x300", "2780x2780");
                String wall7 = wall6.substring(wall6.indexOf("__image\" src=\"") + 14);
                String wall_7 = wall7.split("\" alt")[0].replace("300x300", "2780x2780");

                String wall8 = wall7.substring(wall7.indexOf("__image\" src=\"") + 14);
                String wall_8 = wall8.split("\" alt")[0].replace("300x300", "2780x2780");
                String wall9 = wall8.substring(wall8.indexOf("__image\" src=\"") + 14);
                String wall_9 = wall9.split("\" alt")[0].replace("300x300", "2780x2780");
                String wall10 = wall9.substring(wall9.indexOf("__image\" src=\"") + 14);
                String wall_10 = wall10.split("\" alt")[0].replace("300x300", "2780x2780");

                String wall11 = wall10.substring(wall10.indexOf("__image\" src=\"") + 14);
                String wall_11 = wall11.split("\" alt")[0].replace("300x300", "2780x2780");
                String wall12 = wall11.substring(wall11.indexOf("__image\" src=\"") + 14);
                String wall_12 = wall12.split("\" alt")[0].replace("300x300", "2780x2780");
                String wall13 = wall12.substring(wall12.indexOf("__image\" src=\"") + 14);
                String wall_13 = wall13.split("\" alt")[0].replace("300x300", "2780x2780");

                String wall14 = wall13.substring(wall13.indexOf("__image\" src=\"") + 14);
                String wall_14 = wall14.split("\" alt")[0].replace("300x300", "2780x2780");
                String wall15 = wall14.substring(wall14.indexOf("__image\" src=\"") + 14);
                String wall_15 = wall15.split("\" alt")[0].replace("300x300", "2780x2780");



                JSONObject wall01 = new JSONObject();

                try {
                    wall01.put("image", wall_1);
                    wall01.put("date_add", currectDate);
                        all_text.setText("");

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                JSONObject wall02 = new JSONObject();

                try {
                    wall02.put("image", wall_2);
                    wall02.put("date_add", currectDate);
                    all_text.setText("");

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                JSONObject wall03 = new JSONObject();

                try {
                    wall03.put("image", wall_3);
                    wall03.put("date_add", currectDate);
                    all_text.setText("");

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                JSONObject wall04 = new JSONObject();

                try {
                    wall04.put("image", wall_4);
                    wall04.put("date_add", currectDate);
                    all_text.setText("");

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                JSONObject wall05 = new JSONObject();

                try {
                    wall05.put("image", wall_5);
                    wall05.put("date_add", currectDate);
                    all_text.setText("");

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                JSONObject wall06 = new JSONObject();

                try {
                    wall06.put("image", wall_6);
                    wall06.put("date_add", currectDate);
                    all_text.setText("");

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                JSONObject wall07 = new JSONObject();

                try {
                    wall07.put("image", wall_7);
                    wall07.put("date_add", currectDate);
                    all_text.setText("");

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                JSONObject wall08 = new JSONObject();

                try {
                    wall08.put("image", wall_8);
                    wall08.put("date_add", currectDate);
                    all_text.setText("");

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                JSONObject wall09 = new JSONObject();

                try {
                    wall09.put("image", wall_9);
                    wall09.put("date_add", currectDate);
                    all_text.setText("");

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                JSONObject wall010 = new JSONObject();

                try {
                    wall010.put("image", wall_10);
                    wall010.put("date_add", currectDate);
                    all_text.setText("");

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                JSONObject wall011 = new JSONObject();

                try {
                    wall011.put("image", wall_11);
                    wall011.put("date_add", currectDate);
                    all_text.setText("");

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                JSONObject wall012 = new JSONObject();

                try {
                    wall012.put("image", wall_12);
                    wall012.put("date_add", currectDate);
                    all_text.setText("");

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                JSONObject wall013 = new JSONObject();

                try {
                    wall013.put("image", wall_13);
                    wall013.put("date_add", currectDate);
                    all_text.setText("");

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                JSONObject wall014 = new JSONObject();

                try {
                    wall014.put("image", wall_14);
                    wall014.put("date_add", currectDate);
                    all_text.setText("");

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                JSONObject wall015 = new JSONObject();

                try {
                    wall015.put("image", wall_15);
                    wall015.put("date_add", currectDate);
                    all_text.setText("");

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }





                String jsonStr = wall01.toString().replace("{","{\n").replace(",",",\n").replace("}","\n},\n") +
                        wall02.toString().replace("{","\n{\n").replace(",",",\n").replace("}","\n},\n") +
                        wall03.toString().replace("{","\n{\n").replace(",",",\n").replace("}","\n},\n") +
                        wall04.toString().replace("{","\n{\n").replace(",",",\n").replace("}","\n},\n") +
                        wall05.toString().replace("{","\n{\n").replace(",",",\n").replace("}","\n},\n") +
                        wall06.toString().replace("{","\n{\n").replace(",",",\n").replace("}","\n},\n") +
                        wall07.toString().replace("{","\n{\n").replace(",",",\n").replace("}","\n},\n") +
                        wall08.toString().replace("{","\n{\n").replace(",",",\n").replace("}","\n},\n") +
                        wall09.toString().replace("{","\n{\n").replace(",",",\n").replace("}","\n},\n") +
                        wall010.toString().replace("{","\n{\n").replace(",",",\n").replace("}","\n},\n") +
                        wall011.toString().replace("{","\n{\n").replace(",",",\n").replace("}","\n},\n") +
                        wall012.toString().replace("{","\n{\n").replace(",",",\n").replace("}","\n},\n") +
                        wall013.toString().replace("{","\n{\n").replace(",",",\n").replace("}","\n},\n") +
                        wall014.toString().replace("{","\n{\n").replace(",",",\n").replace("}","\n},\n") +
                        wall015.toString().replace("{","\n{\n").replace(",",",\n").replace("}","\n},\n");


                        showText.append(jsonStr);

                /*
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
                final List<Pojo> filterModList = filter(liste, all_text.getText().toString());
                if (filterModList.isEmpty()) {
                    showText.append(jsonStr);

                } else {
                    Toast.makeText(add_wallpapers.this, "bu eyyam bar", Toast.LENGTH_SHORT).show();
                }

                 */


            }
        });

        all_text.setOnEditorActionListener((v, actionId, event) -> {

            String all_textToString = all_text.getText().toString();
            String wall1 = all_textToString.substring(all_textToString.indexOf("__image\" src=\"") + 14);
            String wall_1 = wall1.split("\" alt")[0].replace("300x300", "2780x2780");
            String wall2 = wall1.substring(wall1.indexOf("__image\" src=\"") + 14);
            String wall_2 = wall2.split("\" alt")[0].replace("300x300", "2780x2780");
            String wall3 = wall2.substring(wall2.indexOf("__image\" src=\"") + 14);
            String wall_3 = wall3.split("\" alt")[0].replace("300x300", "2780x2780");
            String wall4 = wall3.substring(wall3.indexOf("__image\" src=\"") + 14);
            String wall_4 = wall4.split("\" alt")[0].replace("300x300", "2780x2780");

            String wall5 = wall4.substring(wall4.indexOf("__image\" src=\"") + 14);
            String wall_5 = wall5.split("\" alt")[0].replace("300x300", "2780x2780");
            String wall6 = wall5.substring(wall5.indexOf("__image\" src=\"") + 14);
            String wall_6 = wall6.split("\" alt")[0].replace("300x300", "2780x2780");
            String wall7 = wall6.substring(wall6.indexOf("__image\" src=\"") + 14);
            String wall_7 = wall7.split("\" alt")[0].replace("300x300", "2780x2780");

            String wall8 = wall7.substring(wall7.indexOf("__image\" src=\"") + 14);
            String wall_8 = wall8.split("\" alt")[0].replace("300x300", "2780x2780");
            String wall9 = wall8.substring(wall8.indexOf("__image\" src=\"") + 14);
            String wall_9 = wall9.split("\" alt")[0].replace("300x300", "2780x2780");
            String wall10 = wall9.substring(wall9.indexOf("__image\" src=\"") + 14);
            String wall_10 = wall10.split("\" alt")[0].replace("300x300", "2780x2780");

            String wall11 = wall10.substring(wall10.indexOf("__image\" src=\"") + 14);
            String wall_11 = wall11.split("\" alt")[0].replace("300x300", "2780x2780");
            String wall12 = wall11.substring(wall11.indexOf("__image\" src=\"") + 14);
            String wall_12 = wall12.split("\" alt")[0].replace("300x300", "2780x2780");
            String wall13 = wall12.substring(wall12.indexOf("__image\" src=\"") + 14);
            String wall_13 = wall13.split("\" alt")[0].replace("300x300", "2780x2780");

            String wall14 = wall13.substring(wall13.indexOf("__image\" src=\"") + 14);
            String wall_14 = wall14.split("\" alt")[0].replace("300x300", "2780x2780");
            String wall15 = wall14.substring(wall14.indexOf("__image\" src=\"") + 14);
            String wall_15 = wall15.split("\" alt")[0].replace("300x300", "2780x2780");



            JSONObject wall01 = new JSONObject();

            try {
                wall01.put("image", wall_1);
                wall01.put("date_add", currectDate);
                all_text.setText("");

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            JSONObject wall02 = new JSONObject();

            try {
                wall02.put("image", wall_2);
                wall02.put("date_add", currectDate);
                all_text.setText("");

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            JSONObject wall03 = new JSONObject();

            try {
                wall03.put("image", wall_3);
                wall03.put("date_add", currectDate);
                all_text.setText("");

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            JSONObject wall04 = new JSONObject();

            try {
                wall04.put("image", wall_4);
                wall04.put("date_add", currectDate);
                all_text.setText("");

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            JSONObject wall05 = new JSONObject();

            try {
                wall05.put("image", wall_5);
                wall05.put("date_add", currectDate);
                all_text.setText("");

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            JSONObject wall06 = new JSONObject();

            try {
                wall06.put("image", wall_6);
                wall06.put("date_add", currectDate);
                all_text.setText("");

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            JSONObject wall07 = new JSONObject();

            try {
                wall07.put("image", wall_7);
                wall07.put("date_add", currectDate);
                all_text.setText("");

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            JSONObject wall08 = new JSONObject();

            try {
                wall08.put("image", wall_8);
                wall08.put("date_add", currectDate);
                all_text.setText("");

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            JSONObject wall09 = new JSONObject();

            try {
                wall09.put("image", wall_9);
                wall09.put("date_add", currectDate);
                all_text.setText("");

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            JSONObject wall010 = new JSONObject();

            try {
                wall010.put("image", wall_10);
                wall010.put("date_add", currectDate);
                all_text.setText("");

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            JSONObject wall011 = new JSONObject();

            try {
                wall011.put("image", wall_11);
                wall011.put("date_add", currectDate);
                all_text.setText("");

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            JSONObject wall012 = new JSONObject();

            try {
                wall012.put("image", wall_12);
                wall012.put("date_add", currectDate);
                all_text.setText("");

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            JSONObject wall013 = new JSONObject();

            try {
                wall013.put("image", wall_13);
                wall013.put("date_add", currectDate);
                all_text.setText("");

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            JSONObject wall014 = new JSONObject();

            try {
                wall014.put("image", wall_14);
                wall014.put("date_add", currectDate);
                all_text.setText("");

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            JSONObject wall015 = new JSONObject();

            try {
                wall015.put("image", wall_15);
                wall015.put("date_add", currectDate);
                all_text.setText("");

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }





            String jsonStr = wall01.toString().replace("{","{\n").replace(",",",\n").replace("}","\n},\n") +
                    wall02.toString().replace("{","\n{\n").replace(",",",\n").replace("}","\n},\n") +
                    wall03.toString().replace("{","\n{\n").replace(",",",\n").replace("}","\n},\n") +
                    wall04.toString().replace("{","\n{\n").replace(",",",\n").replace("}","\n},\n") +
                    wall05.toString().replace("{","\n{\n").replace(",",",\n").replace("}","\n},\n") +
                    wall06.toString().replace("{","\n{\n").replace(",",",\n").replace("}","\n},\n") +
                    wall07.toString().replace("{","\n{\n").replace(",",",\n").replace("}","\n},\n") +
                    wall08.toString().replace("{","\n{\n").replace(",",",\n").replace("}","\n},\n") +
                    wall09.toString().replace("{","\n{\n").replace(",",",\n").replace("}","\n},\n") +
                    wall010.toString().replace("{","\n{\n").replace(",",",\n").replace("}","\n},\n") +
                    wall011.toString().replace("{","\n{\n").replace(",",",\n").replace("}","\n},\n") +
                    wall012.toString().replace("{","\n{\n").replace(",",",\n").replace("}","\n},\n") +
                    wall013.toString().replace("{","\n{\n").replace(",",",\n").replace("}","\n},\n") +
                    wall014.toString().replace("{","\n{\n").replace(",",",\n").replace("}","\n},\n") +
                    wall015.toString().replace("{","\n{\n").replace(",",",\n").replace("}","\n},\n");


            showText.append(jsonStr);

            return false;
        });
    }

    private List<Pojo>filter(List<Pojo>hi,String query){
        query=query.toLowerCase();
        final List<Pojo>filterModeList=new ArrayList<>();
        for (Pojo modal:hi){
            final String text=modal.getImage();


            if (text.contains(query)){
                filterModeList.add(modal);
            }
        }
        return filterModeList;
    }
    
    
    public void save(Context context, String jsonString) throws IOException {
        File rootFolder = context.getExternalFilesDir(null);
        File jsonFile = new File(rootFolder, "file.json");
        FileWriter writer = new FileWriter(jsonFile, true);
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



        save(add_wallpapers_wallcraft.this, String.valueOf(jsonArray));
        return obj;

    }
}