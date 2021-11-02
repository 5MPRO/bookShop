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
    private ActionBar toolbarmenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tai_khoan);
        AnhXa();
        GetEmail();
        OnClickconten();
        AcctionToolbar();
        OnclickMenu();
    }

    private void OnclickMenu() {
        toolbarmenu = getSupportActionBar();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigationmenu);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        toolbarmenu.setTitle("Trang chủ");
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigationmenu:
                    toolbarmenu.setTitle("Trang chủ");
                    Intent intent1 = new Intent(TaiKhoanActivity.this,MainActivity.class);
                    startActivity(intent1);
                    return true;
                case R.id.navigation_list:
                    toolbarmenu.setTitle("Danh sách");
                    return true;
                case R.id.navigation_search:
                    toolbarmenu.setTitle("Tìm kiếm");
                    return true;
                case R.id.navigation_bell:
                    toolbarmenu.setTitle("Thông báo");
                    Intent intent4 = new Intent(getApplicationContext(),ThongBaoActivity.class);
                    startActivity(intent4);
                    return true;
                case R.id.navigation_profile:
                    toolbarmenu.setTitle("Tài khoản");
                    Intent intent5 = new Intent(getApplicationContext(),TaiKhoanActivity.class);
                    startActivity(intent5);
                    return true;
            }
            return false;
        }
    };

    private void OnClickconten() {
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
        Intent intent = getIntent();
        String emailtk = intent.getStringExtra("email");
        txtEmail.setText(emailtk);
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
    }
}