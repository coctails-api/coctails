package com.massage.regex;

import java.util.regex.Pattern;

public class PasswordValidator {
    private static final Pattern PASSWORD_VALIDATOR = Pattern.compile(
            Regex.PASSWORD_REGEX
    );

    public static boolean passwordValidator(String email){
        return PASSWORD_VALIDATOR.matcher(email).matches();
    }
}
