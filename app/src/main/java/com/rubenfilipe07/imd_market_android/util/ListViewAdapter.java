package com.rubenfilipe07.imd_market_android.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.rubenfilipe07.imd_market_android.R;
import com.rubenfilipe07.imd_market_android.domain.Produto;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Produto> {

    public ListViewAdapter(Context context, List<Produto> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView itemView = convertView.findViewById(R.id.itemView);
        TextView subitemView = convertView.findViewById(R.id.subitemVIew);
        Produto item = getItem(position);
        itemView.setText(item.getNomeProduto() + " (" + item.getCodigoProduto() + ")");
        subitemView.setText("Descrição: " + item.getDescricaoProduto() + "\nEstoque: " + item.getEstoque());
        return convertView;
    }

}
