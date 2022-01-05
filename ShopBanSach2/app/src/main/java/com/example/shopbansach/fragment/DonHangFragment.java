package com.example.shopbansach.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
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
import com.example.shopbansach.adapter.OderAdapter;
import com.example.shopbansach.adapter.donhangFGAdapter;
import com.example.shopbansach.model.DonHang;
import com.example.shopbansach.util.CheckConnection;
import com.example.shopbansach.util.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DonHangFragment extends Fragment {
    private View view;
    ListView listView;
    ArrayList<DonHang> donHangArrayList;
    donhangFGAdapter oderAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_donhang,container,false);
        AnhXa();
        GetDonHang();
        return view;
    }

    public void UpdateDonHang(String maDonHang){
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Duongdanupdatedh, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){
                    //CheckConnection.ShowToast_Short(getActivity(),"Update thành công");
                    GetDonHang();
                }else {
                    CheckConnection.ShowToast_Short(getActivity(),"Update không thành công");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnection.ShowToast_Short(getActivity(),"Update không thành công");
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("maDonHang",String.valueOf(maDonHang));
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void GetDonHang() {
        donHangArrayList.clear();
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Server.DuongdangetdonhangAD,null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response){
                        for (int i = 0;i < response.length();i++){
                            String txtOrderName,txtTotal, txtQuantity, txtStatus;
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                String MaDH = "";
                                MaDH = jsonObject.getString("maDonHang");
                                txtOrderName = jsonObject.getString("tenSanPham");
                                txtTotal   =(jsonObject.getString("tongtien"));
                                txtQuantity = (jsonObject.getString("soLuongSanPham"));
                                txtStatus = (jsonObject.getString("trangThai"));
                                donHangArrayList.add(new DonHang(MaDH,txtOrderName,txtQuantity,txtStatus,txtTotal));
                                oderAdapter.notifyDataSetChanged();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }}
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(),error.toString(),Toast.LENGTH_SHORT).show();

                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }

    private void AnhXa() {

        donHangArrayList = new ArrayList<>();
        oderAdapter = new donhangFGAdapter (DonHangFragment.this,donHangArrayList);
        listView = view.findViewById(R.id.lvDonHang);
        listView.setAdapter(oderAdapter);
    }
}
