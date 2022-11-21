package com.phanquangminhlong.MLBaemin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.phanquangminhlong.MLBaemin.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        addEvent();
    }

    private void addEvent() {
        binding.imvLunchBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RestaurantActivity.class);
                intent.putExtra("item","LUNCH_BOX");
                startActivity(intent);
            }
        });
        binding.imvNoodle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RestaurantActivity.class);
                intent.putExtra("item","NOODLE");
                startActivity(intent);
            }
        });
    }
}