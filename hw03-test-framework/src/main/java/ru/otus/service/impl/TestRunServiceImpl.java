package ru.otus.service.impl;

import lombok.NonNull;
import lombok.SneakyThrows;
import ru.otus.annotation.After;
import ru.otus.annotation.Before;
import ru.otus.annotation.Test;
import ru.otus.service.TestRunService;
import ru.otus.result.Printer;
import ru.otus.result.ResultDto;
import ru.otus.result.ResultType;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class TestRunServiceImpl implements TestRunService {

    private final Class<?> testClass;
    private Object instance;

    public TestRunServiceImpl(Class<?> clazz) {
        this.testClass = clazz;
    }

    @Override
    public void run() {
        invokeMethods(Before.class);
        var results = invokeMethods(Test.class);
        invokeMethods(After.class);

        Printer.printResult(results);
    }

    private List<ResultDto> invokeMethods(Class<? extends Annotation> annotation) {
        Method[] methods = testClass.getDeclaredMethods();
        List<ResultDto> resultDtoList = new ArrayList<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(annotation)) {
                try {
                    method.invoke(instance());
                    resultDtoList.add(ResultDto.builder()
                            .type(ResultType.SUCCESS)
                            .description(method.getName())
                            .build());
                } catch (InvocationTargetException ex) {
                    resultDtoList.add(ResultDto.builder()
                            .type(ResultType.ERROR)
                            .description(String.format("%s, error: %s", method.getName(), ex.getTargetException().getMessage()))
                            .build());
                } catch (Exception ex) {
                    resultDtoList.add(ResultDto.builder()
                            .type(ResultType.ERROR)
                            .description(String.format("%s, error: %s", method.getName(), ex.getMessage()))
                            .build());
                }
            }
        }
        return resultDtoList;
    }

    @SneakyThrows
    private Object instance(Object... args) {
        if (instance == null) {
            instance = getConstructor().newInstance(args);
        }
        return instance;
    }

    @NonNull
    private Constructor<?> getConstructor() throws NoSuchMethodException {
        return testClass.getConstructor();
    }

}
