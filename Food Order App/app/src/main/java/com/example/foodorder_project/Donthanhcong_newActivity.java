package com.example.foodorder_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder_project.Adapter.XacnhanAdapter;
import com.example.foodorder_project.Model.Xacnhan;

import java.util.ArrayList;

public class Donthanhcong_newActivity extends AppCompatActivity {
    ArrayList<Xacnhan> listfood;
    private RecyclerView recyclerView;
    TextView tongtien, thanhtien, soluong, ngaydat;
    public String get_ngaydat;
    AppCompatButton btn_datlai;
    String ten;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donthanhcong_new);

        recyclerView = findViewById(R.id.recycle_donthanhcong);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listfood = new ArrayList<Xacnhan>();
//        listfood.add(new Xacnhan(R.drawable.ic_canhnam, "Canh nấm hạt sen", "Size S", "1", "80.000đ"));
//        listfood.add(new Xacnhan(R.drawable.ic_comchienkhom, "Cơm chiên khóm", "Size M", "1", "55.000đ"));
        String price = null;
        Intent intent = getIntent();
        if (intent != null) {
            ten = intent.getStringExtra("foodname");
            String quantity = intent.getStringExtra("quantity");
            price = intent.getStringExtra("price");
            String status = intent.getStringExtra("status");
            get_ngaydat = intent.getStringExtra("createDate");

            listfood = new ArrayList<Xacnhan>();

            // Kiểm tra giá trị của ten và thêm vào listfood dựa trên điều kiện
            if ("Cơm hấp lá sen".equals(ten)) {
                // Thêm dữ liệu vào listfood với tham số đầu tiên cụ thể cho "Cơm hấp lá sen"
                listfood.add(new Xacnhan(R.drawable.comhaplasen1, ten, "Size M", quantity, price));
            } else if ("Lẩu atiso".equals(ten)) {
                // Thêm dữ liệu vào listfood với tham số đầu tiên cụ thể cho "Lẩu atiso"
                // Thay đổi giá trị tham số đầu tiên tùy thuộc vào điều kiện
                listfood.add(new Xacnhan(R.drawable.img_1, ten, "Size M", quantity, price));
            } else {
                // Thêm dữ liệu với giá trị mặc định cho các trường hợp khác
                listfood.add(new Xacnhan(R.drawable.img_trasendo, ten, "Size M", quantity, price));
            }
        }

//        if (intent != null) {
//            String ten = intent.getStringExtra("foodname");
//            String quantity = intent.getStringExtra("quantity");
//            price = intent.getStringExtra("price");
//            String status = intent.getStringExtra("status");
//            get_ngaydat = intent.getStringExtra("createDate");
//
//            listfood = new ArrayList<Xacnhan>();
//            listfood.add(new Xacnhan(R.drawable.comhaplasen1, ten, "Size M", quantity, price));
//        }

        XacnhanAdapter adapter = new XacnhanAdapter(listfood, this);
        recyclerView.setAdapter(adapter);

        tongtien = findViewById(R.id.txt_giatong);
        thanhtien = findViewById(R.id.txt_giathanhtien);
        soluong = findViewById(R.id.txt_soluongtong);
        ngaydat = findViewById(R.id.ngaydat);
        tongtien.setText(price);
        ngaydat.setText(get_ngaydat);
        char firstChar = price.charAt(0); // Lấy ký tự đầu tiên
        String firstCharString = String.valueOf(firstChar); // Chuyển đổi thành chuỗi
        soluong.setText(firstCharString);
        thanhtien.setText(price);

        btn_datlai = findViewById(R.id.datlai);
        btn_datlai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("Cơm hấp lá sen".equals(ten)) {
                    Intent intent1 = new Intent(Donthanhcong_newActivity.this, ChitietMonAnActivity.class);
                    startActivity(intent1);
                } else if ("Lẩu Atiso".equals(ten)) {
                    Intent intent2 = new Intent(Donthanhcong_newActivity.this, ChitietMonAn_lauatisoActivity.class);
                    startActivity(intent2);
                } else {
                    Intent intent3 = new Intent(Donthanhcong_newActivity.this, ChitietMonAn_trasendoActivity.class);
                    startActivity(intent3);
                }
            }
        });
    }
}
