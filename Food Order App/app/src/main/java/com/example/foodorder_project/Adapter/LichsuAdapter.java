package com.example.foodorder_project.Adapter;

//import static android.os.Build.VERSION_CODES.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder_project.DangchuanbiActivity;
import com.example.foodorder_project.DanggiaoActivity;
import com.example.foodorder_project.DathangthanhcongActivity;
import com.example.foodorder_project.Donthanhcong_newActivity;
import com.example.foodorder_project.Model.Hientai;
import com.example.foodorder_project.Model.Lichsu;
import com.example.foodorder_project.R;
import com.example.foodorder_project.XacnhanActivity;

import java.util.ArrayList;

public class LichsuAdapter extends RecyclerView.Adapter<LichsuAdapter.LichsuViewHolder> {
    private ArrayList<Lichsu> listcart;
    private Context context;

    public LichsuAdapter(ArrayList<Lichsu> listcart, Context context) {
        this.listcart = listcart;
        this.context = context;
    }

    @NonNull
    @Override
    public LichsuAdapter.LichsuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment_lichsu_new,parent,false);
        return new LichsuViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull LichsuAdapter.LichsuViewHolder holder, @SuppressLint("RecyclerView") int position) {

//        holder.FoodPicture.setImageResource(listcart.get(position).getFoodPicture());
        holder.txtQuantity.setText(listcart.get(position).getQuantity());
        holder.txtPrice.setText(listcart.get(position).getPrice());
        holder.txtStatus.setText(listcart.get(position).getStatus());
        holder.ngaydat.setText(listcart.get(position).getCreateDate().toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lấy giá trị txtStatus của dòng được click
                String status = listcart.get(position).getStatus();

                // Kiểm tra giá trị txtStatus và mở Activity tương ứng
                if ("Giao hàng thành công".equals(status)) {
                    Intent intentDangGiao = new Intent(context, Donthanhcong_newActivity.class);
                    intentDangGiao.putExtra("foodname", listcart.get(position).getFoodname());
                    intentDangGiao.putExtra("quantity", listcart.get(position).getQuantity());
                    intentDangGiao.putExtra("quantity", listcart.get(position).getQuantity());
                    intentDangGiao.putExtra("price", listcart.get(position).getPrice());
                    intentDangGiao.putExtra("status", listcart.get(position).getStatus());
                    intentDangGiao.putExtra("createDate", listcart.get(position).getCreateDate());
                    // Truyền dữ liệu vào intent nếu cần
                    context.startActivity(intentDangGiao);
                } else {
                }
            }
        });
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Kiểm tra xem position có phải là vị trí cuối cùng hay không
//                if (position == listcart.size() - 1) {
//                    // Mở Activity tương ứng với vị trí cuối cùng
//                    Intent intentLastItem = new Intent(context, DanggiaoActivity.class);
//
//                    intentLastItem.putExtra("quantity", listcart.get(position).getQuantity());
//                    intentLastItem.putExtra("price", listcart.get(position).getPrice());
//                    intentLastItem.putExtra("status", listcart.get(position).getStatus());
//                    intentLastItem.putExtra("arrivalTime", listcart.get(position).getArrivalTime());
//                    intentLastItem.putExtra("createDate", listcart.get(position).getCreateDate());
//                    intentLastItem.putExtra("paymentMethod", listcart.get(position).getPaymentMethod());
//                    context.startActivity(intentLastItem);
//                } else {
//                    // Xử lý click cho các vị trí khác nếu cần
//                    // Dựa vào giá trị position để xác định dòng nào được click
//                    switch (position) {
//                        case 0:
//                            // Mở Activity tương ứng với dòng 0
//                            break;
//                        // Thêm các trường hợp khác nếu cần
//                        default:
//                            break;
//                    }
//                }
//            }
//        });
//        Hientai hientai = listcart.get(position);
//        holder.txtQuantity.setText(hientai.Quantity);
//        holder.txtPrice.setText(hientai.Price);
//        holder.txtStatus.setText(hientai.Status);
//        holder.txtArrivalTime.setText(hientai.ArrivalTime);
//        holder.txtPaymentMethod.setText(hientai.PaymentMethod);
    }

    @Override
    public int getItemCount() {
        return listcart.size();
    }

    public class LichsuViewHolder extends RecyclerView.ViewHolder {
        TextView txtQuantity, txtStatus,txtPrice, ngaydat, foodname;
        public LichsuViewHolder(@NonNull View itemView) {
            super(itemView);
            foodname = itemView.findViewById(R.id.foodname);
            txtQuantity = itemView.findViewById(R.id.txt_quantity);
            txtStatus = itemView.findViewById(R.id.txt_ship);
            ngaydat = itemView.findViewById(R.id.txt_date1);
            txtPrice = itemView.findViewById(R.id.txt_price);
        }
    }


}
