package com.bawei.dingjianfei20191126.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.dingjianfei20191126.R;
import com.bawei.dingjianfei20191126.bean.BeanFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class Center_Fragment extends BeanFragment {
    private TextView name;
    @Override
    protected void initView(View inflate) {
        name=inflate.findViewById(R.id.c_name);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_center;
    }

    @Override
    protected void initDate() {
        String key = getArguments().getString("key");
        name.setText(key);
    }

    public static Center_Fragment getInstance(String vv) {
        Center_Fragment center_fragment = new Center_Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("key",vv);
        center_fragment.setArguments(bundle);
        return center_fragment;
    }
}
