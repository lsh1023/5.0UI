package com.lsh.day36_50ui;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CoordinatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);
        FloatingActionButton fab= (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar=Snackbar.make(v,"展示的信息",Snackbar.LENGTH_SHORT);
                     View view=snackbar.getView();
                view.setBackgroundColor(Color.GREEN);
                snackbar.setActionTextColor(Color.RED).setAction("点我", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(CoordinatorActivity.this, "snackbar被点击了", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });
    }
}
