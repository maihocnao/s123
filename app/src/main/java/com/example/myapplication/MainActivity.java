package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout ;
    private ViewPager2 viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = new MainActivity();
        mTabLayout = findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.view_pager);
        myViewPagerAdapter = new MyViewPagerAdapter(this);
        viewPager.setAdapter(myViewPagerAdapter);
        new TabLayoutMediator(mTabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0: tab.setText("Current");
                    //    mTabLayout.setSelectedTabIndicatorColor(Color.parseColor("727272"));

                           mTabLayout.setSelectedTabIndicatorColor(Color.parseColor("#F78F1E"));
                         mTabLayout.setTabTextColors(Color.parseColor("#A9A9A9"), Color.parseColor("#F78F1E"));

                            break;
                    case 1: tab.setText("Incoming");   mTabLayout.setSelectedTabIndicatorColor(Color.parseColor("#F78F1E"));
                        mTabLayout.setTabTextColors(Color.parseColor("#A9A9A9"), Color.parseColor("#F78F1E"));
                        break;
                    case 2: tab.setText("Ended");   mTabLayout.setSelectedTabIndicatorColor(Color.parseColor("#F78F1E"));
                        mTabLayout.setTabTextColors(Color.parseColor("#A9A9A9"), Color.parseColor("#F78F1E"));
                        break;
                }
            }
        }).attach();
    }
}