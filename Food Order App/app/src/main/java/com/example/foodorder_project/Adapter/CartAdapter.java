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

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private ArrayList<Cart> listcart;
    private Context context;

    public CartAdapter(Context context,ArrayList<Cart> listcart) {
        this.listcart = listcart;
        this.context = context;
    }

    @NonNull
    @Override
    public CartAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart,parent,false);
        return new CartViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.FoodPicture.setImageResource(listcart.get(position).getFoodPicture());
        holder.txtFoodName.setText(listcart.get(position).getFoodName());
        holder.txtQuantity.setText(listcart.get(position).getQuantity());
        holder.txtPrice.setText(listcart.get(position).getPrice());
        holder.txtNote.setText(listcart.get(position).getNote());

        holder.imgedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Dựa vào giá trị position để xác định dòng nào được click
                String foodName = listcart.get(position).getFoodName();

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
        holder.imgdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dựa vào giá trị position để xác định dòng nào được click
                String foodNameToDelete = listcart.get(position).getFoodName();

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



    }

    @Override
    public int getItemCount() {
        return listcart.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView imgedit, imgdelete;
        ImageView FoodPicture;
        TextView txtFoodName, txtQuantity, txtPrice, txtNote;
        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            FoodPicture = itemView.findViewById(R.id.img_food);
            txtFoodName = itemView.findViewById(R.id.food_name);
            txtQuantity = itemView.findViewById(R.id.number_food);
            txtPrice = itemView.findViewById(R.id.price);
            txtNote = itemView.findViewById(R.id.add_note);
            imgedit = itemView.findViewById(R.id.edit);
            imgdelete = itemView.findViewById(R.id.delete);

        }
    }


}
