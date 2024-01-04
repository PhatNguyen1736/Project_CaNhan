package com.example.foodorder_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder_project.Adapter.HientaiAdapter;
import com.example.foodorder_project.Adapter.LichsuAdapter;
import com.example.foodorder_project.Model.Hientai;
import com.example.foodorder_project.Model.Lichsu;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class LichsuActivity extends Fragment {
    private ArrayList<Lichsu> listlichsu;
    private TextView chitiet, chitiet1;
    private RecyclerView recyclerView;
    FirebaseFirestore db;
    LichsuAdapter adapter;

    @SuppressLint("MissingInflatedId")
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lichsu_, container, false);

        recyclerView = view.findViewById(R.id.recycleview_lichsu);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        db = FirebaseFirestore.getInstance();

        listlichsu = new ArrayList<>();

        EventChangeListener();
        adapter = new LichsuAdapter(listlichsu, getActivity());

        recyclerView.setAdapter(adapter);


        chitiet = view.findViewById(R.id.txt_chitiet);
        chitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(getActivity(),DondahuyActivity.class);
                startActivity(intent6);
            }
        });

        chitiet1 = view.findViewById(R.id.txt_chitiet1);
        chitiet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent7 = new Intent(getActivity(), DonthanhcongActivity.class);
                startActivity(intent7);
            }
        });
        return view;
    }

    private void EventChangeListener() {

        db.collection("Orders_giaothanhcong") // Thay "ten_collection" bằng tên collection của bạn
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            // Lấy dữ liệu từ document
                            String sl = document.getString("Quantity");
                            String gia = document.getString("Price");
                            String ten = document.getString("FoodName");
                            char firstChar = gia.charAt(0); // Lấy ký tự đầu tiên
                            String firstCharString = String.valueOf(firstChar); // Chuyển đổi thành chuỗi
//                            Timestamp ngaydat = document.getTimestamp("createDate");
//                            String status = document.getString("status");
//                            Date ngaydatDate = ngaydat.toDate();
                            String ngaydat = document.getString("createDate");
                            // Định dạng ngày giờ thành chuỗi
//                            String ngaydatString = formatDateToString(ngaydatDate);
                            // Tạo đối tượng Hientai và thêm vào listhientai
                            listlichsu.add(new Lichsu(ten, firstCharString,"Giao hàng thành công", ngaydat, gia));
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
