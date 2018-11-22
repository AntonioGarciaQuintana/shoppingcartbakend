package com.shopping.enums;

public enum GenreEnum {
    THRILLER("THRILLER"),
    ROMANTIC("ROMANTIC"),
    DRAMA("DRAMA"),
    MYSTERY("MYSTERY"),
    MELODRAMA("MOLODRAMA"),
    PARODY("PARODY"),
    ACCION("ACCION");


    private String value;

    GenreEnum(String value){
        this.value = value;
    }

    public GenreEnum GetGenreByValue(Integer value){
        switch (value){
            case 0:  return THRILLER;
            case 1:  return ROMANTIC;
            case 2:  return DRAMA;
            case 3:  return MYSTERY;
            case 4:  return MELODRAMA;
            case 5:  return PARODY;
            case 6:  return ACCION;
            default: return null;
        }
    }
}
