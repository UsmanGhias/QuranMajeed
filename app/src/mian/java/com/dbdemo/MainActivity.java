package com.example.dbdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import com.google.android.material.navigation.NavigationView;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.core.view.GravityCompat;

public class MainActivity extends AppCompatActivity{
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(getApplicationContext(),"Start",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"End",Toast.LENGTH_LONG).show();
        }
    }
    TextView text;
    Button surah_names;
    Button para_names;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.nav_drawer);
        drawerLayout= findViewById(R.id.drawer);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.all_surah :

                        //Intent intent = new Intent(MainActivity.this, BookActivity.class);
                        //startActivity(intent);
                        //drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent=new Intent(MainActivity.this, Surah_List.class);
                        startActivity(intent);
                        break;

                    case R.id.all_parah:

                        //drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent1=new Intent(MainActivity.this, Parah_List.class);
                        startActivity(intent1);
                        break;

                    case R.id.search_surah:

//                       // drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent2=new Intent(MainActivity.this, search_surahno.class);
                        startActivity(intent2);
                        break;




                }

                return true;
            }
        });

       /*txt=findViewById(R.id.txt);
        DatabaseAccess databaseAccess=DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        String translation=databaseAccess.getTranslation(1);
        txt.setText(translation);*/





    }



}