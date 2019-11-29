package com.bawei.day11_29.beas;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 作者：丁建飞
 * 时间：2019/11/29  18:51
 * 类名：com.bawei.day11_29.beas
 */
public abstract class BeanActivit extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        initView();
        initDate();
    }

    protected abstract void initDate();

    protected abstract void initView();

    protected abstract int layoutId();

}
