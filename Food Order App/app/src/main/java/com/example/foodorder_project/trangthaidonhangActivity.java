package com.example.foodorder_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import com.example.foodorder_project.Adapter.HientaiAdapter;
import com.example.foodorder_project.Adapter.XacnhanAdapter;
import com.example.foodorder_project.Model.Hientai;
import com.example.foodorder_project.Model.Xacnhan;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class trangthaidonhangActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private RelativeLayout dangvanchuyen;

//    ArrayList<Hientai> listcart;
//    private RecyclerView recyclerView;

    ArrayList<Xacnhan> listfood;
    private RecyclerView recyclerView;

    //    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangthaidonhang);

//        // Đổ dữ liệu thử cho trang hiện tại fragment
//        recyclerView = findViewById(R.id.recycle_hientai);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        listcart = new ArrayList<Hientai>();
//        listcart.add(new Hientai(1, "Đang chuẩn bị", "Sẽ tới trong 20 phút nữa", "300.000đ", "Tiền mặt"));
//
//        HientaiAdapter adapter = new HientaiAdapter(listcart, this);
//        recyclerView.setAdapter(adapter);

//        // Đổ dữ liệu thử cho trang chờ xác nhận món ăn
//        recyclerView = findViewById(R.id.recycle_xacnhan_monan);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        listfood = new ArrayList<Xacnhan>();
//        listfood.add(new Xacnhan(R.drawable.ic_comchienraucu, "Cơm chiên rau củ", "Size M", "1", "70.000đ"));
//
//        XacnhanAdapter adapter = new XacnhanAdapter(listfood, this);
//        recyclerView.setAdapter(adapter);

//        // Đổ dữ liệu thử cho trang đang chuẩn bị món ăn
//        recyclerView = findViewById(R.id.recycle_dangchuanbi);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        listfood = new ArrayList<Xacnhan>();
//        listfood.add(new Xacnhan(R.drawable.ic_comchienraucu, "Cơm chiên rau củ", "Size M", "1", "70.000đ"));
//        listfood.add(new Xacnhan(R.drawable.ic_comchienraucu, "Cơm chiên rau củ", "Size M", "1", "70.000đ"));
//
//        XacnhanAdapter adapter = new XacnhanAdapter(listfood, this);
//        recyclerView.setAdapter(adapter);

//        // Đổ dữ liệu thử cho trang đang giao món ăn
//        recyclerView = findViewById(R.id.recycle_danggiao);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        listfood = new ArrayList<Xacnhan>();
//        listfood.add(new Xacnhan(R.drawable.ic_lauchay, "Lẩu chay", "Bún thêm", "1", "150.000đ"));
//        listfood.add(new Xacnhan(R.drawable.ic_comchienraucu, "Cơm chiên rau củ", "Size M", "1", "70.000đ"));
//
//        XacnhanAdapter adapter = new XacnhanAdapter(listfood, this);
//        recyclerView.setAdapter(adapter);

//        // Đổ dữ liệu thử cho trang xác nhận hủy đơn
//        recyclerView = findViewById(R.id.recycle_xacnhan_huydon);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        listfood = new ArrayList<Xacnhan>();
//        listfood.add(new Xacnhan(R.drawable.ic_lauchay, "Lẩu chay", "Bún thêm", "1", "150.000đ"));
//        listfood.add(new Xacnhan(R.drawable.ic_chagiobap, "Chả giò bắp", "Size S", "1", "60.000đ"));
//
//        XacnhanAdapter adapter = new XacnhanAdapter(listfood, this);
//        recyclerView.setAdapter(adapter);

//        // Đổ dữ liệu thử cho trang đã hủy đơn
//        recyclerView = findViewById(R.id.recycle_dahuy);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        listfood = new ArrayList<Xacnhan>();
//        listfood.add(new Xacnhan(R.drawable.ic_lauchay, "Lẩu chay", "Bún thêm", "1", "150.000đ"));
//        listfood.add(new Xacnhan(R.drawable.ic_chagiobap, "Chả giò bắp", "Size S", "1", "60.000đ"));
//        listfood.add(new Xacnhan(R.drawable.ic_goicuon, "Gỏi cuốn", "", "1", "40.000đ"));
//        listfood.add(new Xacnhan(R.drawable.ic_canhnam, "Canh nấm hạt sen", "Size L", "1", "250.000đ"));
//
//        XacnhanAdapter adapter = new XacnhanAdapter(listfood, this);
//        recyclerView.setAdapter(adapter);

        // Set seekbar không tương tác được
        //SeekBar seekBar = findViewById(R.id.seekBar);
        //seekBar.setClickable(false);
        //seekBar.setEnabled(false);
        //seekBar.setSplitTrack(false);

        // Set tablayout
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager);
        //dangvanchuyen = findViewById(R.id.frameLayout);

        tabLayout.addTab(tabLayout.newTab().setText("Hiện tại"));
        tabLayout.addTab(tabLayout.newTab().setText("Lịch sử"));

        FragmentManager fragmentManager = getSupportFragmentManager();
        MyFragmentAdapter adapter = new MyFragmentAdapter(fragmentManager, getLifecycle());
        viewPager2.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });


    }
}