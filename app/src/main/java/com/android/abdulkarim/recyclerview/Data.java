package com.android.abdulkarim.recyclerview;

import java.util.ArrayList;
import java.util.List;

public  class Data {

    public List<Contact> getContactList (){

        List<Contact> contactList = new ArrayList<>();

        contactList.add(new Contact("Abdul Karim","+880123456789","10:27 pm"));
        contactList.add(new Contact("Abdul Karim","+880123445555","11:00 pm"));
        contactList.add(new Contact("B Name One","+8801700000000","11:30 pm"));
        contactList.add(new Contact("C Name Two","+8801777777777","12:00 am"));
        contactList.add(new Contact("D Name Three","+8801800000000","12:30 am"));
        contactList.add(new Contact("E Name Four","+8801900000000","1:00 am"));
        contactList.add(new Contact("F Name Five","+8801700000000","1:30 am"));
        contactList.add(new Contact("G Name Six","+8801700000000","2:00 am"));
        contactList.add(new Contact("H Name Seven","+8801700000000","2:30 am"));
        contactList.add(new Contact("I Name Eight","+8801700000000","9:00 pm"));
        contactList.add(new Contact("J Name Nine","+8801700000000","10:20 pm"));
        contactList.add(new Contact("K Name Ten","+8801700000000","11:07 pm"));
        contactList.add(new Contact("L Name Eleven","+8801700000000","11:30 pm"));
        contactList.add(new Contact("M Name Twelve","+8801700000000","11:50 pm"));
        contactList.add(new Contact("M Name Twelve","+8801700000000","11:50 pm"));

        return contactList;

    }
}
