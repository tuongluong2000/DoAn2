package com.example.shopuit.ui.taikhoans;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopuit.R;
import com.example.shopuit.data.model.TaiKhoan;
import com.example.shopuit.ui.common.OnItemClickListener;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoansAdapter extends RecyclerView.Adapter<TaiKhoansAdapter.TaiKhoanViewHolder> {

    @NonNull
    private final Context context;
    private List<TaiKhoan> taiKhoans = new ArrayList<>();
    private final OnItemClickListener<TaiKhoan> onTaiKhoanClickListener;

    public TaiKhoansAdapter(@NonNull Context context, OnItemClickListener<TaiKhoan> onCategoryClickListener) {
        this.context = context;
        this.onTaiKhoanClickListener = onCategoryClickListener;
    }

    @Override
    public TaiKhoanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TaiKhoanViewHolder(LayoutInflater.from(context).inflate(R.layout.taikhoan_item, parent, false));
    }

    @Override
    public void onBindViewHolder(TaiKhoanViewHolder holder, int position) {
        holder.setTaiKhoanItem(taiKhoans.get(position));
    }

        @Override
    public int getItemCount() {
        return taiKhoans == null ? 0 : taiKhoans.size();
    }

    public void setTaiKhoans(List<TaiKhoan> taiKhoans) {
        this.taiKhoans = taiKhoans;
        this.notifyDataSetChanged();
    }

    class TaiKhoanViewHolder extends RecyclerView.ViewHolder {

        private final TextView username;
        private final TextView pass;
        private final TextView id;
        private final View taikhoanItem;

        TaiKhoanViewHolder(View categoryItem) {
            super(categoryItem);
            username = categoryItem.findViewById(R.id.taikhoan_username);
            pass = categoryItem.findViewById(R.id.taikhoan_pass);
            id = categoryItem.findViewById(R.id.taikhoan_id);
            this.taikhoanItem = categoryItem;
        }

        private void setTaiKhoanItem(TaiKhoan category){
            username.setText(category.getUsername());
            pass.setText(category.getPass());
            id.setText(String.valueOf(category.getId()));
            taikhoanItem.setOnClickListener(view -> onTaiKhoanClickListener.onItemClicked(view, category));
        }

    }
}
