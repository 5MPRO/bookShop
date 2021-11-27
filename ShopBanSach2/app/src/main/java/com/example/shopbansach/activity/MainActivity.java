package com.example.shopbansach.activity;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toolbar;
import android.widget.ViewFlipper;

import com.example.shopbansach.R;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    LinearLayout ln_home,ln_tk,ln_tb,ln_search,ln_dm;
    RecyclerView recyclerViewSpkm,recyclerViewSpmn;
    NavigationView navigationView;
    ListView listViewmanhinhchinh;
    DrawerLayout drawerLayout;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}