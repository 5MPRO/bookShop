package com.example.shopbansach.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import android.support.v7.widget.Toolbar;

import com.example.shopbansach.R;

public class ThongBaoActivity extends AppCompatActivity {
    Toolbar toolbartb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_bao);
        AnhXa();
        ActionToolbar();
    }

    private void AnhXa() {
        toolbartb = findViewById(R.id.toolbarthongbao);
    }

    private void ActionToolbar() {
        setSupportActionBar(toolbartb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbartb.setNavigationIcon(R.drawable.ic_baseline_keyboard_backspace_24);
        toolbartb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}