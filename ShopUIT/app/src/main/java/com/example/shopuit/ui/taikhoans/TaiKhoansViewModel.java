package com.example.shopuit.ui.taikhoans;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import com.example.shopuit.data.repository.ShopUITRepository;
import com.example.shopuit.data.model.TaiKhoan;

public class TaiKhoansViewModel extends ViewModel {
    private MutableLiveData<List<TaiKhoan>> taikhoans;
    private ShopUITRepository shopUITRepository;

    public TaiKhoansViewModel(ShopUITRepository shopUITRepository) {
        this.shopUITRepository = shopUITRepository;
    }

    public MutableLiveData<List<TaiKhoan>> getTaiKhoanByUsernamePass(String username, String pass) {
        taikhoans = shopUITRepository.getTaikhoanByusernamepass(username, pass);

        return taikhoans;
    }
    public MutableLiveData<List<TaiKhoan>> getTaikhoans() {
        taikhoans = shopUITRepository.getTaikhoans();

        return taikhoans;
    }
}
