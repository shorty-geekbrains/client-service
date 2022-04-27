package ru.geekbrains.clientservice.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 26.04.2022
 */
public class PasswordAndUsernameValidatorTest {
    PasswordAndUsernameValidator pv = new PasswordAndUsernameValidator();


    @ParameterizedTest(name = "#{index} - Run test with password = {0}")
    @MethodSource("validPassword")
    void passwordValidatorValid(String password) {
        assertTrue(pv.IsValid(password));
    }


    @ParameterizedTest(name = "#{index} - Run test with password = {0}")
    @MethodSource("invalidPassword")
    void passwordValidatorInvalid(String password) {
        assertFalse(pv.IsValid(password));
    }

  static Stream<String> validPassword() {
        return Stream.of(
                "AAAbbbccc@123",
                "Hello world$123",
                "A!@#&()–a1",
                "A[{}]:;',?/*a1",
                "A~$^+=<>a1",
                "0123456789$abcdefgAB",
                "123Aa$Aa"
        );
    }

   static Stream<String> invalidPassword() {
        return Stream.of(
                "12345678",
                "abcdefgh",
                "ABCDEFGH",
                "abc123$$$",
                "ABC123$$$",
                "ABC$$$$$$",
                "java REGEX 123",
                "java REGEX 123 %",
                "________",
                "--------",
                " ",
                ""
        );
    }
}
