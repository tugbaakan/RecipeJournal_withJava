package com.tugbaakan;

public class Category {

    private int ID;
    private String name;
    private String[] keywords;
    private String[] ignoreWords;


    public Category(int ID, String name,  String[] keywords, String[] ignoreWords) {
        this.ID = ID;
        this.name = name;
        this.keywords = keywords;
        this.ignoreWords = ignoreWords;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getIgnoreWords() {
        return ignoreWords;
    }

    public void setIgnoreWords(String[] ignoreWords) {
        this.ignoreWords = ignoreWords;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
