package com.example.shopbansach.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.shopbansach.R;
import com.example.shopbansach.adapter.AllSanphamAdapter;
import com.example.shopbansach.model.Sanpham;
import com.example.shopbansach.util.CheckConnection;
import com.example.shopbansach.util.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DanhmucActivity extends AppCompatActivity {
    Toolbar toolbardm;
    int idsp = 0;
    LinearLayout ln_home,ln_tk,ln_tb,ln_search,ln_dm;
    ListView lvsp;
    AllSanphamAdapter sanphamAdapter;
    ArrayList<Sanpham> mangsp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhmuc);
        AnhXa();
        OnClickMenu();
        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
            ActionToolbar();
            GetData();
        }else {
            CheckConnection.ShowToast_Short(getApplicationContext(),"Hãy kiểm tra lại kết nối Internet");
            finish();
        }

    }

    private void GetData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String duongdan = Server.Duongdanallsp;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, duongdan, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int id = 0;
                String Tensp = "";
                int Giasp;
                String Hinhanhsp="";
                String Motasp="";
                int Idsp=0;
                if(response!=null){
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0;i<jsonArray.length();i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            Tensp = jsonObject.getString("tensp");
                            Giasp = jsonObject.getInt("giasp");
                            Hinhanhsp = jsonObject.getString("hinhanhsp");
                            Motasp = jsonObject.getString("motasp");
                            Idsp = jsonObject.getInt("idsanpham");
                            mangsp.add(new Sanpham(id,Tensp,Giasp,Hinhanhsp,Motasp,Idsp));
                            sanphamAdapter.notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> parram = new HashMap<String,String>();
                parram.put("idSanPham",String.valueOf(idsp));
                return super.getParams();
            }
        };
        requestQueue.add(stringRequest);
    }

    private void AnhXa() {
            toolbardm = findViewById(R.id.toolbardanhmuc);
            lvsp = findViewById(R.id.listviewdanhmuc);
            mangsp = new ArrayList<>();
            sanphamAdapter = new AllSanphamAdapter(getApplicationContext(),mangsp);
            lvsp.setAdapter(sanphamAdapter);
            ln_home = findViewById(R.id.ln_home);
            ln_tk = findViewById(R.id.ln_tk);
            ln_tb = findViewById(R.id.ln_tb);
            ln_dm = findViewById(R.id.ln_dm);
            ln_search = findViewById(R.id.ln_search);

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

    private void ActionToolbar() {
        setSupportActionBar(toolbardm);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbardm.setNavigationIcon(R.drawable.ic_baseline_keyboard_backspace_24);
        toolbardm.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}