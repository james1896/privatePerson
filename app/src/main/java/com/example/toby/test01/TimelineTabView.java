package com.example.toby.test01;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * Created by toby on 27/01/2017.
 */

public class TimelineTabView extends FrameLayout {

    ImageView mIconIV;

    public TimelineTabView(Context context) {
        super(context);
        init(context);
    }

    public TimelineTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        View v = View.inflate(context, R.layout.view_weibo_timeline_tab, this);
        mIconIV = (ImageView)v.findViewById(R.id.timeline_tab_icon_iv);
    }

    public void setData(int iconResId) {

        mIconIV.setImageResource(iconResId);
    }
}
