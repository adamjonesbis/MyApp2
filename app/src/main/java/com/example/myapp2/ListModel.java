package com.example.myapp2;

public class ListModel {
    String ListName;
    int image;


    public ListModel(String listName, int image) {
        this.image = image;
        ListName = listName;
    }

    public String getListName() {
        return ListName;
    }

    public int getImage() {
        return image;
    }
}
