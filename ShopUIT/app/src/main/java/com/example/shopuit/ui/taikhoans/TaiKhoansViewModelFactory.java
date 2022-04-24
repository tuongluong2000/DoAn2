package com.example.shopuit.ui.taikhoans;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.shopuit.MainApplication;
import com.example.shopuit.data.repository.ShopUITRepository;

public class TaiKhoansViewModelFactory implements ViewModelProvider.Factory {
    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(TaiKhoansViewModel.class)) {
            return (T) new TaiKhoansViewModel(ShopUITRepository.getInstance(MainApplication.shopUITApiManager));
        } else {
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }
}
