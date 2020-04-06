package com.android.abdulkarim.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.abdulkarim.recyclerview.adapter.ContactAdapter;
import com.android.abdulkarim.recyclerview.common.Common;
import com.android.abdulkarim.recyclerview.common.LinearLayoutManagerWithSmoothScroller;
import com.android.abdulkarim.recyclerview.interfaces.OnItemClickListener;
import com.android.abdulkarim.recyclerview.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    private RecyclerView contacts_recycler_view;
    private LinearLayoutManager layoutManager;
    private ArrayList<Contact> contacts = new ArrayList<>();
    private ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getContactList();
        initRecyclerView();
    }

    private void initRecyclerView() {
        contacts_recycler_view = findViewById(R.id.contacts_recycler_view_id);
        layoutManager = new LinearLayoutManagerWithSmoothScroller(this);
        contacts_recycler_view.setLayoutManager(layoutManager);
        contacts_recycler_view.addItemDecoration(new DividerItemDecoration(this, layoutManager.getOrientation()));
        contactAdapter = new ContactAdapter(contacts, this);
        contacts_recycler_view.setAdapter(contactAdapter);
    }

    @Override
    public void onItemClick(Contact contact, int position) {
        Toast.makeText(this, "Name is : " + contact.getName() + "\nNumber is : " + contact.getNumber(), Toast.LENGTH_SHORT).show();
    }

    private void getContactList() {
        contacts = Common.getPeopleGroup();
        contacts = Common.sortList(contacts);
        contacts = Common.addAlphabets(contacts);
    }
}
