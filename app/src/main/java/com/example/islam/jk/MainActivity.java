package com.example.islam.jk;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.islam.jk.Main_Fragments.Fragment_1;
import com.example.islam.jk.Main_Fragments.Fragment_2;
import com.example.islam.jk.Main_Fragments.Fragment_3;
import com.example.islam.jk.Main_Fragments.Fragment_4;
import com.example.islam.jk.Main_Fragments.Fragment_5;
import com.example.islam.jk.Main_Fragments.Fragment_6;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Fragment_1 fragment_1 = new Fragment_1();
    Fragment_2 fragment_2 = new Fragment_2();
    Fragment_3 fragment_3 = new Fragment_3();
    Fragment_4 fragment_4 = new Fragment_4();
    Fragment_5 fragment_5 = new Fragment_5();
    Fragment_6 fragment_6 = new Fragment_6();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_main) {
            // Handle the camera action
            FTReplace(fragment_1);
        } else if (id == R.id.nav_lc) {
            FTReplace(fragment_2);
        } else if (id == R.id.nav_news) {
            FTReplace(fragment_3);
        } else if (id == R.id.nav_uslugi) {
            FTReplace(fragment_4);
        } else if (id == R.id.nav_settings) {
            FTReplace(fragment_5);
        } else if (id == R.id.nav_aboutapp) {
            FTReplace(fragment_6);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
    public void FTReplace(Fragment fragment){
        android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.container,fragment);
        ft.commit();
    }
}
