package firsttask.Exam;

public class Exam {
    private String discipline;
    private int mark;
    private String solution;
    private String task;
    public Exam(String discipline){
        this.discipline = discipline;
    }

    public String getDiscipline() {
        return discipline;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
