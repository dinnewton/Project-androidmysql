package com.kennedy.mysqlapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by walter on 3/10/19.
 */

public class SimpleAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<Item> mArrayList;

    public SimpleAdapter(Context mContext, ArrayList<Item> mArrayList) {
        this.mContext = mContext;
        this.mArrayList = mArrayList;
    }

    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return mArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            //MODIFY HERE
            view = LayoutInflater.from(mContext).inflate(R.layout.list_item, null);
        }

        //MODIFY HERE
        TextView txtName = view.findViewById(R.id.textViewName);
        TextView txtAmount = view.findViewById(R.id.textViewAmount);
        //TextView txtPrice = view.findViewById(R.id.txtPrice);

        Item borrower=mArrayList.get(i);

        //MODIFY HERE
        txtName.setText(borrower.getName());
        txtAmount.setText("Ksh x"+borrower.getAmount());
        //txtPrice.setText(borrower.getTotal()+"");


        return view;
    }
}