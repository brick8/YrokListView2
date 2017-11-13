package com.example.brick.yroklistview.Fragments;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.activeandroid.query.Select;
import com.example.brick.yroklistview.AddTransactionActivity;
import com.example.brick.yroklistview.R;
import com.example.brick.yroklistview.Transaction;
import com.example.brick.yroklistview.TransactionAdapter;

import java.util.List;

/**
 * Created by brick on 07.11.2017.
 */

public class TransactionsFragment extends Fragment {
    private RecyclerView recyclerView;
//    private TransactionAdapter transactionAdapter;
//    List<Transaction> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View inflate = inflater.inflate(R.layout.fragment_transactions, container, false);
//        List<Transaction> adapterData = getDataList();
//        transactionAdapter = new TransactionAdapter(adapterData);
        recyclerView = (RecyclerView) inflate.findViewById(R.id.transactions_list);
        FloatingActionButton fab = (FloatingActionButton) inflate.findViewById(R.id.fab);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        linearLayoutManager.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setAdapter(transactionAdapter);
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

    @Override
    public void onResume() {
        super.onResume();
        getLoaderManager().restartLoader(0, null, new LoaderManager.LoaderCallbacks<List<Transaction>>() {
            @Override
            public Loader<List<Transaction>> onCreateLoader(int id, Bundle args) {
                AsyncTaskLoader<List<Transaction>> transactionsloader = new AsyncTaskLoader<List<Transaction>>(getActivity()) {
                    @Override
                    public List<Transaction> loadInBackground() {
                        return getDataList();
                    }
                };
                transactionsloader.forceLoad();
                return transactionsloader;
            }

            @Override
            public void onLoadFinished(Loader<List<Transaction>> loader, List<Transaction> data) {
                recyclerView.setAdapter(new TransactionAdapter(data));
            }

            @Override
            public void onLoaderReset(Loader<List<Transaction>> loader) {

            }
        });

    }

    private List<Transaction> getDataList() {
        return new Select()
                .from(Transaction.class)
//                .where("Category = ?", category.getId())
                .orderBy("date DESC")
                .execute();
    }
}
