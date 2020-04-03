package com.android.abdulkarim.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.abdulkarim.recyclerview.adapter.ContactAdapter;
import com.android.abdulkarim.recyclerview.common.ActionModeCallback;
import com.android.abdulkarim.recyclerview.common.Common;
import com.android.abdulkarim.recyclerview.common.LinearLayoutManagerWithSmoothScroller;
import com.android.abdulkarim.recyclerview.interfaces.OnItemClickListener;
import com.android.abdulkarim.recyclerview.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    private RecyclerView contacts_recycler_view ;
    private LinearLayoutManager layoutManager;
    private ArrayList<Contact> contacts = new ArrayList<>();
    private ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createContactList();
        contacts_recycler_view = findViewById(R.id.contacts_recycler_view_id);
        layoutManager = new LinearLayoutManagerWithSmoothScroller(this);
        contacts_recycler_view.setLayoutManager(layoutManager);
        contacts_recycler_view.addItemDecoration(new DividerItemDecoration(this,layoutManager.getOrientation()));
        adapter = new ContactAdapter(this,contacts,this);
        contacts_recycler_view.setAdapter(adapter);


    }

    private void createContactList(){

        contacts = Common.getPeopleGroup();
        contacts = Common.sortList(contacts);
        contacts = Common.addAlphabets(contacts);
    }

    @Override
    public void onItemClick(View view, Contact contact, int position) {
        Toast.makeText(this, ""+contact.getName()+"\nNumber is : "+contact.getNumber(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClick(View view, Contact contact, int position) {

        Toast.makeText(this, ""+contact.getName(), Toast.LENGTH_SHORT).show();

    }
}
