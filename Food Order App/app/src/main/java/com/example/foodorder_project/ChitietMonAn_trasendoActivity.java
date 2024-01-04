package com.example.foodorder_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodorder_project.Model.MenuChitiet;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ChitietMonAn_trasendoActivity extends AppCompatActivity {

    MenuChitiet data;

    TextView namefood, soluong, Foodprice, total, feed;
    ImageView addCart;
    ImageView add , subtract;
    int count = 1;
    RadioGroup radioGroup;
    RadioButton small, medium, large;
    int customPizzaPrice;
    int amount = 1;
    int originalPrice;
    private int quantity = 1;
    private int basePrice = 85000;
    FirebaseFirestore db;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_detail_tracusen);

            soluong = findViewById(R.id.val);
            total = findViewById(R.id.total);
            radioGroup = findViewById(R.id.radgroup);
            addCart = findViewById(R.id.add);
            namefood = findViewById(R.id.name);
            small = findViewById(R.id.radS);
            large = findViewById(R.id.radL);
            medium = findViewById(R.id.radM);
            feed = findViewById(R.id.feedback);
            // Set initial quantity and total price
            soluong.setText(String.valueOf(quantity));
            db = FirebaseFirestore.getInstance();
            updateTotalPrice();

            // Set click listeners for the increment and decrement buttons
            ImageView inc = findViewById(R.id.inc);
            ImageView dec = findViewById(R.id.dec);

            inc.setOnClickListener(v -> incrementQuantity());
            dec.setOnClickListener(v -> decrementQuantity());

            // Set a listener for radio button changes
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    // Gọi phương thức cập nhật giá trị tổng khi có sự thay đổi RadioButton được chọn
                    updateTotalPrice();
                }
            });
//            feed.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(ChitietMonAnActivity.this, FeedbackAcivity.class);
//                    startActivity(intent);
//                }
//            });
            ImageView imgFood = findViewById(R.id.img_food);
            EditText note = findViewById(R.id.edit_note);
            addCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Lấy dữ liệu từ Activity A và chuyển sang Activity B
                    uploadOrderDataToFirebase();
                    Intent intent = new Intent(ChitietMonAn_trasendoActivity.this, CartActivity.class);
//                    intent.putExtra("Image", imagePath);
                    intent.putExtra("Name", String.valueOf(namefood.getText()));
                    intent.putExtra("Quality", String.valueOf(soluong.getText()));
                    intent.putExtra("Price", String.valueOf(total.getText()));
                    intent.putExtra("Note", String.valueOf(note.getText()));
                    startActivity(intent);
                }
            });
    }
    private void uploadOrderDataToFirebase() {
        // Lấy reference đến tài liệu trong Firestore
        DocumentReference orderRef = db.collection("Cart").document();

        String foodName = String.valueOf(namefood.getText());
        String quantity = String.valueOf(soluong.getText());
        String price = String.valueOf(total.getText());


        // Lấy 3 trường dữ liệu giống nhau từ listoder
        Map<String, Object> orderData = new HashMap<>();
        orderData.put("FoodName", foodName);
        orderData.put("Quantity", quantity );
        orderData.put("Price", price);

        // Đặt giá trị cho các trường trong tài liệu
        orderRef.set(orderData)
                .addOnSuccessListener(documentReference -> {
//                    Log.d("Firestore", "Order item added with ID: " + documentReference.getId());
                })
                .addOnFailureListener(e -> {
                    Log.w("Firestore", "Error adding order item", e);
                });
    }
    private void incrementQuantity() {
        quantity++;
        soluong.setText(String.valueOf(quantity));
        updateTotalPrice();
    }

    private void decrementQuantity() {
        if (quantity > 1) {
            quantity--;
            soluong.setText(String.valueOf(quantity));
            updateTotalPrice();
        }
    }

    private void updateTotalPrice() {
        int selectedSizePrice = 0;
        int checkedId = radioGroup.getCheckedRadioButtonId();

        if (checkedId == R.id.radM) {
            selectedSizePrice = 50000;
        } else if (checkedId == R.id.radL) {
            selectedSizePrice = 80000;
        }

        int totalPrice = quantity * basePrice + selectedSizePrice;
        total.setText(String.valueOf(totalPrice));
    }
}
