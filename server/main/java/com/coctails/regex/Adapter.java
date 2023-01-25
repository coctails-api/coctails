package com.coctails.regex;

public class Adapter {
    public static String substringSingleVariable(String str) {
        return str.substring(str.lastIndexOf('=')+1, str.lastIndexOf('}'));
    }
}
