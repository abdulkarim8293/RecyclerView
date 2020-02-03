package com.android.abdulkarim.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContactAdapter contactAdapter = new ContactAdapter(this,getContactList());
        recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setAdapter(contactAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public List<Contact> getContactList (){

        List<Contact> contactList = new ArrayList<>();

        contactList.add(new Contact("Abdul Karim","+880123456789"));
        contactList.add(new Contact("Abdul Karim","+880123445555"));
        contactList.add(new Contact("B Name One","+8801700000000"));
        contactList.add(new Contact("C Name Two","+8801777777777"));
        contactList.add(new Contact("D Name Three","+8801800000000"));
        contactList.add(new Contact("E Name Four","+8801900000000"));
        contactList.add(new Contact("F Name Five","+8801700000000"));
        contactList.add(new Contact("G Name Six","+8801700000000"));
        contactList.add(new Contact("H Name Seven","+8801700000000"));
        contactList.add(new Contact("I Name Eight","+8801700000000"));
        contactList.add(new Contact("J Name Nine","+8801700000000"));
        contactList.add(new Contact("K Name Ten","+8801700000000"));
        contactList.add(new Contact("L Name Eleven","+8801700000000"));
        contactList.add(new Contact("M Name Twelve","+8801700000000"));

        return contactList;

    }
}
