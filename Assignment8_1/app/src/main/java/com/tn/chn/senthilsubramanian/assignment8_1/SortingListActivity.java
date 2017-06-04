package com.tn.chn.senthilsubramanian.assignment8_1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class SortingListActivity extends AppCompatActivity {

    ArrayList<String> loadedList;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String sort;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorting_list);

        loadedList = getList("default");

        ListView list = (ListView) findViewById(R.id.listView);
        if(loadedList != null){
            adapter = new ArrayAdapter<String>(this,
                    R.layout.list_item, loadedList);
            list.setAdapter(adapter);
        }

        Button asc = (Button) findViewById(R.id.asc);
        asc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadedList = getList("asc");
                updateAdapter(adapter, loadedList);
            }
        });

        Button dsc = (Button) findViewById(R.id.desc);
        dsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadedList = getList("dsc");
                updateAdapter(adapter, loadedList);
            }
        });



    }

    protected ArrayList<String> getList(String sort){
        System.out.println("Inside getList()..");
        String [] months = {"Jan", "Feb", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"};
        ArrayList<String> sortedList = new ArrayList<String>(Arrays.asList(months));
        System.out.println("ArrayList sortedList is ["+sortedList.size()+"]");
        if(sort != null && sortedList != null){
            if(sort.equals("asc")){
                System.out.println("Inside getList() asc");
                Collections.sort(sortedList);
            }else if(sort.equals("dsc")){
                System.out.println("Inside getList() dsc");
                Collections.sort(sortedList, Collections.<String>reverseOrder());
            }
        }
        return sortedList;
    }

    private void updateAdapter(ArrayAdapter adapterUpdate, ArrayList updatedList){
        if(adapterUpdate != null && updatedList != null){
            adapterUpdate.clear();
            adapterUpdate.addAll(updatedList);
            adapterUpdate.notifyDataSetChanged();
        }

    }

}
