package ru.otus;


import java.util.ArrayDeque;
import java.util.Deque;

public class CustomerReverseOrder {

    //todo: 2. надо реализовать методы этого класса
    //надо подобрать подходящую структуру данных, тогда решение будет в "две строчки"
    private final Deque<Customer> allData = new ArrayDeque<>();

    public void add(Customer customer) {
        allData.push(customer);
    }

    public Customer take() {
        return allData.pop(); // это "заглушка, чтобы скомилировать"
    }
}
