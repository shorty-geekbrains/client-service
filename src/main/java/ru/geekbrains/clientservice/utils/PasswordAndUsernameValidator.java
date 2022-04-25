package ru.geekbrains.clientservice.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 25.04.2022
 */

public class PasswordAndUsernameValidator {
    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public boolean IsValid(String str) {
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
