package furniture.my_factory_furniture;

public class Case extends Furniture {
    @Override
    public String getName() {
        this.name = "Шкаф";
        return name;
    }
}
