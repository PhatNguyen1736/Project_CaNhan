package com.example.foodorder_project.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder_project.Model.Hientai;
import com.example.foodorder_project.Model.Xacnhan;
import com.example.foodorder_project.R;

import java.util.ArrayList;

public class XacnhanAdapter extends RecyclerView.Adapter<XacnhanAdapter.XacnhanViewHolder> {
    private ArrayList<Xacnhan> listfood;
    private Context context;

    public XacnhanAdapter(ArrayList<Xacnhan> listfood, Context context) {
        this.listfood = listfood;
        this.context = context;
    }

    @NonNull
    @Override
    public XacnhanAdapter.XacnhanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_xacnhan_monan,parent,false);
        return new XacnhanViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull XacnhanAdapter.XacnhanViewHolder holder, int position) {

//        holder.FoodPicture.setImageResource(listcart.get(position).getFoodPicture());
        holder.foodPicture.setImageResource(listfood.get(position).getFoodPicture());
        holder.txtFoodName.setText(listfood.get(position).getFoodName());
        holder.txtNote.setText(listfood.get(position).getNote());
        holder.txtQuantity.setText(listfood.get(position).getQuantity());
        holder.txtPrice.setText(listfood.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return listfood.size();
    }

    public class XacnhanViewHolder extends RecyclerView.ViewHolder {
        ImageView foodPicture;
        TextView txtFoodName, txtNote, txtQuantity, txtPrice;
        public XacnhanViewHolder(@NonNull View itemView) {
            super(itemView);
            foodPicture = itemView.findViewById(R.id.img_donhang1);
            txtFoodName = itemView.findViewById(R.id.txt_monan);
            txtNote = itemView.findViewById(R.id.txt_note);
            txtQuantity = itemView.findViewById(R.id.txt_soluong);
            txtPrice = itemView.findViewById(R.id.txt_gia);
        }
    }


}