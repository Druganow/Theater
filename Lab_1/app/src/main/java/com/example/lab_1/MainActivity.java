package com.example.lab_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lab_1.model.Theater;

public class MainActivity extends AppCompatActivity {

    String[] theaterName;
    String[] theaterAddress;
    String[] theaterVk;
    String[] theaterSite;
    String[] theaterTel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        theaterName = getResources().getStringArray(R.array.theater_names);
        theaterAddress = getResources().getStringArray(R.array.theater_address);
        theaterVk = getResources().getStringArray(R.array.theater_vk);
        theaterSite = getResources().getStringArray(R.array.theater_site);
        theaterTel = getResources().getStringArray(R.array.theater_tel);

    }

    public void CardClick(View view) {
        Intent intent = new Intent(getApplicationContext(), TheaterActivity.class);

        int number;
        switch (view.getId()){
            case R.id.theaterTUZ:
                number = 0;
                break;
            case R.id.theaterDrama:
                number = 1;
                break;
            case R.id.theaterDol:
                number = 2;
                break;
            default: number = 2;
        }

        int id;
        switch (number){
            case 0:
                id = R.drawable.tuz_img;
                break;
            case 1:
                id = R.drawable.drama_img;
                break;
            case 2:
                id = R.drawable.dol_img;
                break;
            default: id = 0;
        }
        Theater theater = new Theater();//создание элемента Theater theater с помощью конструктора
        theater.setImageId(id);
        theater.setName(theaterName[number]);
        theater.setAddress(theaterAddress[number]);
        theater.setSite(theaterSite[number]);
        theater.setVk(theaterVk[number]);
        theater.setTel(theaterTel[number]);
        intent.putExtra("theater", theater);
        startActivity(intent);
    }
}

