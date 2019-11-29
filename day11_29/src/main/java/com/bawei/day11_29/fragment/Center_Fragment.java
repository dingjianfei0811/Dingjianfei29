package com.bawei.day11_29.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.bawei.day11_29.MainActivity;
import com.bawei.day11_29.R;
import com.bawei.day11_29.beas.BeanFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class Center_Fragment extends BeanFragment {
    private Button button;
private RelativeLayout center;

    @Override
    protected void initView(View inflate) {
    button=inflate.findViewById(R.id.tiao) ;
    center=inflate.findViewById(R.id.cente);


    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_center_;
    }

    @Override
    protected void initDate() {
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                //丁建飞 11.29作业
//                FragmentManager ss = getActivity().getSupportFragmentManager();
//                Right_Fragment right_fragment = new Right_Fragment();
//
//                ss.beginTransaction().replace(R.id.cente,right_fragment).commit();
//        button.setVisibility(View.GONE);
       MainActivity aa= (MainActivity)getActivity();
                aa.acc();

            }
        });



    }

}
