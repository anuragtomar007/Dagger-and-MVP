package com.example.dell.flexydriver;

public class LoginModel {
    boolean validateData(String string1, String string2) {
        if (string1 == null || string1.equals("") || string2 == null || string2.equals(""))
            return true;
        else
            return false;
    }
}
