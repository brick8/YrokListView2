package com.example.brick.yroklistview;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by brick on 04.11.2017.
 */

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.CardViewHolder> {
    private List<Transaction> transactions;

    public TransactionAdapter(@NonNull List<Transaction> transactions) {

        this.transactions = transactions;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new CardViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        Transaction transaction = transactions.get(position);
        holder.name.setText(transaction.name);
        holder.date.setText(transaction.date);
        holder.sum.setText(Integer.toString(transaction.sum));
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }


    public static class CardViewHolder extends RecyclerView.ViewHolder {
        protected TextView name;
        protected TextView sum;
        protected TextView date;

        public CardViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            sum = (TextView) itemView.findViewById(R.id.sum);
            date = (TextView) itemView.findViewById(R.id.date);
        }
    }
}
