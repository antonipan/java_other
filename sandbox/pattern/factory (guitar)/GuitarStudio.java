package my_factory_pattern;

public class GuitarStudio {
    // создаём переменную фабрики
    private final GuitarFactory guitarFactory;
    // Конструктор, создающий фабрику
    public GuitarStudio(GuitarFactory guitarFactory) {
        this.guitarFactory = guitarFactory;
    }
    // метод студии, где создаётся объект фабричного метода.
    public Guitar soundsGuitar (GuitarsMark guitarsMark) {
        Guitar guitar = guitarFactory.createGuitar(guitarsMark);
        guitar.switchGuitar();
        guitar.setting();
        guitar.player();

        System.out.println("Вы слушаете звук любимой гитары...");
        return guitar;
    }
}
