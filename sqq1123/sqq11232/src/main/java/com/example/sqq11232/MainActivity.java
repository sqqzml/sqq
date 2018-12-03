package com.example.sqq11232;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sqq11232.fragment.MyFragment;
import com.example.sqq11232.fragment.SpFragment;
import com.example.sqq11232.fragment.WdFragment;

public class MainActivity extends AppCompatActivity {

    private FrameLayout fram;
    private NavigationView nav;
    private DrawerLayout draws;
    private FragmentManager manager;
    private TextView my;
    private TextView sp;
    private TextView wd;
    private MyFragment myFragment;
    private SpFragment spFragment;
    private WdFragment wdFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化数据
        initData();
        initView();
    }

    private void initData() {
        myFragment = new MyFragment();
        spFragment = new SpFragment();
        wdFragment = new WdFragment();
    }

    private void initView() {
        fram = (FrameLayout) findViewById(R.id.fram);
        nav = (NavigationView) findViewById(R.id.nav);
        draws = (DrawerLayout) findViewById(R.id.draws);
        my = findViewById(R.id.my);
        sp = findViewById(R.id.sp);
        wd = findViewById(R.id.wd);
        manager = getSupportFragmentManager();
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.my:
                        manager.beginTransaction().replace(R.id.fram,myFragment).commit();
                        Toast.makeText(MainActivity.this,"这是我的页面",Toast.LENGTH_LONG).show();
                        draws.closeDrawers();
                        break;
                    case R.id.sp:
                        manager.beginTransaction().replace(R.id.fram,spFragment).commit();
                        draws.closeDrawers();
                        break;
                    case R.id.wd:
                        manager.beginTransaction().replace(R.id.fram,wdFragment).commit();
                        draws.closeDrawers();
                        break;
                }
                return false;
            }
        });
 /*       my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"这是我的页面",Toast.LENGTH_LONG).show();
            }
        });*/
    }

}
