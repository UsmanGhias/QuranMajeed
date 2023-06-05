package com.example.dbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class search_surahno extends AppCompatActivity {
    public EditText textView;
    public EditText textView2;
    public Button query_btn;
    public TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_surahno);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        query_btn = (Button)findViewById(R.id.query_btn);
        resultText = findViewById(R.id.resultText);

        //ayahs=findViewById(R.id.resultText);


        query_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();

                String an = textView.getText().toString();
                String sn = textView2.getText().toString();
                String arabict = databaseAccess.getAyah(Integer.valueOf(an), Integer.valueOf(sn));

                resultText.setText(arabict);

                databaseAccess.close();
            }
        });

    }
}