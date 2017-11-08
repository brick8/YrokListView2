package com.example.brick.yroklistview.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.brick.yroklistview.R;

/**
 * Created by brick on 08.11.2017.
 */

public class StatisticFragment extends Fragment {
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_statistic, container, false);
        listView = (ListView) inflate.findViewById(R.id.listview_statistic);
        return inflate;
    }
}
