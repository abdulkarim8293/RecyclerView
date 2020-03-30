package com.android.abdulkarim.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.abdulkarim.recyclerview.adapter.PersonAdapter;
import com.android.abdulkarim.recyclerview.common.Common;
import com.android.abdulkarim.recyclerview.common.LinearLayoutManagerWithSmoothScroller;
import com.android.abdulkarim.recyclerview.model.Person;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler_person;
    private LinearLayoutManager layoutManager;
    private ArrayList<Person> people = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler_person = findViewById(R.id.recycler_person);
        layoutManager = new LinearLayoutManagerWithSmoothScroller(this);
        recycler_person.setLayoutManager(layoutManager);
        recycler_person.addItemDecoration(new DividerItemDecoration(this,layoutManager.getOrientation()));
        createPersonList();
        PersonAdapter adapter = new PersonAdapter(this,people);
        recycler_person.setAdapter(adapter);

    }

    private void createPersonList(){
        people = Common.getPeopleGroup();
        people = Common.sortList(people);
        people = Common.addAlphabets(people);
    }
}
