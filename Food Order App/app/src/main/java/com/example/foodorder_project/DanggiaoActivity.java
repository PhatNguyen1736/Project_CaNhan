package com.example.foodorder_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder_project.Adapter.HientaiAdapter;
import com.example.foodorder_project.Adapter.XacnhanAdapter;
import com.example.foodorder_project.Model.Detail_order;
import com.example.foodorder_project.Model.Hientai;
import com.example.foodorder_project.Model.Xacnhan;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DanggiaoActivity extends AppCompatActivity {
    ArrayList<Xacnhan> listfood;
    private RecyclerView recyclerView;
    TextView btndanggiao;
    TextView tongtien, thanhtien, soluong, ngaydat;
    FirebaseFirestore db;
    public String get_ngaydat, dkngay;
    public String foodname;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitietdonhang_danggiao);
        db = FirebaseFirestore.getInstance();

        recyclerView = findViewById(R.id.recycle_giao);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        listfood = new ArrayList<Xacnhan>();
//        listfood.add(new Xacnhan(R.drawable.ic_comchienraucu, "Cơm chiên rau củ", "Size M", "1", "70.000đ"));




        String price = null;
        get_ngaydat = null;
        Intent intent = getIntent();
        if (intent != null) {
            foodname = intent.getStringExtra("foodname");
            String quantity = intent.getStringExtra("quantity");
            price = intent.getStringExtra("price");
            String status = intent.getStringExtra("status");
            String arrivalTime = intent.getStringExtra("arrivalTime");
            String paymentMethod = intent.getStringExtra("paymentMethod");
            get_ngaydat = intent.getStringExtra("createDate");
            dkngay = intent.getStringExtra("createDate");
            listfood = new ArrayList<Xacnhan>();

            // Kiểm tra giá trị của foodname và thêm vào listfood dựa trên điều kiện
            if ("Cơm hấp lá sen".equals(foodname)) {
                // Thêm dữ liệu vào listfood với tham số đầu tiên cụ thể cho "Cơm hấp lá sen"
                listfood.add(new Xacnhan(R.drawable.comhaplasen1, foodname, "Size M", quantity, price));
            } else if ("Lẩu Atiso".equals(foodname)) {
                // Thêm dữ liệu vào listfood với tham số đầu tiên cụ thể cho "Lẩu atiso"
                // Thay đổi giá trị tham số đầu tiên tùy thuộc vào điều kiện
                listfood.add(new Xacnhan(R.drawable.img_1, foodname, "Size M", quantity, price));
            } else {
                // Thêm dữ liệu với giá trị mặc định cho các trường hợp khác
                listfood.add(new Xacnhan(R.drawable.img_trasendo, foodname, "Size M", quantity, price));
            }
        }

//        if (intent != null) {
//            String foodname = intent.getStringExtra("foodname");
//            String quantity = intent.getStringExtra("quantity");
//            price = intent.getStringExtra("price");
//            String status = intent.getStringExtra("status");
//            String arrivalTime = intent.getStringExtra("arrivalTime");
//            String paymentMethod = intent.getStringExtra("paymentMethod");
//            get_ngaydat = intent.getStringExtra("createDate");
//
//            listfood = new ArrayList<Xacnhan>();
//            listfood.add(new Xacnhan(R.drawable.comhaplasen1, foodname, "Size M", quantity, price));
//        }
        XacnhanAdapter adapter = new XacnhanAdapter(listfood, this);
        recyclerView.setAdapter(adapter);

        tongtien = findViewById(R.id.txt_giatong);
        thanhtien = findViewById(R.id.txt_giathanhtien);
        soluong = findViewById(R.id.txt_soluongtong);
        ngaydat = findViewById(R.id.ngaydat);
        tongtien.setText(price);
        ngaydat.setText(get_ngaydat);
        char firstChar = price.charAt(0); // Lấy ký tự đầu tiên
        String firstCharString = String.valueOf(firstChar); // Chuyển đổi thành chuỗi
        soluong.setText(firstCharString);
        thanhtien.setText(price);

        btndanggiao = findViewById(R.id.btn_nhanduocmon);
        btndanggiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteDataFromOrdersCollection(foodname);
                uploadOrderDataToFirebase();
                Intent intent = new Intent(DanggiaoActivity.this, GiaothanhcongActivity.class);
                startActivity(intent);

            }
        });
    }
    private void deleteDataFromOrdersCollection(String foodNameToDelete) {
        // Lấy reference đến collection "Orders"
        CollectionReference ordersCollectionRef = db.collection("Orders");

        // Tìm tất cả các tài liệu có trường "FoodName" bằng giá trị cần xóa
        ordersCollectionRef
                .whereEqualTo("FoodName", foodNameToDelete)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            // Lấy ID của mỗi tài liệu thỏa mãn điều kiện
                            String documentId = document.getId();

                            // Xóa tài liệu
                            ordersCollectionRef.document(documentId).delete()
                                    .addOnSuccessListener(aVoid -> Log.d("Firestore", "Document successfully deleted"))
                                    .addOnFailureListener(e -> Log.w("Firestore", "Error deleting document", e));
                        }
                    } else {
                        Log.d("Firestore", "Error getting documents: ", task.getException());
                    }
                });
    }

    private void uploadOrderDataToFirebase() {
        // Lấy reference đến tài liệu trong Firestore
        DocumentReference orderRef = db.collection("Orders_giaothanhcong").document();

        // Lấy 3 trường dữ liệu giống nhau từ listoder
        Map<String, Object> orderData = new HashMap<>();
        for (Xacnhan orderItem : listfood) {
            orderData.put("FoodName", orderItem.getFoodName());
            orderData.put("Quantity", orderItem.getQuantity());
            orderData.put("Price", orderItem.getPrice());
        }

        // Lấy ngày và giờ hiện tại
//        long createDate = System.currentTimeMillis();

        // Thêm trường createDate vào orderData
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = dateFormat.parse(get_ngaydat);
//
//        Timestamp timestamp = new Timestamp(date);

        orderData.put("createDate", get_ngaydat);
        orderData.put("status", "Giao hàng thành công");

        // Đặt giá trị cho các trường trong tài liệu
        orderRef.set(orderData)
                .addOnSuccessListener(documentReference -> {
//                    Log.d("Firestore", "Order item added with ID: " + documentReference.getId());
                })
                .addOnFailureListener(e -> {
                    Log.w("Firestore", "Error adding order item", e);
                });
    }
}
