package com.example.hp.mediminder;


import android.content.Intent;
import android.icu.util.Calendar;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity



        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createReminder();
            }
        });

        ImageButton button1 = (ImageButton) findViewById(R.id.add);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ReminderEditActivity.class);
                startActivity(intent);
            }

        });

        ImageButton button2 = (ImageButton) findViewById(R.id.list);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ReminderListActivity2.class);
                startActivity(intent);
            }

        });


        ImageButton button3 = (ImageButton) findViewById(R.id.cal);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, calender.class);
                startActivity(intent);
            }

        });

        ImageButton button4 = (ImageButton) findViewById(R.id.set);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, TaskPreferences.class);
                startActivity(i);
            }

        });
        ImageButton button5 = (ImageButton) findViewById(R.id.exit);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
                System.exit(0);
            }

        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.menu_settings) {
            Intent i = new Intent(this, TaskPreferences.class);
            startActivity(i);
            return  true;

        }
        if (id == R.id .menu_insert)
        {
            createReminder();
            return true;
        }
        if (id == R.id.menu_exit)
        {
            finish();
            System.exit(0);
        }


        return super.onOptionsItemSelected(item);
    }

    private void createReminder() {
        Intent i = new Intent(this, ReminderEditActivity.class);
       /* startActivityForResult(i, ACTIVITY_CREATE);*/
        startActivity(i);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.add) {
           createReminder();
            return true;
        } else if (id == R.id.list) {
            Intent intent = new Intent(MainActivity.this, ReminderListActivity2.class);
            startActivity(intent);

        } else if (id == R.id.cal) {
            Intent intent = new Intent(MainActivity.this, calender.class);
            startActivity(intent);

        } else if (id == R.id.set) {
            Intent intent = new Intent(MainActivity.this, TaskPreferences.class);
            startActivity(intent);

        }
        else if (id == R.id.exit)
        {
            finish();
            System.exit(0);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
