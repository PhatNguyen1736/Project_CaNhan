package com.example.foodorder_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class voucherggActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vouchergg);

//        ImageView imageView = findViewById(R.id.imageView12);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Chuyển từ trang vouchergg về trang icon_cai_chuong
//                Intent intent = new Intent(voucherggActivity.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
        ImageView imgvoucher1 = findViewById(R.id.voucher1);
        imgvoucher1 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển từ trang vouchergg về trang icon_cai_chuong
                Intent resultIntent = new Intent();
                resultIntent.putExtra("Voucher1", "SO15"); // Thay yourValue bằng giá trị bạn muốn truyền

                // Đặt kết quả và kết thúc voucherggActivity
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
