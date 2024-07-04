package bookTask.Model;

import bookTask.Program;

import java.time.LocalDate;

public class HomeTask extends BaseTask {
    Calendary calendar;
    public HomeTask() {
        this.calendar = new Calendary<>();
    }

    public String getInfo () {
        return "BaseTask{" +
                    "nameTask='" + getNameTask() + '\'' +
                    ", priority=" + getPriority() +
                    ", dataStart='" + getDataStart() + '\'' +
                    ", dataFinish='" + getDataFinish() + '\'' +
                    ", deadline=" + getDeadline() +
                    '}';
    }

    @Override
    public void statusTask() {
        LocalDate dateNow = LocalDate.now();
        if (dateNow.isBefore(getDataStart())) {
            System.out.println("Задача ещё не началась");
        } else if (dateNow.isAfter(getDataStart()) && dateNow.isBefore(getDataFinish())) {
            System.out.println("Задача выполняется");
        } else if (dateNow.isAfter(getDataFinish())) {
            System.out.println("Задача выполнена");
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
        System.out.print("Specify start date: ");
        variableString = scanner.nextLine();
        setDataFinish(variableString);
        System.out.print("Enter priority: ");
        variableString = scanner.nextLine();
        setPriority(Integer.parseInt(variableString));
        System.out.println("I created a " + Program.GREEN + "home " + Program.ANSI_RESET + "task");
    }

    @Override
    public void readTask() {
        System.out.println("I read a " + Program.GREEN + "home " + Program.ANSI_RESET + "task");

    }

    @Override
    public void deleteTask() {
        System.out.println("I deleted a " + Program.GREEN + "home " + Program.ANSI_RESET + "task");

    }

    @Override
    public void watchTask() {
        System.out.println("I watched a " + Program.GREEN + "home " + Program.ANSI_RESET + "task");

    }
}
