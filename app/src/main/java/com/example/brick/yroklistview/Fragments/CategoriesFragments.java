package com.example.brick.yroklistview.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.brick.yroklistview.CategoriesAdapter;
import com.example.brick.yroklistview.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by brick on 08.11.2017.
 */

public class CategoriesFragments extends Fragment {
    private RecyclerView recyclerView;
    private CategoriesAdapter categoriesAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_categories, container, false);
        String[] values = new String[]{"Одежда для мужчин", "Одежда для женщин", "Компьютеры и оргтехника", "Книги и Развлечения", "Телефоны и аксексуары", "Бижутерия и часы", "Спорт", "Красота и здоровье"};
        List<String> list = Arrays.asList(values);
        categoriesAdapter = new CategoriesAdapter(list);
        recyclerView = (RecyclerView) inflate.findViewById(R.id.categories_list);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        linearLayoutManager.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(categoriesAdapter);
        return inflate;
    }
}
