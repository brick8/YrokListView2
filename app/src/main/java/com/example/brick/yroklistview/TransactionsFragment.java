package com.example.brick.yroklistview;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by brick on 07.11.2017.
 */

public class TransactionsFragment extends Fragment {
    private ListView listView;
    private TransactionAdapter transactionAdapter;
    List<Transactions> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View inflate = inflater.inflate(R.layout.fragment_transactions, container, false);
        List<Transactions> adapterData = getDataList();
        transactionAdapter = new TransactionAdapter(getActivity(), adapterData);
        listView = (ListView) inflate.findViewById(R.id.listview);
        listView.setAdapter(transactionAdapter);
        return inflate;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private List<Transactions> getDataList() {
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        Calendar now_calendar = Calendar.getInstance();
        String now = df.format(now_calendar.getTime());
        data.add(new Transactions("Thelephone", 2000, now));
        data.add(new Transactions("T-Shirts", 3000, now));
        data.add(new Transactions("Jeans", 1000, now));
        data.add(new Transactions("Notebook", 10000, now));
        data.add(new Transactions("Powerbank", 2500, now));
        data.add(new Transactions("Videocard", 7000, now));
        data.add(new Transactions("SSD", 4000, now));
        return data;
    }
}
