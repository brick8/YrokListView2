package com.example.brick.yroklistview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by brick on 12.11.2017.
 */

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CardViewHolder> {
    private List<String> list;

    public CategoriesAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public CategoriesAdapter.CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_categories, parent, false);
        return new CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        String string = list.get(position);
        holder.names.setText(String.format(string));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        protected TextView names;

        public CardViewHolder(View itemView) {
            super(itemView);
            names = (TextView) itemView.findViewById(R.id.categories_list);
        }
    }
}
