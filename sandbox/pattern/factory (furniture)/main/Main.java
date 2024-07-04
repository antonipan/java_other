package furniture.main;

import furniture.my_factory_furniture.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        FurnitureFactory furnitureFactory = new FurnitureFactory();
        FurnitureStudio furnitureStudio = new FurnitureStudio(furnitureFactory);
        System.out.println("------");
        furnitureStudio.createStudio(FurnitureMark.CASE);
        System.out.println("------");
        furnitureStudio.createStudio(FurnitureMark.CHAIR);
        System.out.println("------");
        furnitureStudio.createStudio(FurnitureMark.TABLE);

    }
}
