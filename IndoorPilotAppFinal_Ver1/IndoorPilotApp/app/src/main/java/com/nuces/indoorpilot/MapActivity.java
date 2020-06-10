package com.nuces.indoorpilot;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import android.widget.TextView;
import android.widget.Toast;

public class MapActivity extends AppCompatActivity {
    GridView gridview;
    int gridsize;
    Button search;
    EditText searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        gridview = (GridView) findViewById(R.id.Gridview1);
        search=(Button) findViewById(R.id.button_search);
        searchText=(EditText)findViewById(R.id.search_text); //search for room/person string
        gridview.setColumnWidth(300);
        gridview.setClickable(true);

        gridsize =  readIndoorData();

        //Log.d("size", "arraysize: "+ gridsize);
        gridview.setAdapter(new TextAdapter(this, gridsize));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the GridView selected/clicked item text
                String selectedItem = parent.getItemAtPosition(position).toString();

                // Display the selected/clicked item text and position on TextView
                Toast.makeText(getApplicationContext(), "GridView item clicked : " +selectedItem
                        + "\nAt index position : " + position, Toast.LENGTH_SHORT).show();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                if (searchText.getText().toString()!=""){
                    Toast.makeText(getApplicationContext(), "Searching...", Toast.LENGTH_SHORT).show();
                    Globals searchVar=Globals.getInstance();
                    searchVar.setVarSearch(searchText.getText().toString());
                    Toast.makeText(getApplicationContext(), "Searching...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MapActivity.this,MapActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Nothing entered! ", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }

    public int readIndoorData() {

        InputStream is = getResources().openRawResource(R.raw.fast_building);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );

        String line = "";
        int rows = 0;
        String[] tokens = {""};
        try {
            while ((line = reader.readLine()) != null) {
                tokens = line.split(",");
                rows++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Log.d("TAG", "rowcount: " + rows);
        //Log.d("TAG", "colcount: " + tokens.length);

        gridsize = rows * tokens.length;
        //Log.d("TAG", "Gridsize: " + gridsize);
        return gridsize;
    }
}





