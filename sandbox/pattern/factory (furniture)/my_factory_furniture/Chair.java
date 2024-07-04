package furniture.my_factory_furniture;

public class Chair extends Furniture {
    @Override
    public String getName() {
        this.name = "Стул";
        return name;
    }
}
