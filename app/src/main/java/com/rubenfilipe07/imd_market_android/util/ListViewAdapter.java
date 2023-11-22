package com.rubenfilipe07.imd_market_android.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.rubenfilipe07.imd_market_android.R;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<String> {

    public ListViewAdapter(Context context, List<String> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView textView = convertView.findViewById(R.id.item_view);
        String item = getItem(position);
        textView.setText(item);
        return convertView;
    }

}
