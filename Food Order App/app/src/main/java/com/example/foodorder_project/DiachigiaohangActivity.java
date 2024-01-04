package com.example.foodorder_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DiachigiaohangActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diachigiaohang);
        Button themdiachinha = findViewById(R.id.button_themdiachinha);
        Button themdiachicty= findViewById(R.id.button_themdiachicty);
        Button themdiachimoi = findViewById(R.id.button_themdiachimoi);
        themdiachinha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openthemdiachi() ;
            }
        });
        themdiachicty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openthemdiachi() ;
            }
        });
        themdiachimoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openthemdiachi() ;
            }
        });
    }
    private void openthemdiachi() {
        Intent intent = new Intent(this, ThemdiachimoiActivity.class);
        startActivity(intent);
    }
}
