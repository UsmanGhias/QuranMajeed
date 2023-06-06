package com.example.quranpakapp522;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SurahPage extends AppCompatActivity {

    TextView AyatsView;
    TextView SurahName;
    Button Search, Cancel;
    EditText edx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_page);
        AyatsView = findViewById(R.id.textView2);
        SurahName = findViewById(R.id.SurahName);
        Search = findViewById(R.id.button);
        edx = findViewById(R.id.editTextNumber);
        Cancel = findViewById(R.id.button3);


        AyatsView.setText("");
        Intent I = getIntent();

        try {
            QDH QDHObject = new QDH();
            QuranArabicText Arabic = new QuranArabicText();
            I.getStringExtra("surahIndex");
            int surahIndex = I.getIntExtra("surahIndex", -1);
            if(surahIndex==-1)
                throw new Exception();


            SurahName.setText(QDHObject.urduSurahNames[surahIndex]);
            String[] Ayat = Arabic.GetData(QDHObject.getSurahStart(surahIndex)-1,QDHObject.getSurahStart(surahIndex)+ QDHObject.getSurahVerses(surahIndex));
            String tmp = "";

            for (int i = 0; i <Ayat.length; i++) {
                tmp+=Ayat[i];
            }

            AyatsView.setText(tmp);



            Cancel.setOnClickListener(new View.OnClickListener() {
                String tmp = "";
                @Override
                public void onClick(View view) {
                    for (int i = 0; i <Ayat.length; i++) {
                        tmp+=Ayat[i];
                        edx.setText("");
                    }

                    AyatsView.setText(tmp);
                }
            });
            Search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {


                        int count = Integer.parseInt(edx.getText().toString());

                        if (count == 0) return;
                        if(count>QDHObject.getSurahVerses(surahIndex)) return;

                        AyatsView.setText(Arabic.QuranArabicText[QDHObject.SSP[surahIndex] + count - 1]);
                    }
                    catch (Exception E)
                    {
                        Toast.makeText(SurahPage.this, "Please Enter Something", Toast.LENGTH_LONG).show();
                        return;
                    }
                }
            });

        }

        catch (Exception E)
        {
            Toast.makeText(this, E.toString(), Toast.LENGTH_LONG).show();
        }

    }
}