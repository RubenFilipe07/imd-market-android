package com.rubenfilipe07.imd_market_android.util;

import android.app.AlertDialog;
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
        Produto item = getItem(position);
        itemView.setText(item.getNomeProduto() + " (" + item.getCodigoProduto() + ")");
        itemView.setOnClickListener(v ->  showAlert("Detalhes do Produto", item.toString()));
        return convertView;
    }

    public void showAlert(String titulo, String detalhes) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(titulo);
        builder.setMessage(detalhes);
        builder.setPositiveButton("OK", (d, i) -> d.dismiss());
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
