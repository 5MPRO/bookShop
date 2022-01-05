package com.example.shopbansach.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.shopbansach.R;
import com.example.shopbansach.activity.EditLoaiSP;
import com.example.shopbansach.fragment.SachFragment;
import com.example.shopbansach.model.Sanpham;
import com.example.shopbansach.util.CheckConnection;
import com.example.shopbansach.util.Server;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SachFGAdapter extends BaseAdapter {

    SachFragment context;
    ArrayList<Sanpham> arraysanpham;

    public SachFGAdapter(SachFragment context, ArrayList<Sanpham> arraysanpham) {
        this.context = context;
        this.arraysanpham = arraysanpham;
    }

    @Override
    public int getCount() {
        return arraysanpham.size();
    }

    @Override
    public Object getItem(int i) {
        return arraysanpham.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class ViewHolder{
        public TextView txttensanpham,txtgiasanpham,txtmotasanpham;
        public ImageView imgsanpham;
        public ImageButton btnDelete,btnEdit;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view ==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_sanphamad,null);
            viewHolder.txttensanpham = view.findViewById(R.id.tvSanPhamAD);
            viewHolder.txtgiasanpham = view.findViewById(R.id.tvGiaSPAD);
            viewHolder.txtmotasanpham = view.findViewById(R.id.tvMTaSPAD);
            viewHolder.imgsanpham = view.findViewById(R.id.imgSPAD);
            viewHolder.btnDelete = view.findViewById(R.id.IBDeleteSP);
            /*viewHolder.btnEdit = view.findViewById(R.id.IBEditSP);*/
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Sanpham sanpham = (Sanpham) getItem(i);
        viewHolder.txttensanpham.setText(sanpham.getTensanpham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtgiasanpham.setText("Giá: "+decimalFormat.format(sanpham.getGiasanpham())+" Đ");
        viewHolder.txtmotasanpham.setMaxLines(2);
        viewHolder.txtmotasanpham.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtmotasanpham.setText(sanpham.getMotasanpham());
        String hinhanhsp = "http://"+ Server.localhost+sanpham.getHinhanhsanpham();
        Picasso.get().load(hinhanhsp)
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(viewHolder.imgsanpham);
        viewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XacNhanXoa(sanpham.getTensanpham(),sanpham.getID());
            }
        });
        /*viewHolder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getActivity(), EditLoaiSP.class);
                intent.putExtra("thongtinsp",arraysanpham.get(i));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                CheckConnection.ShowToast_Short(context.getActivity(),arraysanpham.get(i).getTensanpham());
                context.startActivity(intent);
            }
        });*/
        return view;
    }

    private void XacNhanXoa(String ten,final int id){
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(context.getActivity());
        dialogXoa.setMessage("Bạn có muốn xóa "+ten+" không?");
        dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                context.DeleteSach(id);
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
