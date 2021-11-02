package com.example.shopbansach.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shopbansach.R;
import com.example.shopbansach.model.Loaisp;
import com.example.shopbansach.model.TaiKhoan;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TaikhoanAdapter extends BaseAdapter {
    Context context;
    ArrayList<TaiKhoan> arrayTaiKhoan;

    public TaikhoanAdapter(Context context, ArrayList<TaiKhoan> arrayTaiKhoan) {
        this.context = context;
        this.arrayTaiKhoan = arrayTaiKhoan;
    }

    public class ViewHolder{
        TextView tvtenkh;
        TextView tvemail;

    }

    @Override
    public int getCount() {
        return arrayTaiKhoan.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayTaiKhoan.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
