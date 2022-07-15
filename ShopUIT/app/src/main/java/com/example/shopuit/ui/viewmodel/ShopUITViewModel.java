package com.example.shopuit.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import com.example.shopuit.data.model.SanPham;
import com.example.shopuit.data.repository.ShopUITRepository;
import com.example.shopuit.data.model.TaiKhoan;

public class ShopUITViewModel extends ViewModel {
    private MutableLiveData<List<TaiKhoan>> taikhoans;
    private MutableLiveData<List<SanPham>> sanphams;
    private ShopUITRepository shopUITRepository;

    public ShopUITViewModel(ShopUITRepository shopUITRepository) {
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

    public MutableLiveData<List<SanPham>> getAllSanPhams() {
        sanphams = shopUITRepository.getAllSanPhams();
        return  sanphams;
    }

    public MutableLiveData<List<SanPham>> getSanPhamById(int id) {
        sanphams = shopUITRepository.getSanPhamById(id);
        return  sanphams;
    }
}
