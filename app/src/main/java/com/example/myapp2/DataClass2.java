package com.example.myapp2;

public class DataClass2 {
    // code from https://www.youtube.com/watch?v=DWIGAkYkpg8&ab_channel=AndroidKnowledge
    private String dataTitle;
    private String dataDesc;
    private String dataLang;
    private String dataImage;
    private String key;
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }







    public String getDataTitle() {

        return dataTitle;
    }
    public String getDataDesc() {

        return dataDesc;
    }

    public String getDataLang() {

        return dataLang;
    }

    public String getDataImage() {

        return dataImage;
    }


    public DataClass2(String dataTitle, String dataDesc, String dataLang, String dataImage) {
        this.dataTitle = dataTitle;
        this.dataDesc = dataDesc;
        this.dataLang = dataLang;
        this.dataImage = dataImage;
    }



    public DataClass2() {
    }
}

