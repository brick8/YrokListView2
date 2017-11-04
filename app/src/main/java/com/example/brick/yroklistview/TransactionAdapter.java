package com.example.brick.yroklistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by brick on 04.11.2017.
 */

public class TransactionAdapter extends ArrayAdapter<Transactions>{

    public TransactionAdapter(Context context, List<Transactions> transactionses) {
        super(context,0, transactionses);
    }
}
