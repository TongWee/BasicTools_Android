package com.example.administrator.basictools.UI.ListView_Fragment;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.basictools.R;

/**
 * Created by Tong on 2015/5/31.
 */
public class FragmentList extends ListFragment {
    private MyAdapter myadapter;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private String [] titles = {"Beautiful Girls","Hero","Let It Be","UnaMattina","Blue Night",
            "Say It Right","Pretty","Right Here Waiting","The Rose","What Are Words",
            "白日梦蓝","回忆的阁楼","后会无期","泪的告白","寂寞的季节"};
    private String [] abstracts = {"Jona","James","Beatles","Ludovico","Micheal",
            "Nelly Furtado","Jenny","Acoustic","Chris","Landy",
            "Hedgehog","郭静","邓紫棋","吉田亚纪子","陶喆"};
    private String[] times = {
            "4:30","4:16","5:01","4:33","4:29",
            "5:20","4:56","4:26","4:53","4:37",
            "4:38","4:45","5:08","4:31","4:48"};
    private int[] ids = {R.drawable.beautifulgirls,R.drawable.hero,R.drawable.letitbe,R.drawable.una,R.drawable.bluenight,
            R.drawable.sayitright,R.drawable.pretty,R.drawable.rightherewaiting,R.drawable.therose,R.drawable.whatareword,
            R.drawable.bairi,R.drawable.huiyid,R.drawable.houhui,R.drawable.leidegao,R.drawable.jimode};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myadapter = new MyAdapter(getActivity());
        setListAdapter(myadapter);
        fragmentManager = getFragmentManager();
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        myadapter.setSelect(position);
        myadapter.notifyDataSetChanged();
        fragmentTransaction = fragmentManager.beginTransaction();
        DetailFragment detailFragment = new DetailFragment();

        Bundle bundle = new Bundle();
        bundle.putString("title",titles[position]);
        bundle.putString("abstract",abstracts[position]);
        bundle.putString("time",times[position]);
        bundle.putInt("pic",ids[position]);

        detailFragment.setArguments(bundle);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        if(this.getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT)
            fragmentTransaction.replace(R.id.left,detailFragment);
        else
            fragmentTransaction.replace(R.id.right,detailFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    static class ViewHolder{
        public GridLayout _item;
        public TextView _title;
        public TextView _abstract;
        public TextView _date;
        public ImageView _pic;
    }
    class MyAdapter extends BaseAdapter{
        private int selected = -1;
        private LayoutInflater inflater = null;
        public MyAdapter(Context context){
            super();
            inflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return titles.length;
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        public void setSelect(int position){this.selected = position;}
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if(convertView==null)
            {
                viewHolder = new ViewHolder();
                convertView = inflater.inflate(R.layout.layout_list,null);
                viewHolder._item = (GridLayout)convertView.findViewById(R.id.item);
                viewHolder._title = (TextView)convertView.findViewById(R.id.tv_item_title);
                viewHolder._abstract = (TextView)convertView.findViewById(R.id.tv_item_abstract);
                viewHolder._date = (TextView)convertView.findViewById(R.id.tv_item_date);
                viewHolder._pic = (ImageView)convertView.findViewById(R.id.iv_item_pic);
                convertView.setTag(viewHolder);
            }
            else
            {
                viewHolder = (ViewHolder)convertView.getTag();
            }
            viewHolder._title.setText(titles[position]);
            viewHolder._abstract.setText(abstracts[position]);
            viewHolder._date.setText(times[position]);
            viewHolder._pic.setImageResource(ids[position]);
            if(position==selected)
            {
                viewHolder._item.setBackgroundColor(Color.argb(150, 20, 212, 227));
            }
            else
            {
                viewHolder._item.setBackgroundColor(Color.argb(0,255,255,255));
            }
            return convertView;
        }
    }
}
