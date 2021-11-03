package com.example.shopbansach.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shopbansach.R;

public class TaiKhoanActivity extends AppCompatActivity {
    Button btndonhang,btndangxuat,btntttk;
    Toolbar toolbartk;
    TextView txtEmail;
    LinearLayout ln_home,ln_tk,ln_tb,ln_search,ln_dm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tai_khoan);
        AnhXa();
        GetEmail();
        OnClickcontent();
        AcctionToolbar();
        OnclickMenu();
    }

    private void OnclickMenu() {
        ln_dm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DanhmucActivity.class);
                startActivity(intent);
            }
        });

        ln_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),TimKiemActivity.class);
                startActivity(intent);
            }
        });
        ln_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        ln_tk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),TaiKhoanActivity.class);
                startActivity(intent);
            }
        });
        ln_tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ThongBaoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void OnClickcontent() {
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
        btntttk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentg = getIntent();
                String emailtkk = intentg.getStringExtra("email");
                Intent intent = new Intent(getApplicationContext(),ThongtinTaiKhoan.class);
                intent.putExtra("email",emailtkk);
                startActivity(intent);
            }
        });
    }

    private void GetEmail() {

    }

    private void AcctionToolbar() {
        setSupportActionBar(toolbartk);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbartk.setNavigationIcon(R.drawable.ic_baseline_keyboard_backspace_24);
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
        txtEmail = findViewById(R.id.textviewtenkh);
        btntttk = findViewById(R.id.btnthongtintk);
        ln_home = findViewById(R.id.ln_home);
        ln_tk = findViewById(R.id.ln_tk);
        ln_tb = findViewById(R.id.ln_tb);
        ln_dm = findViewById(R.id.ln_dm);
        ln_search = findViewById(R.id.ln_search);
    }
}