package com.example.shopuit.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopuit.R;
import com.example.shopuit.data.model.SanPham;
import com.example.shopuit.data.model.TaiKhoan;
import com.example.shopuit.ui.common.OnItemClickListener;
import com.example.shopuit.ui.taikhoans.TaiKhoansAdapter;

import java.util.ArrayList;
import java.util.List;

public class SanPhamsAdapter extends RecyclerView.Adapter<SanPhamsAdapter.SanPhamViewHolder> {

    @NonNull
    private final Context context;
    private List<SanPham> sanPhams = new ArrayList<>();
    private final OnItemClickListener<SanPham> onSanPhamClickListener;

    public SanPhamsAdapter(@NonNull Context context, OnItemClickListener<SanPham> onCategoryClickListener) {
        this.context = context;
        this.onSanPhamClickListener = onCategoryClickListener;
    }

    @Override
    public SanPhamsAdapter.SanPhamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SanPhamsAdapter.SanPhamViewHolder(LayoutInflater.from(context).inflate(R.layout.products_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(SanPhamsAdapter.SanPhamViewHolder holder, int position) {
        holder.setSanPhamItem(sanPhams.get(position));
    }

    @Override
    public int getItemCount() {
        return sanPhams == null ? 0 : sanPhams.size();
    }

    public void setSanPhams(List<SanPham> sanPhams) {
        this.sanPhams = sanPhams;
        this.notifyDataSetChanged();
    }

    class SanPhamViewHolder extends RecyclerView.ViewHolder {

        private final TextView tensp;
        private final TextView giasp;
        private final View sanphamItem;

        SanPhamViewHolder(View Item) {
            super(Item);
            tensp = Item.findViewById(R.id.product_name_tv);
            giasp = Item.findViewById(R.id.product_price_tv);
            this.sanphamItem = Item;
        }

        private void setSanPhamItem(SanPham item){
            tensp.setText(item.getTensp());
            giasp.setText(String.valueOf(item.getGiasp()));
            sanphamItem.setOnClickListener(view -> onSanPhamClickListener.onItemClicked(view, item));
        }

    }
}
