package com.example.zouyu.miniweather;

import com.example.zouyu.app.MyApplication;
import com.example.zouyu.bean.City;

import android.app.Activity;
import android.content.Intent;
import android.content.SearchRecentSuggestionsProvider;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectCity extends Activity implements View.OnClickListener {
    //    监听按钮
    private ImageView mBackBtn;
    private TextView mTestBtn;

    // 搜索栏和ListView
    private ListView listView = null;//声名listview对象，用于绑定select_city布局文件中的ListView
    private TextView cityselected = null; //声名TextView对象，用于绑定select_city布局文件中顶部栏的显示内容

    private List<City> listcity = MyApplication.getInstance().getCityList();
    private int listSize = listcity.size();  //建立listcity长度的String[]数组，用于存储要在ListView中展示的内容
    private String[] city = new String[listSize];

    private ArrayList<String> mSearchResult = new ArrayList<>(); //搜索结果
    private Map<String,String> nameToCode = new HashMap<>();//城市名到编码
    private Map<String,String> nameToPinyin = new HashMap<>(); //城市名到拼音

    //搜索功能
    private EditText mSearch;

    String returnCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_city);

//        onclick方法要在这里写绑定监听事件
        mBackBtn = (ImageView) findViewById(R.id.title_back);
        mBackBtn.setOnClickListener(this);

        mTestBtn = (TextView) findViewById(R.id.title_name);
        mTestBtn.setOnClickListener(this);
//        实现ListView对数组的展示
//        listView = new ListView(this);
//        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,getData()));
//        setContentView(listView);
        cityselected = (TextView) findViewById(R.id.title_name);
        Log.i("City", listcity.get(1).getCity());
        for (int i = 0; i < listSize; i++) {
            city[i] = listcity.get(i).getCity();
            Log.d("City", city[i]);
        }

        //建立映射
        String strName;
        String strNamePinyin;
        String strCode;

        for(City city1:listcity){
            strCode = city1.getNumber();
            strName = city1.getCity();
            strNamePinyin = city1.getFirstPY();
            nameToCode.put(strName,strCode);
            nameToPinyin.put(strName,strNamePinyin);
            mSearchResult.add(strName);
        }


        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, mSearchResult);
        listView = findViewById(R.id.list_view);
        listView.setAdapter(arrayAdapter); //设置适配器
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String returnCityName = mSearchResult.get(i);
                Toast.makeText(SelectCity.this, "你已选择：" + returnCityName, Toast.LENGTH_SHORT).show();
//                cityselected.setText("当前城市：" + city[i]);
                returnCode = nameToCode.get(returnCityName);
                Log.d("returncode",returnCode);
                cityselected.setText("当前城市：" + returnCityName);
            }
        });

        mSearch = (EditText)findViewById(R.id.search_edit);
        mSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                arrayAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private List<String> getData() {
        List<String> data = new ArrayList<String>();
        data.add("测试数据1");
        data.add("测试数据2");
        data.add("测试数据3");

        return data;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.title_back) {
            Log.d("myWeather", "我点击了返回界面");
            int position = listView.getCheckedItemPosition();
            String select_cityCode = listcity.get(position).getNumber();
            Intent i = new Intent();
            i.putExtra("cityCode",returnCode );
            setResult(RESULT_OK, i);
            finish();
        }

        if (v.getId() == R.id.title_name) {
            Log.d("myWeather", "我是北京");
        }
    }
}
