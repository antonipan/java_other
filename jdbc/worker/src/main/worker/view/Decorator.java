package view;

public class Decorator {

    public void enterUserNumber () {
        System.out.print(Color.CYAN.getTitle() + "Введите число: " + Color.RESET.getTitle());

    }

    public void funcAtWork () {
        System.out.println(Color.YELLOW.getTitle() + "Функционал нереализован. " + Color.RESET.getTitle());
    }
}
