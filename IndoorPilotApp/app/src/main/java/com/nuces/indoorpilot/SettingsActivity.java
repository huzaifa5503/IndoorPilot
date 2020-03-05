package com.nuces.indoorpilot;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.nuces.indoorpilot.base.AbstractDrawerActivity;

public class SettingsActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_settings);
        addPreferencesFromResource(R.layout.activity_settings);
    }
    @Override
    public void onBackPressed() {
        Intent back=new Intent(SettingsActivity.this,HomeActivity.class);
        startActivity(back);
    }

}
