package com.android.abdulkarim.recyclerview.common;

import com.android.abdulkarim.recyclerview.model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public  class Common {

    public static final int VIEW_TYPE_GROUP = 0;
    public static final int VIEW_TYPE_PERSON = 1;
    public static final int RESULT_CODE = 1000;

    public static List<String> alphabet_available = new ArrayList<>();

    public static ArrayList<Person> addAlphabets (ArrayList<Person> list){
        int i = 0;

        ArrayList<Person> customList = new ArrayList<>();
        Person firstPosition = new Person();
        firstPosition.setName(String.valueOf(list.get(0).getName().charAt(0)));
        firstPosition.setViewType(VIEW_TYPE_GROUP);
        alphabet_available.add(String.valueOf(list.get(0).getName().charAt(0))); // add first character group header list;
        customList.add(firstPosition);

        for (i=0; i < list.size() - 1; i++){
            Person person = new Person();
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

    public static int findPositionWithName(String name,ArrayList<Person> list){
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

    public static ArrayList<Person> sortList (ArrayList<Person> people){
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        return people;
    }

    public static ArrayList<Person> getPeopleGroup() {
        ArrayList<Person> personList = new ArrayList<>();

        personList.add(new Person("Abdul Karim","0123456789",-1));
        personList.add(new Person("B","0123456789",-1));
        personList.add(new Person("C","0123456789",-1));
        personList.add(new Person("D","0123456789",-1));
        personList.add(new Person("E","0123456789r",-1));
        personList.add(new Person("F","0123456789",-1));
        personList.add(new Person("G","0123456789",-1));
        personList.add(new Person("H","0123456789",-1));
        personList.add(new Person("I","0123456789",-1));
        personList.add(new Person("J","0123456789",-1));
        personList.add(new Person("K","0123456789",-1));
        personList.add(new Person("L","0123456789",-1));
        personList.add(new Person("M","0123456789",-1));
        personList.add(new Person("N","0123456789",-1));
        personList.add(new Person("O","0123456789",-1));
        personList.add(new Person("P","0123456789",-1));
        personList.add(new Person("Q","0123456789",-1));
        personList.add(new Person("R","0123456789",-1));
        personList.add(new Person("S","0123456789",-1));
        personList.add(new Person("T","0123456789",-1));
        personList.add(new Person("U","0123456789",-1));
        personList.add(new Person("V","0123456789",-1));
        personList.add(new Person("W","0123456789",-1));
        //personList.add(new Person("X","0123456789",-1));
        personList.add(new Person("Y","0123456789",-1));
        personList.add(new Person("Z","0123456789",-1));
        personList.add(new Person("Abdul Karim","0123456789",-1));
        personList.add(new Person("Abdul Karim","0123456789",-1));
        personList.add(new Person("Abdul Karim","0123456789",-1));
        personList.add(new Person("Abdul Karim","0123456789",-1));
        personList.add(new Person("Abdul Karim","0123456789",-1));
        personList.add(new Person("Abdul Karim","0123456789",-1));
        personList.add(new Person("Abdul Karim","0123456789",-1));
        personList.add(new Person("Abdul Karim","0123456789",-1));
        personList.add(new Person("Two","0123456789",-1));
        personList.add(new Person("Three","0123456789",-1));
        personList.add(new Person("Four","0123456789",-1));
        personList.add(new Person("Five","0123456789",-1));
        personList.add(new Person("Six","0123456789",-1));

        return personList;
    }
}
