package com.lsh.complexui;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolBar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private FloatingActionButton fabButton;
    private String[] tabNames;
    private DrawerLayout mDrawer;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除标题
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.home_layout);

        initView();

        //处理ToolBar
        mToolBar.inflateMenu(R.menu.main);
        //设置溢出菜单的图标
        mToolBar.setOverflowIcon(getResources().getDrawable(R.mipmap.ic_menu_more_overflow));
        //Home菜单的点击事件
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mDrawer.isDrawerOpen(Gravity.LEFT)) {
                    mDrawer.openDrawer(Gravity.LEFT);
                }
            }
        });
        tabNames=getResources().getStringArray(R.array.tab_names);

        //设置TabLayout
        //添加导航标签
        //mTabLayout.addTab(mTabLayout.newTab().setText("军事"));

        //处理ViewPager
        mViewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));

        //true:自动刷新。当ViewPager中的内容发生改变，会自动刷新界面
        mTabLayout.setupWithViewPager(mViewPager,true);
        //设置tab模式
        //mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        //设置tab的文本颜色
        mTabLayout.setTabTextColors(Color.WHITE,Color.RED);
        //设置指示器的颜色
        mTabLayout.setSelectedTabIndicatorColor(Color.GREEN);
        //设置指示器的高度
        mTabLayout.setSelectedTabIndicatorHeight(4);

        //设置FloatingActionButton
        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"看美女",Snackbar.LENGTH_SHORT).setAction("点", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "美女", Toast.LENGTH_SHORT).show();
                    }
                }).show();

            }
        });

       // NavigationView的监听方法
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                //mDrawer.closeDrawer(Gravity.LEFT);
                mDrawer.closeDrawers();
                return true;
            }
        });
    }

    private void initView() {
        mToolBar = (Toolbar) findViewById(R.id.tool_bar);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        fabButton = (FloatingActionButton) findViewById(R.id.floating_button);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_View);
    }

    //设置适配器
    class MyViewPagerAdapter extends FragmentPagerAdapter{

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return FragmentFactory.createFragment(position,tabNames[position]);
        }

        @Override
        public int getCount() {
            return tabNames.length;
        }

        //导航标题名称
        @Override
        public CharSequence getPageTitle(int position) {
            return tabNames[position];
        }
    }

}
