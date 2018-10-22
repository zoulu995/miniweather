package com.example.zouyu.miniweather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SelectCity extends Activity implements View.OnClickListener {
    private ImageView mBackBtn;
    private TextView mTestBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_city);
//        onclick方法要在这里写绑定监听事件
        mBackBtn = (ImageView) findViewById(R.id.title_back);
        mBackBtn.setOnClickListener(this);

        mTestBtn = (TextView) findViewById(R.id.title_name);
        mTestBtn.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.title_back){
            Log.d("myWeather","我点击了返回界面");
            Intent i = new Intent();
            i.putExtra("cityCode", "101160101");
            setResult(RESULT_OK, i);
            finish();
        }

        if(v.getId() == R.id.title_name){
            Log.d("myWeather","我是北京");
        }
    }
}
