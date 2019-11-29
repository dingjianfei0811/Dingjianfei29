package com.bawei.dingjianfei20191126.bean;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 作者：丁建飞
 * 时间：2019/11/26  14:02
 * 类名：com.bawei.dingjianfei20191126.bean
 */

//工具类
public abstract class BeanFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(layoutId(), null);
        initView(inflate);
        return inflate;
    }

    protected abstract void initView(View inflate);
    protected abstract int layoutId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDate();

    }

    protected abstract void initDate();
}
