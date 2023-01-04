package com.massage.regex;

public abstract class Validation {
    public static final String LOGIN_REGEX = "^[a-zA-Z0-9]$";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    private static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{6,}$";
    public static final String PHONE_REGEX = "^\\d{9}$";


}
