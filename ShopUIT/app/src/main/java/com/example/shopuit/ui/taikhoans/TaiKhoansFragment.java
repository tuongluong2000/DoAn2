package com.example.shopuit.ui.taikhoans;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.shopuit.R;
import com.example.shopuit.data.model.TaiKhoan;
import com.example.shopuit.ui.common.OnItemClickListener;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;


public class TaiKhoansFragment  extends Fragment {
    private TaiKhoansAdapter taiKhoansAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_taikhoans, container, false);
        return root;
    }

        /*TaiKhoansViewModel taiKhoansViewModel = new ViewModelProvider(this, new TaiKhoansViewModelFactory()).get(TaiKhoansViewModel.class);
        View root = inflater.inflate(R.layout.fragment_taikhoans, container, false);
        ContentLoadingProgressBar progress = root.findViewById(R.id.progress);

        RecyclerView taikhoansRecyclerView = root.findViewById(R.id.taikhoans_recycler_view);



        OnItemClickListener<TaiKhoan> onTaiKhoanClickListener = (view, taiKhoan) -> {
            Gson gson = new Gson();
            String taikhoanJson = gson.toJson(taiKhoan);
            Intent intent = new Intent(getActivity(), TaiKhoansActivity.class);
            intent.putExtra("TaiKhoan", taikhoanJson);
            intent.putExtra("CallerActivity", getActivity().getClass().getSimpleName());
            startActivity(intent);
        };

        taiKhoansAdapter = new TaiKhoansAdapter(root.getContext(), onTaiKhoanClickListener);
        taikhoansRecyclerView.addItemDecoration(new DividerItemDecoration(root.getContext(), LinearLayout.VERTICAL));
        taikhoansRecyclerView.setAdapter(taiKhoansAdapter);
        taikhoansRecyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));

        Snackbar make = Snackbar.make(getActivity().findViewById(android.R.id.content), "No blogs found for this category", BaseTransientBottomBar.LENGTH_INDEFINITE);

        progress.show();
        taiKhoansViewModel.getTaikhoans().observe(getViewLifecycleOwner(), categories -> {
            taiKhoansAdapter.setTaiKhoans(categories);
            progress.hide();
        });

        return root;

         */


}
