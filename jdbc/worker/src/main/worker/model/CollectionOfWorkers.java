package model;

import databases.WorkerDB;
import view.Color;

import java.util.ArrayList;
import java.util.List;

public class CollectionOfWorkers extends java.awt.List{

    /**
     * коллекция добавленных работников.
     */
    private List <BaseWorker> listWorker;
    private WorkerDB workerDB;
    private int countStartWorker;

    /**
     * конструктор, который по умолчанию создаёт новый лист.
     */
    public CollectionOfWorkers () {
        listWorker = new ArrayList<>();
        workerDB = new WorkerDB();
    }

    /**
     * Геттер коллекции работников.
     * @return - возвращает лист работников.
     */
    public List<BaseWorker> getListWorker() {
        return listWorker;
    }

    /**
     * Метод добавления работников
     * @param worker - принимает объект - работник и его наследников.
     */
    public void addWorker (BaseWorker worker) {
        listWorker.add(worker);
    }

    /**
     * Метод вывода в консоль списка работников.
     */
    public void printWorker () {
        for (BaseWorker worker :  listWorker
             ) {
            System.out.println(Color.GREEN.getTitle() + worker.toString()
            + Color.RESET.getTitle());
        }
    }

    /**
     * метод удаления работника
     * @param name - имя работника, которого нужно удалить.
     */
    public void removeWorker (String name) {
        for (BaseWorker worker :  listWorker
        ) {
            if (worker.getName().equals(name)) {
                listWorker.remove(worker);
                System.out.println("Работник успешно удалён. ");
                workerDB.deleteDB(name);
                return;
            }
        }
        System.out.printf("A worker with name %s was not found. \n", name);
    }

    /**
     * Вспомогательный метод.
     * @return возращает количество работников.
     */
    public int countWorker() {
        return listWorker.size();
    }

    public void unloadFromDB () {
        workerDB.selectDB(getListWorker());
        countStartWorker = countWorker();
        System.out.println("Количество работников в базе: " + countStartWorker);

    }

    public void loadToDB () {
        workerDB.addDB(getListWorker(), countStartWorker);
    }
}
