package com.example.foodorder_project.Adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodorder_project.MenuChitiet_Activity;
import com.example.foodorder_project.MenuChitiet_Lau_Activity;
import com.example.foodorder_project.MenuChitiet_TrangMieng_Activity;
import com.example.foodorder_project.Model.Category;
import com.example.foodorder_project.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CateViewHolder> {

    private ArrayList<Category> mListCate;
    Context context;
    private CategoryClickListener mListener;

    public CategoryAdapter(Context context, ArrayList<Category> mListCate) {
        this.mListCate = mListCate;
        this.context = context;
    }

    public CategoryAdapter(Context context, ArrayList<Category> mListCate, CategoryClickListener listener) {
        this.context = context;
        this.mListCate = mListCate;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public CategoryAdapter.CateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false);
        return new CateViewHolder(view, mListener);

    }

    public interface CategoryClickListener {
        void onCategoryClick(int position);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CateViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Category cate = mListCate.get(position);
        // Sử dụng Glide để tải hình ảnh và hiển thị nó trên ImageView

        Glide.with(context)
                .load(cate.image) // Đường dẫn hình ảnh từ Firebase
                .into(holder.imgCate);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Dựa vào giá trị position để xác định dòng nào được click
                switch (position) {
                    case 0:
                        // Mở Activity tương ứng với dòng 0
                        Intent intent0 = new Intent(context, MenuChitiet_Activity.class);
                        context.startActivity(intent0);
                        break;
                    case 1:
                        // Mở Activity tương ứng với dòng 1
                        Intent intent1 = new Intent(context, MenuChitiet_Lau_Activity.class);
                        context.startActivity(intent1);
                        break;
                    case 4:
                        // Mở Activity tương ứng với dòng 1
                        Intent intent4 = new Intent(context, MenuChitiet_TrangMieng_Activity.class);
                        context.startActivity(intent4);
                        break;
                    // Thêm các trường hợp khác nếu cần
                    default:
                        break;
                }
            }
        });
        holder.tvName.setText(cate.nameCategory);
    }

    @Override
    public int getItemCount() {
        if (mListCate != null) {
            return mListCate.size();
        }
        return mListCate.size();
    }

    public static class CateViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgCate;
        private TextView tvName;

        //        private CategoryClickListener mListener;
        public CateViewHolder(@NonNull View itemView, CategoryClickListener listener) {
            super(itemView);
            imgCate = itemView.findViewById(R.id.img_cate);
            tvName = itemView.findViewById(R.id.tv_cate);
//            mListener = listener;
//            itemView.setOnClickListener(this);
        }

//        @Override
//        public void onClick(View v) {
//            mListener.onCategoryClick(getAdapterPosition());
//        }
//    }

    }
}

