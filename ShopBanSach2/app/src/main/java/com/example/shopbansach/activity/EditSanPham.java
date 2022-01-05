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
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.shopbansach.R;
import com.example.shopbansach.adapter.SNP_LoaiSach_Adapter;
import com.example.shopbansach.model.Loaisp;
import com.example.shopbansach.model.Sanpham;
import com.example.shopbansach.util.CheckConnection;
import com.example.shopbansach.util.Server;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class EditSanPham extends AppCompatActivity {
    public static int idTypeBook;
    private EditText edit_Title, edit_Price, edit_Quantity,edit_Desc, edit_imgs;
    private Spinner spnTypeBook;
    private SNP_LoaiSach_Adapter snp_loaiSach_adapter;
    private ArrayList<Loaisp> listTypeBook  = new ArrayList<>();;
    Button btnAdd,btnchon;
    String tenLoaiSp="";
    private ImageView imgha;
    private final int IMG_REQUEST = 999;
    private Bitmap bitmap;
    int id=0;
    String TenChitiet = "";
    int GiaChitiet=0;
    String HinhanhChitiet = "";
    String MotaChitiet = "";
    int Idsanpham = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sach);
        AnhXa();
        GetDuLieuLoaiSP();
        setSpinner();
        btnchon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(EditSanPham.this,new String[]{
                        Manifest.permission.READ_EXTERNAL_STORAGE},IMG_REQUEST);
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
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
                imgha.setImageBitmap(bitmap);
                imgha.setVisibility(View.VISIBLE);
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

    /*private void GetInfomation() {
        Sanpham sanPham = (Sanpham) getIntent().getSerializableExtra("thongtinsp");
        id = sanPham.getID();
        TenChitiet = sanPham.getTensanpham();
        GiaChitiet = sanPham.Giasanpham;
        HinhanhChitiet = sanPham.Hinhanhsanpham;
        MotaChitiet = sanPham.getMotasanpham();
        Idsanpham = sanPham.getIDSanpham();
        edit_Title.setText(TenChitiet);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        edit_Price.setText("Giá: "+decimalFormat.format(GiaChitiet) + " Đ");
        edit_Title.setText(MotaChitiet);
        String hinhanhsp = "http://"+Server.localhost+HinhanhChitiet;
        Picasso.get().load(hinhanhsp)
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(imageViewChiTiet);

    }*/

    private void AnhXa() {
        edit_Title = findViewById(R.id.edit_Title);
        edit_Price = findViewById(R.id.edit_Price);
        edit_Quantity  = findViewById(R.id.edit_Quantity);
        edit_Desc = findViewById(R.id.edit_Desc);
        imgha = findViewById(R.id.imageViewSach);
        btnchon = findViewById(R.id.btnChonHASach);
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
        snp_loaiSach_adapter = new SNP_LoaiSach_Adapter(EditSanPham.this,R.layout.item_selected,listTypeBook);
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
}