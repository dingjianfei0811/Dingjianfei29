package com.bawei.dingjianfei20191126.bean;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 作者：丁建飞
 * 时间：2019/11/26  14:01
 * 类名：com.bawei.dingjianfei20191126.bean
 */
//工具类
public abstract class BeanActivity extends AppCompatActivity {
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
