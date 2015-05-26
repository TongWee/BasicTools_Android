package com.example.administrator.basictools;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Tong on 2015/5/23.
 */
public class ListViewActivity extends Activity{
    private ListView lv_show;
    private String [] titles = {"Beautiful Girls","Hero","Let It Be","UnaMattina","Blue Night",
            "Say It Right","Pretty","Right Here Waiting","The Rose","What Are Words",
            "白日梦蓝","回忆的阁楼","后会无期","泪的告白","寂寞的季节"};
    private String [] abstracts = {"Jona","James","Beatles","Ludovico","Micheal",
            "Nelly Furtado","Jenny","Acoustic","Chris","Landy",
            "Hedgehog","郭静","邓紫棋","吉田亚纪子","陶喆"};
    private String[] times = {
            "4:30","4:16","5:01","4:33","4:29",
            "5:20","4:56","4:26","4:53","4:37",
            "4:38","4:45","5:08","4:31","4:48"
    };
    private int[] ids = {R.drawable.beautifulgirls,R.drawable.hero,R.drawable.letitbe,R.drawable.una,R.drawable.bluenight,
            R.drawable.sayitright,R.drawable.pretty,R.drawable.rightherewaiting,R.drawable.therose,R.drawable.whatareword,
            R.drawable.bairi,R.drawable.huiyid,R.drawable.houhui,R.drawable.leidegao,R.drawable.jimode};
    private MyAdapter myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        lv_show = (ListView)findViewById(R.id.showList);
        myadapter = new MyAdapter();
        lv_show.setAdapter(myadapter);
        lv_show.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv_show.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                myadapter.setSelect(position);
                myadapter.notifyDataSetChanged();
            }
        });
    }
    class MyAdapter extends BaseAdapter {
        private int selected = -1;
        @Override
        //获得绘制次数
        public int getCount(){
            return titles.length;
        }
        public void setSelect(int position){
            this.selected = position;
        }
        @Override
        public Object getItem(int position){
            return lv_show.getItemIdAtPosition(position);
        }
        @Override
        public long getItemId(int position){
            return position;
        }
        @Override
        //
        public View getView(int position,View convertView,ViewGroup list){
            View v;
            LayoutInflater layoutInflater = ListViewActivity.this.getLayoutInflater();
            if(convertView!=null){
                v = convertView;
            }
            else
            {
                v = layoutInflater.inflate(R.layout.layout_list,null);
            }
            GridLayout item = (GridLayout)v.findViewById(R.id.item);
            TextView tv_item_title = (TextView)v.findViewById(R.id.tv_item_title);
            TextView tv_item_abstract = (TextView)v.findViewById(R.id.tv_item_abstract);
            TextView tv_item_date = (TextView)v.findViewById(R.id.tv_item_date);
            ImageView iv_item_pic = (ImageView)v.findViewById(R.id.iv_item_pic);
           // TextView tv_item_arrow = (TextView)v.findViewById(R.id.tv_item_arrow);
            tv_item_title.setText(titles[position]);
            tv_item_abstract.setText(abstracts[position]);
            tv_item_date.setText(times[position]);
            iv_item_pic.setImageResource(ids[position]);
            if(position==selected){
                item.setBackgroundColor(Color.argb(150, 20, 212, 227));
            }
            else {
                item.setBackgroundColor(Color.argb(0,255,255,255));
            }
            return v;
        }
    }

}
