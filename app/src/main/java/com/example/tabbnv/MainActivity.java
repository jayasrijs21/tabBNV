package com.example.tabbnv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnv;

    WaterFragment waterFragment= new WaterFragment();
    FireFragment fireFragment = new FireFragment();
    AirFragment airFragment = new AirFragment();

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    MyAdapter myAdapter;

    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnv = findViewById(R.id.bottom_nav);
        frameLayout= findViewById(R.id.container);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.ViewPager);
        myAdapter = new MyAdapter(this);
        viewPager2.setAdapter(myAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setVisibility(View.VISIBLE);
                frameLayout.setVisibility(View.GONE);

                viewPager2.setCurrentItem(tab.getPosition());


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

                viewPager2.setVisibility(View.VISIBLE);
                frameLayout.setVisibility(View.GONE);

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });



       //getSupportFragmentManager().beginTransaction()
              // .replace(R.id.container , waterFragment).commit();



        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                viewPager2.setVisibility(View.GONE);
                frameLayout.setVisibility(View.VISIBLE);


                switch (item.getItemId()) {
                    case R.id.water: {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container , waterFragment).commit();
                        return true;

                    }
                    case R.id.fire: {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container , fireFragment).commit();
                        return true;

                    }
                    case R.id.air: {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container , airFragment).commit();
                        return true;

                    }

                }
                return false;
            }
        });






    }
}