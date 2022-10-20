package ru.otus;

import java.util.Objects;

public class Customer implements Comparable<Customer> {

    private final long id;
    private String name;
    private long scores;

    //todo: 1. в этом классе надо исправить ошибки

    public Customer(long id, String name, long scores) {
        this.id = id;
        this.name = name;
        this.scores = scores;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getScores() {
        return scores;
    }

    public void setScores(long scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", scores=" + scores +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

//        if (id != customer.id) return false;
//        if (scores != customer.scores) return false;
        return id == customer.id;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (int) (scores ^ (scores >>> 32));
        return result;
    }

    @Override
    public int compareTo(Customer o) {
        if (o == null) {
            return 1;
        }
        if (Objects.equals(this, o) || this.scores == o.getScores()) {
            return 0;
        }
        return this.scores > o.getScores() ? 1 : -1;
    }
}
