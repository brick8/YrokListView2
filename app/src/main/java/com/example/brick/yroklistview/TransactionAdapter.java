package com.example.brick.yroklistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by brick on 04.11.2017.
 */

public class TransactionAdapter extends ArrayAdapter<Transactions>{
    List<Transactions> transactions;

    public TransactionAdapter(@NonNull Context context, @NonNull List<Transactions> transactions) {
        super(context,0,  transactions);
        this.transactions = transactions;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Transactions transactions = getItem(position);
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView sum = (TextView) convertView.findViewById(R.id.sum);
        name.setText(transactions.name);
        sum.setText(transactions.sum);
        return convertView;
    }
}
