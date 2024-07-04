package bookTask.Model;

import bookTask.Program;

import java.time.LocalDate;
import java.util.LinkedList;

public class WorkTask extends BaseTask implements Salary {

    private String responsible;


    public WorkTask () {
        listTask = new LinkedList<>();
    }

    public String getInfo () {
        return "BaseTask{" +
                "Задача='" + getNameTask() + '\'' +
                ", Приоритет=" + getPriority() +
                ", responsible='" + getResponsible() + '\'' +
                ", dataStart='" + getDataStart() + '\'' +
                ", dataFinish='" + getDataFinish() + '\'' +
                ", deadline=" + getDeadline() +
                '}';
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public void statusTask() {
        LocalDate dateNow = LocalDate.now();
        if (dateNow.isBefore(getDataStart())) {
            System.out.println("Задача ещё не началась");
        } else if (dateNow.isAfter(getDataStart()) && dateNow.isBefore(getDataFinish())) {
            System.out.println("Задача выполняется");
        } else if (dateNow.isAfter(getDataFinish())) {
            System.out.println("Задача выполнена");
            count++;
            sumSalary(100);
        }
    }

    @Override
    public void addTask() {
        System.out.print("Enter task name: ");
        String variableString = scanner.nextLine();
        setNameTask(variableString);
        System.out.print("Specify start date: ");
        variableString = scanner.nextLine();
        setDataStart(variableString);
        System.out.print("Specify finish date: ");
        variableString = scanner.nextLine();
        setDataFinish(variableString);
        System.out.print("Enter priority: ");
        variableString = scanner.nextLine();
        setPriority(Integer.parseInt(variableString));
        System.out.print("Enter responsibly: ");
        variableString = scanner.nextLine();
        setResponsible(variableString);
        System.out.println(Program.BLUE + "I created a work task" + Program.ANSI_RESET);

    }

    @Override
    public void readTask() {
        System.out.println(Program.BLUE + "I changed a work task" + Program.ANSI_RESET);

    }

    @Override
    public void deleteTask() {
        System.out.println(Program.BLUE + "I deleted a work task" + Program.ANSI_RESET);

    }

    @Override
    public void watchTask() {
        System.out.println(Program.BLUE + "I watched a work task" + Program.ANSI_RESET);

    }

    public static void getCount () {
        System.out.println("Задач выполнено " + count);
    }
    public static void getSalary () {
        System.out.println("За работу получено " + salaryTask);
    }
    @Override
    public int sumSalary(int salary) {
        return salaryTask += salary;
    }
}
