package com.example.shopbansach.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.example.shopbansach.R;

public class TaiKhoanActivity extends AppCompatActivity {
    Button btndonhang,btndangxuat;
    Toolbar toolbartk;
    LinearLayout ln_home,ln_tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tai_khoan);
        AnhXa();
        OnClickMenu();
        btndonhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Giohang.class);
                startActivity(intent);

            }
        });

        btndangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });

        AcctionToolbar();
    }

    private void OnClickMenu() {
        ln_home = findViewById(R.id.ln_home_ct5);
        ln_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        ln_tb = findViewById(R.id.ln_tk_tb);
        ln_tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ThongBaoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void AcctionToolbar() {
        setSupportActionBar(toolbartk);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbartk.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menugiohang:
                Intent intent = new Intent(getApplicationContext(), com.example.shopbansach.activity.Giohang.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


    private void AnhXa() {
        btndonhang = findViewById(R.id.btndonhangcuatoi);
        btndangxuat = findViewById(R.id.buttonDangXuat);
        toolbartk = findViewById(R.id.toolbartaikhoan);
    }
}