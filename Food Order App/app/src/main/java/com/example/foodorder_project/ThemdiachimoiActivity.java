package com.example.foodorder_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ThemdiachimoiActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themdiachimoi);
    }
        public void onLocationImageClick(View view) {
        // Chuyển sang trang chondiachi khi click vào ImageView
        Intent intent = new Intent(this, GoogleMapActivity.class);
        startActivity(intent);
    }
}
