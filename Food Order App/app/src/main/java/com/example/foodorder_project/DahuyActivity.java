package com.example.foodorder_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder_project.Adapter.HientaiAdapter;
import com.example.foodorder_project.Adapter.XacnhanAdapter;
import com.example.foodorder_project.Model.Hientai;
import com.example.foodorder_project.Model.Xacnhan;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class DahuyActivity extends AppCompatActivity {
    ArrayList<Xacnhan> listfood;
    private RecyclerView recyclerView;
    TextView tongtien, soluong, ngaydat, ngayhuy, txt_gioithieu;
    TextView txtlydo;
    AppCompatButton btn_datlai;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitietdonhang_dahuy);

        recyclerView = findViewById(R.id.recycle_dahuy);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listfood = new ArrayList<Xacnhan>();
//        listfood.add(new Xacnhan(R.drawable.ic_comchienraucu, "Cơm chiên rau củ", "Size M", "1", "70.000đ"));

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
        String price = null;
        String date = null;
        String quantity = null;
        String cancel_date = null;
        String lydo = null;
        Intent intent = getIntent();
        if (intent != null) {
            quantity = intent.getStringExtra("quantity1");
            price = intent.getStringExtra("price1");
            date = intent.getStringExtra("createDate1");
            cancel_date = intent.getStringExtra("cancelDateTime1");
            lydo = intent.getStringExtra("lydohuy1");
            listfood = new ArrayList<Xacnhan>();

            String thanhtien = String.valueOf(Integer.parseInt(price) + 15000);
            listfood.add(new Xacnhan(R.drawable.comhaplasen1, "Cơm hấp lá sen", "Size M", quantity, thanhtien));
        }


        XacnhanAdapter adapter = new XacnhanAdapter(listfood, this);
        recyclerView.setAdapter(adapter);



        ngaydat = findViewById(R.id.ngaydat);
        ngayhuy = findViewById(R.id.ngayhuy);
        txtlydo = findViewById(R.id.txt_lydo);
        txt_gioithieu = findViewById(R.id.txt_gioithieu);
        ngaydat.setText(date);
        ngayhuy.setText(cancel_date);
        txtlydo.setText(lydo);
        txt_gioithieu.setText(cancel_date);

        btn_datlai = findViewById(R.id.btn_nhanduocmon);
        btn_datlai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DahuyActivity.this, ChitietMonAnActivity.class);
                startActivity(intent1);
            }
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
