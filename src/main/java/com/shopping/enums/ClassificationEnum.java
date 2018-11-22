package com.shopping.enums;

public enum ClassificationEnum {
    AA("AA"),
    A("A"),
    B("B"),
    B15("B15"),
    C("A"),
    D("A");


    private String value;

    ClassificationEnum(String value){
        this.value = value;
    }

    public ClassificationEnum GetClassificationByValue(Integer value){
        switch (value){
            case 0:  return AA;
            case 1:  return A;
            case 2:  return B;
            case 3:  return B15;
            case 4:  return C;
            case 5:  return D;
            default: return null;
        }
    }
}
