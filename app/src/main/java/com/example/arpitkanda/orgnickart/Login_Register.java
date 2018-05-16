package com.example.arpitkanda.orgnickart;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login_Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__register);
        ViewPager viewPager=(ViewPager)findViewById(R.id.viewpager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        SampleFragmentPagerAdapter same=new SampleFragmentPagerAdapter(getSupportFragmentManager());
        same.addFragment(new Login(),"Login");
        same.addFragment(new Sign_Up(),"Sing Up");
        viewPager.setAdapter(same);
        tabLayout.setupWithViewPager(viewPager);
    }
}
