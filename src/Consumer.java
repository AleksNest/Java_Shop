import java.util.ArrayList;

public class Consumer extends Human {
    ArrayList<Item> busket = new ArrayList<>();                 // корзина покупок

    ArrayList<Item> wishList = new ArrayList<>();           // список желаемого товара, который хочет приобрести покупатель

    public Consumer(String name, double money, int loveIndex) {         // конструктор связь с родителем
        super(name, money, loveIndex);
    }

    public ArrayList<Item> setBusket(ArrayList<Item> wishList) {  // метод добавления товара в корзину
        for (Item item : wishList) {
            busket.add(item);
        }
        return busket;
    }

    public ArrayList<Item> getBusket() {
        return busket;
    }

    @Override
    public void walkInStorage() {                                   // метод поведения покупателя со складом
        System.out.println("Покупатель идет на склад  искать другой товар");
    }

    @Override
    public void loyalIndexConsumer(Consumer consumer) {             // метод лояльности покупателя на продавца
        if (consumer.getLoveIndex() > 4) {
            System.out.println("Продавец: Спасибо за обслуживание. Хорошего вам дня!");
        } else {
            System.out.println("Покупатель: Хотелось бы за свои деньги уйти с хорошим настроением. Не порте мне его.");
        }
    }

    @Override
    public void loyalIndexSeller(Seller seller) {                      // метод лояльности продавца  на покупателя
        if (seller.getLoveIndex() > 4) {
            System.out.println("Спасибо за покупку, всегда рады вам!");
        } else {
            System.out.println("Давайте не будем портить друг другу настроение..");
        }
    }


}

