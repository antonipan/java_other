package furniture.my_factory_furniture;

public class Table extends Furniture {
    @Override
    public String getName() {
        this.name = "Стол";
        return name;
    }
}
