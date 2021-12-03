package com.example.shopbansach.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.support.v7.widget.Toolbar;
import android.widget.Button;

import com.example.shopbansach.R;

public class Diachigiaohang extends AppCompatActivity {
    Button btnthemdc;
    Toolbar toolbardc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diachigiaohang);
        AnhXa();
        ActionToolbar();
        BtnThemDc();
    }

    private void BtnThemDc() {
        btnthemdc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ThemDiaChi.class);
                startActivity(intent);
            }
        });
    }

    private void ActionToolbar() {
        setSupportActionBar(toolbardc);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbardc.setNavigationIcon(R.drawable.ic_baseline_keyboard_backspace_24);
        toolbardc.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void AnhXa() {
        btnthemdc = findViewById(R.id.btnthemdchi);
        toolbardc = findViewById(R.id.toolbardiachi);
    }
}