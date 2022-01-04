package com.example.shopbansach.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.example.shopbansach.R;
import com.example.shopbansach.fragment.LoaiSachFragment;
import com.example.shopbansach.model.Loaisp;
import com.example.shopbansach.util.Server;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LoaiSachFGAdapter extends BaseAdapter {
    ArrayList<Loaisp> arrayListLoaisp;
    LoaiSachFragment context;

    public LoaiSachFGAdapter(ArrayList<Loaisp> arrayListLoaisp, LoaiSachFragment context) {
        this.arrayListLoaisp = arrayListLoaisp;
        this.context = context;
    }

    @Override
    public int getCount()
    {
        return arrayListLoaisp.size();
    }

    @Override
    public Object getItem(int i)
    {
        return arrayListLoaisp.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    public class ViewHolder{
        TextView txttenloaisanpham;
        ImageView imgloaisp,btnDelete;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        ViewHolder viewHolder= null;
        if(view ==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_lspadmin,null);
            viewHolder.txttenloaisanpham = view.findViewById(R.id.tvLSPAD);
            viewHolder.imgloaisp = view.findViewById(R.id.imgLoaiSPAD);
            viewHolder.btnDelete = view.findViewById(R.id.btnDeleteLSP);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Loaisp loaisp = (Loaisp) getItem(i);
        String hinhanhlsp = "http://"+ Server.localhost+loaisp.getHinhanhloaisp();
        viewHolder.txttenloaisanpham.setText(loaisp.getTenloaisp());
        Picasso.get().load(hinhanhlsp)
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(viewHolder.imgloaisp);
        viewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XacNhanXoa(loaisp.getTenloaisp(),loaisp.getId());
            }
        });

        return view;
    }

    private void XacNhanXoa(String ten,final int id){
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(context.getActivity());
        dialogXoa.setMessage("Bạn có muốn xóa "+ten+" không?");
        dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                context.DeleteLoaiSach(id);
            }
        });
        dialogXoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialogXoa.show();
    }
}
