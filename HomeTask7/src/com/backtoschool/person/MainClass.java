package com.backtoschool.person;

import com.backtoschool.person.student.Student;
import com.backtoschool.person.student.collegestudent.CollegeStudent;
import com.backtoschool.person.teacher.Teacher;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> Person = new ArrayList<>();
        boolean exit = false;
        do {
            System.out.println("Кого добавляем?");
            System.out.println("1 Просто личность");
            System.out.println("2 Учитель");
            System.out.println("3 Студент");
            System.out.println("4 Студент колледжа");
            System.out.println("0 На выход");
            switch (scanner.nextInt()) {
                case 1: {
                    System.out.println("ФИО:");
                    String name = scanner.next();
                    System.out.println("Возраст:");
                    int age = scanner.nextInt();
                    System.out.println("Пол:");
                    String gender = scanner.next();
                    Person person = new Person(name,age,gender);
                    Person.add(person.getName()+", age: "+person.getAge()+", gender: "+person.getGender());
                    break;
                }
                case 2: {
                    System.out.println("ФИО:");
                    String name = scanner.next();
                    System.out.println("Возраст:");
                    int age = scanner.nextInt();
                    System.out.println("Пол:");
                    String gender = scanner.next();
                    System.out.println("Предмет:");
                    String subject = scanner.next();
                    System.out.println("З.п.:");
                    double salary = scanner.nextDouble();
                    Teacher teacher = new Teacher(name, age, gender, subject, salary);
                    Person.add(teacher.getName()+", age: "+teacher.getAge()+", gender: "+teacher.getGender()+", subject:"+teacher.getSubject()+", salary:"+teacher.getSalary());
                    break;
                }
                case 3: {
                    System.out.println("ФИО:");
                    String name = scanner.next();
                    System.out.println("Возраст:");
                    int age = scanner.nextInt();
                    System.out.println("Пол:");
                    String gender = scanner.next();
                    System.out.println("ID Студента:");
                    String idNumber = scanner.next();
                    System.out.println("GPA:");
                    double gpa = scanner.nextDouble();
                    Student student = new Student(name, age, gender, idNumber, gpa);
                    Person.add(student.getName()+", age: "+student.getAge()+", gender: "+student.getGender()+", student id:"+student.getIdNumber()+", gpa:"+student.getGpa());
                    break;
                }
                case 4: {
                    System.out.println("ФИО:");
                    String name = scanner.next();
                    System.out.println("Возраст:");
                    int age = scanner.nextInt();
                    System.out.println("Пол:");
                    String gender = scanner.next();
                    System.out.println("ID Студента:");
                    String idNumber = scanner.next();
                    System.out.println("GPA:");
                    double gpa = scanner.nextDouble();
                    System.out.println("Год");
                    int year = scanner.nextInt();
                    System.out.println("Профильный предмет:");
                    String major = scanner.next();
                    CollegeStudent cStudent = new CollegeStudent(name, age, gender, idNumber, gpa, year, major);
                    Person.add(cStudent.getName()+", age: "+cStudent.getAge()+", gender: "+cStudent.getGender()+", student id:"+cStudent.getIdNumber()+", gpa:"+cStudent.getGpa()+", year:"+cStudent.getYear()+", major:"+cStudent.getMajor());
                    break;
                }
                case 0:{
                    exit = true;
                    break;
                }
            }
        }while (!exit);
        for (String person: Person) {
            System.out.println(person);
        }

    }
}
