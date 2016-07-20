package com.lsh.day36_50ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void coord(View view) {
        startActivity(new Intent(MainActivity.this,CoordinatorActivity.class));
    }

    public void textInputLayout(View view) {
        startActivity(new Intent(MainActivity.this,TextInputLayoutActivity.class));
    }
}
