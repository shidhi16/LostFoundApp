package com.example.lostfoundapp.Activities.Activities;

public class FirstModel {

    public FirstModel() {
    }

    private int itemID;

    public int getItemID() {
        return itemID;
    }

    public int setItemID(int itemID) {
        return itemID;
    }

    private String itemName;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }



    public FirstModel(int itemID, String itemName, String itemDescription, String itemStatus, String itemLocation, String itemContact) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemStatus = itemStatus;
        this.itemLocation = itemLocation;
        this.itemContact = itemContact;
    }

    private String itemDescription;
    private String itemStatus;
    private String itemLocation;
    private String itemContact;


}
