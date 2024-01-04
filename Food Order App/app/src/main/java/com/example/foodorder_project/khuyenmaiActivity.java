package com.example.foodorder_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class khuyenmaiActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.khuyenmai);

        ImageView imageView = findViewById(R.id.imageViewKM);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển từ trang vouchergg về trang icon_cai_chuong
                Intent intent = new Intent(khuyenmaiActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}