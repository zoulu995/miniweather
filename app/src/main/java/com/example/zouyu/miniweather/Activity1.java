package com.example.zouyu.miniweather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.NoCopySpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Activity1 extends Activity implements View.OnClickListener {
    private Button mBt;
    private EditText mEd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);

        mBt = (Button) findViewById(R.id.bt1);
        mBt.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("zouyuhang","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("zouyuhang","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("zouyuhang","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("zouyuhang","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("zouyuhang","onDestroy");
    }

    @Override
    public void onClick(View v) {
        if (v.getId()== R.id.bt1){
            Intent i = new Intent();
            i.setClass(Activity1.this,Activity2.class);
            startActivity(i);
        }
    }
}
