package com.feicui.news.everydaynews;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mToggle;
    ArrayList<BeanTools> mList;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout= (DrawerLayout) findViewById(R.id.root);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        String path="http://c.m.163.com/nc/article/headline/T1348647909107/0-20.html";
        mList=new ArrayList<>();
        mListView= (ListView) findViewById(R.id.listview);
        new Thread(){
            @Override
            public void run() {
                super.run();

            }
        }.start();
    }
    public void parseJson(String s) throws JSONException {
        JSONObject object=new JSONObject(s);
        JSONArray array=object.getJSONArray("T1348647909107");
        for (int i = 0; i <array.length() ; i++) {
            JSONObject jsonobject=array.getJSONObject(i);
            String title=jsonobject.getString("title");
            String imasrc=jsonobject.getString("imasrc");
            BeanTools beanTools=new BeanTools(title,imasrc);
            mList.add(beanTools);
        }
    }
}
