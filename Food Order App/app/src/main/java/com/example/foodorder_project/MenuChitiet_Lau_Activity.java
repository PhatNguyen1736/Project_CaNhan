package com.example.foodorder_project;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder_project.Adapter.MenuChitiet_Adapter;
import com.example.foodorder_project.Model.MenuChitiet;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MenuChitiet_Lau_Activity extends AppCompatActivity {
    ArrayList<MenuChitiet> listmenu;
    RecyclerView recyclerView;
    MenuChitiet_Adapter menuChitiet_adapter;
    FirebaseFirestore db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_chitiet_lau);

        recyclerView = findViewById(R.id.recycleview_cart);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        db = FirebaseFirestore.getInstance();
        listmenu = new ArrayList<>();
        menuChitiet_adapter = new MenuChitiet_Adapter(MenuChitiet_Lau_Activity.this, listmenu);
//         cateadapter1 = new CategoryAdapter(MenuActivity.this, catelist, (CategoryAdapter.CategoryClickListener) this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(menuChitiet_adapter);
        EventChangeListener();

    }
//    public void onCategoryClick(int position) {
//        // Xử lý khi một dòng được click
//        switch (position) {
//            case 0:
//                Intent intent = new Intent(this, MenuChitiet_Activity.class);
//                startActivity(intent);
//                break;
//        }
//    }

    private void EventChangeListener() {
        db.collection("Menu_Detail_Lau")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null){
                            Log.e("Firestore error", error.getMessage());
                            return;
                        }

                        for (DocumentSnapshot dc: value.getDocuments()){

                            MenuChitiet menu = dc.toObject(MenuChitiet.class);
                            listmenu.add(menu);
                            if (menu != null) {
                                String foodName= menu.getFoodName();
                                Log.d("Food Name", foodName);
                                int foodprice = menu.getPrice();
                                Log.d("Food price", String.valueOf(foodprice));
                                int foodstart= menu.getReviewStar();
                                Log.d("Food start", String.valueOf(foodstart));
                            }
                        }
                        menuChitiet_adapter.notifyDataSetChanged();
                    }
                });
    }











//        listmenu = new ArrayList<MenuChitiet>();
//        listmenu.add(new MenuChitiet("4.9",R.drawable.heart,R.drawable.lauthai,"Lẩu thái","100000"));
//        listmenu.add(new MenuChitiet("4.8",R.drawable.heart,R.drawable.lauthai,"Lẩu thái 1","99000"));
//        listmenu.add(new MenuChitiet("4.7",R.drawable.heart,R.drawable.lauthai,"Lẩu thái 2","88000"));
//        listmenu.add(new MenuChitiet("4.6",R.drawable.heart,R.drawable.lauthai,"Lẩu thái 3","77000"));
//        listmenu.add(new MenuChitiet("4.5",R.drawable.heart,R.drawable.lauthai,"Lẩu thái 4","66000"));
//        listmenu.add(new MenuChitiet("4.4",R.drawable.heart,R.drawable.lauthai,"Lẩu thái 5","55000"));

//        MenuChitiet_Adapter adapter = new MenuChitiet_Adapter(listmenu,this);
//        recyclerView.setAdapter(adapter);
    }

