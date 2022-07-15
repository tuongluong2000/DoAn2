package com.example.shopuit.data.remote;

import com.example.shopuit.data.model.SanPham;
import com.example.shopuit.data.model.TaiKhoan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IShopUITAPI {

    @GET("taikhoans")
    Call<List<TaiKhoan>> getTaiKhoans();

    @GET("taikhoans/{username}/taikhoan")
    Call<List<TaiKhoan>> getTaiKhoanByUsernamePass(@Path("username") String username, @Path("pass") String pass);

    @GET("sanphams")
    Call<List<SanPham>> getAllSanPhams();

    @GET("/sanphams/sanpham/{id}")
    Call<List<SanPham>> getSanPhamById(int id);

}
