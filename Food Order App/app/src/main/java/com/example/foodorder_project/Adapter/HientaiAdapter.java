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
import com.example.foodorder_project.Model.Hientai;
import com.example.foodorder_project.R;
import com.example.foodorder_project.XacnhanActivity;
import com.example.foodorder_project.Xacnhan_HuyDon_Activity;

import java.util.ArrayList;
public class HientaiAdapter extends RecyclerView.Adapter<HientaiAdapter.HientaiViewHolder> {
    private ArrayList<Hientai> listcart;
    private Context context;

    public HientaiAdapter(ArrayList<Hientai> listcart,Context context) {
        this.listcart = listcart;
        this.context = context;
    }

    @NonNull
    @Override
    public HientaiAdapter.HientaiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment_hientai,parent,false);
        return new HientaiViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull HientaiAdapter.HientaiViewHolder holder, @SuppressLint("RecyclerView") int position) {

//        holder.FoodPicture.setImageResource(listcart.get(position).getFoodPicture());
        holder.txtQuantity.setText(listcart.get(position).getQuantity());
        holder.txtPrice.setText(listcart.get(position).getPrice());
        holder.txtStatus.setText(listcart.get(position).getStatus());
        holder.txtArrivalTime.setText(listcart.get(position).getArrivalTime());
        holder.ngaydat.setText(listcart.get(position).getCreateDate().toString());
        holder.txtPaymentMethod.setText(listcart.get(position).getPaymentMethod());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lấy giá trị txtStatus của dòng được click
                String status = listcart.get(position).getStatus();

                // Kiểm tra giá trị txtStatus và mở Activity tương ứng
                if ("Đang giao".equals(status)) {
                    Intent intentDangGiao = new Intent(context, DanggiaoActivity.class);
                    intentDangGiao.putExtra("foodname", listcart.get(position).getFoodName());
                    intentDangGiao.putExtra("quantity", listcart.get(position).getQuantity());
                    intentDangGiao.putExtra("price", listcart.get(position).getPrice());
                    intentDangGiao.putExtra("status", listcart.get(position).getStatus());
                    intentDangGiao.putExtra("arrivalTime", listcart.get(position).getArrivalTime());
                    intentDangGiao.putExtra("createDate", listcart.get(position).getCreateDate());
                    intentDangGiao.putExtra("paymentMethod", listcart.get(position).getPaymentMethod());
                    // Truyền dữ liệu vào intent nếu cần
                    context.startActivity(intentDangGiao);
                } else if ("Đang chuẩn bị".equals(status)) {
                    Intent intentDangChuanBi = new Intent(context, DangchuanbiActivity.class);
                    // Truyền dữ liệu vào intent nếu cần
                    intentDangChuanBi.putExtra("quantity", listcart.get(position).getQuantity());
                    intentDangChuanBi.putExtra("price", listcart.get(position).getPrice());
                    intentDangChuanBi.putExtra("status", listcart.get(position).getStatus());
                    intentDangChuanBi.putExtra("arrivalTime", listcart.get(position).getArrivalTime());
                    intentDangChuanBi.putExtra("createDate", listcart.get(position).getCreateDate());
                    intentDangChuanBi.putExtra("paymentMethod", listcart.get(position).getPaymentMethod());
                    context.startActivity(intentDangChuanBi);
                } else {
                    Intent intentXacNhan = new Intent(context, XacnhanActivity.class);
                    // Truyền dữ liệu vào intent nếu cần
                    intentXacNhan.putExtra("quantity", listcart.get(position).getQuantity());
                    intentXacNhan.putExtra("price", listcart.get(position).getPrice());
                    intentXacNhan.putExtra("status", listcart.get(position).getStatus());
                    intentXacNhan.putExtra("arrivalTime", listcart.get(position).getArrivalTime());
                    intentXacNhan.putExtra("createDate", listcart.get(position).getCreateDate());
                    intentXacNhan.putExtra("paymentMethod", listcart.get(position).getPaymentMethod());
                    context.startActivity(intentXacNhan);
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

    public class HientaiViewHolder extends RecyclerView.ViewHolder {
        TextView txtQuantity, txtStatus, txtArrivalTime, txtPrice, txtPaymentMethod,ngaydat, foodname;
        public HientaiViewHolder(@NonNull View itemView) {
            super(itemView);
            foodname = itemView.findViewById(R.id.txt_foodname);
            txtQuantity = itemView.findViewById(R.id.txt_quantity);
            txtStatus = itemView.findViewById(R.id.txt_ship);
            txtArrivalTime = itemView.findViewById(R.id.txt_arrival);
            ngaydat = itemView.findViewById(R.id.txt_date1);
            txtPrice = itemView.findViewById(R.id.txt_price);
            txtPaymentMethod = itemView.findViewById(R.id.txt_payment);
        }
    }


}
