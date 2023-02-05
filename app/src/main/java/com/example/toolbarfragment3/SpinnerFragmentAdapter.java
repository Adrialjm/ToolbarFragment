package com.example.toolbarfragment3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.List;

public class SpinnerFragmentAdapter extends BaseAdapter {
    private final List<Fragment> fragments;
    private final Context context;
    private final FragmentManager fragmentManager;

    public SpinnerFragmentAdapter(Context context, List<Fragment> fragments, FragmentManager fragmentManager) {
        this.context = context;
        this.fragments = fragments;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Object getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.spinner_item, parent, false);

        TextView textView = view.findViewById(R.id.spinner_item_text);
        switch (position) {
            case 0:
                textView.setText("Menu");
                break;
            case 1:
                textView.setText("Alfa");
                break;
            case 2:
                textView.setText("Beta");
                break;
            case 3:
                textView.setText("Gamma");
                break;
            case 4:
                textView.setText("Delta");
                break;
            case 5:
                textView.setText("Epsilon");
                break;
            case 6:
                textView.setText("Zeta");
                break;
            case 7:
                textView.setText("Eta");
                break;
        }
        return view;
    }


    public void changeFragment(int position) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragments.get(position));
        transaction.commit();
    }
}
