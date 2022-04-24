package com.example.shopuit.data.remote;

import java.util.List;
import com.example.shopuit.data.model.TaiKhoan;
import retrofit2.Call;
import retrofit2.Callback;

public class ShopUITApiManager {
    private static IShopUITAPI service;
    private static ShopUITApiManager apiManager;

    private ShopUITApiManager() {
        service = RetrofitService.Create();
    }

    public static ShopUITApiManager getInstance() {
        if (apiManager == null) {
            apiManager = new ShopUITApiManager();
        }
        return apiManager;
    }

    public void getTaiKhoanByUsernamePass(String username, String pass, Callback<List<TaiKhoan>> callback){
        Call<List<TaiKhoan>> taiKhoanByUsernamePass = service.getTaiKhoanByUsernamePass(username,pass);
        taiKhoanByUsernamePass.enqueue(callback);
    }
    public void getTaiKhoans(Callback<List<TaiKhoan>> callback){
        Call<List<TaiKhoan>> taiKhoans = service.getTaiKhoans();
        taiKhoans.enqueue(callback);
    }
}
