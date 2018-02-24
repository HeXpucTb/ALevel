package com.backtoschool.person.student;

import com.backtoschool.person.Person;

public class Student extends Person {
    private String idNumber;
    private double gpa;

    @Override
    public String toString() {
        return super.toString();
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public Student(String name, int age, String gender, String idNumber, double gpa) {
        super(name, age, gender);
        this.idNumber = idNumber;
        this.gpa = gpa;
    }
}
