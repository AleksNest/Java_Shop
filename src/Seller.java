import java.util.ArrayList;
import java.util.List;

public class Seller extends Human {
    private List<Item> items = new ArrayList<>();               // список товара у продавца

    public Seller(String name, double money, int loveIndex) {   // связь в родителем через имя продавца, деньги,
        super(name, money, loveIndex);
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public void walkInStorage() {
        System.out.println("Денег на покупку достаточно. Продавец уходит на склад за товаром");
    }


    @Override
    public void loyalIndexSeller(Seller seller) {         // метод реализации лояльности  продавца на покупателя
        if (seller.getLoveIndex() > 2) {
            System.out.println("Продавец: Всегда рады вас видеть, приходите еще!");
        } else {
            System.out.println("Продавец: Давайте не будем портить друг другу настроение..");
        }
    }

    @Override
    public void loyalIndexConsumer(Consumer consumer) {         // метод реализации лояльности  а покупателя на продавца
        if (consumer.getLoveIndex() > 2) {
            System.out.println("Покупатель: Спасибо за обслуживание. Хорошего вам дня!");
        } else {
            System.out.println("Покупатель: Хотелось бы за свои деньги уйти с хорошим настроением. Не порте мне его.");
        }
    }


}
