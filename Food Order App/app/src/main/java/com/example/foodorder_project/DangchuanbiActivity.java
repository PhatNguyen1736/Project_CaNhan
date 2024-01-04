package com.example.foodorder_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder_project.Adapter.HientaiAdapter;
import com.example.foodorder_project.Adapter.XacnhanAdapter;
import com.example.foodorder_project.Model.Hientai;
import com.example.foodorder_project.Model.Xacnhan;

import java.util.ArrayList;

public class DangchuanbiActivity extends AppCompatActivity {
    ArrayList<Xacnhan> listfood;
    private RecyclerView recyclerView;
    AppCompatButton btnHuydon, btnlienhe;
    TextView tongtien, thanhtien, soluong, ngaydat;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitietdonhang_dangchuanbi);

        recyclerView = findViewById(R.id.recycle_dangchuanbi);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listfood = new ArrayList<Xacnhan>();
//        listfood.add(new Xacnhan(R.drawable.ic_comchienraucu, "Cơm chiên rau củ", "Size M", "1", "70.000đ"));
        String price = null;
        String date = null;
        String quantity = null;
        Intent intent = getIntent();
        if (intent != null) {
            quantity = intent.getStringExtra("quantity");
            price = intent.getStringExtra("price");
            String status = intent.getStringExtra("status");
            String arrivalTime = intent.getStringExtra("arrivalTime");
            String paymentMethod = intent.getStringExtra("paymentMethod");
            date = intent.getStringExtra("createDate");

            listfood = new ArrayList<Xacnhan>();
            listfood.add(new Xacnhan(R.drawable.comhaplasen1, "Cơm hấp lá sen", "Size M", quantity, price));
        }

        XacnhanAdapter adapter = new XacnhanAdapter(listfood, this);
        recyclerView.setAdapter(adapter);

        btnHuydon = findViewById(R.id.btnHuydon);

        String finalDate = date;
        String finalPrice = price;
        String finalQuantity = quantity;

        btnHuydon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(DangchuanbiActivity.this, Xacnhan_HuyDon_Activity.class);
                intent2.putExtra("quantity", finalQuantity);
                intent2.putExtra("price", finalPrice);
                intent2.putExtra("createDate", finalDate);
                startActivity(intent2);
            }
        });

        btnlienhe = findViewById(R.id.lienhenhahang);
        btnlienhe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(DangchuanbiActivity.this, trangthaichatshipper_nhahangActivity.class);
                startActivity(intent3);
            }
        });


        tongtien = findViewById(R.id.txt_giatong);
        thanhtien = findViewById(R.id.txt_giathanhtien);
        soluong = findViewById(R.id.txt_soluongtong);
        ngaydat = findViewById(R.id.ngaydat);
        tongtien.setText(price);
        ngaydat.setText(date);
        char firstChar = price.charAt(0); // Lấy ký tự đầu tiên
        String firstCharString = String.valueOf(firstChar); // Chuyển đổi thành chuỗi
        soluong.setText(firstCharString);
        thanhtien.setText(String.valueOf(Integer.parseInt(price) + 15000));

    }
}
