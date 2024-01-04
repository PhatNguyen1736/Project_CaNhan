package com.example.foodorder_project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.foodorder_project.Adapter.CategoryAdapter;
import com.example.foodorder_project.Model.Category;
import com.google.firebase.Firebase;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

public class MenuActivity extends AppCompatActivity {

    RecyclerView rclView;
    ArrayList<Category> catelist;
    CategoryAdapter cateadapter;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu1);


        rclView = findViewById(R.id.recycler_menu);
        rclView.setHasFixedSize(true);
        rclView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        catelist = new ArrayList<>();
        cateadapter = new CategoryAdapter(MenuActivity.this, catelist);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rclView.setLayoutManager(gridLayoutManager);
        rclView.setAdapter(cateadapter);
        EventChangeListener();




//
//        CategoryAdapter adapter = new CategoryAdapter(getListCate());
//        rclView.setAdapter(adapter);
    }
//        public void onCategoryClick(int position) {
//            // Xử lý khi một dòng được click
//            switch (position) {
//                case 0:
//                    Intent intent = new Intent(this, MenuChitiet_Activity.class);
//                    startActivity(intent);
//                    break;
//            }
//        }

    private void EventChangeListener() {
        db.collection("Menu_Food")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null){
                            Log.e("Firestore error", error.getMessage());
                            return;
                        }

                        for (DocumentSnapshot dc: value.getDocuments()){

                            Category category = dc.toObject(Category.class);
                            catelist.add(category);

                            if (category != null) {
//                                    String nameCategory = category.getNameCategory();
                                String image = category.getImage();

//                                    String imageUrl = dc.getString("https://scontent.fsgn16-1.fna.fbcdn.net/v/t39.30808-6/295307525_3303048946684112_1855975664910836331_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=efb6e6&_nc_eui2=AeESyCsC0ava5BnMM8ttPqFL79qGR2uEVWHv2oZHa4RVYehS4LKgp3vcSanzEKUJwYiGN26g671PXgMGDKYyTxqz&_nc_ohc=aXvJIKbQap0AX9Xpau5&_nc_ht=scontent.fsgn16-1.fna&oh=00_AfBz1KOFFGQXveO2CjkQYcD4xlm-sEccwpiu6A0TLU2PGw&oe=658A8885");
//                                    Picasso.get().load(imageUrl).into(imageView);
//                                    Log.d("Category Name", nameCategory);
                                Log.d("Image", image);
                            }
                        }
                        cateadapter.notifyDataSetChanged();
                    }
                });
    }

//    private List<Category> getListCate() {
//        List<Category> list = new ArrayList<>();
//        list.add(new Category(R.drawable.com, "Cơm chay"));
//        list.add(new Category(R.drawable.lau, "Lẩu chay"));
//        list.add(new Category(R.drawable.bun, "Bún/Phở"));
//        list.add(new Category(R.drawable.monkhac, "Món khác"));
//        list.add(new Category(R.drawable.trangmieng, "Tráng miệng"));
//        list.add(new Category(R.drawable.anvat, "Ăn vặt"));
//
//        return list;
//
//    }
}

