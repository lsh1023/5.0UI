package com.lsh.day36_50ui;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TextInputLayoutActivity extends AppCompatActivity {

    private TextInputLayout tilName;
    private EditText etName;
    TextInputEditText et_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input_layout);

        tilName = (TextInputLayout) findViewById(R.id.til);
        etName = (EditText) findViewById(R.id.et_name);
        et_pass = (TextInputEditText) findViewById(R.id.et_pass);

        tilName.setHint("请输入你的姓名");


    }

    public void login(View view) {
        String name = etName.getText().toString().trim();
        if ("aaa".equals(name)) {
            //错误检查功能可用
            tilName.setErrorEnabled(true);
            //设置错误提示信息
            tilName.setError("输入错误");
        } else {
            tilName.setErrorEnabled(false);
        }

        String pass=et_pass.getText().toString().trim();
        if ("123".equals(pass)){
            et_pass.setError("输入错误");
        }

    }
}
