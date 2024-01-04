package com.example.foodorder_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GiaothanhcongActivity extends AppCompatActivity {
    TextView btnDanhgia;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitietdonhang_giaohangthanhcong);

        btnDanhgia = findViewById(R.id.btnDanhgia);
        btnDanhgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(GiaothanhcongActivity.this, DanhgiaActivity.class);
                startActivity(intent3);
            }
        });
    }
}
