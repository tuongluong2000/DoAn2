package com.example.shopuit.ui.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.shopuit.MainApplication;
import com.example.shopuit.data.repository.ShopUITRepository;
import com.example.shopuit.ui.taikhoans.TaiKhoansViewModel;

public class ShopUITViewModelFactory implements ViewModelProvider.Factory {
    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ShopUITViewModel.class)) {
            return (T) new ShopUITViewModel(ShopUITRepository.getInstance(MainApplication.shopUITApiManager));
        } else {
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }
}
