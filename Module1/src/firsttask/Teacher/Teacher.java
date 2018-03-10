package firsttask.Teacher;

import firsttask.Exam.Exam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Teacher {
    private String name;
    private int age;
    private String discipline;
    private double salary;

    public Teacher(String name, int age, String discipline) {
        this.name = name;
        this.age = age;
        this.discipline = discipline;
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

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public Exam createNewExam(){
        Exam exam = new Exam(discipline);
        try(BufferedReader reader = new BufferedReader(new FileReader("/home/temp/javatask.txt"))){
            exam.setTask(reader.readLine());
        }catch (FileNotFoundException e){
            System.out.println("Файл не найден");
        }catch (IOException e){
            System.out.println("Ошибка ввода-вывода");
        }
        return exam;
    }
    private Exam checkExam(Exam exam){
        exam.setMark(generateMark(exam.getSolution()));
        return exam;
    }
    public int checkExams(List<Exam> exams){
        int mark = 0;
        for (Exam ex: exams) {
            checkExam(ex);
            mark += ex.getMark();
        }
        return mark/exams.size();
    }
    private int generateMark(String solution){
        return solution.length()/10;
    }
}
