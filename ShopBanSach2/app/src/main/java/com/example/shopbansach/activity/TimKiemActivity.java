package com.example.shopbansach.activity;

import android.app.SearchManager;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.shopbansach.R;

public class TimKiemActivity extends AppCompatActivity {

    Toolbar toolbartk;
    LinearLayout ln_home,ln_tk,ln_tb,ln_search,ln_dm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_kiem);
        AnhXa();
        ActionBar();
        OnClickMenu();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
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

    private void ActionBar() {
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

    private void AnhXa() {
        toolbartk = findViewById(R.id.toolbartimkiem);
        ln_home = findViewById(R.id.ln_home);
        ln_tk = findViewById(R.id.ln_tk);
        ln_tb = findViewById(R.id.ln_tb);
        ln_dm = findViewById(R.id.ln_dm);
        ln_search = findViewById(R.id.ln_search);
    }
}