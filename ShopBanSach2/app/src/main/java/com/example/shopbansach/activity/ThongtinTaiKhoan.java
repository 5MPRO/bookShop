package com.example.shopbansach.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.shopbansach.R;
import com.example.shopbansach.util.CheckConnection;

public class ThongtinTaiKhoan extends AppCompatActivity {
    EditText edname,edphone,eddate,edaddress,edemail;
    Button btnUpdate;
    Toolbar toolbartttk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtin_tai_khoan);
        AnhXa();
        Updata();
        ActionToolbar();
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckConnection.ShowToast_Short(getApplicationContext(),"Cập nhật thành công");
            }
        });
    }

    private void ActionToolbar() {
        setSupportActionBar(toolbartttk);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbartttk.setNavigationIcon(R.drawable.ic_baseline_keyboard_backspace_24);
        toolbartttk.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void Updata() {
        Intent intent = getIntent();
        String emailtk = intent.getStringExtra("email");
        edemail.setText(emailtk);
    }

    private void AnhXa() {
        toolbartttk = findViewById(R.id.toolbartttk);
        btnUpdate = findViewById(R.id.btnUpdate);
        edname = findViewById(R.id.edt_tk_ht);
        edaddress = findViewById(R.id.edt_tk_dchi);
        edphone = findViewById(R.id.edt_tk_sdt);
        eddate = findViewById(R.id.edt_tk_ngsinh);
        edemail = findViewById(R.id.edt_tk_em);
    }
}