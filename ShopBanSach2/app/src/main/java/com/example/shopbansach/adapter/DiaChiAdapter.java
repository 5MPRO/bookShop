package com.example.shopbansach.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shopbansach.R;
import com.example.shopbansach.model.Sanpham;
import com.example.shopbansach.model.diachi;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class DiaChiAdapter extends BaseAdapter {
    ArrayList<diachi> diachiArrayList;
    Context context;

    public DiaChiAdapter(ArrayList<diachi> diachiArrayList, Context context) {
        this.diachiArrayList = diachiArrayList;
        this.context = context;
    }

    public class ViewHolder{
        public TextView txtTenDiaChi ,txtTenNguoiDung, txtDiaChi, txtSoDienThoai;
    }
    @Override
    public int getCount() {
        return diachiArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(view ==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.diachi_item,null);
            viewHolder.txtDiaChi = view.findViewById(R.id.txtDiaChi);
            viewHolder.txtTenDiaChi = view.findViewById(R.id.txtTenDiaChi);
            viewHolder.txtSoDienThoai = view.findViewById(R.id.txtSoDienThoai);
            viewHolder.txtTenNguoiDung = view.findViewById(R.id.txtTenNguoiDung);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }
        diachi diachi = diachiArrayList.get(i);
        viewHolder.txtTenDiaChi.setText(diachi.getTenDiaChi());
        viewHolder.txtDiaChi.setText(diachi.getDiaChi());
        viewHolder.txtTenNguoiDung.setText(diachi.getTenNguoiDung());
        viewHolder.txtSoDienThoai.setText(diachi.getSoDienThoai());
        return view;
    }
}
