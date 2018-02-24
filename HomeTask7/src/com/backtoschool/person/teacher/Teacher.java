package com.backtoschool.person.teacher;

import com.backtoschool.person.Person;

public class Teacher extends Person {
    private double salary;
    private String subject;

    @Override
    public String toString() {
        return super.toString();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Teacher(String name, int age, String gender, String subject, double salary) {
        super(name,age,gender);
        this.salary = salary;
        this.subject = subject;
    }
}
