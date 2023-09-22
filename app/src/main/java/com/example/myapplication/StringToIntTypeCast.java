package com.example.myapplication;

import static java.lang.Math.pow;

public class StringToIntTypeCast {
    public int intA=0;
    public StringToIntTypeCast(String string){
        for (int i = 0; i < string.length(); i++) {
             intA= intA+(int)((((int) string.charAt(i))-48)*pow(10,string.length()-i-1));

        }
        System.out.println(intA);
    }
}
