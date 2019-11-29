package com.bawei.dingjianfei20191126;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.bawei.dingjianfei20191126.bean.BeanActivity;
import com.bawei.dingjianfei20191126.fragment.Center_Fragment;
import com.bawei.dingjianfei20191126.fragment.LEft_Fragment;
import com.google.android.material.tabs.TabLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BeanActivity {
    //丁建飞  11.29添加一行代码

    private ImageView img;
    private TabLayout tab;
    private ViewPager viewPager;
    private List<String> title = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void initDate() {

    }

    @Override
    protected void initView() {
        img = findViewById(R.id.img);
        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewpager);

        title.add("实时");
        title.add("要闻");
        title.add("推荐");
        title.add("视频");
        title.add("财经");


        LEft_Fragment lEft_fragment = new LEft_Fragment();
        fragmentList.add(lEft_fragment);
        Center_Fragment cc = Center_Fragment.getInstance("要闻");
        fragmentList.add(cc);
        Center_Fragment cc2 = Center_Fragment.getInstance("推荐");
        fragmentList.add(cc2);
        Center_Fragment cc3 = Center_Fragment.getInstance("视频");
        fragmentList.add(cc3);
        Center_Fragment cc4 = Center_Fragment.getInstance("财经");
        fragmentList.add(cc4);

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return title.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });
        tab.setupWithViewPager(viewPager);

//图片
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,10);
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri data1 = data.getData();
        if (requestCode==10&&resultCode==-1){
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), data1);
                img.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
