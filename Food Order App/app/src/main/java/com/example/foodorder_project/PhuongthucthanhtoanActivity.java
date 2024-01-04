package com.example.foodorder_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PhuongthucthanhtoanActivity extends AppCompatActivity
{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phuongthucthanhtoan);
        Button Pay_visa = findViewById(R.id.button_themthe);
        Pay_visa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openthemtindung();
            }
        });
    }
    private void openthemtindung() {
        Intent intent = new Intent(this, ThemthetindungActivity.class);
        startActivity(intent);
    }

}
