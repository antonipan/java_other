package controller;

import comparators.SortByAge;
import comparators.SortByName;
import comparators.SortBySalary;
import model.CollectionOfWorkers;
import model.WorkerHour;
import model.WorkerMonth;
import view.Color;
import view.MenuProgram;

import java.util.Collections;

public class Controller {
    private CollectionOfWorkers collectionOfWorkers = new CollectionOfWorkers();
    /**
     * Метод принимает тип создания работника (с полными параметрами или только с заработной платой),
     * и тип заработной платы. Метод соответствует выбору главного пункта меню.
     * @param a - тип создания работника
     * @param b - тип заработной платы
     * @param rate - размер заработной платы.
     */
    public void getLevel1 (int a, int b, double rate){
        if (a == 1 && b == 1) {
            MenuProgram.decorator.funcAtWork(); // TODO: доделать
        } else if (a == 2 && b == 1) {
            collectionOfWorkers.addWorker(new WorkerMonth(rate));
        }else if (a == 1 && b == 2) {
            MenuProgram.decorator.funcAtWork(); // TODO: доделать
        } else if (a == 2 && b == 2) {
            collectionOfWorkers.addWorker(new WorkerHour(rate));
        } else {
            MenuProgram.decorator.funcAtWork(); // TODO: доделать
        }
    }

    /**
     * Метод отображает всех выбранных работников.
     * Метод соответствует выбору второго пункта главного меню.
     * По умолчанию присутствует сортировка по имени.
     */
    public void getLevel2 (){
        Collections.sort(collectionOfWorkers.getListWorker(), new SortByName());
        if (collectionOfWorkers.countWorker() != 0) {
            collectionOfWorkers.printWorker();
            System.out.println("Список работников успешно выведен");
        } else {
            System.err.println("Список работников ПУСТ! ");
        }
    }

    /**
     * Метод сортирует работников.
     * @param menuSort - выбранный пользователем тип сортировки.
     */
    public void getLevel3 (int menuSort){
        switch (menuSort) {
            case 1: // сортировка по имени
                Collections.sort(collectionOfWorkers.getListWorker(), new SortByName());
                System.out.println(Color.GREEN.getTitle());
                collectionOfWorkers.printWorker();
                System.out.println(Color.RESET.getTitle());
                break;
            case 2: // сортировка по возрасту
                Collections.sort(collectionOfWorkers.getListWorker(), new SortByAge());
                collectionOfWorkers.printWorker();

                break;
            case 3: // сортировка по заработной плате.
                Collections.sort(collectionOfWorkers.getListWorker(), new SortBySalary());
                collectionOfWorkers.printWorker();
            default:
                break;
        }
    }

    /**
     * Метод запускает удаление работника реализован только по имени.
     * @param name - имя работника, которого нужно удалить.
     */
    public void getLevel4 (String name){
        collectionOfWorkers.removeWorker(name);
    }

    /**
     * метод записи добавленных работников в базу данных.
     */
    public void getLevel5 (){
        collectionOfWorkers.loadToDB();
        // TODO: доделать запись добавленных работников в файл.
    }

    public void getDB () {
        collectionOfWorkers.unloadFromDB();
    }
}
