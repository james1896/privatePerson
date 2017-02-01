package com.example.toby.test01;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import static android.content.ContentValues.TAG;


/**
 * Created by toby on 02/01/2017.
 */



public class Fragment1 extends Fragment{
    private static Fragment1 fragment1;
    private SecondActivity secondAct;
    private static RecyclerView recyclerview;
    private   MyRecyclerAdapter  recycleAdapter;
    private List<String> mDatas;
    private GridLayoutManager mLayoutManager;



    public static Fragment1 newInstant(){
        if(fragment1 == null){
            fragment1 = new Fragment1();

        }
        return fragment1;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment1, null);

        //init recyclerView
        initData();
        recycleAdapter= new MyRecyclerAdapter(getActivity() , mDatas);
        recyclerview=(RecyclerView)view.findViewById(R.id.grid_recycler);
//        mLayoutManager=new GridLayoutManager(getActivity(),3,GridLayoutManager.VERTICAL,false);//设置为一个3列的纵向网格布局
        View header = inflater.inflate(R.layout.recycler_header, null);
        View footer = inflater.inflate(R.layout.recycler_footer, null);
        recycleAdapter.setHeaderView(header);
        recycleAdapter.setFooterView(footer);
//      设置布局管理器
        recyclerview.setLayoutManager(new GridLayoutManager( getActivity(),MyRecyclerAdapter.ITEM_ROW_COUNT));
        //设置Adapter
        //设置分隔线
        recyclerview.addItemDecoration( new DividerGridItemDecoration(getActivity()));
//       设置增加或删除条目的动画
//       recyclerview.setItemAnimator( new DefaultItemAnimator());
        recyclerview.setAdapter(recycleAdapter);
        recycleAdapter.setOnItemClickListener(new MyRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), SecondActivity.class);
                startActivity(intent);
                //设置切换动画，从右边进入，左边退出
                getActivity().overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
//                overridePendingTransition();
                Toast.makeText(getActivity(),"onClick事件 您点击了第："+position+"个Item",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(int position) {
                Toast.makeText(getActivity(),"onLongClick事件 您点击了第："+position+"个Item",Toast.LENGTH_SHORT).show();
            }
        });

        secondAct = new SecondActivity();
        return view;
    }
    private void initData() {
        mDatas = new ArrayList<String>();
        for ( int i=0; i < 40; i++) {
            mDatas.add( "item"+i);
        }
    }
    @Override
    public void onStart() {
        super.onStart();
//        Log.i(TAG,"onStart1");
    }

    @Override
    public void onResume() {
        super.onResume();
//        Log.i(TAG,"onResume1");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if(isVisibleToUser){

            final String url = "http://www.google.com";

            OkHttpClient okHttpClient = new OkHttpClient();
            final okhttp3.Request request = new okhttp3.Request.Builder()
                    .url(url)
                    .build();
            Call call = okHttpClient.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.e(TAG, "onFailure() e=" + e);
                }
                @Override
                public void onResponse(Call call, final Response response) throws IOException {
                Log.i(TAG, " onResponse() reuslt=" + response.body().string());
                }
            });

        }
        super.setUserVisibleHint(isVisibleToUser);
    }
}
