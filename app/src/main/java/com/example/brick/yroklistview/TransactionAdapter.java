package com.example.brick.yroklistview;

import android.content.Context;
import android.graphics.Color;
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

public class TransactionAdapter extends ArrayAdapter<Transactions> {
    public List<Transactions> transactions;

    public TransactionAdapter(@NonNull Context context, @NonNull List<Transactions> transactions) {
        super(context, 0, transactions);
        this.transactions = transactions;
    }

    static class ViewHolder {
        public TextView name;
        public TextView sum;
        public TextView date;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        Transactions transactions = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.sum = (TextView) convertView.findViewById(R.id.sum);
            holder.date = (TextView) convertView.findViewById(R.id.date);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(transactions.name);
        holder.sum.setText(Integer.toString(transactions.sum));
        holder.date.setText(transactions.date);
        if (position % 2 == 0) {
            convertView.setBackgroundColor(Color.parseColor("#f9de11"));
        } else {
            convertView.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        return convertView;
    }
}
