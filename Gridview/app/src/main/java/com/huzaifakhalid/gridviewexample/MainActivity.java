package com.huzaifakhalid.gridviewexample;


import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    GridView gridview;
    TextView tv1;
    int gridsize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridview = (GridView) findViewById(R.id.Gridview1);
        gridview.setColumnWidth(300);

        gridsize =  readIndoorData();

        Log.d("size", "arraysize: "+ gridsize);
        gridview.setAdapter(new TextAdapter(this, gridsize));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String desc="";

                switch (position) {
                    case 0:
                        Toast.makeText(getApplicationContext(), desc , Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(), "Second item clicked" , Toast.LENGTH_SHORT).show();
                        break;

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
        Log.d("TAG", "rowcount: " + rows);
        Log.d("TAG", "colcount: " + tokens.length);

        gridsize = rows * tokens.length;
        Log.d("TAG", "Gridsize: " + gridsize);
        return gridsize;
    }
}





