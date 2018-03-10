package firsttask.abiturient;

import firsttask.Exam.Exam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Abiturient {
    private String name;
    private int age;
    private String progress;
    private String discipline;

    public Abiturient(String name, int age, String progress, String discipline) {
        this.name = name;
        this.age = age;
        this.progress = progress;
        this.discipline = discipline;
    }

    public Abiturient(String name, int age, String progress) {
        this.name = name;
        this.age = age;
        this.progress = progress;
    }

    public Abiturient(String name, int age) {
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

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
    private Exam takeAnExam(Exam exam){
        System.out.println(exam.getTask());
        try(BufferedReader reader = new BufferedReader(new FileReader("/home/temp/exam.txt"))){
            exam.setSolution(reader.readLine());
        }catch (FileNotFoundException e){
            System.out.println("Файл не найден");
        }catch (IOException e){
            System.out.println("Ошибка ввода-вывода");
        }
        return exam;
    }
    public List<Exam> takeExams(List<Exam> exams){
        for (Exam ex:exams) {
            takeAnExam(ex);
        }
        return exams;
    }
}
