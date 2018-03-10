package firsttask;

import firsttask.Exam.Exam;
import firsttask.Teacher.Teacher;
import firsttask.abiturient.Abiturient;
import firsttask.faculty.Faculty;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BeginerTask {
    public String beginTask(){
        Scanner scanner = new Scanner(System.in);
        Abiturient abiturient = new Abiturient("Alex",30,"good","Java");
        Teacher teacher = new Teacher("Alya",25,"Java");
        Faculty faculty = new Faculty();
        faculty.addNewAbiturient(abiturient);
        List<Exam> exams = new ArrayList<>();
        String more;
        do{
            exams.add(teacher.createNewExam());
            System.out.println("Добавить еще 1 экзамен?(yes/no)");
            more = scanner.next();
        }while (more.equals("yes"));
        faculty.setExams(exams);
        List<Exam> resovedExams = abiturient.takeExams(exams);
        int midMark = teacher.checkExams(resovedExams);
        System.out.println("Оценка за экзамен - "+midMark);
        if(midMark>3){
            return "абитуриент принят";
        }else return "абитуриент провалил экзамен";
    }
}
