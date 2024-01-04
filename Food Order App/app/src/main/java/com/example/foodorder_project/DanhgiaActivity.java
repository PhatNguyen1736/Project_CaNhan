package com.example.foodorder_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DanhgiaActivity extends AppCompatActivity {
    TextView btnDanhgia;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danhgia);

        btnDanhgia = findViewById(R.id.btn_danhgia);
        btnDanhgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(DanhgiaActivity.this, Danhgia_Thanhcong_Activity.class);
                startActivity(intent5);
            }
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.home_id) {
                // Xử lý khi nhấn vào Trang chủ
                if (!isMainActivity()) {
                    openMainActivity();
                    return true;
                }
            } else if (itemId == R.id.menu_id) {
                openmenu();
                // Xử lý khi nhấn vào Thực đơn
            } else if (itemId == R.id.giohang_id) {
                // Xử lý khi nhấn vào Giỏ hàng
                opengiohang();
            } else if (itemId == R.id.donhang_id) {
                // Xử lý khi nhấn vào Giỏ hàng
                opendonhang();
            } else if (itemId == R.id.bagach_id) {
                // Xử lý khi nhấn vào Khác
                openbagach();
            }
            return true;
        });
    }
    private boolean isMainActivity() {
        // Kiểm tra xem đang ở MainActivity hay không
        return getClass().getSimpleName().equals(MainActivity.class.getSimpleName());
    }
    private void openMainActivity() {
        // Khởi tạo lại MainActivity
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
    private void openmenu() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
    private void opengiohang() {
        Intent intent = new Intent(this, CartActivity.class);
        startActivity(intent);
    }
    private void opendonhang() {
        Intent intent = new Intent(this, trangthaidonhangActivity.class);
        startActivity(intent);
    }

    private void openbagach() {
        Intent intent = new Intent(this, ThongtinkhacActivity.class);
        startActivity(intent);
    }
}
