package com.jpmorgan.leetcode.model;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable  {

    private String name;
    private Integer customerId;
    private String emailId;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId (Integer customerId) {
        this.customerId = customerId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getName().equals(person.getName())
                && getCustomerId().equals(person.getCustomerId())
                && getEmailId().equals(person.getEmailId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCustomerId(), getEmailId());
    }

    public Person(String name, Integer customerId, String emailId) {
        this.name = name;
        this.customerId = customerId;
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", customerId=" + customerId +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
