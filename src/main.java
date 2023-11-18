import java.util.ArrayList;

public class main {
    public static void main(String[] args) {


        Seller seller = new Seller("Вася", 20, 5);           // создание покупателя
        Consumer consumer = new Consumer("Таня", 20, 3);     // создание продавца
        ArrayList<Item> items = new ArrayList<>();     // список товаров
        ArrayList<Item> wishList = new ArrayList<>();   // список желаний покупателя


        // создание списка товара
        items.add(0, new Item("молоко", 55, Category.Food));
        items.add(1, new Item("хлеб", 35, Category.Food));
        items.add(2, new Item("сок", 105, Category.Water));
        items.add(3, new Item("суп", 105, Category.Hygiene));
        items.add(4, new Item("шампунь", 125, Category.Hygiene));
        items.add(5, new Item("масло Вкуснотеево", 101, Category.Food));
        items.add(5, new Item("масло Дворик", 121, Category.Food));


        // формирование списка товара на складе у продавца
        seller.setItems(items);
        System.out.println("Наличие товара на складе:  " + seller.getItems().toString());
        System.out.println("----------------------");

        // вывод списка товара отсортированного по цене
        ComporatorByCost comporatorByCost = new ComporatorByCost();
        items.sort(comporatorByCost);
        System.out.println("Сортировка товара на складе по возрастанию цены:  " + items.toString());
        System.out.println("----------------------");

        // запрос от покупателя цены на товар
        System.out.println("стоимость запрашиваемого товара  " + items.get(4) + ":  " + consumer.costOfItem(items.get(4)));
        System.out.println("----------------------");

        // создание списка покупок покупателем
        wishList.add(0, new Item("хлеб", 35, Category.Food));
        wishList.add(1, new Item("сок", 105, Category.Water));
        wishList.add(2, new Item("шампунь", 105, Category.Hygiene));
        wishList.add(3, new Item("масло Буренка", 200, Category.Food));
        System.out.println("список желаемых покупок покупателя:  " + (wishList));
        System.out.println("----------------------");

        // запрос о наличии товара на складе
        System.out.println("Запрос о наличии товара");
        consumer.isItemsInStorage(seller, wishList);
        System.out.println("----------------------");

        // создание корзины покупок
        wishList.remove(3);                         // удаление из списка желаний отсутствующей на складе позиции
        consumer.setBusket(wishList);                       // формирование корзины покупателя
        System.out.println("Корзина покупателя" + consumer.getBusket());
        System.out.println("----------------------");

        // запрос общей стоимости товара:
        System.out.println("Всего к оплате:  " + consumer.totalCost(consumer.getBusket()));
        System.out.println("----------------------");

        // проверка платежеоспособности покупателя
        consumer.areYouPoor(consumer, seller);
        System.out.println("----------------------");

        //  вывод лояльности продавца
        consumer.loyalIndexConsumer(consumer);
        seller.loyalIndexSeller(seller);


    }
}
