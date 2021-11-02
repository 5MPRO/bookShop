package com.example.shopbansach.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.shopbansach.R;

public class ThongBaoActivity extends AppCompatActivity {
    LinearLayout ln_home,ln_tk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_bao);
        ClickMenu();
    }

    private void ClickMenu() {
        ln_home = findViewById(R.id.ln_home_tb);
        ln_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        ln_tk= findViewById(R.id.ln_tk_tb);
        ln_tk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),TaiKhoanActivity.class);
                startActivity(intent);
            }
        });
    }
}