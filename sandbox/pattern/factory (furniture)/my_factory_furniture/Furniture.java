package furniture.my_factory_furniture;

/**
 * Родительский класс по мебели, от которого наследуются три класса - типы мебели
 */
public abstract class Furniture {
    protected String name;

    /**
     *
     * @return возвращает имя класса. Метод реализован в классах наследниха
     */
    public abstract String getName();

    public void processingTree () {
        System.out.print("Дерево обрабатывается. Скоро ваш "+ getName() + " будет готов...  ");
    }

    public void makeForm () {
        System.out.print("Вашей мебели " + getName() + " придаётся форма... ");
    }

    public void paintFurniture () {
        System.out.print("Идёт покраска вашего " + getName() + "а... ");
    }

}
