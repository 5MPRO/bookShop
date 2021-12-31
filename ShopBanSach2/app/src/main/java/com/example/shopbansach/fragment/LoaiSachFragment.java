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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.shopbansach.R;
import com.example.shopbansach.activity.ThemTheLoaiSach;
import com.example.shopbansach.adapter.LoaiSachFGAdapter;
import com.example.shopbansach.model.Loaisp;
import com.example.shopbansach.util.CheckConnection;
import com.example.shopbansach.util.Server;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LoaiSachFragment extends Fragment {
    private View view;
    private ListView lvLoaiSach;
    private FloatingActionButton btnThem;
    private LoaiSachFGAdapter keSachAdapter;
    private ArrayList<Loaisp> arrayListKeSach;
    private int id=0;
    private String tenLoaiSp="";
    private String hinhAnhLoai="";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_loaisach,container,false);
        AnhXa();
        GetDuLieuLoaiSP();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ThemTheLoaiSach.class);
                startActivity(intent);
            }
        });
        return view;
    }

    private void GetDuLieuLoaiSP() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.Duongdanloaisp, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                if (response != null){

                    for (int i = 0;i < response.length();i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            tenLoaiSp = jsonObject.getString("tenloaisp");
                            hinhAnhLoai = jsonObject.getString("hinhanhloaisp");
                            arrayListKeSach.add(new Loaisp(id,tenLoaiSp,hinhAnhLoai));
                            keSachAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnection.ShowToast_Short(getActivity(),error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
        lvLoaiSach.setAdapter(keSachAdapter);
    }

    private void AnhXa() {
        lvLoaiSach = view.findViewById(R.id.lvLoaiSach);
        arrayListKeSach = new ArrayList<>();
        keSachAdapter = new LoaiSachFGAdapter(arrayListKeSach,LoaiSachFragment.this);
        btnThem = view.findViewById(R.id.btnThemLoaiSach);
    }
}