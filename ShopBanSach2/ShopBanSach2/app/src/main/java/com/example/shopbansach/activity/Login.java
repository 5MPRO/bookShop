package com.example.shopbansach.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.shopbansach.R;
import com.example.shopbansach.model.TaiKhoan;
import com.example.shopbansach.util.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    private EditText etEmail,etPassword;
    private String email, password;
    public static ArrayList<TaiKhoan> mangtaikhoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = password = "";
        etEmail = findViewById(R.id.edittextdnemail);
        etPassword =  findViewById(R.id.edittextdnpassword);
        mangtaikhoan = new ArrayList<>();
    }

    public void login(View view){
        email = etEmail.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        if(!email.equals("")&&!password.equals("")){
            StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Đuongdandangnhap, new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    Log.e("QB", "onResponse: " + response);
                    if(response.contains("success")){
                        JSONArray jsonArray = null;
                        try {
                            jsonArray = new JSONArray(response);
                            for (int i = 0;i<jsonArray.length();i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                String tenkh = jsonObject.getString("name");
                                String email = jsonObject.getString("email");
                                mangtaikhoan.add(new TaiKhoan(tenkh,email));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                        Intent intent = new Intent(Login.this, MainActivity.class);
                        intent.putExtra("thongtintaikhoan",mangtaikhoan);
                        startActivity(intent);
                        finish();
                        Log.e("QB", "onResponse: " + response);
                    }else if(response.contains("failure")) {

                        Toast.makeText(Login.this, "Nhập sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(Login.this, "onResponse: " + response, Toast.LENGTH_SHORT).show();
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
                    data.put("email",email);
                    data.put("password",password);
                    return data;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        } else {
            Toast.makeText(Login.this, "Field can not be empty!", Toast.LENGTH_SHORT).show();
        }
    }

    public void register(View view){
        Intent intent = new Intent(this, DangKy.class);
        startActivity(intent);
        finish();
    }
}