package bookTask.Model;

import java.util.ArrayList;
import java.util.List;

public class Calendary <T extends BaseTask> {
    private List <T> tasks = new ArrayList <> ();

    public Calendary(List tasks) {
        this.tasks = tasks;
    }
    public Calendary() {
    }

    public void addTask (T baseTask) {
        tasks.add(baseTask);
    }

    public void remove (T baseTask) {
        tasks.remove(baseTask);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (BaseTask basetask : tasks
             ) {
            builder.append(basetask.getInfo() + "\n");
        }
        return "Calendary{" +
                "tasks=" + builder +
                '}';
    }


}
