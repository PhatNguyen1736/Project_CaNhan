package com.example.foodorder_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ChinhanhnhahangActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chinhanhnhahang);
    }
    public void onLocationImageClick(View view) {
        // Chuyển sang trang chitietnhahang khi click vào ImageView
        Intent intent = new Intent(this, ChitietnhahangActivity.class);
        startActivity(intent);
    }
}
