package ru.otus.result;

import java.util.List;

public class Printer {

    private static final String PRINT_TEST_TEMPLATE = "\t%s: %s\n\n";

    public static void printResult(List<ResultDto> results) {
        if (results.size() > 0) {
            int countPassedTests = 0;
            int countFailedTests = 0;
            for (ResultDto resultDto : results) {
                if (resultDto.getType().equals(ResultType.SUCCESS)) {
                    countPassedTests++;
                }
                if (resultDto.getType().equals(ResultType.ERROR)) {
                    countFailedTests++;
                }
                System.out.printf(PRINT_TEST_TEMPLATE, resultDto.getType(), resultDto.getDescription());
            }
            System.out.println("Всего тестов: " + results.size());
            System.out.println("  из них успешных: " + countPassedTests);
            System.out.println("  из них упало: " + countFailedTests);
        }
    }
}
