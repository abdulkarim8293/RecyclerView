package com.android.abdulkarim.recyclerview.common;

import com.android.abdulkarim.recyclerview.R;
import com.android.abdulkarim.recyclerview.model.Contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public  class Common {

    public static final int VIEW_TYPE_CONTACT_GROUP = 0;
    public static final int VIEW_TYPE_CONTACT = 1;

    public static List<String> contact_header_alphabet_available = new ArrayList<>();

    public static ArrayList<Contact> addAlphabetToGroupHeader (ArrayList<Contact> list){

        int i = 0;
        ArrayList<Contact> groupHeaderList = new ArrayList<>();
        Contact firstPosition = new Contact();
        firstPosition.setName(String.valueOf(list.get(0).getName().charAt(0)));
        firstPosition.setViewType(VIEW_TYPE_CONTACT_GROUP);
        contact_header_alphabet_available.add(String.valueOf(list.get(0).getName().charAt(0)));
        groupHeaderList.add(firstPosition);

        for (i=0; i < list.size() - 1; i++){
            Contact person = new Contact();
            char name1 = list.get(i).getName().charAt(0); // get first character in name;
            char name2 = list.get(i+1).getName().charAt(0);
            if (name1 == name2){
                list.get(i).setViewType(VIEW_TYPE_CONTACT);
                groupHeaderList.add(list.get(i));
            }else {
                list.get(i).setViewType(VIEW_TYPE_CONTACT);
                groupHeaderList.add(list.get(i));
                person.setName(String.valueOf(name2));
                person.setViewType(VIEW_TYPE_CONTACT_GROUP);
                contact_header_alphabet_available.add(String.valueOf(name2));
                groupHeaderList.add(person);
            }
        }
        list.get(i).setViewType(VIEW_TYPE_CONTACT);
        groupHeaderList.add(list.get(i));
        return groupHeaderList;
    }

    public static int findPositionWithName(String name,ArrayList<Contact> list){
        for (int i = 0; i<list.size(); i++){
            if (list.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public static ArrayList<String> getAlphabets(){
        ArrayList<String> result = new ArrayList<>();
        for (int i = 65; i<= 90; i++){
            char character = (char) i;
            result.add(String.valueOf(character));
        }
        return result;
    }

    public static ArrayList<Contact> sortContactList (ArrayList<Contact> contacts){
        Collections.sort(contacts, new Comparator<Contact>() {
            @Override
            public int compare(Contact objectOne, Contact objectTwo) {
                return objectOne.getName().compareTo(objectTwo.getName());
            }
        });

        return contacts;
    }

    public static ArrayList<Contact> getAllContacts() {

        ArrayList<Contact> contactList = new ArrayList<>();

        contactList.add(new Contact("Abdul Karim","0123456789",null,-1));
        contactList.add(new Contact("Abdul Karim","0123456789",null,-1));
        contactList.add(new Contact("Abdul Karim","0123456789", R.drawable.karim_profile_image,-1));
        contactList.add(new Contact("Abdul Karim","0123456789",null,-1));
        contactList.add(new Contact("Abdul Karim","0123456789", R.drawable.orin_profile_image,-1));
        contactList.add(new Contact("Taslima Yesmin Orin","0123456789", R.drawable.orin_profile_image,-1));
        contactList.add(new Contact("B","0123456789",null,-1));
        contactList.add(new Contact("B","0123456789",null,-1));
        contactList.add(new Contact("B","0123456789",null,-1));
        contactList.add(new Contact("C","0123456789",null,-1));
        contactList.add(new Contact("D","0123456789",null,-1));

        return contactList;
    }
}
