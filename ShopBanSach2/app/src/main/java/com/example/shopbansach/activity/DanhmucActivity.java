package com.example.shopbansach.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.support.v7.widget.Toolbar;

import com.example.shopbansach.R;

public class DanhmucActivity extends AppCompatActivity {
    Toolbar toolbardm;
    LinearLayout ln_home,ln_tk,ln_tb,ln_search,ln_dm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhmuc);
        AnhXa();
        OnClickMenu();
        ActionToolbar();
    }

    private void AnhXa() {
            toolbardm = findViewById(R.id.toolbardanhmuc);
            ln_home = findViewById(R.id.ln_home);
            ln_tk = findViewById(R.id.ln_tk);
            ln_tb = findViewById(R.id.ln_tb);
            ln_dm = findViewById(R.id.ln_dm);
            ln_search = findViewById(R.id.ln_search);
        }

    private void OnClickMenu() {
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

    private void ActionToolbar() {
        setSupportActionBar(toolbardm);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbardm.setNavigationIcon(R.drawable.ic_baseline_keyboard_backspace_24);
        toolbardm.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}