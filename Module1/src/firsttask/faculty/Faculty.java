package firsttask.faculty;

import firsttask.Exam.Exam;
import firsttask.abiturient.Abiturient;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private List<Abiturient> abiturients = new ArrayList<>();
    private List<Exam> exams;
    public void addNewAbiturient(Abiturient abiturient){
        abiturients.add(abiturient);
    }

    public List<Abiturient> getAbiturients() {
        return abiturients;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }
}
