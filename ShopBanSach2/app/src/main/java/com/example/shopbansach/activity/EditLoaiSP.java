package com.example.shopbansach.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.shopbansach.R;
import com.example.shopbansach.model.Loaisp;
import com.example.shopbansach.model.Sanpham;
import com.example.shopbansach.model.emailLogin;
import com.example.shopbansach.util.Server;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class EditLoaiSP extends AppCompatActivity {
    int id=0;
    String tenLSP = "";
    String imgLSP="";
    ImageView imgELSP;
    EditText edtETLSP;
    Button btnEChonHA, btnESuaLSP;
    private final int IMG_REQUEST = 999;
    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_loai_sp);
        AnhXa();
        GetInfomation();
        btnEChonHA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(EditLoaiSP.this,new String[]{
                        Manifest.permission.READ_EXTERNAL_STORAGE},IMG_REQUEST);
            }
        });
        btnESuaLSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
    }

    private void update() {
        RequestQueue requestQueue  = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Duongdanupdatelsp,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("success")){
                            Toast.makeText(getApplicationContext(),"Cập nhật thành công",Toast.LENGTH_SHORT).show();
                        }
                        else {Toast.makeText(getApplicationContext(),"Cập nhật không thành công",Toast.LENGTH_SHORT).show();

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();

            }
        } ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                param.put("id",String.valueOf(id));
                param.put("tenLoaiSanPham",edtETLSP.getText().toString().trim());
                param.put("hinhAnhLoaiSanPham",imageToString(bitmap));
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    private String imageToString(Bitmap bitmap)
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] imgBytes = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgBytes,Base64.DEFAULT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==IMG_REQUEST && resultCode==RESULT_OK && data!=null)
        {
            Uri path = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(path);
                bitmap = BitmapFactory.decodeStream(inputStream);
                imgELSP.setImageBitmap(bitmap);
                imgELSP.setVisibility(View.VISIBLE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == IMG_REQUEST){
            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent,"Chọn hình ảnh "),IMG_REQUEST);
            }
            else {
                Toast.makeText(getApplicationContext(),"Không có quyền truy cập",Toast.LENGTH_LONG).show();
            }

            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void AnhXa() {
        imgELSP = findViewById(R.id.imgELSP);
        edtETLSP = findViewById(R.id.edtETLSP);
        edtETLSP = findViewById(R.id.edtETLSP);
        btnEChonHA = findViewById(R.id.btnEChonHA);
        btnESuaLSP = findViewById(R.id.btnESuaLSP);
    }


    private void GetInfomation() {Loaisp loaisp = (Loaisp) getIntent().getSerializableExtra("thongtinlsp");
        id = loaisp.getId();
        tenLSP = loaisp.getTenloaisp();
        imgLSP = loaisp.getHinhanhloaisp();
        edtETLSP.setText(tenLSP);
        String hinhanhsp = "http://"+ Server.localhost+imgLSP;
        Picasso.get().load(hinhanhsp)
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(imgELSP);

    }

}