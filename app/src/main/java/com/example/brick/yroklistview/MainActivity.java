package com.example.brick.yroklistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private TransactionAdapter transactionAdapter;
    List<Transactions> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Transactions> adapterData = getDataList();
        transactionAdapter = new TransactionAdapter(MainActivity.this, adapterData);
        listView = ( ListView )findViewById(R.id.listview);
        listView.setAdapter(transactionAdapter);

    }
    private List<Transactions> getDataList(){
        data.add(new Transactions("Thelephone", "2000"));
        data.add(new Transactions("T-Shirts", "3000"));
        data.add(new Transactions("Jeans", "1000"));

        return data;
    }
}
