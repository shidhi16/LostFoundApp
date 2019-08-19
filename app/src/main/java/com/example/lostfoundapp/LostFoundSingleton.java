package com.example.lostfoundapp;

import com.example.lostfoundapp.Activities.pojoUsers.Items;

import java.util.ArrayList;

public class LostFoundSingleton {

     public ArrayList<Items> itemsArrayList = null ;

    private static final LostFoundSingleton ourInstance = new LostFoundSingleton();

    public static LostFoundSingleton getInstance() {

        return ourInstance;
    }

    private LostFoundSingleton() {
        itemsArrayList = new ArrayList<>();
    }
    public ArrayList<Items> getItemsList(){
        return itemsArrayList;
    }

    public void addItem(Items items){
        itemsArrayList.add(items);
    }

    public void deleteItem(Items items){
        itemsArrayList.remove(items);
    }

}
