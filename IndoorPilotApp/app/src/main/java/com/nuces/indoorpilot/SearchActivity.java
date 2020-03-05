package com.nuces.indoorpilot;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.nuces.indoorpilot.base.AbstractDrawerActivity;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AbstractDrawerActivity {
    ListView buildings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buildings=findViewById(R.id.list_buildings_search);
        // Instanciating an array list (you don't need to do this,
        // you already have yours).
        List<String> your_array_list = new ArrayList<String>();
        your_array_list.add("Fast Nuces");
        your_array_list.add("Nescom");
        your_array_list.add("Centaurus");
        your_array_list.add("Giga Mall");
        your_array_list.add("Nust University");
        your_array_list.add("Pims Hospital");
        your_array_list.add("Ufone Tower");
        your_array_list.add("Safa Gold");

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                your_array_list );

        buildings.setAdapter(arrayAdapter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public String getCustomTitle() {
        return "Search for buildings";
    }
}
