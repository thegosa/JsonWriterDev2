package com.thegosa.jsonwriterdev;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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

import static android.content.ClipDescription.MIMETYPE_TEXT_PLAIN;

public class add_wallpapers extends AppCompatActivity {

    TextView showText;
    String stringdone, whichcolor, wichcaty;
    List<Pojo> liste = new ArrayList<>();
    boolean makeit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button setBtn = findViewById(R.id.button);
        showText = findViewById(R.id.textView);

        EditText all_text = findViewById(R.id.dssd);
        RadioGroup rb =  findViewById(R.id.radios);
        RadioGroup catyRadio = findViewById(R.id.radioscaty);



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
        Calendar cal = Calendar.getInstance();
        String currectDate = String.valueOf(cal.get(Calendar.DAY_OF_YEAR));


        all_text.setOnClickListener(v34 ->{
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
                makeit = true;

            }
            if (makeit) {
                JSONObject theme = new JSONObject();

                try {
                    theme.put("image", all_text.getText());
                    theme.put("date_add", currectDate);
                    all_text.setText("");

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                String jsonStr = theme.toString().replace("{", "{\n").replace(",", ",\n").replace("}", "\n},\n");
                showText.append(jsonStr);
                try {
                    save(add_wallpapers.this, jsonStr);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                makeit = false;
            }
        });
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
                    makeit = true;

                }
                if (makeit) {
                    JSONObject theme = new JSONObject();

                    try {
                        theme.put("image", all_text.getText());
                        theme.put("date_add", currectDate);
                        all_text.setText("");

                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    String jsonStr = theme.toString().replace("{", "{\n").replace(",", ",\n").replace("}", "\n},\n");
                    showText.append(jsonStr);
                    try {
                        save(add_wallpapers.this, jsonStr);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    makeit = false;
                }
                return false;
            }
        });


        /*
        setBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                JSONObject theme = new JSONObject();

                try {
                        theme.put("image", all_text.getText());
                        theme.put("date_add", currectDate);
                        all_text.setText("");

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                String jsonStr = theme.toString().replace("{","{\n").replace(",",",\n").replace("}","\n},\n");
                showText.append(jsonStr);
                try {
                    save(add_wallpapers.this, jsonStr);
                } catch (IOException e) {
                    e.printStackTrace();
                }
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




            }
        });*/
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



        save(add_wallpapers.this, String.valueOf(jsonArray));
        return obj;

    }
}