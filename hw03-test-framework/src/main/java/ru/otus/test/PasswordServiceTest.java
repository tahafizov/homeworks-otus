package ru.otus.test;

import ru.otus.annotation.After;
import ru.otus.annotation.Before;
import ru.otus.annotation.Test;
import ru.otus.service.PasswordService;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordServiceTest {

    private PasswordService passwordService;

    @Before
    public void setUp() {
        passwordService = new PasswordService();
    }

    @Test
    public void nullPasswordTestPassed() {
        assertThat(passwordService.isPasswordNull(null))
                .isEqualTo(true);
    }

    @Test
    public void nullPasswordTestFailed() {
        assertThat(passwordService.isPasswordNull("qqq"))
                .isEqualTo(true);
    }

    @Test
    public void lessCountCharsInPasswordTestPassed() {
        assertThat(passwordService.isLessMinPasswordChars("qqq"))
                .isEqualTo(true);
    }

    @After
    public void cleanService() {
        passwordService = null;
    }

}
