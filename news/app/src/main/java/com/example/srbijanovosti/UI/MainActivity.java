package com.example.srbijanovosti.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.srbijanovosti.R;

public class MainActivity extends AppCompatActivity {

    Button Srbija_btn,Francuska_btn,Turska_btn,Indija_btn,Amerika_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        Srbija_btn=findViewById(R.id.Srbija);
        Francuska_btn=findViewById(R.id.Francuska);
        Turska_btn=findViewById(R.id.Turska);
        Indija_btn=findViewById(R.id.Indija);
        Amerika_btn=findViewById(R.id.Amerika);



    }

    public void Srbija(View view) {
        Intent intent=new Intent(MainActivity.this,NewsData.class);
        intent.putExtra("CountryCode","rs");
        startActivity(intent);
    }

    public void Francuska(View view) {
        Intent intent=new Intent(MainActivity.this,NewsData.class);
        intent.putExtra("CountryCode","fr");
        startActivity(intent);
    }

    public void Turska(View view) {
        Intent intent=new Intent(MainActivity.this,NewsData.class);
        intent.putExtra("CountryCode","tr");
        startActivity(intent);
    }

    public void Indija(View view) {
        Intent intent=new Intent(MainActivity.this,NewsData.class);
        intent.putExtra("CountryCode","in");
        startActivity(intent);
    }

    public void Amerika(View view) {
        Intent intent=new Intent(MainActivity.this,NewsData.class);
        intent.putExtra("CountryCode","us");
        startActivity(intent);
    }
}