package com.example.shopbansach.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.shopbansach.R;

public class  DoimatkhauActivity extends AppCompatActivity {
    Toolbar toolbardmm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doimatkhau);
        AnhXa();
        ActionToolbar();
    }
    private void ActionToolbar() {
        setSupportActionBar(toolbardmm);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbardmm.setNavigationIcon(R.drawable.ic_baseline_keyboard_backspace_24);
        toolbardmm.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void AnhXa() {
        toolbardmm = findViewById(R.id.toolbardmm);
    }
}