package my_factory_pattern;

public class GuitarFactory {

    public Guitar createGuitar (GuitarsMark guitarsMark) {
        Guitar guitar = null;
        switch (guitarsMark) {
            case FENDER -> guitar = new Fender();
            case IBANES -> guitar = new Ibanez();
            case STRATOCASTER -> guitar = new Stratocaster();
        }
        return guitar;
    }
}
