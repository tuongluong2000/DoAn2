package com.example.shopuit.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TaiKhoan {
    @SerializedName ("id")
    @Expose
    private final int Id;

    @SerializedName ("username")
    @Expose
    private final String Username;

    @SerializedName ("pass")
    @Expose
    private final String Pass;

    @SerializedName ("quyen")
    @Expose
    private final int  Quyen;


    public TaiKhoan(int id, String username, String pass, int quyen) {
        Id = id;
        Username = username;
        Pass = pass;
        Quyen = quyen;
    }


    public int getId() {
        return Id;
    }

    public String getUsername() {
        return Username;
    }

    public String getPass() {
        return Pass;
    }

    public int getQuyen() {
        return Quyen;
    }
}
