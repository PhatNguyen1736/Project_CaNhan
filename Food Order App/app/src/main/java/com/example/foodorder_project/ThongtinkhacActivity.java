package com.example.foodorder_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class ThongtinkhacActivity extends AppCompatActivity {
    Button thongtincanhan,diachigiaohang, phuongthucthantoan, diachinhahang, chinhanhtoanquoc, lienhe, chinhsachgiaohang,dieukhoan,dangxuat;
    public void Units(){
        thongtincanhan = findViewById(R.id.button_thongtincanhan);
        diachigiaohang= findViewById(R.id.button_diachigiaohang);
        phuongthucthantoan = findViewById(R.id.button_phuongthucthanhtoan);
        diachinhahang = findViewById(R.id.button_nhahanggan);
        chinhanhtoanquoc = findViewById(R.id.button_chinhanh);
        lienhe = findViewById(R.id.button_lienhegopy);
        chinhsachgiaohang = findViewById(R.id.button_chinsachgiaohang);
        dieukhoan = findViewById(R.id.button_dieukhoan);
        dangxuat =findViewById(R.id.button_dangxuat);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangthongtinkhac1);
        Units();
        thongtincanhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openthongtincanhan();
            }
        });
        diachigiaohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendiachigiaohang();
            }
        });
        phuongthucthantoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openphuongthucthantoan();
            }
        });
        diachinhahang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendiachinhahang();
            }
        });
        lienhe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlienhe();
            }
        });
        chinhsachgiaohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openchinhsachgiaohang();
            }
        });
        dieukhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendieukhoan();
            }
        });

        dangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void openthongtincanhan() {
        Intent intent = new Intent(this, ThongtincanhanActivity.class);
        startActivity(intent);
    }
    private void opendiachigiaohang() {
        Intent intent = new Intent(this, DiachigiaohangActivity.class);
        startActivity(intent);
    }
    private void openphuongthucthantoan() {
        Intent intent = new Intent(this, PhuongthucthanhtoanActivity.class);
        startActivity(intent);
    }
    private void opendiachinhahang() {
        Intent intent = new Intent(this, ChinhanhnhahangActivity.class);
        startActivity(intent);
    }
    private void openlienhe() {
        Intent intent = new Intent(this, LienhegopyActivity.class);
        startActivity(intent);
    }
    private void openchinhsachgiaohang() {
        Intent intent = new Intent(this, ChinhsachgiaohangActivity.class);
        startActivity(intent);
    }
    private void opendieukhoan() {
        Intent intent = new Intent(this, DieukhoanActivity.class);
        startActivity(intent);
    }
}
