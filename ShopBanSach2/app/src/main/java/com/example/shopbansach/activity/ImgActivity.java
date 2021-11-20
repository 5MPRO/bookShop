package com.example.shopbansach.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.example.shopbansach.R;

import java.util.Collections;

public class ImgActivity extends Activity {
    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);
        tableLayout = (TableLayout) findViewById(R.id.tableLayout);

        int numRow = 2;
        int numColumn = 1;
        Collections.shuffle(MainActivity.arrayBird);
        // tạo dòng và cột
        for(int i = 1 ; i<= numRow; i++){
            TableRow tableRow = new TableRow(this);
            // tạo cột
            for(int j =1;j<= numColumn; j++)
            {
                ImageView imageView = new ImageView(this);
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(200,200);
                imageView.setLayoutParams(layoutParams);
                int vitri = numColumn * (i-1) + j -1;
                int idHinh = getResources().getIdentifier( MainActivity.arrayBird.get(vitri),"drawable",getPackageName());
                imageView.setImageResource(idHinh);

                // add image view vào table row
                tableRow.addView(imageView);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.putExtra("nameHinhSelect",MainActivity.arrayBird.get(vitri));
                        setResult(RESULT_OK,intent);
                        finish();
                    }
                });
            }
            //add tablerow vào table
            tableLayout.addView(tableRow);

        }


    }
}