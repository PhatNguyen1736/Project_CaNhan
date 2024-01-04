package com.example.foodorder_project;

import static com.example.foodorder_project.Model.MenuIds.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.foodorder_project.Model.MenuIds;
import com.example.foodorder_project.Model.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private RelativeLayout dangvanchuyen;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationViewRight;
    private RecyclerView rclView;
    ShapeableImageView imgCom, imgLau,  imgTrangmieng;
    ImageView imgmess, imgnotify;
    public void Inuit(){
        imgCom = findViewById(R.id.img_Com);
        imgLau = findViewById(R.id.img_Lau);
        imgTrangmieng = findViewById(R.id.img_Giaikhat);
        imgmess = findViewById(R.id.mess);
        imgnotify = findViewById(R.id.notify);
    }
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        Inuit();
        imgCom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Xử lý sự kiện click ở đây, ví dụ chuyển sang trang khác
                Intent intent = new Intent(MainActivity.this, MenuChitiet_Activity.class);
                startActivity(intent);
            }
        });
        imgLau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Xử lý sự kiện click ở đây, ví dụ chuyển sang trang khác
                Intent intent = new Intent(MainActivity.this, MenuChitiet_Lau_Activity.class);
                startActivity(intent);
            }
        });
        imgTrangmieng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Xử lý sự kiện click ở đây, ví dụ chuyển sang trang khác
                Intent intent = new Intent(MainActivity.this, MenuChitiet_TrangMieng_Activity.class);
                startActivity(intent);
            }
        });
            imgmess.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Xử lý sự kiện click ở đây, ví dụ chuyển sang trang khác
                    Intent intent = new Intent(MainActivity.this, trangthaichatshipper_nhahangActivity.class);
                    startActivity(intent);
                }
            });
            imgnotify.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Xử lý sự kiện click ở đây, ví dụ chuyển sang trang khác
                    Intent intent = new Intent(MainActivity.this, icon_cai_chuongActivity.class);
                    startActivity(intent);
                }
            });
    }
    // PHAT
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




    //        ANH NGUYEN
    // Tạo danh sách thông tin đơn hàng
//        ArrayList<String> orderInfoList = new ArrayList<>();
//        orderInfoList.add("Đơn hàng 2310JK\nĐơn hàng hiện đang trên đường giao đến bạn. Hãy chú ý theo dõi đơn hàng. Nhà hàng Tuệ Duyên xin cảm ơn!");
//        orderInfoList.add("Đơn hàng 2308JK\nĐơn hàng đã giao thành công. Bạn hãy để lại đánh giá cho món ăn để chúng tôi có thể cải thiện chất lượng món ăn và khách hàng khác có thể hiểu thêm về món ăn nhé!");
//
        // Tạo ArrayAdapterns
    // Tạo ArrayAdapter
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, orderInfoList);

//        // Liên kết ArrayAdapter với ListView
//        ListView listView = findViewById(R.id.infoListView);
//        listView.setAdapter(adapter);

//        tabLayout = findViewById(R.id.tabLayout);
//        viewPager2 = findViewById(R.id.viewPager);
//        //dangvanchuyen = findViewById(R.id.frameLayout);
//
//        tabLayout.addTab(tabLayout.newTab().setText("Hiện tại"));
//        tabLayout.addTab(tabLayout.newTab().setText("Lịch sử"));
//
//
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        MyFragmentAdapter adapter = new MyFragmentAdapter(fragmentManager, getLifecycle());
//        viewPager2.setAdapter(adapter);
//
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                viewPager2.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//
//        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageSelected(int position) {
//                tabLayout.selectTab(tabLayout.getTabAt(position));
//            }
//        })

//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == 1) {
//            if (resultCode == RESULT_OK) {
//                // Nhận tên địa chỉ từ Intent và hiển thị trong EditText
//                String selectedAddress = data.getStringExtra("selectedAddress");
//                if (selectedAddress != null) {
//                    EditText editDiachichitiet = findViewById(R.id.edit_diachichitiet);
//                    editDiachichitiet.setText(selectedAddress);
//                }
//            }
//        }
//    }
}
