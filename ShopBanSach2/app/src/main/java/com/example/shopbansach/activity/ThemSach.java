package com.example.shopbansach.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.shopbansach.R;
import com.example.shopbansach.adapter.AdapterLoaiSach;
import com.example.shopbansach.adapter.SNP_LoaiSach_Adapter;
import com.example.shopbansach.model.Loaisp;
import com.example.shopbansach.util.CheckConnection;
import com.example.shopbansach.util.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ThemSach extends AppCompatActivity{
    public static int idTypeBook;

    private EditText edit_Title, edit_Price, edit_Quantity,edit_Desc, edit_imgs;
    private Spinner spnTypeBook;
    private SNP_LoaiSach_Adapter snp_loaiSach_adapter;
    private ArrayList<Loaisp> listTypeBook  = new ArrayList<>();;
    int id;
    Button btnAdd;
    String tenLoaiSp="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sach);
        AnhXa();
        GetDuLieuLoaiSP();
        setSpinner();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSach();
            }
        });

    }

    private void AnhXa() {
        edit_Title = findViewById(R.id.edit_Title);
        edit_Price = findViewById(R.id.edit_Price);
        edit_Quantity  = findViewById(R.id.edit_Quantity);
        edit_Desc = findViewById(R.id.edit_Desc);
        edit_imgs = findViewById(R.id.edit_imgs);;
        spnTypeBook = (Spinner) findViewById(R.id.spnTypeBook);
        btnAdd =  findViewById(R.id.btnAddBook);
    }
    private void GetDuLieuLoaiSP() {

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.Duongdanloaisp, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                if (response != null){

                    for (int i = 0;i < response.length();i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            tenLoaiSp = jsonObject.getString("tenloaisp");
                            listTypeBook.add(new Loaisp(id,tenLoaiSp));
                            snp_loaiSach_adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnection.ShowToast_Short(getApplicationContext(),error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);

    }
    private void setSpinner() {
        snp_loaiSach_adapter = new SNP_LoaiSach_Adapter(ThemSach.this,R.layout.item_selected,listTypeBook);
        spnTypeBook.setAdapter(snp_loaiSach_adapter);
        spnTypeBook.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private void addSach(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Duongdaninsertloaisach, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                CheckConnection.ShowToast_Short(getApplicationContext(),"Them thanh cong");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ThemSach.this,error.toString(),Toast.LENGTH_LONG).show();
            }
        })
        {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("idLoaiSach",String.valueOf( idTypeBook));
                params.put("tenSach",edit_Title.getText().toString().trim());
                params.put("gia",edit_Price.getText().toString().trim());
                params.put("soLuong",edit_Quantity.getText().toString().trim());
                params.put("moTa",edit_Desc.getText().toString().trim());
                params.put("hinhAnh",edit_imgs.getText().toString().trim());
                return params;
            }
        };
        AdapterLoaiSach.getInstance(ThemSach.this).addToRequesQue(stringRequest);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }



}