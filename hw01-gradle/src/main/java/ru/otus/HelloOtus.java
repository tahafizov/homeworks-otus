package ru.otus;

import com.google.common.base.Splitter;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.List;

public class HelloOtus {
    public static void main(String[] args) {
        String input = "Hello World Hello Otus ";
        List<String> words = Splitter.on(" ").omitEmptyStrings().splitToList(input);

        Multiset<String> multiset = HashMultiset.create();
        multiset.addAll(words);

        for (String key : multiset.elementSet()) {
            System.out.println(key + " --> " + multiset.count(key));
        }
    }
}
