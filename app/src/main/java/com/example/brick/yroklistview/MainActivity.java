package com.example.brick.yroklistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.brick.yroklistview.Fragments.CategoriesFragments;
import com.example.brick.yroklistview.Fragments.StatisticFragment;
import com.example.brick.yroklistview.Fragments.TransactionsFragment;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class MainActivity extends AppCompatActivity {
    public Toolbar toolbar;
    //    private DrawerLayout drawerLayout;
//    private ListView left_drawer;
//    private ActionBarDrawerToggle drawerToggle;
    private Drawer drawer = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        drawerLayout = (DrawerLayout) findViewById(R.id.drawler_layout);
//        left_drawer = (ListView) findViewById(R.id.left_drawer);
        setTitle(getString(R.string.trasactions));
        getFragmentManager().beginTransaction().replace(R.id.content_frame, new TransactionsFragment()).commit();
//        String[] navigationData = new String[]{"Траты", "Категории", "Статистика"};
//        ArrayAdapter<String> navigationDrawerAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, navigationData);
//        left_drawer.setAdapter(navigationDrawerAdapter);
//        left_drawer.setOnItemClickListener(new DrawerItemClickListner());

        if (toolbar != null) {
            setSupportActionBar(toolbar);

        }
//        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.trasactions, R.string.app_name);
//        drawerLayout.addDrawerListener(drawerToggle);
//        drawerToggle.setDrawerIndicatorEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                .withHeader(R.layout.drawer_header)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.trasactions).withIcon(FontAwesome.Icon.faw_rub).withIdentifier(1),
                        new PrimaryDrawerItem().withName(R.string.categories).withIcon(FontAwesome.Icon.faw_list_alt).withIdentifier(2),
                        new PrimaryDrawerItem().withName(R.string.statistic).withIcon(FontAwesome.Icon.faw_bar_chart).withIdentifier(3))
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (position == 1) { // do something with the clicked item :D
                            setTitle(getString(R.string.trasactions));
                            getFragmentManager().beginTransaction().replace(R.id.content_frame, new TransactionsFragment()).commit();
                        } else if (position == 2) {
                            setTitle(getString(R.string.categories));
                            getFragmentManager().beginTransaction().replace(R.id.content_frame, new CategoriesFragments()).commit();
                        } else if (position == 3) {
                            setTitle(getString(R.string.statistic));
                            getFragmentManager().beginTransaction().replace(R.id.content_frame, new StatisticFragment()).commit();
                        }
                        return false;
                    }
                })
                .build();
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
    }

//    @Override
//    public void onPostCreate(@Nullable Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        drawerToggle.syncState();
//    }

//    private class DrawerItemClickListner implements ListView.OnItemClickListener {
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            if (position == 0) {
//                left_drawer.setItemChecked(position, true);
//                drawerLayout.closeDrawer(left_drawer);
//                setTitle(getString(R.string.trasactions));
//                getFragmentManager().beginTransaction().replace(R.id.content_frame, new TransactionsFragment()).commit();
//            } else if (position == 1) {
//                left_drawer.setItemChecked(position, true);
//                drawerLayout.closeDrawer(left_drawer);
//                setTitle(getString(R.string.categories));
//                getFragmentManager().beginTransaction().replace(R.id.content_frame, new CategoriesFragments()).commit();
//            } else if (position == 2) {
//                left_drawer.setItemChecked(position, true);
//                drawerLayout.closeDrawer(left_drawer);
//                setTitle(getString(R.string.statistic));
//                getFragmentManager().beginTransaction().replace(R.id.content_frame, new StatisticFragment()).commit();
//            }
//        }
//    }
}
