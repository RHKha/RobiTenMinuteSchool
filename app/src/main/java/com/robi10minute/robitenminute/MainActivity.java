package com.robi10minute.robitenminute;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.robi10minute.robitenminute.adapter.ItemAdapter;
import com.robi10minute.robitenminute.databinding.ActivityMainBinding;
import com.robi10minute.robitenminute.model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;
    private RecyclerView parentRv;
    private List<Item> itemList;
    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        init();

        configRv();

        setData();
    }




    private void init() {
        itemList = new ArrayList<>();
        itemAdapter = new ItemAdapter(itemList,this);
    }

    private void configRv() {
        mainBinding.parentRV.setLayoutManager(new LinearLayoutManager(this));
        mainBinding.parentRV.setAdapter(itemAdapter);
    }

    private void setData() {
        Item item1 = new Item( "Chapter 1");
        Item item2 = new Item( "Chapter 2");
        Item item3 = new Item( "Chapter 3");
        Item item4 = new Item(R.drawable.ic_play,"VIDEO");
        Item item5 = new Item(R.drawable.ic_audio,"AUDIO");
        Item item6 = new Item(R.drawable.ic_document,"DOCUMENT", "Document 1");


        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);

        itemAdapter.notifyDataSetChanged();

    }
}