package com.bawei.dingjianfei20191126;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.dingjianfei20191126.bean.Bean;
import com.bawei.dingjianfei20191126.bean.NetUtils;

import java.util.List;

/**
 * 作者：丁建飞
 * 时间：2019/11/26  14:46
 * 类名：com.bawei.dingjianfei20191126
 */
public class Myadaptey extends BaseAdapter {
    private List<Bean.ListdataBean> list;

    public Myadaptey(List<Bean.ListdataBean> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        HHaa hHaa;
        if (view==null){
            hHaa=new HHaa() ;
            view=View.inflate(viewGroup.getContext(),R.layout.shiti,null);
            hHaa.img=view.findViewById(R.id.l_img);
            hHaa.name=view.findViewById(R.id.l_name);
            hHaa.name2=view.findViewById(R.id.l_name2);
            view.setTag(hHaa);
        }else {
            hHaa= (HHaa) view.getTag();
        }
        hHaa.name.setText(list.get(i).getContent());
        hHaa.name2.setText(list.get(i).getPublishedAt());
        
        String imageurl = list.get(i).getImageurl();
        NetUtils.getInstance().getimg(imageurl,hHaa.img);

        return view;
    }
    class  HHaa{
        TextView name,name2;
        ImageView img;
    }
}
