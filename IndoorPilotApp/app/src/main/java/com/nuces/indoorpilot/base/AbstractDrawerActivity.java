package com.nuces.indoorpilot.base;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.nuces.indoorpilot.AboutActivity;
import com.nuces.indoorpilot.BuildingsActivity;
import com.nuces.indoorpilot.HomeActivity;
import com.nuces.indoorpilot.LoginActivity;
import com.nuces.indoorpilot.MapsActivity;
import com.nuces.indoorpilot.R;
import com.nuces.indoorpilot.SearchActivity;
import com.nuces.indoorpilot.SettingsActivity;

public abstract class AbstractDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    protected NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getCustomTitle());
        FrameLayout frameLayout = (FrameLayout)findViewById(R.id.main_content);
        getLayoutInflater().inflate(getLayoutId(), frameLayout);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public abstract int getLayoutId();

    public abstract String getCustomTitle();

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id==R.id.nav_home){
            launchActivity(HomeActivity.class);
        }
        else if(id==R.id.nav_about){
            launchActivity(AboutActivity.class);
        }
        else if(id==R.id.nav_search){
            launchActivity(SearchActivity.class);
        }
        else if(id==R.id.nav_buildings){
            launchActivity(BuildingsActivity.class);
        }
        else if(id==R.id.nav_adminLogin){
            launchActivity(LoginActivity.class);
        }
        else if(id==R.id.nav_settings){
            launchActivity(SettingsActivity.class);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void launchActivity(Class _class) {
        //Avoid launch the same activity
        if (this.getClass() != _class) {
            startActivity(makePageIntent(_class));
            overridePendingTransition(0,0);
            finish();
        }
    }

    public Intent makePageIntent(Class _class) {
        Intent intent = new Intent(this, _class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }
}
