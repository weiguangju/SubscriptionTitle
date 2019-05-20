package com.example.wgj.subscriptiontitle;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by wgj on 2019/5/20.
 */

public class TitleLayout extends LinearLayout implements View.OnClickListener{

    private ImageButton backButton;
    private ImageButton settingButton;

    private TextView titleName;

    private String appName = null;

    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title_layout, this);
        backButton = (ImageButton) findViewById(R.id.back_button);
        settingButton = (ImageButton) findViewById(R.id.setting_button);
        titleName = (TextView) findViewById(R.id.title_name);
        backButton.setOnClickListener(this);
        settingButton.setOnClickListener(this);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleLayout);
        appName = typedArray.getString(R.styleable.TitleLayout_appName);
        if (appName == null) {
            appName = "BADU";
        }
        titleName.setText(appName);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                backClick();
                break;
            case R.id.setting_button:
                settingClick();
                break;
            default:
                break;
        }
    }

    public void setTitleName(String appName) {
        this.appName = appName;
        titleName.setText(appName);
    }
    public void backClick() {
        ((Activity) getContext()).finish();
    }

    public void settingClick() {
        Toast.makeText(getContext(), "You click settingButton.", Toast.LENGTH_SHORT).show();
    }
}
