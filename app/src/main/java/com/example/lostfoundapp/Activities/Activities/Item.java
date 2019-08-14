package com.example.lostfoundapp.Activities.Activities;

import java.io.Serializable;

public class Item implements Serializable
{
    public String itemImage;
    public int itemID;
    public String itemName;
    public String description;
    public String status;
    public String location;
    public String contact;


      public Item(){}


    public Item(String itemImage,int itemID, String itemName, String description, String status, String location, String contact) {
        this.itemImage = itemImage;
        this.itemID = itemID;
        this.itemName = itemName;
        this.description = description;
        this.status = status;
        this.location = location;
        this.contact = contact;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
