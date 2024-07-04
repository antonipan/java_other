package furniture.my_factory_furniture;

public class FurnitureStudio {

    private final FurnitureFactory furnitureFactory;

    public FurnitureStudio (FurnitureFactory furnitureFactory) {
        this.furnitureFactory = furnitureFactory;
    }

    /**
     *
     * @param furnitureMark - перечисление объектов мебели, которые возможно создать.
     * @return - возвращает конкретно созданный объект мебели.
     */
    public Furniture createStudio (FurnitureMark furnitureMark) {
        Furniture furniture = furnitureFactory.createFurniture(furnitureMark);
        BarLoading loading1 = new BarLoading();
        System.out.println("Вы заказали: " + furniture.getName());
        furniture.processingTree();
        loading1.stringRun();
        furniture.makeForm();
        loading1.stringRun();
        furniture.paintFurniture();
        loading1.stringRun();

        System.out.println("Прекрасно! Ваш " + furniture.getName() +" готов.");
        return furniture;
    }
}
