package com.example.myapp2;
//See references.txt to get see where code was taken from
//https://www.youtube.com/watch?v=7GPUpvcU1FE&ab_channel=PracticalCoding - recycler view interface to new activty
//https://www.youtube.com/watch?v=Mc0XT58A1Z4&ab_channel=PracticalCoding- recycler view
public class ListModel {
    String ListName;
    int image;
    String description;

    public ListModel(String listName, int image, String description) {
        this.image = image;
        ListName = listName;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getListName() {
        return ListName;
    }

    public int getImage() {
        return image;
    }
}
