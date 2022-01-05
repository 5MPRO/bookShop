package com.example.shopbansach.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.example.shopbansach.R;
import com.example.shopbansach.activity.DonHangActivity;
import com.example.shopbansach.model.DonHang;
import com.example.shopbansach.model.ThongBao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class OderAdapter extends BaseAdapter {
    DonHangActivity context;
    List<DonHang> donHangList;

    public OderAdapter(DonHangActivity context,ArrayList<DonHang> listtb) {
        this.context = context;
        this.donHangList = listtb;
    }

    @Override
    public int getCount() {
        return donHangList.size();
    }

    @Override
    public Object getItem(int i) {
        return donHangList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class ViewHolder{
        TextView txtOrderName,txtTotal, txtQuantity, txtStatus;
        Button btnHuyDH;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.order_item,null);
            viewHolder.txtOrderName = view.findViewById(R.id.txtOrderName);
            viewHolder.txtTotal = view.findViewById(R.id.txtTotal);
            viewHolder.txtQuantity = view.findViewById(R.id.txtQuantity);
            viewHolder.txtStatus = view.findViewById(R.id.txtStatus);
            viewHolder.btnHuyDH = view.findViewById(R.id.btnHuyDonHang);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }
        DonHang donHang = donHangList.get(i);
        viewHolder.txtOrderName.setText(donHang.getOrderName());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtTotal.setText(decimalFormat.format(Integer.parseInt(donHang.getTotal()))+" VNĐ");
        viewHolder.txtQuantity.setText(donHang.getQuantity());
        viewHolder.txtStatus.setText(donHang.getStatus());
        if(donHang.getStatus().contains("Đã duyệt")||donHang.getStatus().contains("Đã hủy")){
            viewHolder.btnHuyDH.setEnabled(false);
            viewHolder.btnHuyDH.setBackgroundColor(Color.parseColor("#c1c1c1"));
        }
        else {
            viewHolder.btnHuyDH.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    XacNhanHuy(donHang.getOrderName(), donHang.getMaDH());
                }
            });
        }
        return view;
    }

    private void XacNhanHuy(String ten,final String maDonHang){
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(context);
        dialogXoa.setMessage("Bạn có muốn xác nhận duyệt đơn hàng "+ten+" không?");
        dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                context.UpdateDonHangUS(maDonHang);
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
