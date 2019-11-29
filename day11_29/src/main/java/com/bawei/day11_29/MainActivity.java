package com.bawei.day11_29;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.bawei.day11_29.beas.BeanActivit;
import com.bawei.day11_29.fragment.Center_Fragment;
import com.bawei.day11_29.fragment.Left_Fragment;
import com.bawei.day11_29.fragment.Right_Fragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BeanActivit {
private ViewPager viewPager;
private List<Fragment> list=new ArrayList<>();
    @Override
    protected void initDate() {

    }

    @Override
    protected void initView() {
    viewPager=findViewById(R.id.viewpager);

        Left_Fragment left_fragment = new Left_Fragment();
        list.add(left_fragment);
        Center_Fragment center_fragment = new Center_Fragment();
        list.add(center_fragment);
        Right_Fragment right_fragment = new Right_Fragment();
        list.add(right_fragment);

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        viewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });




    }

    public void acc(){
        viewPager.setCurrentItem(2);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }
}
