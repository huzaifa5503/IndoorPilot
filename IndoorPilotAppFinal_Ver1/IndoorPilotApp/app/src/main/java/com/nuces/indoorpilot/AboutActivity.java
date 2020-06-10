package com.nuces.indoorpilot;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import android.view.Gravity;
import android.view.View;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class AboutActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        simulateDayNight(/* DAY */ 0);


        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.icon)
                .setCustomFont("fonts/extravaganzza.ttf")
                .setDescription("IndoorPilot is an Indoor Navigation System using which you can navigate through buildings easily. It allows you to search for rooms, people, shops and more. Never get lost inside a building ever again :)")
                .addItem(new Element().setTitle("Version 1.0"))
                .addGroup("Connect with us")
                .addEmail("i160252@nu.edu.pk")
                .addWebsite("http://nu.edu.pk/")
                .addFacebook("aleem.malik.7503")
                .addTwitter("fast_nuces")
                .addYoutube("UCGV2HQKLRVo9OTiothZOyWw")
                .addPlayStore("com.king.candycrushsaga")
                .addInstagram("fast_nuces")
                .addItem(getCopyRightsElement())
                .create();

        setContentView(aboutPage);
    }
    @Override
    public void onBackPressed() {
        Intent back=new Intent(AboutActivity.this,HomeActivity.class);
        startActivity(back);
    }


    Element getCopyRightsElement() {
        Element copyRightsElement = new Element();
        final String copyrights = getString(R.string.copy_right);
        copyRightsElement.setTitle(copyrights);
        copyRightsElement.setIconDrawable(R.drawable.ic_copyright);
        copyRightsElement.setIconNightTint(android.R.color.white);
        copyRightsElement.setGravity(Gravity.CENTER);
        copyRightsElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutActivity.this, R.string.app_name, Toast.LENGTH_SHORT).show();
            }
        });
        return copyRightsElement;
    }

    void simulateDayNight(int currentSetting) {
        currentSetting=1;
        final int DAY = 0;
        final int NIGHT = 1;
        final int FOLLOW_SYSTEM = 3;

        int currentNightMode = getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK;
        if (currentSetting == DAY && currentNightMode != Configuration.UI_MODE_NIGHT_NO) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
        } else if (currentSetting == NIGHT && currentNightMode != Configuration.UI_MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES);
        } else if (currentSetting == FOLLOW_SYSTEM) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        }
    }
}