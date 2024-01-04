package com.example.foodorder_project;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class icon_cai_chuongActivity extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.icon_cai_chuong);
        LinearLayout myLinearLayout = findViewById(R.id.myLinearLayout);
        myLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển từ trang icon cai chuong sang trang voucher khi nhấn vào LinearLayout
                Intent intent = new Intent(icon_cai_chuongActivity.this, voucherggActivity.class);
                startActivity(intent);
            }
        });
        LinearLayout myLinearLayouttintucnhahang = findViewById(R.id.myLinearLayouttintucnhahang);
        myLinearLayouttintucnhahang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển từ trang icon cai chuong sang trang tin tức nhà hàng khi nhấn vào LinearLayout
                Intent intent = new Intent(icon_cai_chuongActivity.this, tintucnhahangActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout myLinearLayoutkhuyenmai = findViewById(R.id.myLinearLayoutkhuyenmai);
        myLinearLayoutkhuyenmai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển từ trang icon cai chuong sang trang tin tức nhà hàng khi nhấn vào LinearLayout
                Intent intent = new Intent(icon_cai_chuongActivity.this, khuyenmaiActivity.class);
                startActivity(intent);
            }
        });
    }
}
