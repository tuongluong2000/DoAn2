package com.example.shopuit.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopuit.R;
import com.example.shopuit.data.model.SanPham;
import com.example.shopuit.ui.adapter.SanPhamsAdapter;
import com.example.shopuit.ui.common.OnItemClickListener;
import com.example.shopuit.ui.viewmodel.ShopUITViewModel;
import com.example.shopuit.ui.viewmodel.ShopUITViewModelFactory;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

public class HomeFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ShopUITViewModel shopUITViewModel = new ViewModelProvider(this, new ShopUITViewModelFactory()).get(ShopUITViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        RecyclerView sanphamsRecyclerView = root.findViewById(R.id.products_recycler_view);


        OnItemClickListener<SanPham> onSanPhamClickListener = (view, sanpham) -> {
            Gson gson = new Gson();
            String sanphamJson = gson.toJson(sanpham);
            Intent intent = new Intent(getActivity(), CartFragment.class);
            intent.putExtra("SanPham", sanphamJson);
            intent.putExtra("CallerActivity", getActivity().getClass().getSimpleName());
            startActivity(intent);
        };

        SanPhamsAdapter sanPhamsAdapter= new SanPhamsAdapter(root.getContext(), onSanPhamClickListener);
        sanphamsRecyclerView.addItemDecoration(new DividerItemDecoration(root.getContext(), LinearLayout.VERTICAL));
        sanphamsRecyclerView.setAdapter(sanPhamsAdapter);
        sanphamsRecyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));

        Snackbar make = Snackbar.make(getActivity().findViewById(android.R.id.content), "No blogs found for this category", BaseTransientBottomBar.LENGTH_INDEFINITE);


        shopUITViewModel.getAllSanPhams().observe(getViewLifecycleOwner(), sanphams -> {
            sanPhamsAdapter.setSanPhams(sanphams);
        });

        return root;
    }
}
