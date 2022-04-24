package com.example.shopuit.ui.taikhoans;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import com.example.shopuit.R;
import com.example.shopuit.data.model.TaiKhoan;
import com.google.gson.Gson;


public class TaiKhoansActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taikhoans);

        Intent intent = getIntent();
        String categoryJson = intent.getStringExtra("TaiKhoan");
        TaiKhoan taiKhoan = new Gson().fromJson(categoryJson, TaiKhoan.class);

        setTitle(taiKhoan.getId());
        String callerActivity = intent.getStringExtra("CallerActivity");

        TaiKhoansFragment fragment = new TaiKhoansFragment();
        Bundle args = new Bundle();
        args.putInt("TaiKhoanId", taiKhoan.getId());
        args.putString("CallerActivity", callerActivity);

        if (savedInstanceState == null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            fragment.setArguments(args);
            ft.replace(R.id.taikhoans_fragment_container, fragment);
            ft.commit();
        }
    }
}
