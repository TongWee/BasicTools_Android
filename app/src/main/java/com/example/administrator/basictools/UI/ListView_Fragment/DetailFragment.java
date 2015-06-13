package com.example.administrator.basictools.UI.ListView_Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.basictools.R;

/**
 * Created by Tong on 2015/6/6.
 */
public class DetailFragment extends Fragment {
    private TextView _title;
    private TextView _abstract;
    private TextView _time;
    private ImageView _pic;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail,null);
        _title =(TextView)view.findViewById(R.id.detail_title);
        _abstract =(TextView)view.findViewById(R.id.detail_abstract);
        _time =(TextView)view.findViewById(R.id.detail_time);
        _pic =(ImageView)view.findViewById(R.id.detail_pic);
        Bundle bundle = getArguments();
        _title.setText(bundle.getString("title"));
        _abstract.setText(bundle.getString("abstract"));
        _time.setText(bundle.getString("time"));
        _pic.setImageResource(bundle.getInt("pic"));
        return view;
    }
}
