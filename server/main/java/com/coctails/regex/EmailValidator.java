package com.coctails.regex;

import java.util.regex.Pattern;

public class EmailValidator {
    private static final Pattern EMAIL_VALIDATOR = Pattern.compile(
            Regex.EMAIL_REGEX
    );

    public static boolean emailValidator(String email){
        return EMAIL_VALIDATOR.matcher(email).matches();
    }
}
