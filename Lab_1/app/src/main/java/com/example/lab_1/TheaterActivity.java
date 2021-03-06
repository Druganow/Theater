package com.example.lab_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab_1.model.Theater;

public class TheaterActivity extends AppCompatActivity {
    Theater theater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theater);
        Bundle intent = getIntent().getExtras();
        theater = (Theater) intent.getSerializable("theater");
       // ImageView theaterImageView = findViewById(R.id.theater_image_view_details);
       // theaterImageView.setImageResource(theater.getImageId());
        ((ImageView)findViewById(R.id.theater_image_view_details))
                .setImageResource(theater.getImageId());
        ((TextView)findViewById(R.id.theater_name_text_view_details))
                .setText(theater.getName());
        ((TextView)findViewById(R.id.theater_address_text_view))
                .setText(theater.getAddress());
        ((TextView)findViewById(R.id.theater_site_text_view))
                .setText(theater.getSite());
        ((TextView)findViewById(R.id.theater_vk_text_view))
                .setText(theater.getVk());
        ((TextView)findViewById(R.id.theater_tel_text_view))
                .setText(theater.getTel());

    }

    public void TroupeButtonClick(View view) {
        Intent intent = new Intent(this, ActorsActivity.class);
        intent.putExtra("theater", theater);
        startActivity(intent);
    }
}
//


