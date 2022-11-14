package ru.otus;

import ru.otus.service.TestRunService;
import ru.otus.service.impl.TestRunServiceImpl;
import ru.otus.test.PasswordServiceTest;

public class Main {
    public static void main(String[] args) {

        TestRunService runService = new TestRunServiceImpl(PasswordServiceTest.class);
        runService.run();
    }
}