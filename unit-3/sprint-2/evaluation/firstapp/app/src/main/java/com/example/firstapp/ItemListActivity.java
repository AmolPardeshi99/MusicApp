package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class ItemListActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        fragmentManager = getSupportFragmentManager();
        initviews();
    }

    private void initviews() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        ItemListFragment itemListFragment = new ItemListFragment();
        transaction.replace(R.id.flcontainer,itemListFragment,"itemlistfrag").commit();
    }


}