package com.example.foodorder_project;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import android.annotation.SuppressLint;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;

public class trangthaichatshipper_nhahangActivity extends AppCompatActivity {
    private ViewPager2 mviewPager2;
    private TabLayout mtabLayout;
    @SuppressLint("MissingInflatedId")
    private RecyclerView rclView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangthaichatshipper_nhahang);

        TabLayout mtabLayout = findViewById(R.id.tablayout);
        ViewPager2 mviewPager2 = findViewById(R.id.viewpager);

        mtabLayout.addTab(mtabLayout.newTab().setText("Chat shipper"));
        mtabLayout.addTab(mtabLayout.newTab().setText("Chat nhà hàng"));

        FragmentManager fragmentManager = getSupportFragmentManager();
        MyFragmentAdapterChat adapter = new MyFragmentAdapterChat(fragmentManager, getLifecycle());
        mviewPager2.setAdapter(adapter);

        mtabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mviewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mviewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                mtabLayout.selectTab(mtabLayout.getTabAt(position));
            }
        });


    }
}