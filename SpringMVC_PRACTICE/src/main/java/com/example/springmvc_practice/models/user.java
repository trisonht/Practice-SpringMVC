package com.example.springmvc_practice.models;

import javax.persistence.*;

@Entity
@Table(name="user")
public class user {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int id;

    @Column(name="name")
    public String name;

    @Column(name="age")
    public int age;

    @Column(name="salary")
    public int salary;

    public user() {}

    public user(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public user(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
