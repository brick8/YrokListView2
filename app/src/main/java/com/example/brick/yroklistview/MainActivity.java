package com.example.brick.yroklistview;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.brick.yroklistview.Fragments.CategoriesFragments;
import com.example.brick.yroklistview.Fragments.StatisticFragment;
import com.example.brick.yroklistview.Fragments.TransactionsFragment;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ListView left_drawer;
    private ActionBarDrawerToggle drawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawler_layout);
        left_drawer = (ListView) findViewById(R.id.left_drawer);
        setTitle(getString(R.string.trasactions));
        getFragmentManager().beginTransaction().replace(R.id.content_frame, new TransactionsFragment()).commit();
        String[] navigationData = new String[]{"Траты", "Категории", "Статистика"};
        ArrayAdapter<String> navigationDrawerAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, navigationData);
        left_drawer.setAdapter(navigationDrawerAdapter);
        left_drawer.setOnItemClickListener(new DrawerItemClickListner());

        if (toolbar != null) {
            setSupportActionBar(toolbar);

        }
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.trasactions, R.string.app_name);
        drawerLayout.setDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        drawerToggle.syncState();
    }

    private class DrawerItemClickListner implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (position == 0) {
                left_drawer.setItemChecked(position, true);
                drawerLayout.closeDrawer(left_drawer);
                setTitle(getString(R.string.trasactions));
                getFragmentManager().beginTransaction().replace(R.id.content_frame, new TransactionsFragment()).commit();
            } else if (position == 1) {
                left_drawer.setItemChecked(position, true);
                drawerLayout.closeDrawer(left_drawer);
                setTitle(getString(R.string.categories));
                getFragmentManager().beginTransaction().replace(R.id.content_frame, new CategoriesFragments()).commit();
            } else if (position == 2) {
                left_drawer.setItemChecked(position, true);
                drawerLayout.closeDrawer(left_drawer);
                setTitle(getString(R.string.statistic));
                getFragmentManager().beginTransaction().replace(R.id.content_frame, new StatisticFragment()).commit();
            }
        }
    }
}
