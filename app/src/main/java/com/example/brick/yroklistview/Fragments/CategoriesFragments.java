package com.example.brick.yroklistview.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.brick.yroklistview.R;

/**
 * Created by brick on 08.11.2017.
 */

public class CategoriesFragments extends Fragment {
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_categories, container, false);
        String[] values = new String[]{"Одежда для мужчин", "Одежда для женщин", "Компьютеры и оргтехника", "Книги и Развлечения", "Телефоны и аксексуары", "Бижутерия и часы", "Спорт", "Красота и здоровье"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, values);
        listView = (ListView) inflate.findViewById(R.id.listview_categories);
        listView.setAdapter(adapter);
        return inflate;
    }
}
