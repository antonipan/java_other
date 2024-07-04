package ru.panferov.homework01.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class Cart<T extends Food> {

    //region Поля

    /**
     * Товары в магазине
     */
    private final ArrayList<T> foodstuffs;
    private final UMarket market;
    private final Class<T> clazz;

    //endregion

    //region Конструкторы

    /**
     * Создание нового экземпляра корзины
     *
     * @param market принадлежность к магазину
     */
    public Cart(Class<T> clazz, UMarket market) {
        this.clazz = clazz;
        this.market = market;
        foodstuffs = new ArrayList<>();
    }

    //endregion

    /**
     * Балансировка корзины
     */
    public void cardBalancing() {

        if (foodstuffs.size() == 0) {
            System.out.println("В корзине отсутствует товар");
        }
        int proteins = (int) foodstuffs.stream().filter(Food::getProteins).count();
        int fats = (int) foodstuffs.stream().filter(Food::getFats).count();
        int carbohydrates = (int) foodstuffs.stream().filter(Food::getCarbohydrates).count();
        if (proteins == 0) {
            Optional<T> optional = market.getThings(clazz).stream().filter(Food::getProteins).findFirst();
            optional.ifPresent(foodstuffs::add);
            System.out.println("Продукт с белками добавлен");

        }
        if (fats == 0) {
            Optional<T> optional = market.getThings(clazz).stream().filter(Food::getFats).findFirst();
            optional.ifPresent(foodstuffs::add);
            System.out.println("Продукт с жирами добавлен");

        }
        if (carbohydrates == 0) {
            Optional<T> optional = market.getThings(clazz).stream().filter(Food::getCarbohydrates).findFirst();
            optional.ifPresent(foodstuffs::add);
            System.out.println("Продукт с углеводами добавлен");
        }
        System.out.println("Корзина успешно сбалансирована");
    }

    public Collection<T> getFoodstuffs() {
        return foodstuffs;
    }

    /**
     * Распечатать список продуктов в корзине
     */
    public void printFoodstuffs()
    {
        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food -> System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                index.getAndIncrement(), food.getName(),
                food.getProteins() ? "Да" : "Нет",
                food.getFats() ? "Да" : "Нет",
                food.getCarbohydrates() ? "Да" : "Нет"));
    }

}
