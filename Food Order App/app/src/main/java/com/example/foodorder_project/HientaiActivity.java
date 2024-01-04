package com.example.foodorder_project;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder_project.Adapter.HientaiAdapter;
import com.example.foodorder_project.Model.Category;
import com.example.foodorder_project.Model.Hientai;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class HientaiActivity extends Fragment {
    private ArrayList<Hientai> listhientai;
    private RecyclerView recyclerView;
    FirebaseFirestore db;
    HientaiAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hientai_, container, false);

        recyclerView = view.findViewById(R.id.recycle_hientai);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        db = FirebaseFirestore.getInstance();
        listhientai = new ArrayList<>();
//        listhientai.add(new Hientai(1, "Đang chuẩn bị", "Sẽ tới trong 20 phút nữa", "200.000đ", "Tiền mặt"));
        EventChangeListener();
        adapter = new HientaiAdapter(listhientai, getActivity());
//        adapter = new HientaiAdapter(getActivity(),listhientai);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void EventChangeListener() {

        db.collection("Orders") // Thay "ten_collection" bằng tên collection của bạn
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        listhientai.clear();
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            // Lấy dữ liệu từ document
                            String sl = document.getString("Quantity");
                            String gia = document.getString("Price");
                            String ten = document.getString("FoodName");
                            Timestamp ngaydat = document.getTimestamp("createDate");
                            String status = document.getString("status");
                            Date ngaydatDate = ngaydat.toDate();

                            char firstChar = gia.charAt(0); // Lấy ký tự đầu tiên
                            String firstCharString = String.valueOf(firstChar); // Chuyển đổi thành chuỗi
                            // Định dạng ngày giờ thành chuỗi
                            String ngaydatString = formatDateToString(ngaydatDate);
                            // Tạo đối tượng Hientai và thêm vào listhientai
                            listhientai.add(new Hientai(ten,firstCharString, status, "Sẽ tới trong 20 phút nữa", ngaydatString,gia, "Tiền mặt"));
                        }

                        // Sau khi lấy dữ liệu, cập nhật RecyclerView
                        adapter.notifyDataSetChanged();
                    } else {
                        Log.d("TAG", "Error getting documents: ", task.getException());
                    }
                });
    }
    private String formatDateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return dateFormat.format(date);
    }
}

