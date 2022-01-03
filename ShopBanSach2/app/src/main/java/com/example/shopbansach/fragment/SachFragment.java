package com.example.shopbansach.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.shopbansach.R;
import com.example.shopbansach.activity.ThemSach;
import com.example.shopbansach.activity.ThemTheLoaiSach;
import com.example.shopbansach.adapter.AllSanphamAdapter;
import com.example.shopbansach.adapter.LoaiSachFGAdapter;
import com.example.shopbansach.adapter.SachFGAdapter;
import com.example.shopbansach.model.Loaisp;
import com.example.shopbansach.model.Sanpham;
import com.example.shopbansach.util.CheckConnection;
import com.example.shopbansach.util.Server;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SachFragment extends Fragment {
    private View view;

    private ListView lvLoaiSach;
    private FloatingActionButton btnThem;

    SachFGAdapter sanphamAdapter;
    ArrayList<Sanpham> mangsp;

    int idsp = 0;
    private String tenLoaiSp="";
    private String hinhAnhLoai="";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sach,container,false);
        AnhXa();
        GetData();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ThemSach.class);
                startActivity(intent);
            }
        });
        return view;
    }

    private void GetData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
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
                if(response!=null && response.length() != 2){

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
                else {

                    CheckConnection.ShowToast_Short(getActivity(),"Đã hết dữ liệu");
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
        lvLoaiSach = view.findViewById(R.id.lvLoaiSach);
        mangsp = new ArrayList<>();
        sanphamAdapter = new SachFGAdapter(SachFragment.this, mangsp);
        lvLoaiSach.setAdapter(sanphamAdapter);
        btnThem = view.findViewById(R.id.btnAddBook);
    }

    @Override
    public void onResume() {
        GetData();
        super.onResume();
    }
}
