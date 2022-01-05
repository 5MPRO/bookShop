package com.example.shopbansach.adapter;


import static com.example.shopbansach.activity.ThemSach.idTypeBook;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.shopbansach.R;
import com.example.shopbansach.model.Loaisp;

import java.util.List;

public class SNP_LoaiSach_Adapter extends ArrayAdapter<Loaisp> {

    public SNP_LoaiSach_Adapter(@NonNull Context context, int resource, @NonNull List<Loaisp> objects) {

        super(context, resource, objects);
    }

    @NonNull
@Override
public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_selected,parent,false);
        TextView txt_select = convertView.findViewById(R.id.txt_select);
        Loaisp loaisp = this.getItem(position);
        if(loaisp!=null){
            idTypeBook = loaisp.getId();
            txt_select.setText(loaisp.getTenloaisp());
        }
        return convertView;
        }

@Override
public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_inner_spn,parent,false);
        TextView txtRecipients =convertView.findViewById(R.id.txtRecipients);
            Loaisp loaisp = this.getItem(position);
        if(loaisp!=null){
            idTypeBook = loaisp.getId();
            txtRecipients.setText(loaisp.getTenloaisp());
        }
        return convertView;
        }
}
