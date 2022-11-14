package ru.otus.service;

public class PasswordService {
    private static final int MIN_PASSWORD_CHARS = 8;


    public boolean isPasswordNull(String password) {
        return password == null;
    }

    public boolean isLessMinPasswordChars(String password) {
        return password.length() < MIN_PASSWORD_CHARS;
    }
}
