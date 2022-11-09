package ru.otus;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class CustomerService {

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны
    private final NavigableMap<Customer, String> allData = new TreeMap<>();

    public Map.Entry<Customer, String> getSmallest() {
        //Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk
        return copyMapEntry(allData.firstEntry());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        return copyMapEntry(allData.higherEntry(customer));
    }

    public void add(Customer customer, String data) {
        allData.put(customer, data);
    }

    private Map.Entry<Customer, String> copyMapEntry(Map.Entry<Customer, String> src) {
        if (src == null) {
            return null;
        }
        Customer srcCustomer = src.getKey();
        return Map.entry(new Customer(srcCustomer.getId(), srcCustomer.getName(), srcCustomer.getScores()),
                src.getValue());
    }
}
