package com.example.shopuit.data.repository;

import java.util.ArrayList;
import java.util.List;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.shopuit.data.model.TaiKhoan;
import com.example.shopuit.data.remote.ShopUITApiManager;


public class ShopUITRepository {
    private static volatile ShopUITRepository instance;

    private final ShopUITApiManager shopUITApiManager;
    List<TaiKhoan> taiKhoanss = new ArrayList<TaiKhoan>();
    private final MutableLiveData<List<TaiKhoan>> taikhoans = new MutableLiveData<>();
    private final MutableLiveData<List<TaiKhoan>> taikhoanByusernamepass = new MutableLiveData<>();


    private ShopUITRepository(ShopUITApiManager shopUITApiManager) {
        this.shopUITApiManager = shopUITApiManager;
    }

    public static ShopUITRepository getInstance(ShopUITApiManager shopUITApiManager) {
        if (instance == null) {
            instance = new ShopUITRepository(shopUITApiManager);
        }
        return instance;
    }

    public MutableLiveData<List<TaiKhoan>> getTaikhoans(){
        shopUITApiManager.getTaiKhoans(new Callback<List<TaiKhoan>>() {
            @Override
            public void onResponse(Call<List<TaiKhoan>> call, Response<List<TaiKhoan>> response) {
                if (response.isSuccessful()){

                    List<TaiKhoan> body = response.body();
                    taikhoans.setValue(body);
                } else{
                    taiKhoanss.add(new TaiKhoan(0,"hi","hi",0));
                    taikhoans.postValue(taiKhoanss);
                }

            }
            @Override
            public void onFailure(Call<List<TaiKhoan>> call, Throwable t) {
                taikhoans.postValue(null);
            }
        });

        return taikhoans;
    }

    public MutableLiveData<List<TaiKhoan>> getTaikhoanByusernamepass(String username, String pass){
        shopUITApiManager.getTaiKhoanByUsernamePass(username,pass, new Callback<List<TaiKhoan>>() {
            @Override
            public void onResponse(Call<List<TaiKhoan>> call, Response<List<TaiKhoan>> response) {
                if (response.isSuccessful()){
                    List<TaiKhoan> body = response.body();
                    taikhoanByusernamepass.setValue(body);
                } else{
                    taikhoanByusernamepass.postValue(null);
                }
            }
            @Override
            public void onFailure(Call<List<TaiKhoan>> call, Throwable t) {
                taikhoanByusernamepass.postValue(null);
            }
        });

        return taikhoanByusernamepass;
    }
}
