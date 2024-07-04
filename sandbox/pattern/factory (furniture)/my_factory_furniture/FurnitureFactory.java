package furniture.my_factory_furniture;

public class FurnitureFactory {
    /**
     *
     * @param furnitureMark - тип энум, где перечиляются объекты
     * @return - возвращает созданный объект классан наследника.
     */
    public Furniture createFurniture (FurnitureMark furnitureMark) {
        Furniture furniture = null;
        switch (furnitureMark) {
            case CASE: furniture = new Case(); break;
            case CHAIR: furniture = new Chair(); break;
            case TABLE: furniture = new Table(); break;
            default: break;
        }
        return furniture;
    }

}
