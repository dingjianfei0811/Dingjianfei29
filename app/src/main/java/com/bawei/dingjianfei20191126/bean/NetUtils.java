package com.bawei.dingjianfei20191126.bean;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 作者：丁建飞
 * 时间：2019/11/26  14:03
 * 类名：com.bawei.dingjianfei20191126.bean
 */
//单例模式
public class NetUtils {
    private  static  NetUtils netUtils=new NetUtils();

    private NetUtils() {
    };

    public static NetUtils getInstance() {
        return netUtils;
    }
//sss判断是否有网
    public  boolean haxe(Context context){
        ConnectivityManager systemService = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = systemService.getActiveNetworkInfo();
        if (activeNetworkInfo != null&&activeNetworkInfo.isAvailable()) {
            return true;
        }else {
            return false;
        }
    }

    public  interface  Myjson{
        void myjson(String json);
    }

    //请求数据
    @SuppressLint("StaticFieldLeak")
    public  void  getjson(final String http, final Myjson myjson){
        new AsyncTask<Void, Void, String>() {
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                myjson.myjson(s);
            }

            @Override
            protected String doInBackground(Void... voids) {
                InputStream inputStream = null;
                String s = null;
                try {
                    URL url=new URL(http);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode()==200){
                      inputStream = httpURLConnection.getInputStream();
                         s = io2String(inputStream);
                    }else {
                        Log.i("i","联网失败");
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (inputStream!=null){
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                return s;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    private String io2String(InputStream inputStream) throws IOException {
        int len=-1;
        byte[] bytes=new byte[1024];
        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        while ((len=inputStream.read(bytes))!=-1){
            stream.write(bytes,0,len);
        }
        byte[] bytes1 = stream.toByteArray();
        String s = new String(bytes1);

        return s;
    }


    //请求图片
    @SuppressLint("StaticFieldLeak")
    public  void getimg(final String httpimg, final ImageView imageView){
        new AsyncTask<Void, Void, Bitmap>() {
            @Override
            protected void onPostExecute(Bitmap bitmap) {
                super.onPostExecute(bitmap);
                imageView.setImageBitmap(bitmap);
            }

            @Override
            protected Bitmap doInBackground(Void... voids) {
                InputStream inputStream = null;
                Bitmap s = null;
                try {
                    URL url=new URL(httpimg);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode()==200){
                        inputStream = httpURLConnection.getInputStream();
                        s = io2Bitamp(inputStream);
                    }else {
                        Log.i("i","联网失败");
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (inputStream!=null){
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                return s;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    private Bitmap io2Bitamp(InputStream inputStream) {
        return BitmapFactory.decodeStream(inputStream);
    }

}
