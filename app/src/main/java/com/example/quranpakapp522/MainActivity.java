package com.example.quranpakapp522;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView SurahListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        SurahListView= findViewById(R.id.surahListView);


        QuranArabicText QAT = new QuranArabicText();
        QDH QDHObject = new QDH();
        String [] UrduSurahNames = QDHObject.urduSurahNames;

        ArrayList<String> QATArrayList= new ArrayList<String>();

        //Array Adapter
       ArrayAdapter<String> arrayAdapter =  new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,QATArrayList);




       //Populating the Array
        for (int i = 0; i < UrduSurahNames.length; i++) {
            QATArrayList.add(i+1 + "-\t\t\t\t" + QDHObject.englishSurahNames[i] + "\t\t\t\t"  + UrduSurahNames[i]);

        }

        //Setting the array adapter
        SurahListView.setAdapter(arrayAdapter);


        //Click Event Listener
        SurahListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent I = new Intent(MainActivity.this,SurahPage.class);
                I.putExtra("surahIndex", i);
                startActivity(I);
            }
        });


    }
}