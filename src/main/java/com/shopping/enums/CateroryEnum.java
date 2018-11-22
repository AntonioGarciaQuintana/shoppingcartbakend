package com.shopping.enums;

public enum CateroryEnum {
    BOOK("books"),
    MOVIE("Movies");

    private String value;

    CateroryEnum(String value){
        this.value = value;
    }

    public CateroryEnum GetCategoryByValue(Integer value){
        switch (value){
            case 0:  return BOOK;
            case 1:  return MOVIE;
            default: return null;
        }
    }
}
