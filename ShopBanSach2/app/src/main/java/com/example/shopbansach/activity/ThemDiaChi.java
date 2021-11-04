package com.example.shopbansach.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.shopbansach.R;

public class ThemDiaChi extends AppCompatActivity {
    Toolbar toolbartdc;
    Button btntdc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_dia_chi);
        AnhXa();
        ActionToolbar();
        BtnThemDC();
    }

    private void BtnThemDC() {
        btntdc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Diachigiaohang.class);
                startActivity(intent);
            }
        });
    }

    private void ActionToolbar() {
        setSupportActionBar(toolbartdc);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbartdc.setNavigationIcon(R.drawable.ic_baseline_keyboard_backspace_24);
        toolbartdc.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void AnhXa() {
        toolbartdc = findViewById(R.id.toolbarthemdc);
        btntdc = findViewById(R.id.btnthemdchimoi);
    }
}