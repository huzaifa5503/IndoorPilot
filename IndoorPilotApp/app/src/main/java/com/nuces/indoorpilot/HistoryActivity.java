package com.nuces.indoorpilot;

import android.os.Bundle;

import com.nuces.indoorpilot.base.AbstractDrawerActivity;

public class HistoryActivity extends AbstractDrawerActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public String getCustomTitle() {
        return "Home";
    }
}
