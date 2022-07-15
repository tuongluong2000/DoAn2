package com.example.shopuit.data.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SanPham {

    @SerializedName ("id")
    @Expose
    private final int Id;

    @SerializedName ("tensp")
    @Expose
    private final String Tensp;

    @SerializedName ("giasp")
    @Expose
    private final int Giasp;

    @SerializedName ("soluongsp")
    @Expose
    private final int  SoLuongsp;


    @SerializedName ("urlimg")
    @Expose
    private final String UrlImg;

    @SerializedName ("idlsp")
    @Expose
    private final int Idlsp;

    public SanPham(int id, String tensp, int giasp, int soLuongsp,String urlImg,int idlsp) {
        Id = id;
        Tensp = tensp;
        Giasp = giasp;
        SoLuongsp = soLuongsp;
        UrlImg = urlImg;
        Idlsp = idlsp;
    }

    public int getId() {
        return Id;
    }

    public String getTensp() {
        return Tensp;
    }

    public int getGiasp() {
        return Giasp;
    }

    public int getSoLuongsp() {
        return SoLuongsp;
    }

    public String getUrlImg() {
        return UrlImg;
    }

    public int getIdlsp() {
        return Idlsp;
    }


}
