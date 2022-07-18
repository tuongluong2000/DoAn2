package com.example.shopuit.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import com.example.shopuit.data.model.SanPham;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.gson.Gson;
import com.example.shopuit.R;

public class ProductDetailsFragment extends Fragment {
    SanPham sanPham;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_product_details, container, false);
        MaterialToolbar materialToolbar = root.findViewById(R.id.topAppBar);
        materialToolbar.setTitle("Product detail");


        TextView tensp =root.findViewById(R.id.pro_details_title_tv);
        tensp.setText(sanPham.getTensp());

        return root;
    }
    public void setSanPham(SanPham sanPham1)
    {
        this.sanPham = sanPham1;
    }
}
