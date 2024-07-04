package my_factory_pattern;

public class Main {

    public static void main(String[] args) {
        GuitarFactory guitarFactory = new GuitarFactory();
        GuitarStudio guitarStudio = new GuitarStudio(guitarFactory);
        guitarStudio.soundsGuitar(GuitarsMark.FENDER);
    }

}
