package com.example.administrator.basictools.UI;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

import com.example.administrator.basictools.R;
import com.example.administrator.basictools.UI.ListView_Fragment.FragmentList;

public class ListViewActivity extends Activity{
    private FragmentManager frg_manager;
    private FragmentTransaction frg_transaction;
    private FragmentList fragmentList;
    private long exitTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_listview);
        frg_manager= getFragmentManager();
        frg_transaction = frg_manager.beginTransaction();
        fragmentList = new FragmentList();
        frg_transaction.add(R.id.left, fragmentList);
        frg_transaction.commit();
    }
    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount()!=0&&(this.getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT))
        {

           fragmentList = new FragmentList();
           frg_transaction = getFragmentManager().beginTransaction();
           frg_transaction.replace(R.id.left,this.fragmentList);
           frg_transaction.commit();
        }
        else
        {
            if (System.currentTimeMillis() - exitTime > 1000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
            }
        }
    }
}
