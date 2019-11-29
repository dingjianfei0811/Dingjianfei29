package com.bawei.dingjianfei20191126.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bawei.dingjianfei20191126.Myadaptey;
import com.bawei.dingjianfei20191126.R;
import com.bawei.dingjianfei20191126.SecctActivity;
import com.bawei.dingjianfei20191126.bean.Bean;
import com.bawei.dingjianfei20191126.bean.BeanFragment;
import com.bawei.dingjianfei20191126.bean.NetUtils;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;


public class LEft_Fragment extends BeanFragment {
private PullToRefreshListView listView;
private  int pager=1;
private List<Bean.ListdataBean> list=new ArrayList<>();
private ImageView img;

    @Override
    protected void initView(View inflate) {
        listView=inflate.findViewById(R.id.listview);
        img=inflate.findViewById(R.id.aa);
        listView.setMode(PullToRefreshBase.Mode.BOTH);

        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                pager=1;
                list.clear();
                getDate();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                pager++;
                getDate();

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getActivity(), SecctActivity.class);
                intent.putExtra("kk","https://www.thepaper.cn/newsDetail_forward_4923534");
                startActivity(intent);
            }
        });

    }

    private void getDate() {
        String http="";
        if (pager==1){
            http="http://blog.zhaoliang5156.cn/api/pengpainews/pengpai1.json";
        }else   if (pager==2) {
            http = "http://blog.zhaoliang5156.cn/api/pengpainews/pengpai2.json";
        }else {
            http = "http://blog.zhaoliang5156.cn/api/pengpainews/pengpai2.json";
        }
        if (NetUtils.getInstance().haxe(getActivity())){
            NetUtils.getInstance().getjson(http, new NetUtils.Myjson() {
                @Override
                public void myjson(String json) {
                    Log.i("i",json+"");
                    List<Bean.ListdataBean> listdata = new Gson().fromJson(json, Bean.class).getListdata();
                    list.addAll(listdata);
                    Myadaptey myadaptey = new Myadaptey(list);
                    listView.setAdapter(myadaptey);
                    listView.onRefreshComplete();
                }
            });
        }else {
            img.setVisibility(View.VISIBLE);
            listView.setVisibility(View.GONE);
        }



        }

    @Override
    protected int layoutId() {
        return R.layout.fragment_left;
    }

    @Override
    protected void initDate() {
        getDate();
    }


}
