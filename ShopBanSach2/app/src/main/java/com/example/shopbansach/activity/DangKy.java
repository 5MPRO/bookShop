package com.example.shopbansach.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.shopbansach.R;
import com.example.shopbansach.util.Server;

import java.util.HashMap;
import java.util.Map;

public class DangKy extends AppCompatActivity {
    private EditText etName,etPassword,etEmail,etReneterPassword;
    private TextView tvStatus;
    private Button btnRegister;
    private String name, email,password,reneterPassword;
    Toolbar toolbardki;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        AnhXa();
        AcctionToolbar();
    }

    private void AnhXa() {
        tvStatus =  findViewById(R.id.tvStatus);
        etName =  findViewById(R.id.etName);
        etEmail =  findViewById(R.id.etEmail);
        etPassword =  findViewById(R.id.etPassword);
        etReneterPassword =  findViewById(R.id.etReneterPassword);
        btnRegister =  findViewById(R.id.btnRegister);
        name = email = password = reneterPassword = "";
        toolbardki = findViewById(R.id.toolbardangky);
    }

    private void AcctionToolbar() {
        setSupportActionBar(toolbardki);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbardki.setNavigationIcon(R.drawable.ic_baseline_keyboard_backspace_24);
        toolbardki.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);

            }
        });
    }

    public void login(View view) {
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
        finish();
    }

    public void save(View view) {
        name =  etName.getText().toString().trim();
        email = etEmail.getText().toString().trim();
        password =  etPassword.getText().toString().trim();
        reneterPassword =  etReneterPassword.getText().toString().trim();
        if(!password.equals(reneterPassword)){
            Toast.makeText(this, "Password Mismatch", Toast.LENGTH_SHORT).show();
        }
        else if (!name.equals("") && !email.equals("") && !password.equals("")){
            StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Đuongdandangky, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.e("QB", "onResponse: " + response);
                    if (response.contains("success")) {
                        etName.setText("");
                        etEmail.setText("");
                        etPassword.setText("");
                        etReneterPassword.setText("");
                        tvStatus.setText("Tạo tài khoản thành công!");
                        btnRegister.setClickable(false);
                    } else if (response.contains("failute")) {
                        tvStatus.setText("Tạo tài khoản thất bại!");
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(),error.toString().trim(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> data = new HashMap<>();
                    data.put("name",name);
                    data.put("email",email);
                    data.put("password",password);
                    return data;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }
    }
}