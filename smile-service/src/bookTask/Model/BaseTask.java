package bookTask.Model;

import java.time.Duration;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

public abstract class BaseTask {
    public static Scanner scanner = new Scanner(System.in);


    private String nameTask;
    private int priority;
    private String responsible;
    private String dataStart;
    private String dataFinish;
    private long daysDuration;
    private boolean deadline;
    protected LinkedList <BaseTask> listTask;


    static int salaryTask;
    static int count;

    static {
        count = 0;
        salaryTask = 0;

    }

    public BaseTask () {

    }


    public abstract String getInfo();

    public String getNameTask() {
        return nameTask;
    }

    public int getPriority() {
        return priority;
    }

    public LocalDate getDataStart() {
        return LocalDate.parse(dataStart);
    }

    public LocalDate getDataFinish() {
        return LocalDate.parse(dataFinish);
    }

    public long getDaysDuration () {
        return this.daysDuration = Duration.between(getDataStart().atStartOfDay(), getDataFinish().atStartOfDay()).toDays();
    }

    public boolean getDeadline () {
        return deadline;
    }

    public void setDeadline () {
        LocalDate datenow = LocalDate.now();
        long x = Duration.between(datenow.atStartOfDay(), getDataFinish().atStartOfDay()).toDays();
        if (x > 2) {
            deadline = false;
            System.out.println("Ещё есть  "+ x + " дней на задачу: " + getNameTask());
        } else {
            deadline = true;
            System.out.println("Срочно! Через " + x + " дней на задачу " + getNameTask());
        }
    }



    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setDataStart(String dataStart) {

        this.dataStart = dataStart;
    }

    public void setDataFinish(String dataFinish) {
        this.dataFinish = dataFinish;
    }

    public abstract void statusTask ();

    public abstract void addTask ();
    public abstract void readTask ();
    public abstract void deleteTask ();
    public abstract void watchTask ();
}
