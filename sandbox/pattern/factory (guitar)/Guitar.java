package my_factory_pattern;


public abstract class Guitar {


    public void switchGuitar () {
        System.out.println("Гитара подключилась");
    }
    public void setting () {
        System.out.println("Гитара настроена.");
    }
    public void player () {
        System.out.println("Гитара играет");
    }

}
