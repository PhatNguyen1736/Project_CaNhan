package com.example.foodorder_project.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder_project.ChitietMonAnActivity;
import com.example.foodorder_project.ChitietMonAn_lauatisoActivity;
import com.example.foodorder_project.ChitietMonAn_trasendoActivity;
import com.example.foodorder_project.Model.Cart;
import com.example.foodorder_project.Model.Detail_order;
import com.example.foodorder_project.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class DetailOrder_Adapter extends RecyclerView.Adapter<DetailOrder_Adapter.DetailOrderViewHolder>{
    private ArrayList<Detail_order> listdetail;
    private Context context;

    public DetailOrder_Adapter(ArrayList<Detail_order> listdetail , Context context) {
        this.listdetail = listdetail;
        this.context = context;
    }

    @NonNull
    @Override
    public DetailOrder_Adapter.DetailOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail_order,parent,false);
        return new DetailOrder_Adapter.DetailOrderViewHolder(view);

    }
    @Override
    public void onBindViewHolder(@NonNull DetailOrder_Adapter.DetailOrderViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.FoodPicture.setImageResource(listdetail.get(position).getFoodPicture());
        holder.txtFoodName.setText(listdetail.get(position).getFoodName());
        holder.txtQuantity.setText(listdetail.get(position).getQuantity());
        holder.txtPrice.setText(listdetail.get(position).getPrice());
//        holder.txtNote.setText(listdetail.get(position).getNote());
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Dựa vào giá trị position để xác định dòng nào được click
                String foodName = listdetail.get(position).getFoodName();

                if ("Cơm hấp lá sen".equals(foodName)) {
                    Intent intentA = new Intent(context, ChitietMonAnActivity.class);
                    context.startActivity(intentA);
                } else if ("Lẩu Atiso".equals(foodName)) {
                    Intent intentB = new Intent(context, ChitietMonAn_lauatisoActivity.class);
                    context.startActivity(intentB);
                } else {
                    Intent intentC = new Intent(context, ChitietMonAn_trasendoActivity.class);
                    context.startActivity(intentC);
                }
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dựa vào giá trị position để xác định dòng nào được click
                String foodNameToDelete = listdetail.get(position).getFoodName();

                // Truy cập Firebase Firestore và tìm tài liệu dựa trên điều kiện tên
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                CollectionReference cartCollection = db.collection("Cart");

                // Thực hiện truy vấn để lấy document có tên là foodNameToDelete
                Query query = cartCollection.whereEqualTo("FoodName", foodNameToDelete);

                query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                // Lấy document ID và xóa document
                                String documentId = document.getId();
                                cartCollection.document(documentId)
                                        .delete()
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                // Xóa thành công, có thể thông báo hoặc cập nhật giao diện người dùng tại đây
                                                Toast.makeText(context, "Đã xóa sản phẩm khỏi giỏ hàng", Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                // Xóa thất bại, có thể thông báo lỗi hoặc xử lý khác tùy ý
                                                Toast.makeText(context, "Lỗi khi xóa sản phẩm khỏi giỏ hàng", Toast.LENGTH_SHORT).show();
                                                Log.e("DeleteError", "Error deleting document", e);
                                            }
                                        });
                            }
                        } else {
                            Log.d("QueryError", "Error getting documents: ", task.getException());
                        }
                    }
                });
            }
        });
//        holder.delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Dựa vào giá trị position để xác định dòng nào được click
//                int deletedPosition = holder.getAdapterPosition();
//
//                // Kiểm tra xem vị trí có hợp lệ không
//                if (deletedPosition != RecyclerView.NO_POSITION) {
//                    // Xóa mục khỏi danh sách
//                    listdetail.remove(deletedPosition);
//
//                    // Thông báo cho RecyclerView biết rằng một mục đã bị xóa
//                    notifyItemRemoved(deletedPosition);
//                }
//            }
//        });

    }

    @Override
    public int getItemCount() {

        if (listdetail != null) {
            return listdetail.size();
        }
        return listdetail.size();
    }

    public class DetailOrderViewHolder extends RecyclerView.ViewHolder {
        ImageView FoodPicture, edit, delete;
        TextView txtFoodName, txtQuantity, txtPrice, txtNote;
        public DetailOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            FoodPicture = itemView.findViewById(R.id.img_food);
            txtFoodName = itemView.findViewById(R.id.food_name);
            txtQuantity = itemView.findViewById(R.id.sl);
            txtPrice = itemView.findViewById(R.id.price);
//            txtNote = itemView.findViewById(R.id.add_note);
            edit = itemView.findViewById(R.id.edit);
            delete = itemView.findViewById(R.id.delete);
        }
    }

}
