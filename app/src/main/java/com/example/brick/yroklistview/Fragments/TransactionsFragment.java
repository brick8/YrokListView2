package com.example.brick.yroklistview.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.brick.yroklistview.AddTransactionActivity;
import com.example.brick.yroklistview.R;
import com.example.brick.yroklistview.Transaction;
import com.example.brick.yroklistview.TransactionAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by brick on 07.11.2017.
 */

public class TransactionsFragment extends Fragment {
    private RecyclerView recyclerView;
    private TransactionAdapter transactionAdapter;
    List<Transaction> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View inflate = inflater.inflate(R.layout.fragment_transactions, container, false);
        List<Transaction> adapterData = getDataList();
        transactionAdapter = new TransactionAdapter(adapterData);
        recyclerView = (RecyclerView) inflate.findViewById(R.id.transactions_list);
        FloatingActionButton fab = (FloatingActionButton) inflate.findViewById(R.id.fab);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        linearLayoutManager.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(transactionAdapter);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddTransactionActivity.class);
                getActivity().startActivity(intent);
            }
        });
        return inflate;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private List<Transaction> getDataList() {
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        Calendar now_calendar = Calendar.getInstance();
        String now = df.format(now_calendar.getTime());
        data.add(new Transaction("Thelephone", 2000, now));
        data.add(new Transaction("T-Shirts", 3000, now));
        data.add(new Transaction("Jeans", 1000, now));
        data.add(new Transaction("Notebook", 10000, now));
        data.add(new Transaction("Powerbank", 2500, now));
        data.add(new Transaction("Videocard", 7000, now));
        data.add(new Transaction("SSD", 4000, now));
        data.add(new Transaction("Cvadrocopter", 7000, now));
        data.add(new Transaction("Shoose", 5500, now));
        data.add(new Transaction("Shorts", 4000, now));
        data.add(new Transaction("Clock", 500, now));
        return data;
    }
}
