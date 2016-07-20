package com.lsh.complexui;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_detail);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.tool_detail);
        ImageView ivDetail = (ImageView) findViewById(R.id.iv_detail);
        CollapsingToolbarLayout mCollapseLayout = (CollapsingToolbarLayout) findViewById(R.id.collapse_layout);

        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        String logoName=intent.getStringExtra("logo");
        int mipmap=getResources().getIdentifier(logoName,"mipmap",getPackageName());

        mToolbar.inflateMenu(R.menu.main);
        mToolbar.setOverflowIcon(getResources().getDrawable(R.mipmap.ic_menu_more_overflow));

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //设置头部图片
        ivDetail.setImageResource(mipmap);
        //设置标题
        mCollapseLayout.setTitle(name);
        //设置展开时的标题颜色
        mCollapseLayout.setExpandedTitleColor(Color.GRAY);
        //设置折叠时的标题颜色
        mCollapseLayout.setCollapsedTitleTextColor(Color.WHITE);
    }
}
