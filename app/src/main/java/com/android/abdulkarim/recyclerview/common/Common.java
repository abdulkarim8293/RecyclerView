package com.android.abdulkarim.recyclerview.common;

import com.android.abdulkarim.recyclerview.R;
import com.android.abdulkarim.recyclerview.model.Contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public  class Common {

    public static final int VIEW_TYPE_GROUP = 0;
    public static final int VIEW_TYPE_PERSON = 1;

    public static List<String> alphabet_available = new ArrayList<>();

    public static ArrayList<Contact> addAlphabets (ArrayList<Contact> list){

        int i = 0;
        ArrayList<Contact> customList = new ArrayList<>();
        Contact firstPosition = new Contact();
        firstPosition.setName(String.valueOf(list.get(0).getName().charAt(0)));
        firstPosition.setViewType(VIEW_TYPE_GROUP);
        alphabet_available.add(String.valueOf(list.get(0).getName().charAt(0))); // add first character group header list;
        customList.add(firstPosition);

        for (i=0; i < list.size() - 1; i++){
            Contact person = new Contact();
            char name1 = list.get(i).getName().charAt(0); // get first character in name;
            char name2 = list.get(i+1).getName().charAt(0);
            if (name1 == name2){
                list.get(i).setViewType(VIEW_TYPE_PERSON);
                customList.add(list.get(i));
            }else {
                list.get(i).setViewType(VIEW_TYPE_PERSON);
                customList.add(list.get(i));
                person.setName(String.valueOf(name2));
                person.setViewType(VIEW_TYPE_GROUP);
                alphabet_available.add(String.valueOf(name2));
                customList.add(person);
            }
        }
        list.get(i).setViewType(VIEW_TYPE_PERSON);
        customList.add(list.get(i));
        return customList;
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

    public static ArrayList<Contact> sortList (ArrayList<Contact> people){
        Collections.sort(people, new Comparator<Contact>() {
            @Override
            public int compare(Contact o1, Contact o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        return people;
    }

    public static ArrayList<Contact> getPeopleGroup() {
        ArrayList<Contact> personList = new ArrayList<>();

        personList.add(new Contact("Abdul Karim","0123456789",null,-1));
        personList.add(new Contact("Abdul Karim","0123456789",null,-1));
        personList.add(new Contact("Abdul Karim","0123456789", R.drawable.karim_profile_image,-1));
        personList.add(new Contact("Abdul Karim","0123456789",null,-1));
        personList.add(new Contact("Abdul Karim","0123456789", R.drawable.orin_profile_image,-1));
        personList.add(new Contact("Taslima Yesmin Orin","0123456789", R.drawable.orin_profile_image,-1));
        personList.add(new Contact("B","0123456789",null,-1));
        personList.add(new Contact("B","0123456789",null,-1));
        personList.add(new Contact("B","0123456789",null,-1));
        personList.add(new Contact("C","0123456789",null,-1));
        personList.add(new Contact("D","0123456789",null,-1));

        return personList;
    }
}
