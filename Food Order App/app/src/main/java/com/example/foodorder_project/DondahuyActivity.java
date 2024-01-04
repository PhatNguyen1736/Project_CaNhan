package com.example.foodorder_project;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder_project.Adapter.HientaiAdapter;
import com.example.foodorder_project.Adapter.XacnhanAdapter;
import com.example.foodorder_project.Model.Hientai;
import com.example.foodorder_project.Model.Xacnhan;

import java.util.ArrayList;

public class DondahuyActivity extends AppCompatActivity {
    ArrayList<Xacnhan> listfood;
    private RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dondahuy);

        recyclerView = findViewById(R.id.recycle_dahuy);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listfood = new ArrayList<Xacnhan>();
        listfood.add(new Xacnhan(R.drawable.comhaplasen1, "Cơm hấp lá sen", "Size M", "1", "110000đ"));

        XacnhanAdapter adapter = new XacnhanAdapter(listfood, this);
        recyclerView.setAdapter(adapter);

    }
}
