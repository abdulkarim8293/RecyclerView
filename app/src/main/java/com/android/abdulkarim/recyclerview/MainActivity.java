package com.android.abdulkarim.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    private List<Contact> contactList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactList = new Data().getContactList();

        ContactAdapter contactAdapter = new ContactAdapter(contactList,this);
        recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setAdapter(contactAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "Time : "+contactList.get(position).getcTime(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClick(int position) {

    }
}
