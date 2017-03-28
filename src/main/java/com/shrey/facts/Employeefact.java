package com.shrey.facts;

/**
 * Created by skany on 3/27/17.
 */
public class Employeefact {

    String name;
    int age;

    public Employeefact(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
