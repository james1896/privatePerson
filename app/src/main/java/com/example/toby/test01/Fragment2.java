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

public class Fragment2 extends Fragment {
    private static Fragment2 fragment1;
    public static Fragment2 newInstant(){
        if(fragment1 == null){
            fragment1 = new Fragment2();
        }
        return fragment1;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment2, null);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
//        Log.i(TAG,"onResume2");
    }

    @Override
    public void onStart() {
        super.onStart();
//        Log.i(TAG,"onStart2");
    }
}
