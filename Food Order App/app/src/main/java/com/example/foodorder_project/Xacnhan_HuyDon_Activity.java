package com.example.foodorder_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.example.foodorder_project.Model.Cart;
import com.example.foodorder_project.Model.Hientai;
import com.example.foodorder_project.Model.Xacnhan;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class Xacnhan_HuyDon_Activity extends AppCompatActivity {
    ArrayList<Xacnhan> listfood;
    private RecyclerView recyclerView;
    AppCompatButton btnHuydon;
    TextView tongtien, thanhtien, soluong, ngaydat;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xacnhan_huydon);

        recyclerView = findViewById(R.id.recycle_xacnhan_huydon);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listfood = new ArrayList<Xacnhan>();

        String price = null;
        String date = null;
        String quantity = null;
        Intent intent = getIntent();
        if (intent != null) {
            quantity = intent.getStringExtra("quantity");
            price = intent.getStringExtra("price");
            date = intent.getStringExtra("createDate");

            listfood = new ArrayList<Xacnhan>();
            listfood.add(new Xacnhan(R.drawable.comhaplasen1, "Cơm hấp lá sen", "Size M", quantity, price));
        }

        XacnhanAdapter adapter = new XacnhanAdapter(listfood, this);
        recyclerView.setAdapter(adapter);

        btnHuydon = findViewById(R.id.btn_huydon);

        String finalDate = date;

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
        btnHuydon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listfood != null && listfood.size() > 0) {
                    Xacnhan firstCartItem = listfood.get(0);

                    Intent intent4 = new Intent(Xacnhan_HuyDon_Activity.this, DahuyActivity.class);

                    String quantity = firstCartItem.getQuantity();
                    String price = firstCartItem.getPrice();

                    intent4.putExtra("quantity1", quantity);
                    intent4.putExtra("price1", price);
                    intent4.putExtra("createDate1", finalDate);
                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                    String currentDate = dateFormat.format(calendar.getTime());
                    intent4.putExtra("cancelDateTime1", currentDate);
                    EditText editText = findViewById(R.id.txt_lydo);
                    String userInput = editText.getText().toString();
                    intent4.putExtra("lydohuy1", userInput);

                    startActivity(intent4);
                }
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
