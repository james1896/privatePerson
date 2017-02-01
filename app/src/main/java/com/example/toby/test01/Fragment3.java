package com.example.toby.test01;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static android.content.ContentValues.TAG;

/**
 * Created by toby on 02/01/2017.
 */

public class Fragment3 extends Fragment {
    private static Fragment3 fragment1;
    public static Fragment3 newInstant(){
        if(fragment1 == null){
            fragment1 = new Fragment3();
        }
        return fragment1;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment3, null);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
//        Log.i(TAG,"onResume3");
    }

    @Override
    public void onStart() {
        super.onStart();
//        Log.i(TAG,"onStart3");
    }
}
