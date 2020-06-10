package com.nuces.indoorpilot;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.nuces.indoorpilot.base.AbstractDrawerActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BuildingsActivity extends AbstractDrawerActivity {
    ListView buildings;
    ArrayAdapter<String> adapter;
    EditText inputSearch;
    // ArrayList for Listview
    ArrayList<HashMap<String, String>> productList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buildings=findViewById(R.id.list_buildings);
        inputSearch=findViewById(R.id.inputSearch);



        // Instanciating an array list (you don't need to do this,
        // you already have yours).
        String products[] = {"Fast Nuces","Home", "Nescom", "Centaurus", "Giga Mall", "Nust University",
                "Pims Hospital", "Ufone Tower", "Safa Gold"};
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.product_name, products);
        buildings.setAdapter(adapter);
        buildings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                String selectedFromList = (String) buildings.getItemAtPosition(position);
                if (selectedFromList == "Fast Nuces" ){
                    Toast.makeText(getApplicationContext(), "Loading "+selectedFromList+ " map. Please wait...", Toast.LENGTH_LONG).show();
                }
                else if(selectedFromList == "Home"){
                    Toast.makeText(getApplicationContext(), "Loading "+selectedFromList+ " map. Please wait...", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(BuildingsActivity.this,MapActivity.class);
                    startActivity(intent);
                }
                else if(selectedFromList == "Nescom"){
                    Toast.makeText(getApplicationContext(), "Loading "+selectedFromList+ " map. Please wait...", Toast.LENGTH_LONG).show();
                }
                else if(selectedFromList == "Centaurus"){
                    Toast.makeText(getApplicationContext(), "Loading "+selectedFromList+ " map. Please wait...", Toast.LENGTH_LONG).show();
                }
                else if(selectedFromList == "Giga Mall"){
                    Toast.makeText(getApplicationContext(), "Loading "+selectedFromList+ " map. Please wait...", Toast.LENGTH_LONG).show();
                }
                else if(selectedFromList == "Nust University"){
                    Toast.makeText(getApplicationContext(), "Loading "+selectedFromList+ " map. Please wait...", Toast.LENGTH_LONG).show();
                }
                else if(selectedFromList == "Pims Hospital"){
                    Toast.makeText(getApplicationContext(), "Loading "+selectedFromList+ " map. Please wait...", Toast.LENGTH_LONG).show();
                }
                else if(selectedFromList == "Ufone Tower"){
                    Toast.makeText(getApplicationContext(), "Loading "+selectedFromList+ " map. Please wait...", Toast.LENGTH_LONG).show();
                }
                else if(selectedFromList == "Safa Gold"){
                    Toast.makeText(getApplicationContext(), "Loading "+selectedFromList+ " map. Please wait...", Toast.LENGTH_LONG).show();
                }
            }
        });
        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                BuildingsActivity.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });
    }
/*
    // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                your_array_list );

        buildings.setAdapter(arrayAdapter);

        buildings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                String selectedFromList = (String) buildings.getItemAtPosition(position);
                if (selectedFromList == "Fast Nuces" ){
                    Toast.makeText(getApplicationContext(), "Loading "+selectedFromList+ " map. Please wait...", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(BuildingsActivity.this,MapActivity.class);
                    startActivity(intent);
                }
                else if(selectedFromList == "Nescom"){
                    Toast.makeText(getApplicationContext(), "Loading "+selectedFromList+ " map. Please wait...", Toast.LENGTH_LONG).show();
                }
                else if(selectedFromList == "Centaurus"){
                    Toast.makeText(getApplicationContext(), "Loading "+selectedFromList+ " map. Please wait...", Toast.LENGTH_LONG).show();
                }
                else if(selectedFromList == "Giga Mall"){
                    Toast.makeText(getApplicationContext(), "Loading "+selectedFromList+ " map. Please wait...", Toast.LENGTH_LONG).show();
                }
                else if(selectedFromList == "Nust University"){
                    Toast.makeText(getApplicationContext(), "Loading "+selectedFromList+ " map. Please wait...", Toast.LENGTH_LONG).show();
                }
                else if(selectedFromList == "Pims Hospital"){
                    Toast.makeText(getApplicationContext(), "Loading "+selectedFromList+ " map. Please wait...", Toast.LENGTH_LONG).show();
                }
                else if(selectedFromList == "Ufone Tower"){
                    Toast.makeText(getApplicationContext(), "Loading "+selectedFromList+ " map. Please wait...", Toast.LENGTH_LONG).show();
                }
                else if(selectedFromList == "Safa Gold"){
                    Toast.makeText(getApplicationContext(), "Loading "+selectedFromList+ " map. Please wait...", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

*/

    @Override
    public int getLayoutId() {
        return R.layout.activity_buildings;
    }

    @Override
    public String getCustomTitle() {
        return "Buildings";
    }
}