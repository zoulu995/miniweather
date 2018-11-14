package com.example.zouyu.miniweather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends Activity implements View.OnClickListener {
    private TextView textView;
    private Button bt;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        bt = (Button) findViewById(R.id.bt2);
        bt.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId()== R.id.bt2){
            this.finish();
        }
    }
}
