package com.example.administrator.basictools;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class ListViewActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_listview);
            FragmentManager frg_manager = getFragmentManager();
            FragmentTransaction frg_transaction = frg_manager.beginTransaction();
            FragmentList fragmentList = new FragmentList();
            frg_transaction.add(R.id.fragment_list, fragmentList);
            frg_transaction.commit();
        }
}
